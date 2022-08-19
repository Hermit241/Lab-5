package serverside;

import java.util.regex.Pattern;

public class SentenceProcessor {
	
	private int size = 65535;
	
	private String sentence;
	
	
	public SentenceProcessor(byte[] byteData) {
		
		this.sentence = new String(byteData);
	}
	
	public String getSentence() {
		
		return sentence;
	}
	
	/**
	 * This method convert value into an array of byte
	 * @param length
	 * @return
	 */
	public byte[] convertToByteArray(int value) {
		
		byte[] outData = new byte[size];
		
		String stringValue = Integer.valueOf(value).toString();
		
        outData = stringValue.getBytes();
        
        return outData;
	}
	
	/**
	 * This method count the number of characters in a sentence
	 * @return
	 */
	public int countCharacters() {
		
        int index = 0;
        char currentChar = sentence.charAt(index);
        while (currentChar != '\0') {
        	
        	currentChar = sentence.charAt(index++);
        }
        

        return index - 1;
	}
	
	/**
	 * This method is used to count the vowels, consonants and punctuations
	 * @param 
	 * @return*/
	
	public int[] analyzeSentence() {
		int vowels = 0, consonants = 0, punctuations = 0;
		
		int index = 0;
		String lowerCaseSentence = sentence.toLowerCase();
		char currentChar;
		do{
		currentChar = lowerCaseSentence.charAt(index++);
			if (currentChar == 'a' || currentChar == 'e' || currentChar == 'i' || currentChar == 'o' || currentChar == 'u' ) {
				vowels++;
			}
			else if (currentChar >= 'a' && currentChar <= 'z') {
				consonants++;
			}
			else
			{
				if (!Character.isWhitespace(currentChar) && !Character.isISOControl(currentChar)) {
					punctuations++;
				}
			}
		}while(currentChar != '\0');
		
		return new int[] {vowels, consonants, punctuations};
	}
	
	
	
	

}
