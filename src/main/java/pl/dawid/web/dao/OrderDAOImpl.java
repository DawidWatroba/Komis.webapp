package pl.dawid.web.dao;

import pl.dawid.web.OrderBean;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class OrderDAOImpl implements OrderDAO {

	public void saveOrder(DataSource ds, OrderBean order) {

		try {
			try (Connection conn = ds.getConnection()) {
				try (PreparedStatement pstmt = conn.prepareStatement(
						"INSERT OR REPLACE INTO zamowienie(klient_id, czesc, charakt_czesci, ilosc, id) VALUES (?,?,?,?,?)")) {

					pstmt.setInt(1, order.getClientId());
					pstmt.setString(2, order.getPart());
					pstmt.setString(3, order.getProfile());
					pstmt.setInt(4, order.getCount());
					if (order.getId() == 0) {
						pstmt.setInt(5, generateId());
					} else {
						pstmt.setInt(5, order.getId());
					}

					pstmt.executeUpdate();
				}
			}
		} catch (Exception e ) {
        	System.out.println("Blad przy zapisie danych: " + e);
		}
	}
	
	private int generateId() {
		return ((int) (System.currentTimeMillis() % 100000)) + 100000;
	}

}
