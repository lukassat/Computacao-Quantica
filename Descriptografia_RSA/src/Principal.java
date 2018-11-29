
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Lucas
 */
public class Principal {

    public static void main(String[] args) {
        
        //VARIAVEIS
        String mensagem;
        //OBJETOS
        Scanner leia = new Scanner(System.in);
        Descriptografia objetoDescriptografia = new Descriptografia();

        // ENTRADAS
        System.out.println("********************************************************************************************************************");
        System.out.println("*******ALGORITMO P/ DESCRIPTOGRAR UMA MENSAGEM*******");
        System.out.println("********************************************************************************************************************");
        System.out.print("Digite a mensagem Cifrada .: ");
        mensagem = leia.next();

        System.out.print("**********MENSAGEM DESCRIPTOGRADA**********************************************************************************");
        System.out.println("");
         objetoDescriptografia.SetmsgCifrada(mensagem);
        objetoDescriptografia.BrutaForca(objetoDescriptografia.EntradaN());
     
        
    }

}
