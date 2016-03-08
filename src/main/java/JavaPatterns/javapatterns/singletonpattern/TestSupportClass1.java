package JavaPatterns.javapatterns.singletonpattern;

public class TestSupportClass1 {
	
	private DBConfig dbConnectionParams;

	public TestSupportClass1() {
		this.dbConnectionParams = DBConfig.getInstance();
	}

	public DBConfig getDbConnectionParams() {
		return dbConnectionParams;
	}

}
