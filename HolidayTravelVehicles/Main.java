public class Main {
    public static void main(String[] args) {
        System.out.println("Vehicle 1");
        Vehicle toyotaYaris001 = new Vehicle(1, "Toyota Yaris", "Yaris", "2018", "Toyota", 670000);
        System.out.println("Serial Number: "+toyotaYaris001.serialNumber);
        System.out.println("Name: "+toyotaYaris001.name);
        System.out.println("Model: "+toyotaYaris001.model);
        System.out.println("Year: "+toyotaYaris001.year);
        System.out.println("Manufacturer: "+toyotaYaris001.manufacturer);
    }
}
