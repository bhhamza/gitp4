package com.entreprise.compta;

public class test {

	public static void main(String[] args) {
		Facture f = new Facture("F-102", "Bureau Plus", 450);
		System.out.println(f);
		f.getMontantAPayer() ;
	}

}
