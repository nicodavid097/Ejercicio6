/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio6;

/**
 *
 * @author Usuario
 */
public class Ejercicio6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Nicolas David Hernandez");
        Arana objeto = new Arana();
        objeto.setNombre("Arañita");
        System.out.println("Nombre : "+objeto.getNombre());
        System.out.println("------PeterD--------");
        Pc objeto2=new Pc();
        objeto2.setMarca("PCmart");
        System.out.println(objeto2.getMarca());
        
        System.out.println("Oscar Andres Hernandez Ariza");
        Casa objeto3 = new Casa();
        objeto3.setDireccion("Avenida Falsa 123");
        System.out.println("Direccion: "+objeto3.getDireccion());
        
    }

}
