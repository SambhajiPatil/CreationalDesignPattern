package CreationalDesignPatternsFactoryPattern;

import CreationalDesignPatternsFactoryPattern.PizzahutFactory.CustomerType;

public class TestFatory {
	public static void main(String[] args) {
		
		Pizzahut p1=PizzahutFactory.getCustmore(CustomerType.VegCust);
		Pizzahut p2=PizzahutFactory.getCustmore(CustomerType.NonvegCust);
		
		System.out.println(p1 instanceof VegCustomer);
		System.out.println(p1 instanceof NonvegCustomer);
		System.out.println(p2 instanceof VegCustomer);
		System.out.println(p2 instanceof NonvegCustomer);
		
		System.out.println(p1.getOnlinePayment());
		System.out.println(p1.getBill());
		System.out.println(p1.getHomeDelliwary());
		System.out.println(p2.getOnlinePayment());
		System.out.println(p2.getBill());
		System.out.println(p2.getHomeDelliwary());
		
	}

}

abstract class Pizzahut{
	abstract public boolean getOnlinePayment();
	abstract public String getHomeDelliwary(); 
	abstract public int getBill();
}
class VegCustomer extends Pizzahut{

	@Override
	public boolean getOnlinePayment() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getHomeDelliwary() {
		// TODO Auto-generated method stub
		return "YES we do";
	}

	@Override
	public int getBill() {
		// TODO Auto-generated method stub
		return 1200;
	}
	
}

class NonvegCustomer extends Pizzahut{

	@Override
	public boolean getOnlinePayment() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getHomeDelliwary() {
		// TODO Auto-generated method stub
		return "NO we don't";
	}

	@Override
	public int getBill() {
		// TODO Auto-generated method stub
		return 1600;
	}
	
}

class PizzahutFactory {
	public static Pizzahut getCustmore(CustomerType type) {
		if(type.equals(CustomerType.VegCust))
		{
			return new VegCustomer();
		}else if(type.equals(CustomerType.NonvegCust))
		{
			return new NonvegCustomer();
		}
		return null;
		
	}
	
	enum CustomerType{
		VegCust,
		NonvegCust;
	}
}

