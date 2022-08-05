package com.lang.iesha;

public class Token {
  final TokenType type;
  final String lexx;
  final Object literal;
  final int line;
  
  Token(TokenType type, String lexx, Object lit, int line){
	  this.type = type;
	  this.lexx = lexx;
	  this.literal = lit;
	  this.line = line;
  }
  
  public String toString() {
	  return type + " " + lexx + " " + literal;
	  
	  
	 
  }

}
