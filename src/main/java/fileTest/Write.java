package fileTest;

import java.io.*;
import java.nio.Buffer;
import java.util.Date;

class FileOption{
  static String path = "demo.txt";
  static String path2 = "demo2.txt";
}

public class Write {
  public static void main(String[] args) {
    try {
      BufferedWriter out = new BufferedWriter(new FileWriter(FileOption.path));
      for(int i = 0 ; i < 1000 ; i++){
        out.write("A");
      }
      out.close();
      System.out.println("File create success");
    }catch (IOException e){

    }
  }
}

class Read{
  public static void main(String[] args) {
    try{
      BufferedReader in = new BufferedReader(new FileReader(FileOption.path));
      String str = "";
      String temp;
      while((temp = in.readLine()) != null){
        str += temp;
      }
      System.out.println(str);
    }catch (IOException e){

    }
  }
}

class Remove{
  public static void main(String[] args) {
    try{
      File file = new File(FileOption.path);
      if(file.delete()){
        System.out.println("File " + FileOption.path + " is deleted");
      }else{
        System.out.println("File delete error");
      }
    }catch (Exception e){

    }
  }
}

class Copy{
  public static void main(String[] args) {
    try {
      File file = new File(FileOption.path);
      File file2 = new File(FileOption.path2);

      InputStream in = new FileInputStream(file);
      OutputStream out = new FileOutputStream(file2);

      int count = 0;

      byte[] buf = new byte[50];
      int len;

      while((len = in.read(buf)) > 0){
      count++;
        out.write(buf,0,len);
      }


      /*int temp;
      while((temp = in.read()) > 0){
        count ++;
        out.write(temp);
      }*/

      in.close();
      out.close();

      System.out.println("act " + count + " times");
    }catch (Exception e){

    }
  }
}

class TempFile{
  public static void main(String[] args) throws Exception{
    File temp = File.createTempFile("tempName",".txt");
    System.out.println("File path: " + temp.getAbsolutePath());
    temp.deleteOnExit();
    BufferedWriter out = new BufferedWriter(new FileWriter(temp));
    out.write("Changed temp");
    out.close();
  }
}

class ModifyFile{
  public static void main(String[] args) {
    File file = new File(FileOption.path);
    System.out.println(file.lastModified());
    Date d = new Date(file.lastModified());
    System.out.println(d.toString());
    System.out.println(file.setLastModified(System.currentTimeMillis()));
    d = new Date(file.lastModified());
    System.out.println(d.toString());
  }
}

class Rename{
  public static void main(String[] args) {
    String distPath ="dist.txt";
    File dist = new File(distPath);
    File src = new File(FileOption.path);
    if(src.renameTo(dist)){
      System.out.println("Rename success");
      FileOption.path = distPath;
    }else{
      System.out.println("Error");
    }
  }
}