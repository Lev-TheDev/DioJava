package br.com.dio.persistence;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class IOFilePersistence implements FilePersistence {

    private final String currentDir = System.getProperty("user.dir"); // retorna o diretório atual do projeto

    private final String storedDir = "/managedFiles/IO/"; // diretório onde os arquivos serão armazenados

    private final String fileName;

    public IOFilePersistence(String fileName) throws IOException {
        this.fileName = fileName;
        File file = new File(currentDir + storedDir);
        if(!file.exists() && !file.mkdirs()) throw new IOException("Erro ao criar arquivo.");
        clearFile();
    }

    @Override
    public String write(final String data) {
        try (
                var fileWriter = new FileWriter(currentDir + storedDir + fileName, true);
                var bufferedWriter = new BufferedWriter(fileWriter);
                var printWriter = new PrintWriter(bufferedWriter)
                ) {
            printWriter.println(data);
            System.out.printf("Dados gravados com sucesso no arquivo --> (%s) \n", currentDir + storedDir + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public boolean remove(final String sentence) {
        var contentList = toListString();
        if (contentList.stream().noneMatch(line -> line.contains(sentence))) {
            return false;
        }
        clearFile();
        contentList.stream().filter(line -> !line.contains(sentence)).forEach(this::write);
        return true;
    }

    @Override
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

    private List<String> toListString() {
        var content = findAll();
        return new ArrayList<>(Stream
                .of(content.split(System.lineSeparator()))
                .toList());
    }

    @Override
    public String findAll() {
        var content = new StringBuilder();
        try(var reader = new BufferedReader(new FileReader(currentDir + storedDir + fileName))){
            String line;
            do {
                line = reader.readLine();
                if(line != null){
                    content.append(line).append("\n");
                }
            } while (line != null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    @Override
    public String findBy(final String sentence) {
        String found = "";
        try(var reader = new BufferedReader(new FileReader(currentDir + storedDir + fileName))){
            String line = reader.readLine();
            while (line != null) {
                if(line.contains(sentence)){
                    found = line;
                    break;
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return found;
    }

    private void clearFile() {
        try (OutputStream outputStream = new FileOutputStream(currentDir + storedDir + fileName)) {
            System.out.printf("Preparando arquivo limpo para uso... (%s) \n", currentDir + storedDir + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
