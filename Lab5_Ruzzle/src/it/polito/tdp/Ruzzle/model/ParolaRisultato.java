package it.polito.tdp.Ruzzle.model;

import java.util.Arrays;

public class ParolaRisultato {
	
	boolean[][] posizioni;
	String parola;
	
	public ParolaRisultato(String parola) {
		
		this.parola = parola;
		
		posizioni = new boolean[4][4];
		
		for ( int i = 0; i<=3 ; i++){
			for ( int j = 0; j<= 3; j++){
				posizioni[i][j]=false;
			}
		}
	}

	public boolean[][] getPosizioni() {
		return posizioni;
	}

	public void setPosizioni(boolean[][] posizioni) {
		this.posizioni = posizioni;
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((parola == null) ? 0 : parola.hashCode());
		result = prime * result + Arrays.deepHashCode(posizioni);
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
		ParolaRisultato other = (ParolaRisultato) obj;
		if (parola == null) {
			if (other.parola != null)
				return false;
		} else if (!parola.equals(other.parola))
			return false;
		if (!Arrays.deepEquals(posizioni, other.posizioni))
			return false;
		return true;
	}
	
	public String toString(){
		return parola;
	}

}
