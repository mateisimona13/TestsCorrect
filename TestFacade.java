package Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import junit.framework.Assert;
import proiectCTS.Client;
import proiectCTS.ProgramCurs;
import proiectCTS.Public;
import proiectCTS.Sala;

public class TestFacade {

	ProgramCurs pc= new ProgramCurs();
	Sala sala= new Sala("Laguna verde");
	Client client=new Client();
	Public publicul=new Public(5);
	
	
	//Verificam daca numele salii este corect
	@Test
	public void test_numeSala() {
		Assert.assertEquals("Mihai Eminescu",pc.numeSala());
		Assert.assertNotSame("Ion Creanga", pc.numeSala());
	}
	
	//Verificam daca se aprinde lumina la Sala
	@Test
	public void test_luminaAprinsa()
	{
		boolean aprinde= sala.aprindeLumina();
		Assert.assertTrue(aprinde);
		
	}

	//Verificam daca daca se returneaza lista de clienti cand nu este vida 
	@Test
	public void test_clienti_NotNULL()
	{
		ArrayList<Client> clienti=publicul.listaPublic(10);
		Assert.assertNotNull(clienti);
		System.out.println("Se returneaza lista de clienti");
		
	}
	
	//Verificam daca lista nula de clienti nu este returnata
	@Test
	public void test_clienti_NULL()
	{
		ArrayList<Client> clienti2=publicul.listaPublic(0);
		Assert.assertNull(clienti2);
		System.out.println("Nu se returneaza lista de clienti");
	}
}
