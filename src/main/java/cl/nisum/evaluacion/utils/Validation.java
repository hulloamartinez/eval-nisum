package cl.nisum.evaluacion.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class Validation {
	
	public static boolean validateEmail(String email) {
		
		Pattern pattern = Pattern.compile("([a-z0-9]+(\\.?[a-z0-9])*)+@(([a-z]+)\\.([a-z]+))+");
		
		Matcher matcher = pattern.matcher(email);
		
		return matcher.find();
		
	}
	


}
