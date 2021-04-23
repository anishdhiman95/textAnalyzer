package com.text.analyzer;

import org.junit.Test;
import org.springframework.context.ApplicationContextException;

public class TextAnalyzerApplicationTest {
	
	@Test(expected=ApplicationContextException.class)
	public void testMainForStartUpFailure() {
		String [] args = {"TEST"};
		TextAnalyzerApplication.main(args);
		
	}

}
