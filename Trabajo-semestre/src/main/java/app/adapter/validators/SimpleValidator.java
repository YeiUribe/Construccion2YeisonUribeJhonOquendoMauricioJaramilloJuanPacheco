package app.adapter.validators;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

import app.application.exceptions.InputsException;

public abstract class SimpleValidator {

    public String stringValidator(String element, String value) throws Exception {
        if (value == null || value.equals("")) {
            throw new InputsException(element + " no puede tener un valor vacío o nulo.");
        }
        return value;
    }

    public int integerValidator(String element, String value) throws Exception {
        stringValidator(element, value);
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new InputsException(element + " debe ser un valor numérico entero.");
        }
    }

    public long longValidator(String element, String value) throws Exception {
        stringValidator(element, value);
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException e) {
            throw new InputsException(element + " debe ser un valor numérico.");
        }
    }
    public double doubleValidator(String element, String value) throws Exception {
        stringValidator(element, value);
        try {
            double doubleValue = Double.parseDouble(value);
            if (doubleValue < 0) {
                 throw new InputsException(element + " no puede ser un valor negativo.");
            }
            return doubleValue;
        } catch (NumberFormatException e) {
            throw new InputsException(element + " debe ser un valor numérico.");
        }
    }
    
    public boolean booleanValidator(String element, String value) throws Exception {
        stringValidator(element, value);
        if (!value.equalsIgnoreCase("true") && !value.equalsIgnoreCase("false")) {
            throw new InputsException(element + " debe ser 'true' o 'false'.");
        }
        return Boolean.parseBoolean(value);
    }

    public LocalDate dateValidator(String element, String value) throws Exception {
        stringValidator(element, value);
        try {
            return LocalDate.parse(value, DateTimeFormatter.ISO_LOCAL_DATE); // Formato YYYY-MM-DD
        } catch (Exception e) {
            throw new InputsException(element + " debe ser una fecha válida en formato YYYY-MM-DD.");
        }
    }
    
    public String emailValidator(String element, String value) throws Exception {
        stringValidator(element, value);
        if (!Pattern.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", value)) {
            throw new InputsException(element + " no es un formato de email válido.");
        }
        return value;
    }

	public String emailValidator(String value) throws InputsException, Exception {
		
		return null;
	}

	public LocalDate dateValidator(String value) throws InputsException, Exception {
		
		return null;
	}

	public String documentValidator(String value) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}