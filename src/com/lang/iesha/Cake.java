package com.lang.iesha;

public abstract class Cake {
   abstract void accept(CakeVistor visitor);
}

class Chocolate extends Cake{

	@Override
	void accept(CakeVistor visitor) {
		visitor.visitChocolate(this);
		
	}}

class Vanilla extends Cake{ 
	@Override
	void accept(CakeVistor visitor) {
		visitor.visitVanilla(this); 
	}}

interface CakeVistor{
	void visitChocolate(Chocolate chocolate);
	void visitVanilla(Vanilla vanilla);
}

