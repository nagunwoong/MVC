package org.zerock.Test;

public class DatasourceTest {
	

	
	@Inject
	private DataSource ds;
	
	
	@Test
	public void testConection() throws Exception{
		try (Connection con = d.getConnection() {
		System.out.println(con);
		System.out.println("연결 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
}
