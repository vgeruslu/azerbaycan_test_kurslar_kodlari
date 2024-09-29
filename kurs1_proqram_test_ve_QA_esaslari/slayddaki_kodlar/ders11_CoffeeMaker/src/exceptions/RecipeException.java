package src.exceptions;

import java.io.Serial;

public class RecipeException extends Exception {
	
@Serial
private static final long serialVersionUID = 1L;

	public RecipeException(String msg) {
		super(msg);
	}

}
