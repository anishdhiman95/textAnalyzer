package com.text.analyzer.processors;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.text.analyzer.enums.CharType;
import com.text.analyzer.models.ResponseModel;

@RunWith(MockitoJUnitRunner.class)
public class WordFrequencyProcessorTest {

	@InjectMocks
	WordFrequencyProcessor wordFrequencyProcessor;

	@Test
	public void testProcess() {
		wordFrequencyProcessor.process(CharType.ALPHA_NUMERIC, 'A');
		assertEquals("A", ReflectionTestUtils.getField(wordFrequencyProcessor, "word").toString());

		wordFrequencyProcessor.process(CharType.WHITESPACE, ' ');
		assertEquals("", ReflectionTestUtils.getField(wordFrequencyProcessor, "word").toString());
		assertEquals("1", ((HashMap<String, Long>) ReflectionTestUtils.getField(wordFrequencyProcessor, "wordFreqMap"))
				.get("a").toString());

		wordFrequencyProcessor.clear();

		wordFrequencyProcessor.process(CharType.NEWLINE, '\n');
		assertEquals("", ReflectionTestUtils.getField(wordFrequencyProcessor, "word").toString());

	}

	@Test
	public void testGetResponse() {
		ResponseModel responseModel = new ResponseModel();

		ReflectionTestUtils.setField(wordFrequencyProcessor, "word", new StringBuilder("TEST"));
		wordFrequencyProcessor.getResult(responseModel);
		assertEquals("", ReflectionTestUtils.getField(wordFrequencyProcessor, "word").toString());
		assertEquals(0L, responseModel.getDistinctWordCount());

		ReflectionTestUtils.setField(wordFrequencyProcessor, "word", new StringBuilder(""));
		wordFrequencyProcessor.getResult(responseModel);
		assertEquals("", ReflectionTestUtils.getField(wordFrequencyProcessor, "word").toString());
		assertEquals(0L, responseModel.getDistinctWordCount());

	}

}
