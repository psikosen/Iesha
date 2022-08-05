package com.lang.iesha;


public abstract class Expr {
    static class Binary extends Expr{
    	Binary(Expr l, Token o, Expr r){
    		this.left = l;
    		this.operator = o;
    		this.right = r;
    	}
    	
     	final Expr left;
    	final Token operator;
    	final Expr right;
    }
    
}
