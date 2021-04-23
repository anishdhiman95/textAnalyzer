package com.text.analyzer.processors;

import org.springframework.stereotype.Component;

import com.text.analyzer.aspects.LogActivity;
import com.text.analyzer.enums.CharType;
import com.text.analyzer.models.ResponseModel;

/**
 * Word Processor is an implementation of Text Processor that counts the
 * non-unique words in the request text. The algorithm computes the value in
 * O(n) time and uses at most O(n) auxiliary space.
 * 
 * @author anishdhiman95
 */
@Component
public class WordProcessor implements TextProcessor {

	private long count = 0L;
	private StringBuilder word = new StringBuilder();

	/**
	 * This method computes the non-unique Word Count.
	 */
	@Override
	public void process(CharType charType, char c) {
		// Checks to see there Alphanumeric present. Then appends Character to StringBuilder.
		if (charType.equals(CharType.ALPHA_NUMERIC)) {
			word.append(c);
		} else if (word.length() > 0) {
			// Word already is formed. Adding it to the counter.
			count++;
			word.setLength(0);
		}
	}

	/**
	 * This method returns the Word Count computed in process(...).
	 */
	@LogActivity("WORD_PROCESSOR")
	@Override
	public void getResult(ResponseModel responseModel) {
		if (word.length() > 0) {
			count++;
		}
		responseModel.setWordCount(count);
		clear();
	}

	/**
	 * This method clears all class variables.
	 */
	@Override
	public void clear() {
		count = 0;
		word.setLength(0);
	}
}
