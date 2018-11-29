
import java.math.BigInteger;
import java.util.Scanner;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Lucas
 */
public class Descriptografia {

    static BigInteger numero;// Defini o tamanho da Chave
    static BigInteger nBI = numero;
    static BigInteger p, q;
    static int ffLooped = 0;
    static int bfLooped = 0;
    static int pfLooped = 0;
    static int esLooped = 0;
    static BigInteger two = new BigInteger("2");
    static BigInteger four = new BigInteger("4");
    BigInteger semiPrime = BigInteger.valueOf(0L);
    BigInteger N, e;
    String msg_decifrada,msg_cifrada;

    public void SetNumero(BigInteger num) {

        numero = num;
    }// FIM SETNumero

    public static BigInteger GetNumero() {

        return numero;
    }// FIM GetNumero

    public BigInteger EntradaN() {
        Scanner ler = new Scanner(System.in);

        String errorMessage = "";
        do {
            try {

                System.out.print("Digite o valor de N : ");
                semiPrime = ler.nextBigInteger();
                errorMessage = "";
            } catch (NumberFormatException nfe) {
                errorMessage = "Entrada Inválida ! Por favor, digite número inteiro";
            }
        } while (!errorMessage.isEmpty());
        return semiPrime;
    } // FIM inputSemiPrime()

    public  void BrutaForca(BigInteger num) { // Método para quebrar o Número N em valores Primos
        BigInteger TWO = new BigInteger("2");
        BigInteger i = new BigInteger("3");

        final long bfStartTime = System.currentTimeMillis();
        while (true) {
            BigInteger tmp0 = num.mod(i);
            if (tmp0 == BigInteger.ZERO) {
                break;
            }
            i = i.add(TWO);
            bfLooped++;
        }
        final long bfEndTime = System.currentTimeMillis();
        q = i;
        setQ(q);
        p = num.divide(i);
        System.out.println("***RSA QUEBRADO***");
        System.out.println("P.: " + i + " ");
        System.out.println("Q.: " + num.divide(i) + " ");
        System.out.println("D.: "+valorD());
       DescriptografiaRSA();
        System.out.println("Tempo total execução.: " + (bfEndTime - bfStartTime) + "ms");
        // System.out.println("BF: steps involved: " + bfLooped);
    }// FIM bruteForceMethodBI()   

    public static void setP(BigInteger pvar) {
        p = pvar;
    }// FIM setP()  

    public static BigInteger getP() {
        return p;

    }// FIM getP()

    public static void setQ(BigInteger qvar) {
        q = qvar;
    }// FIM setQ()

    public static BigInteger getQ() {
        return q;

    }// FIM getQ()

    public BigInteger valorD() {

        BigInteger valor_n;
        BigInteger valor_d;

        valor_n = getP().multiply(getQ());
        setValorN(valor_n);
        //Calcula a função Carmichael phi(n) = (p -1) (q -1)
        BigInteger m = (getP().subtract(BigInteger.ONE))
                .multiply(getQ().subtract(BigInteger.ONE));

        e = new BigInteger("3");
        while (m.gcd(e).intValue() > 1) {
            e = e.add(new BigInteger("2"));
        }

        valor_d = e.modInverse(m);

        return valor_d;

    }// FIM valorD

    
    public void setValorN(BigInteger n) {
        N = n;

    } //FIM setValorN

    public BigInteger getValorN() {

        return N;

    }//FIM getValorN

    public void DescriptografiaRSA() {

        msg_decifrada = new String(new BigInteger(GetmsgCifrada()).modPow(valorD(), getValorN()).toByteArray());
        System.out.println("msg decifrada: " + msg_decifrada);

    }//FIM DescriptografiaRSA
    
      public void SetmsgCifrada(String msg){
        msg_cifrada = msg;
    
    }//FIM SetmsgCifrada
   public String GetmsgCifrada(){
        return msg_cifrada;
    
    }//FIM GetmsgCifrada
}
