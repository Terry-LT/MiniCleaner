import java.io.File;

public class CleanerService {
    public void cleanDir(String pathName){
        File tempPath = new File(pathName);
        File[] files = tempPath.listFiles();
        if (files != null){
            for (File file : files){
                if (!file.isDirectory()){
                    if (file.delete()){
                        System.out.println(file.getName() + " was deleted");
                    }
                    System.out.println(file.getName() + " wasn't deleted");
                }
            }
        }
        else{
            System.out.println(pathName + " does not contain files!");
        }
    }
}
