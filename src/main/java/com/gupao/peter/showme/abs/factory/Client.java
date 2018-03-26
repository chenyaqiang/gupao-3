/**
 * 
 */
package com.gupao.peter.showme.abs.factory;

/**
 * 抽象工厂与工厂方法唯一的区别就是接口里面是一系列的创造抽象产品的方法
 * 如果产品单一 工厂方法是一个非常好的方式
 * 如果产品有多个业务品种与分类 抽象工厂比较适合
 * @author peterhe
 *
 */
public class Client {

	public static void main(String[] args) {
		Creator creator = new Creator1();
		ProductA pa = creator.createProductA();
		ProductB pb = creator.createProductB();
		pa.method();
		pb.method();

		creator = new Creator2();
		pa = creator.createProductA();
		pb = creator.createProductB();
		pa.method();
		pb.method();
	}

}
