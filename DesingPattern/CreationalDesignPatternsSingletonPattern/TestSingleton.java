package CreationalDesignPatternsSingletonPattern;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestSingleton {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub

		//eager loading 1
		PizzahutEager1 peag1=PizzahutEager1.getInstance();
		PizzahutEager1 peag11=PizzahutEager1.getInstance();
		System.out.println(peag1==peag11);
		//eager loading 2
		PizzahutEager2 p=PizzahutEager2.getInstance();
		PizzahutEager2 p1=PizzahutEager2.getInstance();
		System.out.println(p==p1);
			//lazy loading	
		PizzahutLazi pl=PizzahutLazi.getInstance();
		PizzahutLazi pl1=PizzahutLazi.getInstance();
		System.out.println(pl==pl1);
		//thred safe +synchronized at method level
		PizzahutLazithreadsafe pth=PizzahutLazithreadsafe.getInstance();
		PizzahutLazithreadsafe pth1=PizzahutLazithreadsafe.getInstance();
		System.out.println(pth==pth1);
		
		//double check+synchronized at block level
		//Pizzahutdoublecheck pdouble=Pizzahutdoublecheck.getInstance();
		//Pizzahutdoublecheck pdouble1=Pizzahutdoublecheck.getInstance();
	    //System.out.println(pdouble==pdouble1);
	    	    
	    PizzahutBillPugh pizzbp=PizzahutBillPugh.getInstance();
	    PizzahutBillPugh pizzp1=PizzahutBillPugh.getInstance();
	    System.out.println(pizzbp==pizzp1);
	       
	    
	    //Refection mechanism on Double cheching  singletone type(Pizzahutdoublecheck)
	    
	    Pizzahutdoublecheck pizzObj=Pizzahutdoublecheck.getInstance();
	    Pizzahutdoublecheck pizzObj2=null;
	    
	   Constructor cp[] =Pizzahutdoublecheck.class.getConstructors();
	   for (Constructor constructor : cp) {
		   constructor.setAccessible(true);
		   pizzObj2=(Pizzahutdoublecheck)constructor.newInstance();
		
	}
	   
	    
	   System.out.println(pizzObj==pizzObj2);//false means second obejct of the class is created 
	                              //we breack the private policy or we do  bypass the contract
	   
	   //ENUM solutin on refection 
	   pizzahutenum penum= pizzahutenum.pizzaObj;
	   pizzahutenum penum1=pizzahutenum.pizzaObj;
	   System.out.println(penum==penum1);
	   
	  /* pizzahutenum penum2=pizzahutenum.pizzaObj1;
	   System.out.println(penum2==penum1); //false
	   
	   */
		
	}

}

class PizzahutEager1{
	
	//eager Lodding
	
	private static final PizzahutEager1 peager=new PizzahutEager1();
	private PizzahutEager1() {
		System.out.println("this eager loading without static block intialization");
	}
	public static PizzahutEager1 getInstance() {
		return peager;
	}
}

class PizzahutEager2{
	//eager Lodding2
	private static final PizzahutEager2 peager1;
	static {
		 peager1=new PizzahutEager2();
	}
	private PizzahutEager2() {
		System.out.println("this is eager loading with ststic block intialization");
	}
	
	public static PizzahutEager2 getInstance() {
		return peager1;
	}
}

class PizzahutLazi{
	
	//Lazi Loading
	private static  PizzahutLazi plazi;
	
	private PizzahutLazi() {
		System.out.println("this is Lazy loading");
	}
	public static PizzahutLazi getInstance() {
		if(plazi==null) {
		plazi=new PizzahutLazi();
		}
		return plazi;
	}
	
}

class PizzahutLazithreadsafe{
	private static  PizzahutLazithreadsafe pthsafe;
	
	private PizzahutLazithreadsafe() {
		System.out.println("using Threadsafe Synchronized at method level");
	}
	public static synchronized PizzahutLazithreadsafe getInstance() {
		if(pthsafe==null) {
			pthsafe=new PizzahutLazithreadsafe();
		}
		return pthsafe;
	}
	
}

class Pizzahutdoublecheck{
	private static Pizzahutdoublecheck pdch;
	
	private Pizzahutdoublecheck() {
		System.out.println("using Double checking ");
			}
	public static Pizzahutdoublecheck getInstance() {
		if(pdch==null) {
			synchronized (Pizzahutdoublecheck.class) {
				if(pdch==null) {
					pdch=new Pizzahutdoublecheck();
				}
			}
				
			}return pdch;
	}
	
}

class PizzahutBillPugh{
	private static final class innerPizzahutBillPugh{
		private static final PizzahutBillPugh pbp=new PizzahutBillPugh();
	}
	 private PizzahutBillPugh() {
		 System.out.println("this is Bill Pugh...");
	 }
	
	public static PizzahutBillPugh getInstance() {
		return innerPizzahutBillPugh.pbp;
	}
}


enum pizzahutenum{
	pizzaObj,
	//pizzaObj2,
	//pizzaObj1;
}



