package javapatterns.singletonpattern;

public class TestSingleton {
	
	public static void main(String[] args) {
		TestSupportClass1 t1 = new TestSupportClass1();
		TestSupportClass2 t2 = new TestSupportClass2();
		boolean sameInstance = t1.getDbConnectionParams()==t2.getDbConnectionParams();
		System.out.println("t1 and t2 has the same instance of DBConfig class? " + sameInstance);
		System.out.println("t1 DBConfig instance ref: " + t1.getDbConnectionParams());
		System.out.println("t2 DBConfig instance ref: " + t2.getDbConnectionParams());
	}

}
