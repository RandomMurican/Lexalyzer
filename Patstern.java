package com.randommurican.lexalyzer;

import java.util.regex.Pattern;

public class Patstern {
	private String kind; // name of the lexeme kind
	private Pattern pat; // RegEx pattern for the kind
	private boolean bool;// whether the pattern gets a value or not
	
	/*	Naming a class "Pattern" breaks the pattern class, go figure.
	 * 	I kind of liked the sound of Patstern so I kept it...
	 */
	
	Patstern(String kind, String inputPat) { // no value pass, assumed false
		this.kind = kind;
		this.pat = Pattern.compile(inputPat);
		bool = false;
	}
	
	Patstern(String kind, String inputPat, boolean bool) { // has value most likely, but we dont assume here
		this.kind = kind;
		this.pat = Pattern.compile(inputPat);
		this.bool = bool;
	}
	
	public String getKind() {return kind;}
	public Pattern getPattern() {return pat;}
	public boolean hasValue() {return bool;}
}
