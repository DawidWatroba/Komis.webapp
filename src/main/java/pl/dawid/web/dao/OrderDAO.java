package pl.dawid.web.dao;

import pl.dawid.web.OrderBean;

import javax.sql.DataSource;

public interface OrderDAO {

	 void saveOrder(DataSource dataSource, OrderBean order);

}
