/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

/**
 *
 * @author Acer
 */
public class DbIntegrityException extends RuntimeException{

	private static final long serialVersionUID = -2480251639477580514L;
	
	public DbIntegrityException(String msg) {
		super(msg);
	}
    
}
