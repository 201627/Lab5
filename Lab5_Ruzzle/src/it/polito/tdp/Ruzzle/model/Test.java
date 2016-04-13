package it.polito.tdp.Ruzzle.model;

import it.polito.tdp.Ruzzle.DAO.ParolaDAO;

public class Test {

	public static void main(String[] args) {
		
		Ruzzle model = new Ruzzle();
		ParolaDAO dao = new ParolaDAO();
		
		System.out.println(dao.isPresente("ciao"));
	}

}
