package it.uniroma3.diadia;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class Configuratore {

	private static final String DIADIA_PROPERTIES = "diadia.properties";
	private static Properties prop = null;
	
	public static int getProprieta(String p) {
		if(prop == null)
			carica();
		return Integer.parseInt(prop.getProperty(p));
	}

	private static void carica() {
		prop = new Properties();
		try {
			InputStream input = Configuratore.class.getClassLoader().getResourceAsStream(DIADIA_PROPERTIES);
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}