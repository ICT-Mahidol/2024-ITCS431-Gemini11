
public class Salesperson extends Person{
	public String fnSale;
	public String lnSale;
	public int saleId;
	public Salesperson(String fnSale, String lnSale, int saleId) {
		super(fnSale,lnSale);
		this.saleId=saleId;
	}
	public String createInvoice(int cusId) {
		// TODO Auto-generated method stub
		Invoice inv = new Invoice(cusId, saleId);
		return inv.createInvoice(cusId, saleId);
	}

}
