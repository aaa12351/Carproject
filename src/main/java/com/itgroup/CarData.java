package com.itgroup;

import com.itgroup.bean.Car;
import com.itgroup.dao.CarDao;

import java.sql.ResultSet;
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
        System.out.println("번호\t\t브랜드\t모델\t\t\t출시날짜\t\t\t색상");
        for (Car bean : cars) {
            int car_no = bean.getCarNumber();
            String brand = bean.getBrand();
            String car_model = bean.getCarModel();
            String release_date = bean.getReleaseDate();
            String color = bean.getColor();
            String message = car_no + "\t" + brand + "\t\t" + car_model + "\t\t" + release_date + "\t\t" + color;
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

        System.out.println("판매 중인 지점 : ");
        String office = scan.next();

        bean.setCarNumber(car_no);
        bean.setBrand(brand);
        bean.setCarModel(car_model);
        bean.setReleaseDate(release_date);
        bean.setColor(color);
        bean.setCarType(car_type);
        bean.setEngineType(engine_type);
        bean.setFuelEfficiency(fuel_efficiency);
        bean.setPrice(price);
        bean.setOffice(office);

        cnt = cdao.newCar(bean);

        if (cnt == -1) {
            System.out.println("이미 등록된 차량입니다.");
        } else if (cnt == 1) {
            System.out.println(car_no + "번 차량이 등록되었습니다.");
        } else {


        }
    }

    public void soldCar() {
        int car_no = 1006;
        int cnt = -1;
        cnt = cdao.soldCar(car_no);

        if (cnt == 0) {
            System.out.println("이미 판매완료된 차량입니다.");

        } else if (cnt > 0) {
            System.out.println("차량 판매가 완료 되었습니다.");
        } else if (cnt == -1) {
            System.out.println("차량 판매 실패(네트워크 오류)");
        } else {

        }

    }

    public void totalCar() {
        int cnt = cdao.totalCar();
        String message;
        if (cnt == 0) {
            message = "차량 총 댓수가 검색되지 않았습니다.";

        } else {
            message = "차량은 총 " + cnt + "대입니다.";
        }
        System.out.println(message);

    }

    public void highLowPrice() {
        List<Car> priceList = cdao.highLowPrice();

        System.out.println("최고가최저가정보");
        for (int i = 0; i < priceList.size(); i++) {
            Car bean = priceList.get(i);

            System.out.println("최고가 : " + bean.getMaxprice() + "원 " + "최저가 : " + bean.getLowprice() + "원");

        }
    }


    public void carYear(int car_no) {
        Scanner scan = new Scanner(System.in);

        System.out.println("차량 출시일");
        String release_date = scan.next();
        List<Car> year = cdao.carYear(car_no);

        for (Car bean : year) {
            String message = bean.getCarNumber() + "번 차량의 출시일은 " + bean.getReleaseDate() + "입니다.";
            System.out.println(message);
        }
    }

    public void updateCar() {
        int cnt = -1;

        System.out.println("수정하고자 하는 차량 번호 입력 : ");
        int car_no = scan.nextInt();

        Car bean = new Car();

        System.out.println("브랜드 입력 : ");
        String brand = scan.next();

        System.out.println("차량 모델 입력 : ");
        String car_model = scan.next();

        System.out.println("차량 출시일 입력 : ");
        String release_date = scan.next();

        System.out.println("차량 색상 입력 : ");
        String color = scan.next();

        System.out.println("차량 유형 입력 : ");
        String car_type = scan.next();

        System.out.println("엔진 유형 입력 : ");
        String engine_type = scan.next();

        System.out.println("차량 연비 입력 : ");
        int fuel_efficiency = scan.nextInt();

        System.out.println("차량 가격 입력 : ");
        int price = scan.nextInt();

        System.out.println("판매중인 지점 입력 : ");
        String office = scan.next();

        bean.setCarNumber(car_no);
        bean.setBrand(brand);
        bean.setCarModel(car_model);
        bean.setReleaseDate(release_date);
        bean.setColor(color);
        bean.setCarType(car_type);
        bean.setEngineType(engine_type);
        bean.setFuelEfficiency(fuel_efficiency);
        bean.setPrice(price);
        bean.setOffice(office);

        cnt = cdao.updateCar(bean);

        if (cnt == -1) {
            System.out.println("업데이트 실패");
        } else if (cnt == 1) {
            System.out.println("업데이트 성공");
        } else {
        }
    }


    public void avgFe() {
        List<Car> avgfeList = cdao.avgFe();

        System.out.println("평균 연비");
        for (Car bean : avgfeList){
            int fe = bean.getFuelEfficiency();
            int fuel_efficiency = bean.getFuelEfficiency();
            String message = "보유 중인 차량 평균 연비는 " + "\t" + fuel_efficiency + "입니다.";
            System.out.println(message);
        }
    }


    public void dealerCar() {
        Scanner scan = new Scanner(System.in);

        System.out.println("지점별 차량 현황(서울,원주,대전,부산)");
        String office = scan.next();
        List<Car> officedata = cdao.dealerCar(office);
        int cnt = officedata.size();

        if(cnt == 0) {
            System.out.println(office + "지점은 존재하지 않습니다.");
        }else{
            System.out.println(office + "지점은 현재 " + cnt + "대의 차량이 있습니다.");

        }
    }
}


