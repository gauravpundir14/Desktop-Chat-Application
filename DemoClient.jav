import java.net.*;
import java.io.*;

class DemoClient{
    public static void main(String args[])throws Exception
    {
      try{
          Socket sk= new Socket("localhost",2784); //address for the server
          System.out.println("*****Now you can start Chat****");
          BufferedReader keyr= new BufferedReader(new InputStreamReader(System.in)); //to read from the keyboard 
          PrintWriter pw= new PrintWriter(sk.getOutputStream(),true); //open the stream for PrintWriter

          /client reading the message from server through its imputStream/
          InputStreamReader isr = new InputStreamReader(sk.getInputStream());
          BufferedReader ser_receive = new BufferedReader(isr);
          String send,receive;
          while(true)
          {
              send=keyr.readLine();
              pw.println(send);
              if((receive=ser_receive.readLine())!=null)
              {
                  System.out.println("Server :"+receive);
              }
          }
      }
      catch (Exception e){};
    }
}