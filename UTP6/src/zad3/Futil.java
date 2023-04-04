package zad3;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.*;

public class Futil {

    public static void processDir(String dirName, String resultFileName) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(resultFileName), "UTF-8"))) {
            Files.walk(Paths.get(dirName), FileVisitOption.FOLLOW_LINKS)
                .filter(Files::isRegularFile)
                .map(Path::toString)
                .flatMap(fileName -> readFile(fileName).stream())
                .forEach(line -> writeLine(writer, line));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> readFile(String fileName) {
        try {
            return Files.readAllLines(Paths.get(fileName), StandardCharsets.ISO_8859_1);
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    private static void writeLine(BufferedWriter writer, String line) {
        try {
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
		
	}



