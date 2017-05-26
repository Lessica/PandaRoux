package pandaroux.Test;

import com.google.gson.Gson;

import java.util.List;
import java.util.Map;

public class TestService {

    public static String parametersToJson(List list) {

        return new Gson().toJson(list, List.class);
    }

    public static String parametersToJson(Map map) {

        return new Gson().toJson(map, Map.class);    }
}
