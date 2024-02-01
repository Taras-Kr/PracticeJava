package org.krasitskyi.stream;

import java.io.IOException;

public class StreamsApl {
    public static void main(String[] args) throws IOException {
        String inputFile = "src/main/resources/inputCopyFileContent.txt";
        String outputFile = "src/main/resources/copyFileContent.txt";
        String outputFileWithBuff  = "src/main/resources/copyFileContentWithBufferedStreams.txt";
        String outputFileWithValue = "src/main/resources/putString.txt";
        Streams streams = new Streams();
        streams.copyFileContent(inputFile, outputFile);
        streams.copyFileContentWithBufferedStreams(inputFile, outputFileWithBuff);
        String inputString = "This string was added as input parameters using method public void putString(String outputFilePath, String inputString)";
        streams.putString(outputFileWithValue, inputString);
        streams.readFile(inputFile);

    }
}
