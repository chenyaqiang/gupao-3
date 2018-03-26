package com.gupao.peter.showme.abs.factory;


public class Creator1 implements Creator {

	public ProductA createProductA() {
		return new ProductA1();
	}

	public ProductB createProductB() {
		return new ProductB1();
	}

}
