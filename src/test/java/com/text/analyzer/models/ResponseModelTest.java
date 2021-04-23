package com.text.analyzer.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class ResponseModelTest {
	
	@Test
	public void testResponseModel() {
		
		Map<String, Long> hashMap =	new HashMap<String, Long>();
		hashMap.put("TEST", 123L);
		ResponseModel responseModel = new ResponseModel();
		
		assertEquals(0L, responseModel.getDistinctWordCount());
		assertEquals(0L, responseModel.getParagraphCount());
		assertEquals(0L, responseModel.getSentenceCount());
		assertEquals(0L, responseModel.getWordCount());
		assertNull(responseModel.getWordFrequency());
		
		
		responseModel.setDistinctWordCount(123L);
		responseModel.setParagraphCount(123L);
		responseModel.setSentenceCount(123L);
		responseModel.setWordCount(123L);
		responseModel.setWordFrequency(hashMap);
		assertEquals(123L, responseModel.getDistinctWordCount());
		assertEquals(123L, responseModel.getParagraphCount());
		assertEquals(123L, responseModel.getSentenceCount());
		assertEquals(123L, responseModel.getWordCount());
		assertTrue(responseModel.getWordFrequency().containsKey("TEST"));

	}

}
