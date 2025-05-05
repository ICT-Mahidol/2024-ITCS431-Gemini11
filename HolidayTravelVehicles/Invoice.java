
public class Invoice {
	int cusId, saleId;
	public Invoice(int cusId, int saleId) {
		this.cusId = cusId;
		this.saleId=saleId;
	}
	public String createInvoice(int cusId, int saleId) {
		return createInvoice(cusId, saleId, 0,null,0,null);
	}

	public String createInvoice(int cusId, int saleId,int vnum, String vname,int vyear, String vmod) {
		String inv = "";
		Vehicle vehicle = new Vehicle(vnum, vname, vyear,vmod);
		inv += "cusId: "+String.valueOf(cusId) +"saleId: "+saleId+"vehicle: "+vehicle.getInfo();
		return inv;
	}
}
