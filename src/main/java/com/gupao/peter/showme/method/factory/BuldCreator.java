package com.gupao.peter.showme.method.factory;

/**
 * 子类：创建指定的具体工厂产品
 * @author peterhe
 *
 */
public class BuldCreator implements Creator {

	public Light createLight() {
		return new BuldLight();
	}

}
