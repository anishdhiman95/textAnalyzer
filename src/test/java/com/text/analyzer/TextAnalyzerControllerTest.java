package com.text.analyzer;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(MockitoJUnitRunner.class)
public class TextAnalyzerControllerTest {

	@InjectMocks
	private MockMvc mvc;

	@Ignore
	@Test
	public void analyzeTextFailure() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/v1/analyze-txt")).andExpect(status().isNotFound());
	}

}
