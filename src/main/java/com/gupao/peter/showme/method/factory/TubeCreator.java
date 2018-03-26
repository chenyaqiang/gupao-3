/**
 * 
 */
package com.gupao.peter.showme.method.factory;

/**
 * @author peterhe
 *
 */
public class TubeCreator implements Creator {

	public Light createLight() {
		return new TubeLight();
	}

}
