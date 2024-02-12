import java.io.File;

public class Main {
    public static void main(String[] args) {
        String path = "C:\\Users\\Gugugaga\\eclipse-workspace\\SEWtest"; // Hier den gewünschten Pfad angeben
        File file = new File(path);
        listFile(file, 0);
    }

    public static void listFile(File file, int indentLevel) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < indentLevel; i++) {
            indent.append(" ");
        }

        if (file.isFile()) {
            System.out.println(indent + file.getName() + " - " +
                    file.lastModified() + " - " + file.length() + " Bytes");
        } else if (file.isDirectory()) {
            System.out.println(indent + "+" + file.getName());
            File[] files = file.listFiles();
            if (files != null) {
                for (File subFile : files) {
                    listFile(subFile, indentLevel + 2);
                }
            }
        }
    }
}