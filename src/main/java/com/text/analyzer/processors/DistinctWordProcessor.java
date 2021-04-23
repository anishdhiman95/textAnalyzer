package com.text.analyzer.processors;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.text.analyzer.aspects.LogActivity;
import com.text.analyzer.enums.CharType;
import com.text.analyzer.models.ResponseModel;

/**
 * Distinct Word Processor is an implementation of Text Processor that counts
 * the unique words in the request text. The algorithm computes the value in
 * O(n) time and uses at most O(n) auxiliary space.
 * 
 * @author anishdhiman95
 */
@Component
public class DistinctWordProcessor implements TextProcessor {

	private Map<String, Long> wordFreqMap = new HashMap<>();
	private StringBuilder word = new StringBuilder();

	/**
	 * This method computes the Word Frequency Map and keeps track of the occurrence
	 * of each field.
	 */
	@Override
	public void process(CharType charType, char c) {
		if (charType.equals(CharType.ALPHA_NUMERIC)) {
			// Checks to see there Alphanumeric present. Appends Character to StringBuilder.
			word.append(c);
		} else if (word.length() > 0) {
			// Word already is formed. Adding it to the HashMap
			wordFreqMap.put(word.toString().toLowerCase(), wordFreqMap.getOrDefault(word.toString().toLowerCase(), 0L) + 1);
			word.setLength(0);
		}
	}

	/**
	 * This method returns the Distinct Word Count based on the Word Frequency Map
	 * computed in process(...).
	 */
	@LogActivity("DISTINCT_WORD_PROCESSOR")
	@Override
	public void getResult(ResponseModel responseModel) {
		if (word.length() > 0) {
			// Word already is formed. Adding it to the HashMap
			wordFreqMap.put(word.toString().toLowerCase(), wordFreqMap.getOrDefault(word.toString().toLowerCase(), 0L) + 1);
		}
		int count = wordFreqMap.keySet().size();
		responseModel.setDistinctWordCount(count);
		clear();
	}

	/**
	 * This method clears all class variables.
	 */
	@Override
	public void clear() {
		wordFreqMap.clear();
		word.setLength(0);
	}
}
