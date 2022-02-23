package lags;

import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String ...args) {
        List<Request> requests = new ArrayList<>();
        List<String> result = getOptimalCombination(requests);
        result.forEach(System.out::println);
    }

    private static List<String> getOptimalCombination(List<Request> requests) {
        List<String> ret = new ArrayList<>();


        return ret;
    }
}
