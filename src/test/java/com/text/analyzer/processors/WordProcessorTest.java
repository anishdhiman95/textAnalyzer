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
public class WordProcessorTest {

	@InjectMocks
	WordProcessor wordProcessor;
	
	@Test
	public void testProcess() {
		wordProcessor.process(CharType.ALPHA_NUMERIC, 'A');
		assertEquals("A", ReflectionTestUtils.getField(wordProcessor, "word").toString());
		
		wordProcessor.process(CharType.WHITESPACE, ' ');
		assertEquals("", ReflectionTestUtils.getField(wordProcessor, "word").toString());
		assertEquals(1L, ReflectionTestUtils.getField(wordProcessor, "count"));
		
		wordProcessor.process(CharType.NEWLINE, '\n');
		assertEquals("", ReflectionTestUtils.getField(wordProcessor, "word").toString());

	}
	
	@Test
	public void testGetResponse() {
		ResponseModel responseModel = new ResponseModel();
		ReflectionTestUtils.setField(wordProcessor, "word", new StringBuilder("TEST"));
		
		wordProcessor.getResult(responseModel);
		assertEquals("", ReflectionTestUtils.getField(wordProcessor, "word").toString());
		assertEquals(0L, responseModel.getDistinctWordCount());
		ReflectionTestUtils.setField(wordProcessor, "word", new StringBuilder(""));
		
		wordProcessor.getResult(responseModel);
		assertEquals("", ReflectionTestUtils.getField(wordProcessor, "word").toString());
		assertEquals(0L, responseModel.getDistinctWordCount());

	}

}
