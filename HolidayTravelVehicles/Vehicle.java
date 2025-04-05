
public class Vehicle {
	public String name;
	public int id, year;
	public String model;
	public int nVehicle=1000;
	public Vehicle(int vnum, String name, int year,String model) {
		// TODO Auto-generated constructor stub
		this.id=vnum;
		this.name=name;
		this.year=year;
		this.model=model;
	}
	public Vehicle(int vnum) {
		this.id=vnum;
	}

	public Boolean purchase(int vnum, int cusId) {
		// TODO Auto-generated method stub
		if(nVehicle-->0) return true;
		return false;
	}
	public String getInfo() {
		return "name: "+name+"\nid: "+String.valueOf(id)+"\nmodel: "+model;
	}
}
