package com.lang.iesha;

public abstract class Cake {
   abstract void accept(CakeVistor visitor);
}

class Chocolate extends Cake{

	@Override
	void accept(CakeVistor visitor) {
		// TODO Auto-generated method stub
		
	}}

class Vanilla extends Cake{

	@Override
	void accept(CakeVistor visitor) {
		// TODO Auto-generated method stub
		
	}}

interface CakeVistor{
	void visitChocolate(Chocolate chocolate);
	void visitVanilla(Vanilla vanilla);
}

