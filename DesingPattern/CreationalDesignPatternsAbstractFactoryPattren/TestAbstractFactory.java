package CreationalDesignPatternsAbstractFactoryPattren;

public class TestAbstractFactory {

	public static void main(String[] args) {
		
		//fist order 
		PizzaFactories pizzfact= new ChickenSupremeFactory();
		PizaaHut ph=PizzahutAbstractFactory.getInstance(pizzfact);
		System.out.println(ph);
		System.out.println("-------------------------------------------");
		//Second order
		PizzaFactories pizzfact1= new VegExoticaFactory();
		PizaaHut ph1 = PizzahutAbstractFactory.getInstance(pizzfact1);
		System.out.println(ph1);

	}

}

abstract class PizaaHut

{
	//abstact class which can hold contract for ChickenSupreme and VegExotica
    abstract public int CashOnDeliveryBill();
    abstract public String MenuType();
    abstract public String menuName();
    abstract public boolean Drinks();
    
    public String toString(){
		return "\n CashOnDeliveryBill : " +CashOnDeliveryBill() +"\n Menutype : " +MenuType()
						+"\n Drinks : " +Drinks()+"\n MenuName : "+menuName();
}
}

class ChickenSupreme extends PizaaHut{

	@Override
	public int CashOnDeliveryBill() {
		// TODO Auto-generated method stub
		return 1050;
	}

	@Override
	public String MenuType() {
		// TODO Auto-generated method stub
		return "NonVeg";
	}

	@Override
	public boolean Drinks() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String menuName() {
		// TODO Auto-generated method stub
		return "ChickenSupreme";
	}
	
}
class VegExotica extends PizaaHut{

	@Override
	public int CashOnDeliveryBill() {
		// TODO Auto-generated method stub
		return 1230;
	}

	@Override
	public String MenuType() {
		// TODO Auto-generated method stub
		return "veg";
	}

	@Override
	public boolean Drinks() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String menuName() {
		// TODO Auto-generated method stub
		return "VegExotica";
	}
	
}

interface PizzaFactories{
	
	//contract for factory classes
	PizaaHut getOrder();
}

class ChickenSupremeFactory implements PizzaFactories{

	@Override
	public PizaaHut getOrder() {
		// TODO Auto-generated method stub
		return new ChickenSupreme();
	}
	
}

class VegExoticaFactory implements PizzaFactories{

	@Override
	public PizaaHut getOrder() {
		// TODO Auto-generated method stub
		return new VegExotica();
	}
	
}


class PizzahutAbstractFactory{
	// Abstact Flactory class return object of actual order
	public static PizaaHut getInstance(PizzaFactories pf) {
		return pf.getOrder();
	}
}