package pl.dawid.web.dao;

import pl.dawid.web.ClientBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class ClientDataDAOImpl implements ClientDataDAO {

	public void saveClientData(ClientBean cl, DataSource dataSource) throws Exception {

        try (Connection con = dataSource.getConnection()) {

            PreparedStatement pstmt = con.prepareStatement(
                    "INSERT OR REPLACE INTO klient(id,imie,nazwisko,region,wiek,mezczyzna) VALUES (?,?,?,?,?,?)");
            int m = (cl.getSex().equals("MALE") ? 1 : 0);
            if(cl.getId()!=0){
				pstmt.setInt(1, cl.getId());
			}else{
            pstmt.setInt(1, generateId());
            }
            pstmt.setString(2, cl.getName());
            pstmt.setString(3, cl.getSurname());
            pstmt.setString(4, cl.getRegion());
            pstmt.setInt(5, cl.getAge());
            pstmt.setInt(6, m);

            pstmt.executeUpdate();
            pstmt.close();
        }
	}
	private int generateId() {
		return ((int) (System.currentTimeMillis() % 100000)) + 100000;
	}
	
	public List readClientsData(DataSource dataSource) throws Exception {

        Connection conn = null;
        List clients = new ArrayList();
        
        try {
	        conn = dataSource.getConnection();
	        
	        PreparedStatement pstmt = conn.prepareStatement(
	        "SELECT id, imie, nazwisko, region, wiek, mezczyzna FROM klient");
	
	        ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
				ClientBean cl = new ClientBean();
				cl.setId(rs.getInt(1));
				cl.setName(rs.getString(2));
				cl.setSurname(rs.getString(3));
				cl.setRegion(rs.getString(4));
				cl.setAge(rs.getInt(5));
				if (rs.getInt(6) == 1) {
					cl.setSex("MALE");
				} else {
					cl.setSex("FEMALE");
				}
				clients.add(cl);
			}

	        rs.close();
	        pstmt.close();
        } finally {
        	if (conn != null) {
        		conn.close();
        	}
        }
        return clients;
	}
	@Override
	public void removeClient(String name, String surname, DataSource dataSource) throws Exception {
        try (Connection connection = dataSource.getConnection()) {
            connection.createStatement().executeUpdate("DELETE FROM klient WHERE " +
                    "imie = '" + name + "' AND nazwisko = '" + surname + "';");
        }
	}
	@Override
	public void removeClient(int id, DataSource dataSource) throws Exception {
        try (Connection connection = dataSource.getConnection()) {
            connection.createStatement().executeUpdate("DELETE FROM klient WHERE " +
                    "id = " + id + ";");
        }
	}

}
