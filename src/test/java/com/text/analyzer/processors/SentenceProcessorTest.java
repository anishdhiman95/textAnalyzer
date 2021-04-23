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
public class SentenceProcessorTest {
	
	@InjectMocks
	SentenceProcessor sentenceProcessor;
	
	@Test
	public void testProcess() {
		sentenceProcessor.process(CharType.ALPHA_NUMERIC, 'A');
		assertEquals(0L, ReflectionTestUtils.getField(sentenceProcessor, "count"));
		assertEquals(false, ReflectionTestUtils.getField(sentenceProcessor, "isNewSentence"));
		
		sentenceProcessor.process(CharType.SENTENCE_SEPARATOR, '.');
		assertEquals(1L, ReflectionTestUtils.getField(sentenceProcessor, "count"));
		assertEquals(true, ReflectionTestUtils.getField(sentenceProcessor, "isNewSentence"));
		
		sentenceProcessor.process(CharType.NEWLINE, '\n');
		assertEquals(1L, ReflectionTestUtils.getField(sentenceProcessor, "count"));
		assertEquals(true, ReflectionTestUtils.getField(sentenceProcessor, "isNewSentence"));
		
		sentenceProcessor.process(CharType.NEWLINE, '\n');
		assertEquals(1L, ReflectionTestUtils.getField(sentenceProcessor, "count"));
		assertEquals(true, ReflectionTestUtils.getField(sentenceProcessor, "isNewSentence"));
		
		sentenceProcessor.clear();
		
		ReflectionTestUtils.setField(sentenceProcessor, "isNewSentence", true);
		sentenceProcessor.process(CharType.SENTENCE_SEPARATOR, '.');
		assertEquals(1L, ReflectionTestUtils.getField(sentenceProcessor, "count"));
		assertEquals(true, ReflectionTestUtils.getField(sentenceProcessor, "isNewSentence"));
		
		ReflectionTestUtils.setField(sentenceProcessor, "isNewSentence", true);
		sentenceProcessor.process(CharType.ALPHA_NUMERIC, 'A');
		assertEquals(1L, ReflectionTestUtils.getField(sentenceProcessor, "count"));
		assertEquals(false, ReflectionTestUtils.getField(sentenceProcessor, "isNewSentence"));
		
		ReflectionTestUtils.setField(sentenceProcessor, "isNewSentence", true);
		sentenceProcessor.process(CharType.NEWLINE, '\n');
		assertEquals(1L, ReflectionTestUtils.getField(sentenceProcessor, "count"));
		assertEquals(true, ReflectionTestUtils.getField(sentenceProcessor, "isNewSentence"));
		
		ReflectionTestUtils.setField(sentenceProcessor, "isNewSentence", true);
		sentenceProcessor.process(CharType.NEWLINE, '\n');
		assertEquals(1L, ReflectionTestUtils.getField(sentenceProcessor, "count"));
		assertEquals(true, ReflectionTestUtils.getField(sentenceProcessor, "isNewSentence"));

	}
	
	@Test
	public void testGetResponse() {
		ResponseModel responseModel = new ResponseModel();
		ReflectionTestUtils.setField(sentenceProcessor, "count", 10L);
		sentenceProcessor.getResult(responseModel);
		assertEquals(10L, responseModel.getSentenceCount());
		assertEquals(0L, ReflectionTestUtils.getField(sentenceProcessor, "count"));
		assertEquals(true, ReflectionTestUtils.getField(sentenceProcessor, "isNewSentence"));

	}

}
