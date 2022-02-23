package lags;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RequestReader {

    private static final String DELIMITER = " ";

    public static List<Request> getRequestFromFile() {
        Path path = Paths.get("/src/test/resources/data.txt");
        try (Stream<String> stream = Files.lines(path)) {
            return stream.map(RequestReader::toRequest).filter(Objects::nonNull).collect(Collectors.toList());
        }
        catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private static Request toRequest(String line) {
        try {
            String[] arr =  line.split(DELIMITER);
            return new  Request(arr[0],
                                    Integer.parseInt(arr[1]),
                                    Integer.parseInt(arr[2]),
                                    Integer.parseInt(arr[3]));
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String ...args) {
        System.out.println(getRequestFromFile());
    }


}
