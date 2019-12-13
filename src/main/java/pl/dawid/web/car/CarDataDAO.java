package pl.dawid.web.car;

import javax.sql.DataSource;
import java.util.List;

public interface CarDataDAO {
    void saveCarData(Car car, DataSource dataSource) throws Exception;
    List readCarsData(DataSource dataSource) throws Exception;
}
