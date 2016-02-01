package com.mapping.unionVextends.component;

/**
 * 汽车与轮胎存在组合关系
 *
 */
public class Car {
	private Integer carId;
	private String carName;
	private Wheel wheel;
	public Integer getCarId() {
		return carId;
	}
	public void setCarId(Integer carId) {
		this.carId = carId;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public Wheel getWheel() {
		return wheel;
	}
	public void setWheel(Wheel wheel) {
		this.wheel = wheel;
	}

}
