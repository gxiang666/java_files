package com.tnti.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class User {

	private String adress;
	private Integer age;
	private String name;
	private String[] arrayData;
	private List<String> listData;
	private Set<String> setData;
	private Map<String, String> mapData;
	private Properties propsData;

	public String[] getArrayData() {
		return arrayData;
	}

	public void setArrayData(String[] arrayData) {
		this.arrayData = arrayData;
	}

	public List<String> getListData() {
		return listData;
	}

	public void setListData(List<String> listData) {
		this.listData = listData;
	}

	public Set<String> getSetData() {
		return setData;
	}

	public void setSetData(Set<String> setData) {
		this.setData = setData;
	}

	public Map<String, String> getMapData() {
		return mapData;
	}

	public void setMapData(Map<String, String> mapData) {
		this.mapData = mapData;
	}

	public Properties getPropsData() {
		return propsData;
	}

	public void setPropsData(Properties propsData) {
		this.propsData = propsData;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public User() {

	}

	public User(String adress, Integer age, String name) {
		super();
		this.adress = adress;
		this.age = age;
		this.name = name;
	}

	public User(String adress, Integer age, String name, String[] arrayData, List<String> listData, Set<String> setData,
			Map<String, String> mapData, Properties propsData) {
		super();
		this.adress = adress;
		this.age = age;
		this.name = name;
		this.arrayData = arrayData;
		this.listData = listData;
		this.setData = setData;
		this.mapData = mapData;
		this.propsData = propsData;
	}

	@Override
	public String toString() {
		return "User [adress=" + adress + ", age=" + age + ", name=" + name + "]";
	}

	public void print() {
		System.out.println("my name is gx");
	}
}
