package org.dc.common.ml.naviebayes;

import java.math.BigDecimal;

public class Human {
	
	private int id;
	private String sex;
	private BigDecimal height;
	private BigDecimal weight;
	private BigDecimal footSize;
	
	public Human(int id, String sex, String height, String weight, String footSize) {
		this.id = id;
		this.sex = sex;
		this.height = new BigDecimal(height);
		this.weight = new BigDecimal(weight);
		this.footSize = new BigDecimal(footSize);
	}
	
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public BigDecimal getHeight() {
		return height;
	}
	public void setHeight(BigDecimal height) {
		this.height = height;
	}
	public BigDecimal getWeight() {
		return weight;
	}
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
	public BigDecimal getFootSize() {
		return footSize;
	}
	public void setFootSize(BigDecimal footSize) {
		this.footSize = footSize;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Human other = (Human) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Human [id=" + id + ", sex=" + sex + ", height=" + height + ", weight=" + weight + ", footSize="
				+ footSize + "]";
	}
	

}
