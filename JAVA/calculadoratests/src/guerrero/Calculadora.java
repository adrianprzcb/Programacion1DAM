package guerrero;

/**
 * Created by Alumno1 on 15/02/2021.
 */

public class Calculadora {
    private int num1;
    private int num2;

    public Calculadora(int num1, int num2){
        this.num1= num1;
        this.num2= num2;
    }

    public int suma(){
        return num1+num2;
    }

    public int resta(){
        int resul;
        if (resta2()) resul = num1 - num2;
        else resul = num2 - num1;
        return resul;
    }

    public boolean resta2() {
        if (num1 >= num2) return true;
        else return false;
    }

    public Integer divide2(){
        if (num2==0) return null;
        int resul = num1 / num2;
        return resul;
    }

    public int multiplica(){
        return num1*num2;
    }

    public int divide(){
        return  num1/num2;
    }

}
