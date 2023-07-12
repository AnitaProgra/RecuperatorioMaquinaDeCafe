package srcMaquina;

import java.util.ArrayList;
import java.util.Objects;

public class Maquina {

	protected Integer idMaquina; 
	protected Integer capacidadGranos; //en gramos 
	protected LineaCafe linea; 
	protected Integer vaso; 
	protected ArrayList <Vaso> vasosServidos; 
	protected ArrayList <Vaso> vasosVacios; 
	
	
	public Maquina( Integer idMaquina, Integer capacidadGranos, LineaCafe linea) {
		this.idMaquina= idMaquina; 
		this.capacidadGranos = capacidadGranos;
		this.linea = linea;
		this.vasosServidos= new ArrayList<>(); 
		this.vasosVacios= new ArrayList<>(); 
	}



	public void servirVasoLleno(Vaso vaso) {
		vasosServidos.add(vaso); 
		
	}
	
	public void servirVasoVacio(Vaso vaso) {
		vasosVacios.add(vaso); 
		
	}
	
	public Integer cantidadVasosLlenos() {
		return vasosServidos.size(); 
	}
	
	
	public Integer cantidadVasosVacios() {
		return vasosVacios.size(); 
	}

	
	
	
	
	
	public Integer getIdMaquina() {
		return idMaquina;
	}



	public void setIdMaquina(Integer idMaquina) {
		this.idMaquina = idMaquina;
	}



	public Integer getCapacidadGranos() {
		return capacidadGranos;
	}


	public void setCapacidadGranos(Integer capacidadGranos) {
		this.capacidadGranos = capacidadGranos;
	}


	public LineaCafe getLinea() {
		return linea;
	}


	public void setLinea(LineaCafe linea) {
		this.linea = linea;
	}



	@Override
	public int hashCode() {
		return Objects.hash(idMaquina);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Maquina other = (Maquina) obj;
		return Objects.equals(idMaquina, other.idMaquina);
	} 
	
	
	public boolean queNoSePuedaServirMasCafePremiumConGranosInsuficientes(Maquina maquina) throws GramosDeCafeInsuficientesParaOtroCafeException{
		try {
			if(maquina.getCapacidadGranos()<10 &&  linea==LineaCafe.PREMIUM) {
				throw new GramosDeCafeInsuficientesParaOtroCafeException("cargue mas cafe");
			}
		  else return true; 
		}
			catch (GramosDeCafeInsuficientesParaOtroCafeException e) {
				System.out.println(e.getMessage());
				return false; }
			
		
	}
	
	
	public boolean queNoSePuedaServirMasCafeEconomicoConGranosInsuficientes(Maquina maquina) throws GramosDeCafeInsuficientesParaOtroCafeException{
		try {
			if(maquina.getCapacidadGranos()<3 &&  linea==LineaCafe.ECONOMICA) {
				throw new GramosDeCafeInsuficientesParaOtroCafeException("cargue mas cafe");
			}
		  else return true; 
		}
			catch (GramosDeCafeInsuficientesParaOtroCafeException e) {
				System.out.println(e.getMessage());
				return false; }
			
		
	}
	
	
}
