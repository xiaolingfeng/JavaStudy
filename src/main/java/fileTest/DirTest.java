package fileTest;

import org.apache.commons.io.FileUtils;

import java.io.*;

public class DirTest {
  static String path = "demoDir/a/b/c";

  public static void main(String[] args) {
    File dir = new File(path);
    if(dir.mkdirs()){
      System.out.println("Make dir success");
    }

    File text = new File( path +"/demo.txt");
    try{
      BufferedWriter out = new BufferedWriter(new FileWriter(text));
      out.write("ITISDEMO");
      out.close();
    }catch (Exception e){

    }
  }
}


class GetSize{
  public static void main(String[] args) {
    long size = FileUtils.sizeOfDirectory(new File("demoDir"));
    System.out.println(size);
  }
}

class Finder{
  public static void main(String[] args) throws Exception{
    File dir = new File("demoDir/a/b/c");
    String[] children = dir.list();
    if(children == null){
      System.out.println("It is not exist");
    }else{
      for (int i = 0 ; i < children.length ; i++){
        String filename = children[i];
        System.out.println(filename);
      }
    }

    //findAll("demoDir");
    printDir(1,new File("demoDir"));

  }

  static void findAll(String filename, String pathname){
    String path = pathname + filename;
    File dir = new File(pathname + filename);
    if(dir.isFile()){
      System.out.println(dir.getName());
    }else if(dir.isDirectory()){
      System.out.println(dir.getName());
      String[] children = dir.list();
      System.out.print("-");
      for(int i = 0 ; i < children.length ; i++){
        findAll(children[i],pathname + filename + "/");
      }
    }
  }

  static void findAll(String filename){
    findAll(filename,"");
  }

  static void printDir(int indent, File file) throws IOException{

    for(int i = 0 ; i < indent ; i++){
      System.out.print("  ");
    }
    System.out.print("|-");
    System.out.println(file.getName());
    if (file.isDirectory()) {
      File[] files = file.listFiles();
      for(int i = 0 ; i < files.length ; i++){
        printDir(indent+1, files[i]);
      }
    }
  }
}
