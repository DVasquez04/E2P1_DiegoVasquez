/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package e2p1_diegovasquez;
import java.util.ArrayList;
/**
 *
 * @author Diego Vasquez
 */
public class Numero {
    private int Base;
    private String Num;

    public Numero() {
    }

    public Numero(int Base, int decNum) {
        this.Base = Base;
        this.Num = decToBase(decNum);
    }

    public int getBase() {
        return Base;
    }

    public String getNum() {
        return Num;
    }

    public void setBase(int Base) {
        this.Base = Base;
    }

    public void setNum(String Num) {
        this.Num = Num;
    }
    
    public char numToChar(int num_acon){
        int Ascii = (num_acon + 87);
        char chardedNum = (char)Ascii;
        return chardedNum;
        
    }
    public int charToNum(char char_acon){
        int Ascii = char_acon;
        int num = (Ascii-87);
        return num;
    }
    //convierte el num a string (el mismo num pero en base al numero)
    public String decToBase(int decNum){
        String conv = "";
        ArrayList<Integer> digitos = new ArrayList();
        
        if(decNum > Base){
            int divResp = 0;
            boolean Mayor1 = true;
            while (Mayor1){
                digitos.add(decNum % Base);
                divResp = (decNum / Base);
                if(divResp > 1){   
                    decNum = divResp;
                }else{
                    decNum = divResp;
                    Mayor1 = false;
                }
            }//fin while
            digitos.add(decNum);
            //asignar las posiciones a la cadena
            for (int i = digitos.size()-1; i >= 0; i--) {
                if(digitos.get(i) <= 9){
                    conv += digitos.get(i).toString();
                }else{
                    conv += numToChar(digitos.get(i));
                }
            }//fin for
        }else{
            if(decNum <= 9){
                conv += decNum;
            }else{
                conv += numToChar(decNum);
            }
        }//fin else
        System.out.println("El numero ahora es: "+conv);
        return conv;
        
    }
    //convierte el string a num original
    public int baseToDec(){
        //se usa la string Num
        int acum = 0;

        for (int i = 0; i < Num.length(); i++) {
            int loc = Num.charAt(i);
            if(loc >= 48 && loc <= 57){
                int num = Character.getNumericValue(Num.charAt(i));
                acum += num*(Math.pow(Base, Num.length()-1-i));
            }else{
                int num = (int)charToNum(Num.charAt(i));
                acum += num*(Math.pow(Base, Num.length()-1-i));
            }//fin if
        }//fin for
        return acum;
    }
    
}
