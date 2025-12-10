package br.com.dio.persistence;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NIO2FilePersistence extends FilePersistence {

    public NIO2FilePersistence(String fileName) throws IOException {
        super(fileName, "/managedFiles/NIO2/");
        var path = Paths.get(currentDir + storedDir);
        if (!Files.exists(path)){
            Files.createDirectory(path);
        }
        clearFile();
    }


    @Override
    public String write(String data) {
        var path = Paths.get(currentDir + storedDir + fileName);
        try {
            Files.write(path, data.getBytes(), StandardOpenOption.APPEND);
            Files.write(path, System.lineSeparator().getBytes(), StandardOpenOption.APPEND);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public String findAll() {
        var path = Paths.get(currentDir + storedDir + fileName);
        var content = "";
        try(var lines = Files.lines(path)){
            content = lines.collect(Collectors.joining(System.lineSeparator()));
        } catch(IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    @Override
    public String findBy(String sentence) {
        var content = findAll();
        return Stream.of(content.split(System.lineSeparator()))
                .filter(line -> line.contains(sentence))
                .findFirst()
                .orElse("Conteúdo não encontrado.");
    }
}
