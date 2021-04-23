package com.text.analyzer;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.multipart.MultipartFile;

import com.text.analyzer.models.ResponseModel;
import com.text.analyzer.processors.DistinctWordProcessor;
import com.text.analyzer.processors.ParagraphProcessor;
import com.text.analyzer.processors.SentenceProcessor;
import com.text.analyzer.processors.WordFrequencyProcessor;
import com.text.analyzer.processors.WordProcessor;

@RunWith(MockitoJUnitRunner.class)
public class TextAnalyzerControllerTest {

	WordProcessor wordProcessor;
	SentenceProcessor sentenceProcessor;
	ParagraphProcessor paragraphProcessor;
	DistinctWordProcessor distinctWordProcessor;
	WordFrequencyProcessor wordFrequencyProcessor;
	
	@InjectMocks
	private TextAnalyzerController textAnalyzerController;

	MultipartFile multipartFile = null;
	
	@Before
	public void setup() {
		wordProcessor = new WordProcessor();
		sentenceProcessor = new SentenceProcessor();
		paragraphProcessor = new ParagraphProcessor();
		distinctWordProcessor = new DistinctWordProcessor();
		wordFrequencyProcessor = new WordFrequencyProcessor();

		ReflectionTestUtils.setField(textAnalyzerController, "wordProcessor", wordProcessor);
		ReflectionTestUtils.setField(textAnalyzerController, "sentenceProcessor", sentenceProcessor);
		ReflectionTestUtils.setField(textAnalyzerController, "paragraphProcessor", paragraphProcessor);
		ReflectionTestUtils.setField(textAnalyzerController, "distinctWordProcessor", distinctWordProcessor);		
		ReflectionTestUtils.setField(textAnalyzerController, "wordFrequencyProcessor", wordFrequencyProcessor);

	}

	@Test
	public void testAnalyzeTextTC1Regular() throws IOException {
		setup("TC1.txt");
		ResponseModel response = textAnalyzerController.analyzeText(multipartFile);
		assertEquals(15L, response.getDistinctWordCount());
		assertEquals(17L, response.getWordCount());
		assertEquals(5L, response.getSentenceCount());
		assertEquals(2L, response.getParagraphCount());

	}
	
	@Test
	public void testAnalyzeTextTC2Unicode() throws IOException {
		setup("TC2.txt");
		ResponseModel response = textAnalyzerController.analyzeText(multipartFile);
		assertEquals(9L, response.getDistinctWordCount());
		assertEquals(9L, response.getWordCount());
		assertEquals(5L, response.getSentenceCount());
		assertEquals(2L, response.getParagraphCount());
	}
	
	@Test
	public void testAnalyzeTextTC3NoPunctuations() throws IOException {
		setup("TC3.txt");
		ResponseModel response = textAnalyzerController.analyzeText(multipartFile);
		assertEquals(7L, response.getDistinctWordCount());
		assertEquals(7L, response.getWordCount());
		assertEquals(2L, response.getSentenceCount());
		assertEquals(2L, response.getParagraphCount());
	}
	
	@Test
	public void testAnalyzeTextT4Repetitions() throws IOException {
		setup("TC4.txt");
		ResponseModel response = textAnalyzerController.analyzeText(multipartFile);
		assertEquals(2L, response.getDistinctWordCount());
		assertEquals(16L, response.getWordCount());
		assertEquals(7L, response.getSentenceCount());
		assertEquals(4L, response.getParagraphCount());
	}
	
	public void setup(String fileName) {
		Path path = Paths.get("src/test/resources/testFiles/" + fileName);
		String name = "fileName";
		String originalFileName = "fileName";
		String contentType = "text/plain";
		byte[] content = null;
		try {
			content = Files.readAllBytes(path);
		} catch (final IOException e) {
		}
		multipartFile = new MockMultipartFile(name, originalFileName, contentType, content);
	}
	
}
