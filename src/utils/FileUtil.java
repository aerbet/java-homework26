package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.MoviesList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtil {

    private FileUtil() {}

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final Path BASE_PATH = Paths.get("src/data");

    public static Path getFilePath(String fileName) {
        return BASE_PATH.resolve(fileName + ".json");
    }

    public static MoviesList readMoviesFile(Path path) {
        try {
            String json = Files.readString(path);
            return MAPPER.readValue(json, MoviesList.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

/*    public static void writeFile(Path path, Object object) {
        try {
            ObjectWriter writer = MAPPER.writerWithDefaultPrettyPrinter();
            String newJson = writer.writeValueAsString(object);
            Files.write(path, newJson.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}