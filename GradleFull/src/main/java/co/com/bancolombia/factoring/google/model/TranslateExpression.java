package co.com.bancolombia.factoring.google.model;



public class TranslateExpression {
	
	private String sourceLanguage;
	private String targetLanguage;
	String word;
	
	public TranslateExpression(String sourceLanguage, String targetLanguage, String word) {
		this.sourceLanguage = sourceLanguage;
		this.targetLanguage = targetLanguage;
		this.word = word;
	}

	public String getSourceLanguage() {
		return sourceLanguage;
	}

	public String getTargetLanguage() {
		return targetLanguage;
	}

	public String getWord() {
		return word;
	}

}
