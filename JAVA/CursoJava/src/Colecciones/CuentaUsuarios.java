package Colecciones;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CuentaUsuarios {

    public static void main(String[] args){
        Cliente cl1=new Cliente("Antonio Banderas","00001",2000000);
        Cliente cl2=new Cliente("Rafael Nadal","00002",2500000);
        Cliente cl3=new Cliente("Penelope Cruz","00003",2700000);
        Cliente cl4=new Cliente("Julio Iglesias","00004",4000000);


        Set<Cliente> clientesBanco= new HashSet<Cliente>();

        clientesBanco.add(cl1);
        clientesBanco.add(cl2);
        clientesBanco.add(cl3);
        clientesBanco.add(cl4);

 /*    for (Cliente cliente : clientesBanco){
            if(cliente.getNombre().equals("Julio Iglesias")){
                clientesBanco.remove(cliente);
            }
        }

*/
        for (Cliente cliente : clientesBanco){
            System.out.println(cliente.getNombre()+ " "+ cliente.getNombre()+ " " + cliente.getSaldo());

        }

        Iterator<Cliente> it=clientesBanco.iterator();

        while(it.hasNext()){

            String nombreCliente= it.next().getNombre();
            if(nombreCliente.equals("Julio Iglesias")){

                it.remove();
            }
        }
        System.out.println("------------------------------------------");

        for (Cliente cliente : clientesBanco){

            System.out.println(cliente.getNombre()+ " "+ cliente.getNombre()+ " " + cliente.getSaldo());

        }


      /*  Iterator<Cliente> it=clientesBanco.iterator();
        while(it.hasNext()){
            String nombreCliente=it.next().getNombre();
            System.out.println(nombreCliente);
            String nCuenta=it.next().getnCuenta();
            System.out.println(nCuenta);
        }*/



    }
}
