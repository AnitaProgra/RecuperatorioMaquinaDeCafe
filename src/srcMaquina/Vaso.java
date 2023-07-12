package srcMaquina;

public class Vaso {

	
	protected Integer capacidad;
	protected Double valor; 

	public Vaso(Integer capacidad) {
		this.capacidad = capacidad;
	}
	
	public Vaso(Integer capacidad, Double valor) {
		this.capacidad = capacidad;
		this.valor= valor; 
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	} 
	
	
}
