package team.soft.project.model;

import java.io.Serializable;

import android.os.Parcel;
import android.os.Parcelable;

public class Shoes implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private int price;
	private String color;
	private String size;
	private int quantity;

	public Shoes() {

	}

	public Shoes(String name, int price, String color, String size, int quantity) {
		super();
		this.price = price;
		this.name = name;
		this.size = size;
		this.quantity = quantity;
		this.color = color;
	}
	public Shoes(Shoes shoes) {
		this.price = shoes.getPrice();
		this.name = shoes.getName();
		this.size = shoes.getSize();
		this.quantity = shoes.getQuantity();
		this.color = shoes.getColor();
		
	}
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getSize() {
		return size;
	}

	public void setNumber(int number) {
		this.quantity = number;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + price;
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shoes other = (Shoes) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price != other.price)
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		return true;
	}
}
