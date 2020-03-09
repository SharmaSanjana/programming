package strings;


class A{ 
	public static void test(){
		System.out.println("A");
	} 
}
class B extends A{ 
	public static void test(){
		System.out.println("B");
	}
}

public class C{
  public static void main(String[] args) {
	  A a2 = new B();
	  a2.test();
  }
}

//child class normal method cannot override parent class static method
//To override that CC method must also be static

//if both pc and cc have static overridden method 
//and if we call PC p = new CC(); p.staticOverriddenMethod, the PC method will be called
//in case both methods are not static then CC method will be called by PC instance
