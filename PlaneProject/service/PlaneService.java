package PlaneProject.service;

import PlaneProject.model.Plane;
import java.util.Scanner;

public class PlaneService {


    public  Plane create(){
        System.out.println("Creating new Plane");
        Scanner sc = new Scanner(System.in);
        System.out.println(" Enter model");
        String model = sc.next();
        System.out.println(" Enter country");
        String country = sc.next();
        System.out.println(" Enter year");
        int year = sc.nextInt();
        System.out.println(" Enter hours");
        int hours = sc.nextInt();
        System.out.println(" Enter if military");
        boolean military = sc.nextBoolean();
        System.out.println(" Enter engineType");

        String engineType = sc.next();
        System.out.println(" Enter weight");
        int weight = sc.nextInt();
        System.out.println(" Enter wing span");
        int wingspan = sc.nextInt();
        System.out.println(" Enter Top Speed");
        int topSpeed= sc.nextInt();
        System.out.println(" Enter seats");
        int seats = sc.nextInt();
        System.out.println(" Enter cost");
        double cost = sc.nextDouble();


        return new Plane(model,country, year,hours,military,  engineType, weight, wingspan, topSpeed, seats, cost) ;


    }

    //Task1
    public  void printInfo(Plane p){
        System.out.println("//////Printing Information about Plane///////");
        System.out.println("Model: " + p.getModel());
        System.out.println("Country: " +p.getCountry());
        System.out.println("Cost: "+p.getCost());
        System.out.println("EngineType: " +p.getEngineType());
        System.out.println("Hours: " +p.getHours());
        System.out.println("Weight"+p.getWeight());
        System.out.println("Seats: "+p.getSeats());
        System.out.println("Top Speed: "+ p.getTopSpeed());
        System.out.println("WingSpan: "+p.getWingspan());
        System.out.println("Is Military"+p.isMilitary());
        System.out.println("Year"+p.getYear());

    }
    //Task2
    public  void printIfMilitary(Plane p){
        if(p.isMilitary()){
            System.out.println(p.getCost());
            System.out.println(p.getTopSpeed());
        }
        else{
            System.out.println(p.getModel());
            System.out.println(p.getCountry());
        }
    }
    //Task3
    public Plane planeNewer(Plane p1, Plane p2){
        if(p1.getYear() < p2.getYear()){
            return p2;
        }
        return p1;
    }

    //Task4
    public Plane planeWithBiggerWingspan(Plane p1, Plane p2){
        if(p1.getWingspan() < p2.getWingspan()){
            return p2;
        }

        return p1;
    }

    //task5
    public  Plane planeWithHighestCost(Plane p1, Plane p2, Plane p3) {
        if(p1.getCost() < p2.getCost() ){
            if(p2.getCost() >= p3.getCost()){
                return p2;
            }
            else{
                return  p3;
            }
        }
        else {
            if(p1.getCost() >= p3.getCost()){
                return p1;
            }
            else{
                return  p3;
            }
        }

    }

    //Task6
    public void smallestSeatCount(Plane p1, Plane p2, Plane p3){
        if(p1.getSeats() >= p2.getSeats() ){
            if(p2.getSeats() <= p3.getSeats()){
                System.out.println(p2.getCountry());
            }
            else{
                System.out.println(p3.getCountry());
            }
        }
        else {
            if(p1.getSeats() <= p3.getSeats()){
                System.out.println(p1.getCountry());
            }
            else{
                System.out.println(p3.getCountry());
            }
        }

    }

    //Task7
    public void printNotMilitaryPlanes(Plane[] array){
        for(Plane p : array){
            if(!p.isMilitary()){
               printInfo(p);
            }
        }
}

    //Task 8
    public void printMilitaryAnd100Hours(Plane[] array){
        for(Plane p : array){
            if(p.isMilitary() && p.getHours() > 100){
                printInfo(p);
            }
        }
    }


    //Task9
    public Plane minimalWeight(Plane[] array){
        Plane temp = array[0];
        for(Plane p : array){
            if(p.getWeight() <=temp.getWeight()){
                temp = p;
            }
        }
        return temp;
    }

    //Task10
    public  Plane minimalCostMilitaryPlanes(Plane[] array){
        Plane temp = array[0];
        for(Plane p : array){
            if(p.isMilitary() && p.getCost() < temp.getCost() ){
                temp = p;
            }
        }
        return temp.isMilitary() ? temp: null;
    }

    //Task11
    public void printAcsendingOrderYear(Plane[] array){
        ascendingOrderYear(array);
        for(Plane p : array){
            printInfo(p);
        }

    }

    //Task12
    public  void printDescendingBySeats(Plane[] array){
        descendingBySeats(array);
        for(Plane p : array){
            if(!p.isMilitary()){
                printInfo(p);
            }

        }

    }

    private static void descendingBySeats(Plane[] array){
        int len = array.length;
        for(int i = 0; i < len-1; i++ ){
            boolean swapped = false;
            for(int j = 0; j < len-i-1; j++){
                if(array[j].getSeats() < array[j+1].getSeats()){
                    Plane temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    swapped = true;
                }

            }
            if(!swapped){
                break;
            }

        }
    }

    private static void ascendingOrderYear(Plane[] array){
        int len = array.length;
        for(int i = 0; i < len-1; i++ ){
            boolean swapped = false;
            for(int j = 0; j < len-i-1; j++){
                if(array[j].getYear() > array[j+1].getYear()){
                    Plane temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    swapped = true;
                }

            }
            if(!swapped){
                break;
            }

        }
    }

























}
