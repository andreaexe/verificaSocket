package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       try {
            System.out.println("Server in avvio!");

            ServerSocket server = new ServerSocket(3000);
            Socket s = server.accept();

            System.out.println("un client si è collegato");
           

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
             Scanner input=new Scanner(System.in);

           String N1String=in.readLine();
            float N1=Float.parseFloat(N1String);

           System.out.println("ho ricevuto il numero:"+N1);

           String N2String=in.readLine();
           float N2=Float.parseFloat(N2String);

           System.out.println("ho ricevuto il numero:"+N2);

           String operazione=in.readLine();

           System.out.println("operazione:"+operazione);

           float risultato=0;

            if(operazione.equals("+")){

                 risultato=N1+N2;

            }
            else if(operazione.equals("-")){

                 risultato=N1-N2;
            }
            else if(operazione.equals("*")){

                 risultato=N1*N2;
            }
            else if(operazione.equals("/")){

                 risultato=(float)N1/N2;
            }
            
            String risultatoString=Float.toString(risultato);

           out.writeBytes(risultatoString);
           
            s.close();
            server.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("errore durante l'istanza del server");
            System.exit(1);
        }
    }
}
