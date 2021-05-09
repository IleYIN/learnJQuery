package cookie;

import java.util.UUID;

import org.junit.Test;

public class UUIDTest {
	@Test
	public void test() {
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString().replaceAll("-", "");
		System.out.println(str.toString());
			
	}
}
