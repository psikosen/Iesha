package com.lang.iesha;

import com.lang.iesha.Expr1.Binary;
import com.lang.iesha.Expr1.Grouping;
import com.lang.iesha.Expr1.Literal;
import com.lang.iesha.Expr1.Unary;

public class AstPrinter implements Expr1.Visitor<String> {
	String print(Expr1 expr) {
		return expr.accept(this);
	} 

	@Override
	public String visitBinaryExpr1(Binary expr1) {
		// TODO Auto-generated method stub
		return parenthesize(expr1.operator.lexx, expr1.left, expr1.right);
	}

	@Override
	public String visitGroupingExpr1(Grouping expr1) {
		// TODO Auto-generated method stub
		return parenthesize("group", expr1.expression);
	}

	@Override
	public String visitLiteralExpr1(Literal expr1) {
		if(expr1.value == null) return "nil";
		
		return expr1.value.toString();
	}

	@Override
	public String visitUnaryExpr1(Unary expr1) {
		// TODO Auto-generated method stub
		return parenthesize(expr1.operator.lexx, expr1.right);
	}
   
	private String parenthesize(String name, Expr1... exprs) {
		StringBuilder builder = new StringBuilder();
		builder.append("(").append(name);
		
		for (Expr1 expr : exprs) {
			builder.append(" ");
			builder.append(expr.accept(this));
		}
		builder.append(")");
		return builder.toString();
	}
	
	public static void main(String [] args) {
		Token min =  new Token(TokenType.MINUS, "-",null,1);
		Token star = new Token(TokenType.STAR, "*",null,1);
		Expr1 express = new Expr1.Binary(
				new Expr1.Unary(min, 
				new Expr1.Literal(123)),star,
				new Expr1.Grouping(new Expr1.Literal(45.56)));
		System.out.println(new AstPrinter().print(express));
	}
}
