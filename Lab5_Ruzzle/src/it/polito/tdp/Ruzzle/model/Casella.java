package it.polito.tdp.Ruzzle.model;

public class Casella {

	private int riga;
	private int col;
	private char c;
	
	public Casella(int riga, int col, char c) {
		super();
		this.riga = riga;
		this.col = col;
		this.c = c;
	}
	public int getRiga() {
		return riga;
	}
	public void setRiga(int riga) {
		this.riga = riga;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public char getC() {
		return c;
	}
	public void setC(char c) {
		this.c = c;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + c;
		result = prime * result + col;
		result = prime * result + riga;
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
		Casella other = (Casella) obj;
		if (c != other.c)
			return false;
		if (col != other.col)
			return false;
		if (riga != other.riga)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Casella [riga=" + riga + ", col=" + col + ", c=" + c + "]";
	}
	
	
}
