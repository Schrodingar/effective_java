import CashService.CashService;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        CashService cashService = new CashService();
        for (int i = 0;  i < 1; i++) {
            String key = Integer.toString(i);
            Object value = i;
            cashService.put(key, value);
        }
        System.out.println("");
    }

}
