/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package e2p1_diegovasquez;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Diego Vasquez
 */
public class E2P1_DiegoVasquez extends JFrame implements ActionListener{
    static Scanner lea = new Scanner(System.in);
    static Random ran = new Random();
    private JPanel panel;
    private JButton boton1;
    private JButton boton2;
    private JButton boton3;
    private JLabel titulo;
    static Numero n = new Numero();
    static ArrayList<Numero> numbers = new ArrayList<>();
    
    public E2P1_DiegoVasquez() {
        setTitle("Examen lol");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);
        setLocationRelativeTo(null);
        setResizable(false);
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);
        
        titulo = new JLabel("Examen II");
        titulo.setBounds(150, 20, 300, 50);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        
        boton1 = new JButton("Números");
        boton1.setBounds(100, 100, 200, 50);
        boton1.addActionListener(this);
        
        boton2 = new JButton("Operaciones");
        boton2.setBounds(100, 160, 200, 50);
        boton2.addActionListener(this);
        
        boton3 = new JButton("Salir");
        boton3.setBounds(100, 220, 200, 50);
        boton3.addActionListener(this);
        
        panel.add(titulo);
        panel.add(boton1);
        panel.add(boton2);
        panel.add(boton3);
        
        // Agregar el panel a la ventana
        add(panel);
    }//fin metodo UltimoRepaso
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        E2P1_DiegoVasquez frame = new E2P1_DiegoVasquez();
        frame.setVisible(true);
        // TODO code application logic here
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1){
            boolean rep = true;
            int numsAdded = 0;
            while (rep){
                System.out.println("""
                               =Menu Numeros=
                               
                               1.Agregar número
                               2.Eliminar número
                               3.Menu principal""");
                int op = lea.nextInt();
                switch(op){
                    case 1:{
                        System.out.println("Ingrese su numero");
                        int numero = lea.nextInt();
                        while (numero <= 1 ){
                            System.out.println("Su numero debe de ser mayor que 1 \n Intentelo de nuevo:");
                            numero = lea.nextInt();
                        }//fin validacion
                        System.out.println("Ingrese en que base quisiera ver su numero:");
                        int base = lea.nextInt();
                        while(base <2 || base > 35){
                            System.out.println("numero invalido, solo bases de 2 a 35");
                            base = lea.nextInt();
                        }//fin validacion
                        n.setBase(base);
                        Numero num = new Numero(base, numero);
                        numbers.add(num);
                        System.out.println("Numero Agregado Exitosamente!");
                        numsAdded++;
                    }
                    break;
                    case 2:{
                        if(numsAdded == 0){
                            System.out.println("Porfavor agrege un numero primero con la opcion 1 antes de eliminar 1 jaja");
                        }else{
                            System.out.println("Lista de números: ");
                            for (int i = 0; i < numbers.size(); i++) {
                                System.out.println("1. "+numbers.get(i).getNum()+" base "+numbers.get(i).getBase()+": "+ numbers.get(i).baseToDec());
                            }
                        }
                    }
                    break;
                    case 3:{
                        rep = false;
                    }
                    break;
                    default:{
                        System.out.println("Opcion Invalida");
                    }
                    break;
                }
            }
            
            //cosas de numeros
        }else if (e.getSource() == boton1){
            //cosas de operaciones
        }else if(e.getSource() == boton3){
            System.exit(0);
        }
    }
    
}
