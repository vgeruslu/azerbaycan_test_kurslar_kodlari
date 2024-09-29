package src.exceptions;

import java.io.Serial;

public class InventoryException extends Exception {

	@Serial
    private static final long serialVersionUID = 1L;
	
	public InventoryException(String msg) {
		super(msg);
	}

}
