package procesos;


import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	Procesos procesos = new Procesos();
	public void menuprincipal() throws IOException {
		int opcion=1;

		do {
			opcion=menuEntrada();
			switch(opcion) {
			case 1:
				procesos.opcionUno();
				opcion=0;
				break;
			case 2:
				procesos.opcionDos();
				opcion=0;
				break;
			case 3:
				procesos.opcionTres();
				opcion=0;
				break;	
                        case 4:
                                procesos.opcionCuatro();
				opcion=0;
				break;	
                        case 5:
                                procesos.opcionCinco();
				opcion=0;
				break;	
                        case 6:
                                procesos.opcionSeis();
                                opcion=0;
                                break;
                        case 7:
                                procesos.salir();
				opcion=0;
				break;	
			}
                        
		}while(opcion==0);
		
	}
	
	public int menuEntrada() {
		int op=0;
		Scanner sc=new Scanner(System.in);
			do {
				System.out.println("1. Registro de Artistas");
				System.out.println("2. Concurso");
				System.out.println("3. Lanzar/Parar/Finalizar Concurso");
                                System.out.println("4. Clasificación actual");
                                System.out.println("5. Clasificación final");
                                System.out.println("6. Iniciar nuevo concurso");
				System.out.println("7. Salir");
                                try{
                                  op=sc.nextInt();  
                                }catch(InputMismatchException e){
                                System.out.println("Introduce un número");
                                break;
                               
                            }
			}while(op<=0||op>7);
		return op;
	}


}
