/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.util.Date;
import model.Venda;

/**
 *
 * @author Acer
 */
public class testConex {
    public static void main(String[] args) {
        
        Date d = new Date();
        Venda v = new Venda(null, null, d, 25.0, "momi");
        System.out.print(v);
    }
    
}
