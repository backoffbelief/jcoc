package com.kael.coc.bo;
/**
 * 资源池
 * @author kael
 *
 */
public class ResourcePool extends Building {

	protected int goldNum;
	protected int elixirNum;

	public int getGoldNum() {
		return goldNum;
	}

	public void setGoldNum(int goldNum) {
		this.goldNum = goldNum;
	}

	public int getElixirNum() {
		return elixirNum;
	}

	public void setElixirNum(int elixirNum) {
		this.elixirNum = elixirNum;
	}

}
