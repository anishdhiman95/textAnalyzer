package com.text.analyzer.models;

import java.util.Map;

/**
 * Response Model for text Analyzer.
 * 
 * As the request becomes more complicated, the additional fields can be
 * incorporated in the Response Model Class.
 * 
 * Eg. As we improve the API, there could be a requirement to fetch
 * characterCount, puntuationCount, etc. Those changes can be incorporated here.
 * 
 * @author anishdhiman95
 */
public class ResponseModel {

	/**
	 * Number of non-unique words in request.
	 */
	private long wordCount;

	/**
	 * Number of sentences in request.
	 */
	private long sentenceCount;

	/**
	 * Number of paragraphs in request.
	 */
	private long paragraphCount;

	/**
	 * Number of distinct words in request.
	 */
	private long distinctWordCount;

	/**
	 * Word Frequency of distinct words in request.
	 */
	private Map<String, Long> wordFrequency;

	/**
	 * Fetches non-unique Word Count of request.
	 * 
	 * @return
	 */
	public long getWordCount() {
		return wordCount;
	}

	/**
	 * Sets non-unique Word Count of request.
	 * 
	 * @param wordCount
	 */
	public void setWordCount(long wordCount) {
		this.wordCount = wordCount;
	}

	/**
	 * Fetches distinct Word Count of request.
	 * 
	 * @return
	 */
	public long getDistinctWordCount() {
		return distinctWordCount;
	}

	/**
	 * Sets distinct Word Count of request.
	 * 
	 * @param distinctWordCount
	 */
	public void setDistinctWordCount(long distinctWordCount) {
		this.distinctWordCount = distinctWordCount;
	}

	/**
	 * Fetches Sentence Count of request.
	 * 
	 * @return
	 */
	public long getSentenceCount() {
		return sentenceCount;
	}

	/**
	 * Sets Sentence Count of request.
	 * 
	 * @param sentenceCount
	 */
	public void setSentenceCount(long sentenceCount) {
		this.sentenceCount = sentenceCount;
	}

	/**
	 * Get Paragraph Count of request.
	 * 
	 * @return
	 */
	public long getParagraphCount() {
		return paragraphCount;
	}

	/**
	 * Set Paragraph Count of request.
	 * 
	 * @param paragraphCount
	 */
	public void setParagraphCount(long paragraphCount) {
		this.paragraphCount = paragraphCount;
	}

	/**
	 * Get Word Frequency Map of request.
	 * 
	 * @return
	 */
	public Map<String, Long> getWordFrequency() {
		return wordFrequency;
	}

	/**
	 * Set Word Frequency Map of request.
	 * 
	 * @param wordFrequency
	 */
	public void setWordFrequency(Map<String, Long> wordFrequency) {
		this.wordFrequency = wordFrequency;
	}

	/**
	 * Overridden Method of toString() for the Response Model.
	 */
	@Override
	public String toString() {
		return "ResponseBean [wordCount=" + wordCount + ", sentenceCount=" + sentenceCount + ", paragraphCount="
				+ paragraphCount + ", distinctWordCount=" + distinctWordCount + ", wordFrequency=" + wordFrequency
				+ "]";
	}

}
