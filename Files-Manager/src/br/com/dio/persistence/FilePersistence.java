package br.com.dio.persistence;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public abstract class FilePersistence {

    protected final String currentDir = System.getProperty("user.dir"); // retorna o diretório atual do projeto

    protected final String storedDir; // diretório onde os arquivos serão armazenados

    protected final String fileName;

    public FilePersistence(final String fileName, final String storedDir) {
        this.storedDir = storedDir;
        this.fileName = fileName;
    }

    public abstract String write(final String data);

    public boolean remove(final String sentence) {
        var contentList = toListString();
        if (contentList.stream().noneMatch(line -> line.contains(sentence))) {
            return false;
        }
        clearFile();
        contentList.stream().filter(line -> !line.contains(sentence)).forEach(this::write);
        return true;
    }

    public String replace(final String oldContent, final String newContent) {
        var contentList = toListString();
        if (contentList.stream().noneMatch(line -> line.contains(oldContent))) {
            return "Conteúdo não encontrado para substituição.";
        }
        clearFile();
        contentList.stream()
                .map(line -> line.replace(oldContent, newContent))
                .forEach(this::write);
        return newContent;
    }

    public abstract String findAll();

    public abstract String findBy(final String sentence);

    protected List<String> toListString() {
        var content = findAll();
        return new ArrayList<>(Stream
                .of(content.split(System.lineSeparator()))
                .toList());
    }

    protected void clearFile() {
        try (OutputStream outputStream = new FileOutputStream(currentDir + storedDir + fileName)) {
            System.out.printf("Preparando arquivo limpo para uso... (%s) \n", currentDir + storedDir + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
