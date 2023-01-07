public class CleanerController {
    private final CleanerService cleanerService = new CleanerService();
    private final PathService pathService = new PathService();
    public String getTempPath(){
        return pathService.getTempPath();
    }
    public String getAdminTempPath(){
        return pathService.getAdminTempPath();
    }

    public void cleanTempPath(){
        cleanerService.cleanDir("C:\\Windows\\Temp");
    }
    public void cleanAdminTempPath(){
        String path = String.format("C:\\Users\\%s\\AppData\\Local\\Temp", System.getProperty("user.name"));

        cleanerService.cleanDir(path);
    }

}
