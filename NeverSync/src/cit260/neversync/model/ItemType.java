/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.neversync.model;

/**
 *
 * @author jeffledbetter
 */
public enum ItemType {
	
	Tool("Machete", "A large heavy knife used for cutting through thick vegetation", 1),
	Food("Bread", "Loaf of bread. Energy boosting and great tasting", 1),
	Weapon("Tomahawk", "A light ax used as a tool or weapon", 4),
	Animal("Ox", "An adult castrated male ox used especially for hauling loads", 5),
	Medicine("Medicine", "A compound or preparation used for the treatment or prevention of disease", 1);
	
	private String name;
	private String description;
	private int age;
	
	ItemType(String name, String description, int age) {
		this.name = name;
		this.description = description;
		this.age = age;
	
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "ItemType{" + "name=" + name + ", description=" + description + ", age=" + age + '}';
	}
	
	
}
