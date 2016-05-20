package Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;
import proiectCTS.Abonament;

public class TestObserver {
  Abonament A = new Abonament(123);
  
	//Verificam daca observer-ul primeste mesajul corect
	@Test
	public void test_mesaj_corect() {
		Assert.assertEquals("abonamentul cu id-ul 123 expira in 2 zile",A.expira());
		System.out.println("Clientul primeste mesajul corect");
		Assert.assertNotSame("clientul primeste un mesaj gresit", A.expira());
	}
	
	
	//Verificam daca se trimite mesajul cu 2 zile inainte de expirare
	@Test
	public void test_trimite_mesaj()
	{
		boolean trimite= A.trimiteMesaj(2);
		Assert.assertTrue(trimite);
		boolean trimite2=A.trimiteMesaj(5);
		Assert.assertFalse(trimite2);
	}
	
	
	
	//Verific daca adauga in lista mesajele nenule	
	@Test
	public void test_lista_mesajeNotNULL()
	{
		ArrayList<String> listaMesaje=null;
		ArrayList<String> listaMesaje2=null;
		listaMesaje=A.adaugareInLista("Abonamentul expira");
	    listaMesaje2=A.adaugareInLista("Abonamentul expira in 2 zile");
		Assert.assertNotNull(listaMesaje);
		Assert.assertNotNull(listaMesaje2);
	}
	
	//Verificam daca mesajele nule nu sunt adaugate in lista
	@Test
	public void test_lista_mesajeNULL()
	{
		String mesaj=null;
		ArrayList<String> listaMesaje=A.adaugareInLista(mesaj);
		Assert.assertNull(listaMesaje);
	}

}
