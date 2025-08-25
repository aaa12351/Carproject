package com.itgroup;

import com.itgroup.bean.Car;
import com.itgroup.dao.CarDao;

import java.util.List;
import java.util.Scanner;


public class CarData {
    private CarDao cdao = null;
    private Scanner scan = null;

    public CarData() {
        this.cdao = new CarDao();
        this.scan = new Scanner(System.in);

    }


    public void selectAll() {
        List<Car> cars = cdao.selectAll();
        System.out.println("차량\t정보\t시스템");
        System.out.println("번호\t브랜드\t모델\t출시날짜\t색상");
        for (Car bean : cars) {
            int car_no = bean.getCarNumber();
            String brand = bean.getBrand();
            String car_model = bean.getCarModel();
            String release_date = bean.getReleaseDate();
            String color = bean.getColor();
            String message = car_no + "\t" + brand + "\t" + car_model + "\t" + release_date + "\t" + color;
            System.out.println(message);
        }

    }

    public void newCar() {
        Car bean = new Car();
        int cnt = -1;

        System.out.println("차량번호 입력 : ");
        int car_no = scan.nextInt();

        System.out.println("브랜드 입력 : ");
        String brand = scan.next();

        System.out.println("차량 모델 입력 : ");
        String car_model = scan.next();

        System.out.println("출시 날짜 입력 : ");
        String release_date = scan.next();

        System.out.println("차량 색상 입력 : ");
        String color = scan.next();

        System.out.println("차량 유형 입력 : ");
        String car_type = scan.next();

        System.out.println("엔진 유형 입력 : ");
        String engine_type = scan.next();

        System.out.println("연비 입력 : ");
        int fuel_efficiency = scan.nextInt();

        System.out.println("차량 가격 입력 : ");
        int price = scan.nextInt();

        bean.setCarNumber(car_no);
        bean.setBrand(brand);
        bean.setCarModel(car_model);
        bean.setReleaseDate(release_date);
        bean.setColor(color);
        bean.setCarType(car_type);
        bean.setEngineType(engine_type);
        bean.setFuelEfficiency(fuel_efficiency);
        bean.setPrice(price);

        cnt = cdao.newCar(bean);

        if (cnt == -1) {
            System.out.println("이미 등록된 차량입니다.");
        } else if (cnt == 1) {
            System.out.println(car_no + "번 차량이 등록되었습니다.");
        } else {


        }
    }

    public void soldCar() {
        int car_no = 1006 ;
        int cnt = -1 ;
        cnt = cdao.soldCar(car_no);

        if (cnt == 0){
            System.out.println("이미 판매완료된 차량입니다.");

        }else if(cnt > 0){
            System.out.println("차량 판매가 완료 되었습니다.");
        }else {

        }

    }

    public void totalCar() {
    }
}
