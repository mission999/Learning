package test.battleship;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.Test;

import com.battleship.SetUpOcean;
import com.battleship.model.Ocean;

public class SetUpOceanTest {
	@Test
	public void testSetupOcean() {
		String input = "5 E\n2\nQ 1 1 A1 B2\nP 2 1 D4 C3\nA1 B2 B2 B3\nA1 B2 B3 A1 D1 E1 D4 D4 D5 D5";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
		Ocean ocean = SetUpOcean.setUpOcean();
		
		Assert.assertEquals(5,ocean.getP1().getArena().getHeight());
	}
	
	@Test
	public void testPlayersMisiles() {
		String input = "5 E\n2\nQ 1 1 A1 B2\nP 2 1 D4 C3\nA1 B2 B2 B3\nA1 B2 B3 A1 D1 E1 D4 D4 D5 D5";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
		Ocean ocean = SetUpOcean.setUpOcean();
		
		Assert.assertEquals(4,ocean.getP1().getMissiles().size());
	}
	
	@Test
	public void testWeightage() {
		String input = "5 E\n2\nQ 1 1 A1 B2\nP 2 1 D4 C3\nA1 B2 B2 B3\nA1 B2 B3 A1 D1 E1 D4 D4 D5 D5";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
		Ocean ocean = SetUpOcean.setUpOcean();
		
		Assert.assertEquals(4,ocean.getP1().getArena().getWeightSum());
	}
}
