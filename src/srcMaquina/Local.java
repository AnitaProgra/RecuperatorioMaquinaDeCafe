package srcMaquina;

import java.util.ArrayList;
import java.util.HashSet;

public class Local {

	protected String nombre; 
	protected Integer ventasVasosCafe;
	protected Double recaudacionDiaria;
	protected HashSet <Maquina> maquinas; 
	protected ArrayList<Vaso> vasosVendidos; 
	
	
	public Local(String nombre, Integer ventasVasosCafe, Double recaudacionDiaria) {
		this.nombre = nombre;
		this.ventasVasosCafe = ventasVasosCafe;
		this.recaudacionDiaria = recaudacionDiaria;
		this.maquinas= new HashSet<>(); 
		this.vasosVendidos= new ArrayList<>();
	}


	public void asignarMaquina(Maquina maquina) {
		maquinas.add(maquina); 
	}
	
	public void eliminarMaquina(Maquina maquina) {
		maquinas.remove(maquina);
	}
	
	public Integer listaMaquinas() {
		return maquinas.size(); 
	}
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Integer getVentasVasosCafe() {
		return ventasVasosCafe;
	}


	public void setVentasVasosCafe(Integer ventasVasosCafe) {
		this.ventasVasosCafe = ventasVasosCafe;
	}


	public Double getRecaudacionDiaria() {
		return recaudacionDiaria;
	}


	public void setRecaudacionDiaria(Double recaudacionDiaria) {
		this.recaudacionDiaria = recaudacionDiaria;
	} 
	
	public boolean corroborarFuncionamientoMaquina(Local local, Maquina maquina) throws SeDebeCambiarLaMaquinaException {
		  try {
			  if(maquina.cantidadVasosVacios()<10) {
				  return true;
			  }
			  else {throw new SeDebeCambiarLaMaquinaException("Se Debe Cambiar La Maquina");} 
			  
		  }
		  catch (SeDebeCambiarLaMaquinaException e) {
			  System.out.println(e.getMessage()); 
			 local.eliminarMaquina(maquina);
			  return false;
		  }
		}
	
	public void venderVasoChico() {
		double valor =120.0; 
		recaudacionDiaria += valor; 
	}
	
	public void venderVasoGrande() {
		double valor =200.0; 
		recaudacionDiaria += valor; 
	}
	
	
	public Double calcularRecaudacion() {
		return recaudacionDiaria; 
	}
	
	
	
	
}
