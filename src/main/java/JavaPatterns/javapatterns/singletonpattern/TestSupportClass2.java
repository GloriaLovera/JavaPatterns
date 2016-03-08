package JavaPatterns.javapatterns.singletonpattern;

public class TestSupportClass2 {
	private DBConfig dbConnectionParams;

	public TestSupportClass2() {
		this.dbConnectionParams = DBConfig.getInstance();
	}

	public DBConfig getDbConnectionParams() {
		return dbConnectionParams;
	}
}
