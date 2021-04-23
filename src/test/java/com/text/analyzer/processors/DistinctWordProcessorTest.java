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
public class DistinctWordProcessorTest {

	
	@InjectMocks
	DistinctWordProcessor distinctWordProcessor;
	
	@Test
	public void testProcess() {
		distinctWordProcessor.process(CharType.ALPHA_NUMERIC, 'A');
		assertEquals("A", ReflectionTestUtils.getField(distinctWordProcessor, "word").toString());
		distinctWordProcessor.process(CharType.WHITESPACE, ' ');
		assertEquals("", ReflectionTestUtils.getField(distinctWordProcessor, "word").toString());
		assertEquals("1", ((HashMap<String, Long>) ReflectionTestUtils.getField(distinctWordProcessor, "wordFreqMap")).get("a").toString());
		distinctWordProcessor.clear();
		distinctWordProcessor.process(CharType.NEWLINE, '\n');
		assertEquals("", ReflectionTestUtils.getField(distinctWordProcessor, "word").toString());

	}
	
	@Test
	public void testGetResponse() {
		ResponseModel responseModel = new ResponseModel();
		ReflectionTestUtils.setField(distinctWordProcessor, "word", new StringBuilder("TEST"));
		distinctWordProcessor.getResult(responseModel);
		assertEquals("", ReflectionTestUtils.getField(distinctWordProcessor, "word").toString());
		assertEquals(1L, responseModel.getDistinctWordCount());
		ReflectionTestUtils.setField(distinctWordProcessor, "word", new StringBuilder(""));
		distinctWordProcessor.getResult(responseModel);
		assertEquals("", ReflectionTestUtils.getField(distinctWordProcessor, "word").toString());
		assertEquals(0L, responseModel.getDistinctWordCount());

	}

}
