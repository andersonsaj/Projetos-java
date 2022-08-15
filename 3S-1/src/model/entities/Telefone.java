package model.entities;

import java.io.Serializable;

public class Telefone implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String tipo;
	private String numero;
	private Integer fk;
	
	public Telefone() {
	}

	public Telefone(Integer id, String tipo, String numero, Integer fk) {
		this.id = id;
		this.tipo = tipo;
		this.numero = numero;
		this.fk = fk;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public Integer getFk() {
		return fk;
	}

	public void setFk(Integer fk) {
		this.fk = fk;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Telefone other = (Telefone) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Telefone [id=" + id + ", tipo=" + tipo + ", numero=" + numero + ", fk=" + fk + "]";
	}

}
