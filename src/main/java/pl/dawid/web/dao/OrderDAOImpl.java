package pl.dawid.web.dao;

import pl.dawid.web.OrderBean;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class OrderDAOImpl implements OrderDAO {

	public void saveOrder(DataSource ds, OrderBean ord) {

		try {
			try (Connection conn = ds.getConnection()) {
				PreparedStatement pstmt = conn.prepareStatement(
						"INSERT INTO zamowienie(klient_id, czesc, charakt_czesci, ilosc, id) VALUES (?,?,?,?,?)");

				pstmt.setInt(1, ord.getClientId());
				pstmt.setString(2, ord.getPart());
				pstmt.setString(3, ord.getProfile());
				pstmt.setInt(4, ord.getCount());
				pstmt.setInt(5, generateId());

				pstmt.executeUpdate();
				pstmt.close();
			}
		} catch (Exception e ) {
        	System.out.println("Blad przy zapisie danych: " + e);
		}
	}
	
	private int generateId() {
		return ((int) (System.currentTimeMillis() % 100000)) + 100000;
	}

}
