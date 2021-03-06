package net.sinou.hackerrank.drafts.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assume;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class OneDArrayGameTest {

	@Parameter(0)
	public int[] array;
	@Parameter(1)
	public int leap;
	@Parameter(2)
	public boolean result;

	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { { new int[] { 0, 0, 0, 0, 0 }, 3, true },
				{ new int[] { 0, 0, 0, 1, 1, 1 }, 5, true }, { new int[] { 0, 0, 1, 1, 1, 0 }, 3, false },
				{ new int[] { 0, 1, 0 }, 1, false } };
		return Arrays.asList(data);
	}

	@Test
	public void test() {
		assertEquals("Result", result, OneDArrayGame.canWin(leap, array));
	}

	@Test
	public void optionalTest() {
		// disables this test on Linux system
		Assume.assumeFalse(System.getProperty("os.name").contains("Linux"));
	}

	@Test
	@Ignore
	public void failMethod() {
		// would make the test fail without the @Ignore annotation
		assertTrue(false);
		// Force implementation of the test
		fail("unimplemented test");
	}
}
