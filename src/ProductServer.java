import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ProductServer {
    public static void main(String[] args) throws IOException {
        String product1 = "bread";
        String product2 = "jam";
        String product3 = "cake";

        double product1Price = 20;
        double product2Price = 100;
        double product3Price = 50;


        ServerSocket serverSocket = new ServerSocket(6600);
        Socket sc = serverSocket.accept();

        System.out.println("Connection established with client!");

        OutputStreamWriter out = new OutputStreamWriter(sc.getOutputStream());
        BufferedWriter sWriter = new BufferedWriter(out);

        InputStreamReader in = new InputStreamReader(sc.getInputStream());
        BufferedReader sReader = new BufferedReader(in);

        while (true) {
            String op = sReader.readLine();
            if (op.equals("res")) {
                String pro = sReader.readLine();
                double qua = Double.parseDouble(sReader.readLine());

//                double n1 = Double.parseDouble(num1);
//                double n2 = Double.parseDouble(num2);
                if (pro.equals(product1)) {
                    double result = product1Price * qua;
                    System.out.println("Total price: \n" + result);

                    sWriter.write(result + "\n");
                    sWriter.flush();
                }
                if (pro.equals(product2)) {
                    double result = product2Price * qua;
                    System.out.println("Total price: \n" + result);

                    sWriter.write(result + "\n");
                    sWriter.flush();
                }
                if (pro.equals(product3)) {
                    double result = product3Price * qua;
                    System.out.println("Total price: \n" + result);

                    sWriter.write(result + "\n");
                    sWriter.flush();
                }

            }

        }
    }
}

//git config --global user.email "smondal201184@bscse.uiu.ac.bd"
//git config --global user.name "SudiptoMondal25"