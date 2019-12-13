package pl.dawid.web.car;

import pl.dawid.web.client.Client;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CarDataDAOImpl implements CarDataDAO{
    @Override
    public void saveCarData(Car car, DataSource dataSource) throws Exception {

        Connection con = null;

        try {
            con = dataSource.getConnection();

            PreparedStatement pstmt = con.prepareStatement(
                    "INSERT INTO auta(id,marka,model,rokProdukcji,kolor) VALUES (?,?,?,?,?)");

            pstmt.setInt(1, generateId());
            pstmt.setString(2, car.getMake());
            pstmt.setString(3, car.getModel());
            pstmt.setInt(4, car.getProductionYear());
            pstmt.setString(5, car.getColor());

            pstmt.executeUpdate();
            pstmt.close();
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }
    private int generateId() {
        return ((int) (System.currentTimeMillis() % 100000)) + 100000;
    }

    @Override
    public List readCarsData(DataSource dataSource) throws Exception {
        Connection conn = null;
        List cars = new ArrayList();

        try {
            conn = dataSource.getConnection();

            PreparedStatement pstmt = conn.prepareStatement(
                    "SELECT marka, model, rokProdukcji, kolor FROM auta");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Car car = new Car();
                car.setMake(rs.getString(1));
                car.setModel(rs.getString(2));
                car.setProductionYear(rs.getInt(3));
                car.setColor(rs.getString(4));
                cars.add(car);
            }

            rs.close();
            pstmt.close();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return cars;
    }
    }

