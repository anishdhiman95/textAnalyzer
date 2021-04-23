package com.text.analyzer.processors;

import org.springframework.stereotype.Component;

import com.text.analyzer.enums.CharType;
import com.text.analyzer.models.ResponseModel;

/**
 * Interface Class that is implemented for various use cases and algorithms.
 *
 * @author anishdhiman95
 *
 */
@Component
public interface TextProcessor {

	/**
	 * Process method.
	 */
	void process(CharType charType, char c);

	/**
	 * Generate Result Method.
	 */
	void getResult(ResponseModel responseModel);

	/**
	 * Clear class variables.
	 */
	void clear();
}
