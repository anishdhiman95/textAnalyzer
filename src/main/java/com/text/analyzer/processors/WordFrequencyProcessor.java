package com.text.analyzer.processors;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.text.analyzer.aspects.LogActivity;
import com.text.analyzer.enums.CharType;
import com.text.analyzer.models.ResponseModel;

/**
 * Word Frequency Processor is an implementation of Text Processor that
 * generates the frequency of the unique words in the request text. The
 * algorithm computes the value in O(n) time and uses at most O(n) auxiliary
 * space.
 * 
 * @author anishdhiman95
 */
@Component
public class WordFrequencyProcessor implements TextProcessor {

	private Map<String, Long> wordFreqMap = new HashMap<>();
	private StringBuilder word = new StringBuilder();

	/**
	 * This method computes the Word Frequency Map and keeps track of the occurrence
	 * of each field.
	 */
	@Override
	public void process(CharType charType, char c) {
		// Checks to see there Alphanumeric present. Then appends Character to StringBuilder.
		if (CharType.ALPHA_NUMERIC.equals(charType)) {
			word.append(c);
		} else if (word.length() > 0) {
			// Word already is formed. Adding it to the HashMap.
			wordFreqMap.put(word.toString().toLowerCase(), wordFreqMap.getOrDefault(word.toString(), 0L) + 1);
			word.setLength(0);
		}
	}

	/**
	 * This method returns the Word Frequency based on the Word Frequency Map
	 * computed in process(...).
	 */
	@LogActivity("WORD_FREQUENCY_PROCESSOR")
	@Override
	public void getResult(ResponseModel responseModel) {
		if (word.length() > 0) {
			wordFreqMap.put(word.toString().toLowerCase(), wordFreqMap.getOrDefault(word.toString(), 0L) + 1);
		}
		responseModel.setWordFrequency(new HashMap<String, Long>(wordFreqMap));
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
