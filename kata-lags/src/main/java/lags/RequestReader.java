package lags;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RequestReader {

    public static List<Request> getRequestFromFile() {
        Path path = Paths.get("/src/test/resources/data.txt");
        try (Stream<String> stream = Files.lines(path)) {
            return stream.map(RequestReader::toRequest).filter(Optional::isPresent).map(Optional::get).collect(Collectors.toList());
        }
        catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private static Optional<Request> toRequest(String line) {
        String[] arr =  line.split(" ");
        try {
            return Optional.of(new  Request(arr[0],
                                    Integer.parseInt(arr[1]),
                                    Integer.parseInt(arr[2]),
                                    Integer.parseInt(arr[3])));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public static void main(String ...args) {
        System.out.println(getRequestFromFile());
    }


}
