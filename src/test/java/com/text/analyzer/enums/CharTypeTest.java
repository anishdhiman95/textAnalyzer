package com.text.analyzer.enums;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CharTypeTest {
	
	
	@Test
	public void testCharTypeEnum() {
		
		assertEquals(CharType.WHITESPACE, CharType.getType(' '));
		assertEquals(CharType.NEWLINE, CharType.getType('\n'));
		assertEquals(CharType.SENTENCE_SEPARATOR, CharType.getType('.'));
		assertEquals(CharType.ALPHA_NUMERIC, CharType.getType('A'));
		assertEquals(CharType.NORMAL, CharType.getType('$'));
		assertEquals(CharType.NORMAL, CharType.getType('平'));
		assertEquals(CharType.ALPHA_NUMERIC, CharType.getType('a'));
		assertEquals(CharType.ALPHA_NUMERIC, CharType.getType('1'));
		assertEquals(CharType.ALPHA_NUMERIC, CharType.getType('0'));
		assertEquals(CharType.NORMAL, CharType.getType('='));
		assertEquals(CharType.NORMAL, CharType.getType(')'));
		assertEquals(CharType.NORMAL, CharType.getType('_'));


	}

}
