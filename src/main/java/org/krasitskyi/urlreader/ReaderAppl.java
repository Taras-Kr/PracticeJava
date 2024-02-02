package org.krasitskyi.urlreader;


import java.io.IOException;

public class ReaderAppl {
    public static void main(String[] args) {
//        Reader urlReader = new URLReader("https://uk.wikipedia.org/wiki/%D0%93%D0%BE%D0%BB%D0%BE%D0%B2%D0%BD%D0%B0_%D1%81%D1%82%D0%BE%D1%80%D1%96%D0%BD%D0%BA%D0%B0");
//        StringBuilder builder = new StringBuilder();
//        char[] buffer = new char[1024];
//        int charsRead;
//        while ((charsRead = urlReader.read(buffer, 0, buffer.length)) != -1) {
//            builder.append(buffer, 0, charsRead);
//        }
//        FileWriter fileWriter = new FileWriter("src/main/resources/index.html");
//        fileWriter.write(builder.toString());
//        fileWriter.close();
        try (URLReader urlReader = new URLReader("https://uk.wikipedia.org/wiki/%D0%93%D0%BE%D0%BB%D0%BE%D0%B2%D0%BD%D0%B0_%D1%81%D1%82%D0%BE%D1%80%D1%96%D0%BD%D0%BA%D0%B0")
        ) {
            urlReader.writeURLContentToFile("src/main/resources/index.html");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
