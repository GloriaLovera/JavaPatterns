package JavaPatterns.javapatterns.singletonpattern;

/**
 * The singleton design pattern details a class implementation
 * that can be instantiated only once.
 * Singletons are great for storing data shared by an entire 
 * application, e.g. DB connection parameters.
 * 
 * @author glovera
 *
 */

public class DBConfig {
	
	private static final DBConfig instance = new DBConfig();
	private final String URL = "jdbc:oracle:thin:@amrood:1521:EMP";
	private final String USER = "username";
	private final String PASS = "password";
	
	private DBConfig() {}
	
	public static DBConfig getInstance() {
		return instance;
	}
	
	public String getURL() {
		return URL;
	}

	public String getUSER() {
		return USER;
	}

	public String getPASS() {
		return PASS;
	}

}
