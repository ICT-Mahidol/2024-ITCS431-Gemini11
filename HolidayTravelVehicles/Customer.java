
public class Customer extends Person{
	public int cusId;
	public String addr;
	public String phone;
	public String fncus, lncus;


	public Customer(String fncus, String lncus, int cusID, String addr, String phone) {
		super(fncus,lncus);
		this.cusId=cusID;
		this.addr = addr;
		this.phone = phone;
	}
	public String reqInvoice(String fnsale,String lnsale, int saleId) {
		Salesperson sale = new Salesperson(fnsale, lnsale,saleId);
		return sale.createInvoice(cusId);
	}
	public Boolean purchaseVehicle(int vnum) {
		Vehicle v = new Vehicle(vnum);
		return v.purchase(vnum, cusId);
	}
}
