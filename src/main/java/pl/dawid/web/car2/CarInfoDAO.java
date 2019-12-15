package pl.dawid.web.car2;

import javax.sql.DataSource;

public interface CarInfoDAO {

	public void saveCarInfo(CarBean car, DataSource dataSource);

}
