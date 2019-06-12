package it.polito.tdp.food.db;

public class CibiComuni {
	
	
	private int ingrediente1;
	private int ingrediente2;
	private int peso;
	
	
	public CibiComuni(int ingrediente1, int ingrediente2, int peso) {
		super();
		this.ingrediente1 = ingrediente1;
		this.ingrediente2 = ingrediente2;
		this.peso = peso;
	}
	
	
	public int getIngrediente1() {
		return ingrediente1;
	}
	public void setIngrediente1(int ingrediente1) {
		this.ingrediente1 = ingrediente1;
	}
	public int getIngrediente2() {
		return ingrediente2;
	}
	public void setIngrediente2(int ingrediente2) {
		this.ingrediente2 = ingrediente2;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ingrediente1;
		result = prime * result + ingrediente2;
		result = prime * result + peso;
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
		CibiComuni other = (CibiComuni) obj;
		if (ingrediente1 != other.ingrediente1)
			return false;
		if (ingrediente2 != other.ingrediente2)
			return false;
		if (peso != other.peso)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return ""+this.ingrediente1+"-"+this.ingrediente2+"("+this.peso+")";
	}
	
	

	
	
	
	

}
