package prejmenu;

public class Procesos {
    UtilidadesES utilidadesES;
    
    Procesos(UtilidadesES utilidadesES) {
        this.utilidadesES = utilidadesES;
    }

    void ejecutarOpc(int opc) {
        switch (opc) {
            case 1: ejecutarOpc1();break;
            case 2: ejecutarOpc2();break;
            case 3: ejecutarOpc3();break;
            default: ejecutarNada();
        }
    }

    private void ejecutarOpc1() {
        utilidadesES.mostrarln("Se ejecutó el proceso asociado a la opción 1 - Insertar");
    }

    private void ejecutarOpc2() {
        utilidadesES.mostrarln("Se ejecutó el proceso asociado a la opción 2 - Borrar");
    }

    private void ejecutarOpc3() {
        utilidadesES.mostrarln("Se ejecutó el proceso asociado a la opción 3 - Modificar");
    }

    private void ejecutarNada() {
        utilidadesES.mostrarln("La opción introducida no tiene un proceso asociado.");
    }
}
