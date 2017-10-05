package test.battleship;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.Test;

import test.util.CustomizedInput;

import com.battleship.Mediator;
import com.battleship.SetUpOcean;
import com.battleship.model.Ocean;

public class MediatorTest {
	@Test
	public void testLoserMissiles() {
		Mediator med = new Mediator();
		Ocean ocean = CustomizedInput.getCustomizedOcean();
		med.startPlay(ocean);

		Assert.assertEquals(0, ocean.getP1().getMissiles().size());

	}
	
	@Test
	public void testWeighatge() {
		Mediator med = new Mediator();
		Ocean ocean = CustomizedInput.getCustomizedOcean();
		med.startPlay(ocean);

		Assert.assertEquals(0, ocean.getP1().getArena().getWeightSum());

	}
	
	@Test
	public void testWinnerWeightage() {
		Mediator med = new Mediator();
		
		String input = "5 E\n2\nQ 1 1 A1 B2\nP 2 1 D4 C3\nA1 B2 B2 B3\nA1 B2 B3 A1 D1 E1 D4 D4 D5 D5";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
		Ocean ocean = SetUpOcean.setUpOcean();

		Assert.assertEquals(4, ocean.getP2().getArena().getWeightSum());

	}

	
}
