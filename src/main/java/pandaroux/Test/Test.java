package pandaroux.Test;


import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {


    public static void main(String[] args) {

        String json;

        List list = new ArrayList() {{
            add("option 1");
            add("option 2");
        }};

        json = new Gson().toJson(list, List.class);

        System.out.println(json);

        Map map = new HashMap() {{
            put("min", 0);
            put("max", 0);
            put("step", 0);
        }};

        json = new Gson().toJson(map, Map.class);

        System.out.println(json);


        map = new Gson().fromJson(json, Map.class);

        System.out.println(map);

        System.out.println(((Double) map.get("min")).intValue());

    }




}
