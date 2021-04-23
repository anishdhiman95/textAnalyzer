package com.text.analyzer.processors;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.text.analyzer.enums.CharType;
import com.text.analyzer.models.ResponseModel;

@RunWith(MockitoJUnitRunner.class)
public class ParagraphProcessorTest {
	
	@InjectMocks
	ParagraphProcessor paragraphProcessor;
	
	@Test
	public void testProcess() {
		paragraphProcessor.process(CharType.ALPHA_NUMERIC, 'A');
		assertEquals(0L, ReflectionTestUtils.getField(paragraphProcessor, "count"));
		assertEquals(true, ReflectionTestUtils.getField(paragraphProcessor, "isCharacterPresent"));
		
		paragraphProcessor.process(CharType.SENTENCE_SEPARATOR, '.');
		assertEquals(0L, ReflectionTestUtils.getField(paragraphProcessor, "count"));
		assertEquals(true, ReflectionTestUtils.getField(paragraphProcessor, "isCharacterPresent"));
		
		paragraphProcessor.process(CharType.NEWLINE, '\n');
		assertEquals(1L, ReflectionTestUtils.getField(paragraphProcessor, "count"));
		assertEquals(false, ReflectionTestUtils.getField(paragraphProcessor, "isCharacterPresent"));
		
		paragraphProcessor.process(CharType.NEWLINE, '\n');
		assertEquals(1L, ReflectionTestUtils.getField(paragraphProcessor, "count"));
		assertEquals(false, ReflectionTestUtils.getField(paragraphProcessor, "isCharacterPresent"));
		
		paragraphProcessor.clear();
		
		ReflectionTestUtils.setField(paragraphProcessor, "isCharacterPresent", true);
		paragraphProcessor.process(CharType.SENTENCE_SEPARATOR, '.');
		assertEquals(0L, ReflectionTestUtils.getField(paragraphProcessor, "count"));
		assertEquals(true, ReflectionTestUtils.getField(paragraphProcessor, "isCharacterPresent"));
		
		ReflectionTestUtils.setField(paragraphProcessor, "isCharacterPresent", true);
		paragraphProcessor.process(CharType.ALPHA_NUMERIC, 'A');
		assertEquals(0L, ReflectionTestUtils.getField(paragraphProcessor, "count"));
		assertEquals(true, ReflectionTestUtils.getField(paragraphProcessor, "isCharacterPresent"));
		
		ReflectionTestUtils.setField(paragraphProcessor, "isCharacterPresent", true);
		paragraphProcessor.process(CharType.NEWLINE, '\n');
		assertEquals(1L, ReflectionTestUtils.getField(paragraphProcessor, "count"));
		assertEquals(false, ReflectionTestUtils.getField(paragraphProcessor, "isCharacterPresent"));
		
		ReflectionTestUtils.setField(paragraphProcessor, "isCharacterPresent", true);
		paragraphProcessor.process(CharType.NEWLINE, '\n');
		assertEquals(2L, ReflectionTestUtils.getField(paragraphProcessor, "count"));
		assertEquals(false, ReflectionTestUtils.getField(paragraphProcessor, "isCharacterPresent"));

	}
	
	@Test
	public void testGetResponse() {
		ResponseModel responseModel = new ResponseModel();
		ReflectionTestUtils.setField(paragraphProcessor, "count", 10L);
		paragraphProcessor.getResult(responseModel);
		assertEquals(10L, responseModel.getParagraphCount());
		assertEquals(0L, ReflectionTestUtils.getField(paragraphProcessor, "count"));
		assertEquals(false, ReflectionTestUtils.getField(paragraphProcessor, "isCharacterPresent"));

	}

}
