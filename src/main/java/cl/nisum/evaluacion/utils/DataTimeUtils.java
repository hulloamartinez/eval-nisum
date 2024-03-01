package cl.nisum.evaluacion.utils;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class DataTimeUtils {
	
	public static String fechaActual() {
		
		return LocalDateTime.now().toString();
		
	}
	
	

}
