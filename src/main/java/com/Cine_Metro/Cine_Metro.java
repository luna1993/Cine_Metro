package com.Cine_Metro;

import ticket.Cartelera;
import ticket.GeneroPelicula;
import ticket.Pelicula;
import ticket.Productos;
import usuarios.Administrador;
import usuarios.Cliente;
import usuarios.Usuario;

import java.util.Scanner;

public class Cine_Metro {
    public static void main(String[] args){
        new Cartelera().llenadoCartelera();
        new GeneroPelicula().llenadoGeneroPelicula();
        new Pelicula().llenadoPelicula();
        new Productos().llenadoProductos();

        Scanner sc=new Scanner(System.in);
        Usuario u=new Usuario();
        Cliente cl=new Cliente();
        Administrador ad=new Administrador();
        u.llenadoUsuario();
        while (true){
                 System.out.println("Ingrese su usuario:");
                 String id= sc.nextLine();
                 if(cl.iniciarSesion(id)==false){
                 if(ad.iniciarSesion(id)==false){
                     System.out.println("Credenciales incorrectas");
                }
            }
        }
    }
}

