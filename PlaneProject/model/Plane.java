package PlaneProject.model;

public class Plane {

    private String model = "ModelName";
    private String country = "Armenia";
    private int year = 1903;
    private int hours;

    private boolean military = false;

    private String engineType = "My Engine Type";
    private int weight = 1000;
    private int wingspan = 10;
    private int topSpeed = 0;
    private int seats = 0;

    private double cost = 0;

    public Plane(String model, String country, int year, int hours, boolean military, String engineType, int weight, int wingspan, int topSpeed, int seats, double cost) {
        if(model != "")
            this.model = model;
        if(country!= "")
            this.country = country;
        if(year>= 1903 && year <= 2020)
            this.year = year;
        if(hours>= 0 && year <= 10000)
            this.hours = hours;
        this.military = military;
        if(engineType!= "")
            this.engineType = engineType;
        if(weight>=1000 && weight<= 16000)
            this.weight = weight;
        if(wingspan>=10 && wingspan<= 45)
            this.wingspan = wingspan;
        if(topSpeed <= 1000)
            this.topSpeed = topSpeed;
        if(seats >= 0)
            this.seats = seats;
        if(cost >=0)
            this.cost = cost;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public boolean isMilitary() {
        return military;
    }

    public void setMilitary(boolean military) {
        this.military = military;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWingspan() {
        return wingspan;
    }

    public void setWingspan(int wingspan) {
        this.wingspan = wingspan;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }






}
