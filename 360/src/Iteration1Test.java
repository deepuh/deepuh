
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Iteration1Test {
	@Test
	public final void testGetD1() {
		String d1 = "Deep Singh";
		assertEquals(d1, VersionInfo.getD1());
	}
	@Test
	public final void testGetD2() {
		String d1 = "Masse Gashay";
		assertEquals(d1, VersionInfo.getD2());
	}
	@Test
	public final void testGetD3() {
		String d1 = "Kurtis Copeland";
		assertEquals(d1, VersionInfo.getD3());
	}
	@Test
	public final void testGetD4() {
		String d1 = "Ho Jun Choi";
		assertEquals(d1, VersionInfo.getD4());
	}
	@Test
	public final void testGetD5() {
		String d1 = "Kian Rivera";
		assertEquals(d1, VersionInfo.getD5());
	}
	@Test
	public final void testUserName() {
		String d1 = "user";
		assertEquals(d1, VersionInfo.getUserName());
	}
	@Test
	public final void testVersion() {
		String d1 = "v.0.1.0";
		assertEquals(d1, VersionInfo.getVersion());
	}
//	@Test
//	private void assertEquals(String a, String b) {
//		if(a.equals(b)) {
//			return;
//		}
//		
//	}


}
