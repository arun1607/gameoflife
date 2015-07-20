package com.app.logic;

import com.app.exception.InvalidCellPopulationException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniverseTest {

	@Test
	public void cellGenerationTest_1() throws Exception {
		List<String> input = Arrays.asList("-XXX", "XXX-");
		Universe universe = new Universe(input);
		universe.regenerate();
		String[] actual = universe.getCellPopulationArray();
		String[] expected = new String[]{"---X--", "-X--X-", "-X--X-", "--X---"};
		Assert.assertTrue(Arrays.equals(actual, expected));
	}

	@Test
	public void cellGenerationTest_2() throws Exception {
		List<String> input = Arrays.asList("XX", "XX");
		Universe universe = new Universe(input);
		universe.regenerate();
		String[] actual = universe.getCellPopulationArray();
		String[] expected = new String[]{"----", "-XX-", "-XX-", "----"};
		Assert.assertTrue(Arrays.equals(actual, expected));
	}

	@Test
	public void cellGenerationTest_3() throws Exception {
		List<String> input = Arrays.asList("XXX");
		Universe universe = new Universe(input);
		universe.regenerate();
		String[] actual = universe.getCellPopulationArray();
		String[] expected = new String[]{"--X--", "--X--", "--X--"};
		Assert.assertTrue(Arrays.equals(actual, expected));
	}

	@Test
	public void cellGenerationTest_4() throws Exception {
		List<String> input = Arrays.asList("-X-X", "XXX-", "-X-X");
		Universe universe = new Universe(input);
		universe.regenerate();
		String[] actual = universe.getCellPopulationArray();
		String[] expected = new String[]{"------", "-XX---", "-X--X-", "-XX---", "------"};
		Assert.assertTrue(Arrays.equals(actual, expected));
	}

	@Test(expected = InvalidCellPopulationException.class)
	public void cellGenerationTest_5() throws Exception {
		List<String> input = null;
		new Universe(input);
	}

	@Test(expected = InvalidCellPopulationException.class)
	public void cellGenerationTest_6() throws Exception {
		List<String> input = new ArrayList<String>();
		new Universe(input);
	}
}
