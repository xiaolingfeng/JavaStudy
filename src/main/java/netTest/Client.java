package netTest;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Client {
  //Client
  public static void main(String[] args) throws Exception{
    String serverName = args[0];
//    int port = Integer.parseInt(args[1]);
    int port = 9000;
    System.out.println("Connect to server: " + serverName + ": " + port);
    Socket client = new Socket(serverName,port);
    System.out.println("Remote server address" + client.getRemoteSocketAddress());

    OutputStream out = client.getOutputStream();
    DataOutputStream outputStream = new DataOutputStream(out);

    outputStream.writeUTF("Hello from :" + client.getLocalSocketAddress());
    InputStream in = client.getInputStream();
    DataInputStream inputStream = new DataInputStream(in);
    System.out.println("Server response: " + inputStream.readUTF());
    client.close();
  }
}


class Server{
  public static void main(String[] args) throws Exception {
    int port = Integer.parseInt(args[0]);
    Server s = new Server(port);
    s.run();
  }

  public ServerSocket serverSocket;

  public Server(int port) throws IOException {
    serverSocket = new ServerSocket(port);
    //serverSocket.setSoTimeout(1000);
  }

  public void run() throws Exception{
    while(true){
      System.out.println("Waiting for connecting, Port: " + serverSocket.getLocalPort() + "...");
      Socket server = serverSocket.accept();
      System.out.println("Remote IP: " + server.getRemoteSocketAddress());
      DataInputStream in = new DataInputStream(server.getInputStream());
      System.out.println(in.readUTF());

      DataOutputStream out = new DataOutputStream(server.getOutputStream());
      out.writeUTF("Thanks for connecting :" + server.getLocalSocketAddress());
      server.close();
    }
  }
}