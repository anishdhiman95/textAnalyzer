package com.text.analyzer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.text.analyzer.enums.CharType;
import com.text.analyzer.models.ResponseModel;
import com.text.analyzer.processors.DistinctWordProcessor;
import com.text.analyzer.processors.ParagraphProcessor;
import com.text.analyzer.processors.SentenceProcessor;
import com.text.analyzer.processors.TextProcessor;
import com.text.analyzer.processors.WordFrequencyProcessor;
import com.text.analyzer.processors.WordProcessor;

/**
 * Implementation of REST Controller to intercept and process incoming request.
 * It has @Controller and @ResponseBody enabled.
 * 
 * @author anishdhiman95
 */
@RestController
public class TextAnalyzerController {

	@Autowired
	SentenceProcessor sentenceProcessor;
	@Autowired
	ParagraphProcessor paragraphProcessor;
	@Autowired
	WordProcessor wordProcessor;
	@Autowired
	DistinctWordProcessor distinctWordProcessor;
	@Autowired
	WordFrequencyProcessor wordFrequencyProcessor;

	/**
	 * Implementation of the REST API for Analyzing Text. Accepts a request document
	 * and returns a response with the statistical information of the request.
	 * 
	 * @param requestBean
	 * @return
	 */
	@PostMapping("/v1/analyze-text")
	public ResponseModel analyzeText(@RequestPart("file") MultipartFile file) throws IOException {
		ResponseModel responseBean = new ResponseModel();

		// Check if file has a non-null name
		if (null == file.getOriginalFilename()) {
			return null;
		}
		byte[] bytes = file.getBytes();

		// Command/Operation Design Pattern
		List<TextProcessor> processorList = Arrays.asList(sentenceProcessor, paragraphProcessor, wordProcessor,
				distinctWordProcessor, wordFrequencyProcessor);

		// Command Pattern: Process Command
		new String(bytes, StandardCharsets.UTF_8).codePoints()
				.mapToObj(character -> Character.valueOf((char) character)).forEach(character -> {
					CharType charType = CharType.getType(character);
					processorList.forEach(counter -> counter.process(charType, character));
				});

		// Command Pattern: Get Result Command
		processorList.forEach(processor -> processor.getResult(responseBean));
		return responseBean;

	}

}