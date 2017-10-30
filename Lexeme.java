package com.randommurican.Lexalyser;

import java.util.List;
import java.util.regex.Matcher;

public class Lexeme {
	private String kind;
	private int line;
	private int pos;
	private boolean hasValue;
	private String value;
	private boolean success;
	
	Lexeme(String lexemeString, List<Patstern> patterns, int line, int pos) {
		this.line = line; // line of the lexeme
		this.pos = pos; // position of the lexeme
		this.value = lexemeString; // The String that we're checking
		success = false; // Still lazily checking for errors
		hasValue = false; // we assume false, but fix when we know true
		
		/*
		 * Here we cycle through all the known patterns checking each one
		 * until we have a match. 
		 */
		for(int i = 0; i < patterns.size(); i++) {
			Matcher matcher = patterns.get(i).getPattern().matcher(lexemeString);
	        if(matcher.matches()) { 						// When we have a match
	        	this.kind = patterns.get(i).getKind();		// We pull the name of the kind
	        	if(patterns.get(i).hasValue()) {			// Check if we need a value
	        		this.value = lexemeString;				// Add the value if true
	        		hasValue = true;						// And mark down that it has a value
	        	}
	        	i = patterns.size();						// Then we skip the rest of the kinds
	        	success = true;								// and lazily inform the program there were no errors
	        }
		} if(!success)
			System.out.println("Error at Line: " + line + " char: " + pos); // This is printed if we didn't find a match
	}
	
	public boolean getSuccess() {return success;}
	public String getKind() {return kind;}
	public boolean hasValue() {return hasValue;}
	public String getValue() {return value;}
	public String getPos() {return line + ", " + pos;}
	
	public void print() {
		if(hasValue) //Printed with value
			System.out.print("<" + line + "-" + pos + ", " + kind + ", \"" + value + "\"> ");
		else		// Printed without value
			System.out.print("<" + line + "-" + pos + ", " + kind + "> ");
	}
	
}