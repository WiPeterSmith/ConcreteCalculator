package PropertyProvider;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class ConsolePropertyProvider implements PropertyProvider{
	private final String name;

	public ConsolePropertyProvider(String name) {
		this.name = name;
	}

	public double setProp(String str, String measurement) {
		final String Digits     = "(\\p{Digit}+)";
		final String HexDigits  = "(\\p{XDigit}+)";
		// an exponent is 'e' or 'E' followed by an optionally 
		// signed decimal integer.
		final String Exp        = "[eE][+-]?"+Digits;
		final String fpRegex    =
				("[\\x00-\\x20]*"+     // Optional leading "whitespace"
						"?(" +         // Optional sign character
						"NaN|" +       // "NaN" string
						"Infinity|" +  // "Infinity" string

		    // A decimal floating-point string representing a finite positive
		    // number without a leading sign has at most five basic pieces:
		    // Digits . Digits ExponentPart FloatTypeSuffix
		    // 
		    // Since this method allows integer-only strings as input
		    // in addition to strings of floating-point literals, the
		    // two sub-patterns below are simplifications of the grammar
		    // productions from the Java Language Specification, 2nd 
		    // edition, section 3.10.2.

		    // Digits ._opt Digits_opt ExponentPart_opt FloatTypeSuffix_opt
		    "((("+Digits+"(\\.)?("+Digits+"?)("+Exp+")?)|"+

		    // . Digits ExponentPart_opt FloatTypeSuffix_opt
		    "(\\.("+Digits+")("+Exp+")?)|"+

		    // Hexadecimal strings
		    "((" +
		    // 0[xX] HexDigits ._opt BinaryExponent FloatTypeSuffix_opt
		    "(0[xX]" + HexDigits + "(\\.)?)|" +

		    // 0[xX] HexDigits_opt . HexDigits BinaryExponent FloatTypeSuffix_opt
		    "(0[xX]" + HexDigits + "?(\\.)" + HexDigits + ")" +

		    ")[pP][+-]?" + Digits + "))" +
		    "[fFdD]?))" + "[\\x00-\\x20]*");// Optional trailing "whitespace"

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(">> Please enter the "+str+" of "+this.name+" in "+measurement+": ");
		String input;
		double value = -1.0;
		try {
			while(true){
				input = br.readLine();
				if (Pattern.matches(fpRegex, input)){
					value = Double.valueOf(input);
					if(value > 0)
						return value;
				} 
				System.out.print(">Enter valid double greater than zero for "+str+" of "+this.name+" in "+measurement+": ");
				
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return value;
	}
}
