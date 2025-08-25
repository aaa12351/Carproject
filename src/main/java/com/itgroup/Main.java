package com.itgroup;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in) ;
        CarData data = new CarData() ;


        while(true){
            System.out.println("\n차량\t정보\t시스템");
            System.out.println("0:차량목록조회, 1:새로들어온 차량, 2:판매완료된 차량, 3:총차량댓수, 4:최고가/최저가 차량 조회, 5:차량 연식별 조회, 6:가격 통계, 7: 평균 연비, 8:종료");

            int menu = scan.nextInt() ;
            switch(menu){
                case 0:
                    data.selectAll();
                    break;
                case 1:
                    data.newCar();
                    break;
                case 2:
                    data.soldCar();
                    break;
                case 3:
                    data.totalCar();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    System.out.println("차량 목록 시스템을 종료합니다.");
                    System.exit(8);

            }
        }


    }
    }
