package com.itgroup.dao;

import com.itgroup.bean.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CarDao extends SuperDao {

    public CarDao() {
        super();
    }

    public List<Car> selectAll() {
        List<Car> cars = new ArrayList<Car>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection conn = null;


        String sql = "select * from cars order by car_no asc";

        try {
            conn = super.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
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

    public int newCar(Car bean) {
        int cnt = -1;

        String sql = "insert into cars(car_no, brand, car_model, release_date, color, car_type, engine_type, fuel_efficiency, price)";
        sql += " values(?,?,?,?,?,?,?,?,?)";

        Connection conn = null;

        PreparedStatement pstmt = null;

        try {
            conn = super.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bean.getCarNumber());
            pstmt.setString(2, bean.getBrand());
            pstmt.setString(3, bean.getCarModel());
            pstmt.setString(4, bean.getReleaseDate());
            pstmt.setString(5, bean.getColor());
            pstmt.setString(6, bean.getCarType());
            pstmt.setString(7, bean.getEngineType());
            pstmt.setInt(8, bean.getFuelEfficiency());
            pstmt.setInt(9, bean.getPrice());

            cnt = pstmt.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return cnt;


    }


    public int soldCar(int car_no) {
        int cnt = -1;
        String sql = "delete from cars where car_no = ? ";
        PreparedStatement pstmt = null;
        Connection conn = null;

        try {
            conn = super.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, car_no);

            cnt = pstmt.executeUpdate();

            conn.commit();

        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    pstmt.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return cnt;
    }
}

