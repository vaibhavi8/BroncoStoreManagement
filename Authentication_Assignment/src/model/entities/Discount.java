package model.entities;
public class Discount {

	private float discountProf;

	private float discountStud;

	public void Discount(float discountStud, float discountProf) {
		this.discountStud = discountStud;
		this.discountProf= discountProf;

	}

	public float getProfDiscount() {
		return discountProf;
	}

	public float getStudDiscount() {
		return discountStud;
	}

}
