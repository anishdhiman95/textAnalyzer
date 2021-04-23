package com.text.analyzer;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContextException;

public class TextAnalyzerApplicationTest {
	
	@Test
	public void testMainForStartUpFailure() {
		String [] args = {"TEST"};
		try {
			TextAnalyzerApplication.main(args);
		} catch (ApplicationContextException e) {
			Assert.fail();
			throw e;
		}
	}

}
