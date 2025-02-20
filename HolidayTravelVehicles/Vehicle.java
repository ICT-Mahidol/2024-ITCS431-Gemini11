public class Vehicle {
    public int serialNumber;
    public String name;
    public String model;
    public String year;
    public String manufacturer;
    public float baseCost;

    public Vehicle(int serialNumber, String name, String model, 
    String year, String manufacturer, float baseCost){
        this.serialNumber = serialNumber;
        this.name = name;
        this.model = model;
        this.year = year;
        this.manufacturer = manufacturer;
        this.baseCost = baseCost;
    }
}
