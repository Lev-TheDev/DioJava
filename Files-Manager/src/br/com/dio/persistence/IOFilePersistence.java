package br.com.dio.persistence;

import java.io.*;

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
        return false;
    }

    @Override
    public String replace(final String oldContent, final String newContent) {
        return null;
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
        return null;
    }

    private void clearFile() {
        try (OutputStream outputStream = new FileOutputStream(currentDir + storedDir + fileName)) {
            System.out.printf("Preparando arquivo limpo para uso... (%s) \n", currentDir + storedDir + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
