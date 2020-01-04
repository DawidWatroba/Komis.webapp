package pl.dawid.web.dao;

import pl.dawid.web.CarBean;

import javax.sql.DataSource;

public interface CarInfoDAO {

	void saveCarInfo(CarBean car, DataSource dataSource);
	CarBean findCarById(int id, DataSource dataSource);
}
