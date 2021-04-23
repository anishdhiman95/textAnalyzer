package com.text.analyzer.enums;

/**
 * Enumeration for the types of Characters.
 * 
 * @author anishdhiman95
 */
public enum CharType {
	INIT, WHITESPACE, NEWLINE, SENTENCE_SEPARATOR, ALPHA_NUMERIC, NORMAL;

	
	/**
	 * Method to return the Enumeration of the Character type for the input.
	 * 
	 * @param c
	 * @return
	 */
	public static CharType getType(char c) {
		if (c == ' ') {
			return WHITESPACE;
		} else if (c == '\n') {
			return NEWLINE;
		} else if (c == '.' || c == '?' || c == '!') {
			return SENTENCE_SEPARATOR;
		} else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
			return ALPHA_NUMERIC;
		}
		return NORMAL;
	}

}
