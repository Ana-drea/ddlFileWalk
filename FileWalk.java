import java.io.*;
import java.util.regex.Pattern;

public class FileWalk {
    public static void main(String[] args) throws IOException {
        File source_folder = new File("C:\\Users\\AnZhou\\Downloads\\SampleFiles");
        File target_folder = new File("C:\\OutputFiles");
        target_folder.mkdirs();
        copyFiles(source_folder, target_folder);
    }

    public static void copyFiles(File source_folder, File target_folder) throws IOException {
        String pattern = ".*\\.(dll||DLL)";

        if(source_folder.isFile()){
            String filename = source_folder.getName();
            if(Pattern.matches(pattern,filename)){
                File targetFile = new File(target_folder, filename);
                copyFileContent(source_folder,targetFile);
            } else {
                File newFile = new File(target_folder,filename);
                newFile.createNewFile();
            }
        } else{
            File[] files = source_folder.listFiles();
            if(files!=null){
                for(File f1: files){
                    copyFiles(f1,target_folder);
                }
            }
        }
    }

    public static void copyFileContent(File source, File target) throws IOException {
        byte[] bys = new byte[1024];
        int len;
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(target));
        while((len= bis.read(bys))!=-1){
            bos.write(bys,0,len);
        }
        bis.close();
        bos.close();
    }
}
