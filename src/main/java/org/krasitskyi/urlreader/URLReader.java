package org.krasitskyi.urlreader;

import java.io.*;
import java.net.URL;

public class URLReader extends Reader {

    private final BufferedReader bufferedReader;

    public URLReader(String urlString) throws IOException {
        URL url = new URL(urlString);
        InputStream inputStream = url.openStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        this.bufferedReader = new BufferedReader(inputStreamReader);
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        return this.bufferedReader.read(cbuf, off, len);
    }

    @Override
    public void close() throws IOException {
        this.bufferedReader.close();
    }
    public void writeURLContentToFile(String filePath) {
        StringBuilder builder = new StringBuilder();
        char[] buffer = new char[1024];
        int readChars;
        try {
            while ((readChars = bufferedReader.read(buffer, 0, buffer.length)) != -1) {
                builder.append(buffer, 0, readChars);
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
