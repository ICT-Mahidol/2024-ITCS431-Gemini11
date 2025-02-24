
public class MainClass {
	public static void main(String[] args) {
		Salesperson s = new Salesperson("Benni","Benjamin",182);
		Customer c = new Customer("Kitty", "Kitanun",218,"Bangkok, Thailand", "0853478820");
		Vehicle v = new Vehicle(123, "Holiday Travel", 2018, "SX-D1");
		System.out.println("Vehicle Info:\n"+v.getInfo()+"\n");
		System.out.println("Customer Info:\n"+c.getInfo());
		System.out.println(c.purchaseVehicle(123)?"Ordered": "Contact Sale");
	}
}
