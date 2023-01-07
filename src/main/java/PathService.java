public class PathService {
    public String getTempPath(){
        return "C:\\Windows\\Temp";
    }
    public String getAdminTempPath(){
        return String.format("C:\\Users\\%s\\AppData\\Local\\Temp", System.getProperty("user.name"));
    }
}
