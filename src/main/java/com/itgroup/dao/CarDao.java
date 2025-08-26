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

    public int totalCar() {
        String sql = "select count(*) as totalCar from cars";
        PreparedStatement pstmt = null;
        Connection conn = null;
        ResultSet rs = null;
        int cnt = 0;
        try {
            conn = super.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                cnt = rs.getInt("totalCar");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (conn != null) {
                    conn.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }

        return cnt;
    }

    public List<Car> highLowPrice() {
        List<Car> priceList = new ArrayList<Car>();
        String sql = "select max(price) as highest_price, min(price) as lowest_price from cars";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = super.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                Car bean = new Car();

                bean.setMaxprice(rs.getInt("highest_price"));
                bean.setLowprice(rs.getInt("lowest_price"));

                priceList.add(bean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            return priceList;
        }
    }

    public List<Car> carYear(int car_no) {
        List<Car> date = new ArrayList<Car>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select car_no, release_date from cars where car_no = ? ";

        try {
            conn = super.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, car_no);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Car bean = new Car();
                bean.setCarNumber(rs.getInt("car_no"));
                bean.setReleaseDate(rs.getString("release_date"));

                date.add(bean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            return date;
        }
    }

    public int updateCar(Car bean) {
        int cnt = -1 ;

        String sql = " update cars set brand = ?, car_model = ?, release_date = ?, color = ?, car_type = ?, engine_type = ?, fuel_efficiency = ?, price = ? where car_no = ? ";

        Connection conn = null ;
        PreparedStatement pstmt = null ;

        try {
            conn = super.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, bean.getBrand());
            pstmt.setString(2,bean.getCarModel());
            pstmt.setString(3,bean.getReleaseDate());
            pstmt.setString(4,bean.getColor());
            pstmt.setString(5,bean.getCarType());
            pstmt.setString(6,bean.getEngineType());
            pstmt.setInt(7,bean.getFuelEfficiency());
            pstmt.setInt(8,bean.getPrice());
            pstmt.setInt(9,bean.getCarNumber());
            cnt = pstmt.executeUpdate();
            conn.commit();

        }catch (Exception e) {
            e.printStackTrace();
        }try {
            if (conn != null) conn.rollback();
        }catch (Exception e2) {
            e2.printStackTrace();
        }finally {
            try {
                if(pstmt != null){pstmt.close();}
                if(conn != null){conn.close();}


            }catch (Exception e){
                e.printStackTrace();
            }


        }
        return cnt ;
    }

    public List<Car> avgFe() {
        List<Car> avgfeList = new ArrayList<>();
        String sql = "select avg(fuel_efficiency) as avg_fe from cars " ;
        Connection conn = null ;
        PreparedStatement pstmt = null ;
        ResultSet rs = null ;

        try {
            conn = super.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs= pstmt.executeQuery();

            if(rs.next()){
                Car bean = new Car();

                bean.setFuelEfficiency(rs.getInt("avg_fe"));

                avgfeList.add(bean);

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return avgfeList;
    }
}

