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

public class NIO2FilePersistence implements FilePersistence {
    private final String currentDir = System.getProperty("user.dir"); // retorna o diretório atual do projeto

    private final String storedDir = "/managedFiles/NIO2/"; // diretório onde os arquivos serão armazenados

    private final String fileName;

    public NIO2FilePersistence(String fileName) throws IOException {
        this.fileName = fileName;
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
    public boolean remove(String sentence) {
        var contentList = toListString();
        if (contentList.stream().noneMatch(line -> line.contains(sentence))) {
            return false;
        }
        clearFile();
        contentList.stream().filter(line -> !line.contains(sentence)).forEach(this::write);
        return true;
    }

    @Override
    public String replace(String oldContent, String newContent) {
        var contentList = toListString();
        if (contentList.stream().noneMatch(line -> line.contains(oldContent))) {
            return "Conteúdo não encontrado para substituição.";
        }
        clearFile();
        contentList.stream()
                .map(line -> line.contains(oldContent) ? newContent : line)
                .forEach(this::write);
        return newContent;
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

    private List<String> toListString() {
        var content = findAll();
        return new ArrayList<>(Stream
                .of(content.split(System.lineSeparator()))
                .toList());
    }

    private void clearFile() {
        try (OutputStream outputStream = new FileOutputStream(currentDir + storedDir + fileName)) {
            System.out.printf("Preparando arquivo limpo para uso... (%s) \n", currentDir + storedDir + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
