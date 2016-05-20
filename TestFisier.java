package Tests;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import proiectCTS.Abonament;
import proiectCTS.AbonamentBuilder;

public class TestFisier {

	static FileReader reader;
    static BufferedReader br;
    static Abonament A;
    static AbonamentBuilder builder;

    @Before
    public void setUp() throws Exception {
	reader = new FileReader("builder.txt");
	br = new BufferedReader(reader);

	Assert.assertNotNull(reader);

	String linie = null;
	String[] aux = null;

	try {
	    while ((linie = br.readLine()) != null) {
		aux = linie.split(",");
	    }
	    builder = new AbonamentBuilder();
	    A = builder.setIdAbon(1234).setIdClient(23).setStart("3 Martie 2015")
		.setEnd("2 Aprilie 2015").setCNP("1880930100213").setNume("Alexandru").build();

	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

	@Test
	public void testFile() {
		Assert.assertTrue(A.CNP.equals("1880930100213"));
		Assert.assertTrue(A.nume_client.equals("Alexandru"));
	}
	
	@After
    public void closeFile() throws Exception {
	try {
	    br.close();
	    reader.close();
	} catch (Exception ex) {
	    Assert.fail();
	}
    }

}
