package model.entities;
public class Discount {

	private static float discountProf = (float) 0.05;
	private static float discountStud = (float)0.12;



	public static float getProfDiscount() {
		return discountProf;
	}

	public static float getStudDiscount() {
		return discountStud;
	}

}
