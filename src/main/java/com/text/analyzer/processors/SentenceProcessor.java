package com.text.analyzer.processors;

import org.springframework.stereotype.Component;

import com.text.analyzer.aspects.LogActivity;
import com.text.analyzer.enums.CharType;
import com.text.analyzer.models.ResponseModel;

/**
 * Sentence Processor is an implementation of Text Processor that counts the
 * sentences in the request text. The algorithm computes the value in O(n) time
 * and uses at most O(1) auxiliary space.
 * 
 * @author anishdhiman95
 */
@Component
public class SentenceProcessor implements TextProcessor {
	private long count;
	private boolean isNewSentence = true;

	/**
	 * This method computes the Sentence Count.
	 */
	@Override
	public void process(CharType charType, char c) {

		// Checks to see if the Sentence has had a Alphanumeric before it.
		if (isNewSentence && CharType.ALPHA_NUMERIC.equals(charType)) {
			isNewSentence = false;
		}
		// If a newline is detected or a sentence seperator occurss, for an existing
		// sentence, it is considered as a new sentence.
		if (CharType.SENTENCE_SEPARATOR.equals(charType) || (CharType.NEWLINE.equals(charType) && !isNewSentence)) {
			count++;
			isNewSentence = true;
		}
	}

	/**
	 * This method returns the Sentence Count computed in process(...).
	 */
	@LogActivity("SENTENCE_PROCESSOR")
	@Override
	public void getResult(ResponseModel responseModel) {
		responseModel.setSentenceCount(count);
		clear();
	}

	/**
	 * This method clears all class variables.
	 */
	@Override
	public void clear() {
		count = 0;
		isNewSentence = true;
	}
}