/**
 * 
 */
package com.gupao.peter.showme.method.factory;

/**
 * 定义：工厂方法（Factory Method)模式的意义是定一个创建产品的对象工厂接口
 * 		将实际创建工作推迟到子类中完成
 * 		核心工厂类成为一个抽象的角色，仅负责定义工厂子类必须实现的接口，这样进一步抽象化
 * 		的好处是工厂模式方法模式可以使系统在不修改具体工厂角色的情况下引进新的产品
 * 	
 * @author peterhe
 *
 */
public class Client {

	/**
	 * 可以看出具体的工厂与产品之间的转换，并不需要修改任何的代码，这是工厂方法对外
	 * 扩展的表现
	 * @param args
	 */
	public static void main(String[] args) {
		Creator creator = new BuldCreator();
		Light light = creator.createLight();
		light.turnOn();
		light.turnOff();
		
		creator = new TubeCreator();
		light = creator.createLight();
		light.turnOn();
		light.turnOff();
	}

}
