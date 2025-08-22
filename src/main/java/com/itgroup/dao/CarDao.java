package com.itgroup.dao;

import com.itgroup.bean.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CarDao extends SuperDao {

    public CarDao(){
        super();
    }

    public List<Car> selectAll() {
        List<Car> cars = new ArrayList<Car>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection conn = null;


        String sql = "select * from cars order by car_no desc";

        try {
            conn = super.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

        while (rs.next()){
            Car bean = new Car();
            bean.setCarNumber(rs.getInt("car_no"));
            bean.setBrand(rs.getString("brand"));
            bean.setCarModel(rs.getString("car_model"));
            bean.setReleaseDate(rs.getString("release_date"));
            bean.setColor(rs.getString("color"));
            bean.setCarType(rs.getString("car_type"));
            bean.setEngineType(rs.getString("engine_type"));
            bean.setFuelEfficiency(rs.getInt("fuel_efficiency"));
            bean.setPrice(rs.getInt("price"));

            cars.add(bean);

        }

        } catch (Exception ex) {
            ex.printStackTrace();
        }


        return cars;
    }
}
