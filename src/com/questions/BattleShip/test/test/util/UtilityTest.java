package test.util;

import org.junit.Assert;
import org.junit.Test;

import com.battleship.util.Utility;

public class UtilityTest {
	@Test
	public void testGetNumericPosition() {
		String input = "A";
		int res = Utility.getNumericPosition(input);

		Assert.assertEquals(1, res);
	}
}
