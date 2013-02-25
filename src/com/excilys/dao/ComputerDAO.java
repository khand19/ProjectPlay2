package com.excilys.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.excilys.bean.Company;
import com.excilys.bean.Computer;

public class ComputerDAO implements IComputerDAO {

	@Override
	public void addComputer(Computer pComputer) {
		String rqComputerID = "INSERT INTO COMPUTER (NAME,INTRODUCED,DISCONTINUED,IDCOMPANY) VALUES ('?',?,?,?);";
//		String rqComputerI = "INSERT INTO COMPUTER (NAME,INTRODUCED,IDCOMPANY) VALUES ('?','?',?);";
//		String rqComputerD = "INSERT INTO COMPUTER (NAME,DISCONTINUED,IDCOMPANY) VALUES ('?','?',?);";
//		String rqComputer = "INSERT INTO COMPUTER (NAME,IDCOMPANY) VALUES ('?',?);";
//		String rqCompany = "INSERT INTO COMPANY (NAMECOMPANY) VALUES('?');";		
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Connection cn = Connexion.getConnexion();

		try {
			stmt = cn.prepareStatement(rqComputerID);
			stmt.setString(1, pComputer.getNameComputer());
			stmt.setDate(2, (Date) pComputer.getIntroducedDate());
			stmt.setDate(3, (Date) pComputer.getDscountedDate());			
			stmt.setInt(4, pComputer.getCompany().getIdCompany());			
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Connexion.closeAll(rs,stmt,cn);
		}
	}

	@Override
	public List<Computer> getComputers() {
		ResultSet rs = null;
		Statement stmt = null;
		Connection cn = Connexion.getConnexion();
		List<Computer> liste = new ArrayList<Computer>();
		try {
			stmt = cn.createStatement();
			rs = stmt
					.executeQuery("SELECT c.ID, c.NAME, c.INTRODUCED, c.DISCONTINUED, c.IDCOMPANY, d.NAMECOMPANY FROM COMPUTER c INNER JOIN COMPANY d ON c.IDCOMPANY=d.IDCOMPANY ORDER BY c.NAME ASC;");
			while (rs.next()) {
				Computer c = new Computer();
				c.setCompany(new Company(rs.getInt(5),rs.getString(6)));
				c.setIdComputer(rs.getInt(1));
				c.setNameComputer(rs.getString(2));
				c.setIntroducedDate(rs.getDate(3));
				c.setDscountedDate(rs.getDate(4));
				liste.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Connexion.closeAll(rs,stmt,cn);
		}
		return liste;
	}

	@Override
	public Computer getComputerById(int pIdComputer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Computer getComputerByName(String pNameComputer) {
		// TODO Auto-generated method stub
		return null;
	}

}
