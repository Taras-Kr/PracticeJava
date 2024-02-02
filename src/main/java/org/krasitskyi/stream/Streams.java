package org.krasitskyi.stream;

import java.io.*;

/**
 * Base operation with FileInputStream, FileOutputStream
 */
public class Streams {
    /**
     * Copy file content from the input file to the output file using FileInputStream, FileOutputStream
     * and custom buffer
     *
     * @param inputFilePath  path to input file
     * @param outputFilePath path to output file
     * @throws IOException if input file not found
     */
    public void copyFileContent(String inputFilePath, String outputFilePath) throws IOException {
        FileInputStream in = new FileInputStream(inputFilePath);
        FileOutputStream out = new FileOutputStream(outputFilePath);
        byte[] buffer = new byte[1024];
        int bytesRead = in.read(buffer);
        while (bytesRead != -1) {
            out.write(buffer, 0, bytesRead);
            bytesRead = in.read(buffer);

        }
        in.close();
        out.close();
    }

    /**
     * Copy file content from the input file to the output file using BufferedInputStream and BufferedOutputStream
     *
     * @param inputFilePath  input file path
     * @param outputFilePath output file path
     * @throws IOException if input file not found
     */
    public void copyFileContentWithBufferedStreams(String inputFilePath, String outputFilePath) {
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(inputFilePath), 1024);
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outputFilePath), 1024)) {
            int bytesRead = in.read();
            while (bytesRead != -1) {
                out.write(bytesRead);
                bytesRead = in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * Put string in the txt file
     *
     * @param outputFilePath output file path
     * @param inputString    input string
     * @throws IOException if input file not found
     */
    public void putString(String outputFilePath, String inputString) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(outputFilePath);
        byte[] value = inputString.getBytes();
        outputStream.write(value);
        outputStream.close();
    }

    public void readFile(String inputFile) throws IOException {
        FileInputStream in = new FileInputStream(inputFile);
        byte[] buffer = new byte[in.available()];
        in.read(buffer);
        String fileContent = new String(buffer);
        System.out.println(fileContent);
        in.close();
    }
}
