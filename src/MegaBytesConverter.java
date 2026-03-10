public class MegaBytesConverter {
    public static void printMegaBytesAndKiloBytes(int kiloBytes){
        int megabyte = kiloBytes / 1024;
        int remainKb = kiloBytes % 1024;

        if(kiloBytes < 0){
            System.out.println("Invalid Value");
        } else {
            System.out.println(kiloBytes + " KB = " + megabyte + " MB and " + remainKb + " KB");
        }
    }
}