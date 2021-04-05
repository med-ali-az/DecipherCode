package main.java.decipher;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

public class Decipher {
	
	@Test
	public void main() {
		
		String charArray = IntStream.rangeClosed('A', 'Z')
				.mapToObj(c -> "" + (char) c).collect(Collectors.joining()).toString();
		System.out.println(charArray);
		
		String motCle = "KEYWORD";
		String code = "LXQAJI";
		// extraire le mot cle de la chaine alphabétique
		String result = extractCleFromCharArray(charArray, motCle);
		// concatener le mot cle avec la chaine extraite
		String newStr = motCle.concat(result);
		System.out.println(newStr);
		// recuperer le code
		String dc = getDecryptedCode(charArray, code, newStr);
		System.out.println(dc);
	}
	
	String extractCleFromCharArray(String charArray, String motCle) {
		
		while(!motCle.isEmpty()) {
			charArray = charArray.replace(String.valueOf(motCle.charAt(0)), "");
				motCle = motCle.replace(String.valueOf(motCle.charAt(0)), "");
			}
			
		return charArray;
		}
	
	String getDecryptedCode(String charArray, String code, String charArrayRslt) {
		String decryptedCode = "";
		while(!code.isEmpty()) {
			int indexOfCaractere = charArrayRslt.indexOf(String.valueOf(code.charAt(0)));
			decryptedCode = decryptedCode.concat(String.valueOf(charArray.charAt(indexOfCaractere)));
			code = code.replace(String.valueOf(code.charAt(0)), "");
		}
		return decryptedCode;
	}
	

}
