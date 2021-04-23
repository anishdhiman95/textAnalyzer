package com.text.analyzer.processors;

import org.springframework.stereotype.Component;

import com.text.analyzer.aspects.LogActivity;
import com.text.analyzer.enums.CharType;
import com.text.analyzer.models.ResponseModel;

/**
 * Paragraph Processor is an implementation of Text Processor that counts the
 * paragraphs in the request text. The algorithm computes the value in O(n) time
 * and uses at most O(1) auxiliary space.
 * 
 * @author anishdhiman95
 */
@Component
public class ParagraphProcessor implements TextProcessor {
	private long count;
	private boolean isCharacterPresent = false;

	/**
	 * This method computes the Paragraph Count.
	 */
	@Override
	public void process(CharType charType, char c) {

		// Checks to see if the Sentence has had a Alphanumeric or Sentence Seperator before it.
		if (!isCharacterPresent
				&& (CharType.ALPHA_NUMERIC.equals(charType) || CharType.SENTENCE_SEPARATOR.equals(charType))) {
			isCharacterPresent = true;
		}
		// If a newline is detected and a alphanumeric is present, it is the case of a correct new line.
		if (CharType.NEWLINE.equals(charType) && isCharacterPresent) {
			count++;
			isCharacterPresent = false;
		}
	}

	/**
	 * This method returns the Paragraph Count computed in process(...).
	 */
	@LogActivity("PARAGRAPH_PROCESSOR")
	@Override
	public void getResult(ResponseModel responseModel) {
		responseModel.setParagraphCount(count);
		clear();
	}

	/**
	 * This method clears all class variables.
	 */
	@Override
	public void clear() {
		count = 0;
		isCharacterPresent = false;
	}
}
