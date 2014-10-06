
import static org.junit.Assert.*;

import org.junit.Test;
import org.newdawn.slick.SlickException;

public class HammerTest {

	@Test
	public void testHammerCanBeCreated() {
		try {
			Hammer h = new Hammer(10, 20);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
