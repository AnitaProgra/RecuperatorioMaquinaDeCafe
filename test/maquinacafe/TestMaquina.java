package maquinacafe;

import static org.junit.Assert.*;

import org.junit.Test;

import srcMaquina.GramosDeCafeInsuficientesParaOtroCafeException;
import srcMaquina.LineaCafe;
import srcMaquina.Local;
import srcMaquina.Maquina;
import srcMaquina.SeDebeCambiarLaMaquinaException;
import srcMaquina.Vaso;

public class TestMaquina {

	@Test
	public void testCrearMaquinasYAsignarlasAUnLocal() {
		
		
		Maquina maquina1 = new Maquina(100, 3000, LineaCafe.ECONOMICA);
		Maquina maquina2 = new Maquina(101, 1000, LineaCafe.PREMIUM);
		Maquina maquina3 = new Maquina(100, 2000, LineaCafe.ECONOMICA);
		
		Local martinez = new Local("martinez", null, null); 
	
		martinez.asignarMaquina(maquina1);
		martinez.asignarMaquina(maquina2);
		martinez.asignarMaquina(maquina3);
	//no me va a permitir agregar dos maquinas con el mismo id, ya que es su hashcode	
		assertEquals((Integer)2, martinez.listaMaquinas()); 
		
	}

	@Test
	public void testCrearMaquinaDefectuosa() throws SeDebeCambiarLaMaquinaException {
			
		Maquina maquina1 = new Maquina(100, 3000, LineaCafe.ECONOMICA);
		Maquina maquina2 = new Maquina(101, 1000, LineaCafe.PREMIUM);
		
		Local martinez = new Local("martinez", null, null); 
		
		//los vasos tienen capacidad en cc
		Vaso vasoChico = new Vaso(500); 
		
		martinez.asignarMaquina(maquina1);
		martinez.asignarMaquina(maquina2);
		
	    maquina1.servirVasoLleno(vasoChico);
	    maquina1.servirVasoVacio(vasoChico);
	    maquina1.servirVasoLleno(vasoChico);
	    maquina1.servirVasoVacio(vasoChico);
	    maquina1.servirVasoLleno(vasoChico);
	    maquina1.servirVasoVacio(vasoChico);
	    maquina1.servirVasoLleno(vasoChico);
	    maquina1.servirVasoVacio(vasoChico);
	    maquina1.servirVasoLleno(vasoChico);
	    maquina1.servirVasoVacio(vasoChico);
	    maquina1.servirVasoLleno(vasoChico);
	    maquina1.servirVasoVacio(vasoChico);
	    maquina1.servirVasoLleno(vasoChico);
	    maquina1.servirVasoVacio(vasoChico);
	    maquina1.servirVasoLleno(vasoChico);
	    maquina1.servirVasoVacio(vasoChico);
	    maquina1.servirVasoLleno(vasoChico);
	    maquina1.servirVasoVacio(vasoChico);
	    maquina1.servirVasoLleno(vasoChico);
	    maquina1.servirVasoVacio(vasoChico);
	    
	    
	    
	    assertFalse(martinez.corroborarFuncionamientoMaquina(martinez, maquina1));
	    
	}
	
	@Test
	public void testVerificarQueLaMaquinaDefectuosaSeElimineParaReparar() throws SeDebeCambiarLaMaquinaException {
			
		Maquina maquina1 = new Maquina(100, 3000, LineaCafe.ECONOMICA);
		Maquina maquina2 = new Maquina(101, 1000, LineaCafe.PREMIUM);
		
		Local martinez = new Local("martinez",  null, null); 
		
		//los vasos tienen capacidad en cc
		Vaso vasoChico = new Vaso(500); 
		
		martinez.asignarMaquina(maquina1);
		martinez.asignarMaquina(maquina2);
		
	    maquina1.servirVasoLleno(vasoChico);
	    maquina1.servirVasoVacio(vasoChico);
	    maquina1.servirVasoLleno(vasoChico);
	    maquina1.servirVasoVacio(vasoChico);
	    maquina1.servirVasoLleno(vasoChico);
	    maquina1.servirVasoVacio(vasoChico);
	    maquina1.servirVasoLleno(vasoChico);
	    maquina1.servirVasoVacio(vasoChico);
	    maquina1.servirVasoLleno(vasoChico);
	    maquina1.servirVasoVacio(vasoChico);
	    maquina1.servirVasoLleno(vasoChico);
	    maquina1.servirVasoVacio(vasoChico);
	    maquina1.servirVasoLleno(vasoChico);
	    maquina1.servirVasoVacio(vasoChico);
	    maquina1.servirVasoLleno(vasoChico);
	    maquina1.servirVasoVacio(vasoChico);
	    maquina1.servirVasoLleno(vasoChico);
	    maquina1.servirVasoVacio(vasoChico);
	    maquina1.servirVasoLleno(vasoChico);
	    maquina1.servirVasoVacio(vasoChico);
	    
	    martinez.corroborarFuncionamientoMaquina(martinez, maquina1);
	    
	    assertEquals((Integer)1, martinez.listaMaquinas()); 
	    
	}

	

	@Test
	public void testCalcularLaRecaudacionDiaria(){
			
		Maquina maquina1 = new Maquina(100, 3000, LineaCafe.ECONOMICA);
		
		Local martinez = new Local("martinez", null, 0.0); 
		
		martinez.asignarMaquina(maquina1);
		
	    martinez.venderVasoChico();//vale 120.0
	    martinez.venderVasoChico();
	    martinez.venderVasoGrande();//vale 200.0
	  
	     
	    assertEquals((Double)440.0, martinez.calcularRecaudacion());  
	    
	}	
	
	@Test
	public void testQueNoSePuedaServirMasCafePremiumConGranosInsuficientes() throws GramosDeCafeInsuficientesParaOtroCafeException{
			
		Maquina maquina1 = new Maquina(100, 9, LineaCafe.PREMIUM);
		
		Local martinez = new Local("martinez", null, 0.0); 
		
		martinez.asignarMaquina(maquina1);
		
	    assertFalse(maquina1.queNoSePuedaServirMasCafePremiumConGranosInsuficientes(maquina1));  
	    
	}
	
	@Test
	public void testQueNoSePuedaServirMasCafeEconomicoConGranosInsuficientes() throws GramosDeCafeInsuficientesParaOtroCafeException{
			
		Maquina maquina1 = new Maquina(100, 2, LineaCafe.ECONOMICA);
		
		Local martinez = new Local("martinez", null, 0.0); 
		
		martinez.asignarMaquina(maquina1);
		
	    assertFalse(maquina1.queNoSePuedaServirMasCafeEconomicoConGranosInsuficientes(maquina1));  
	    
	}
	
}
