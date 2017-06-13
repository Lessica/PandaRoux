package pandaroux.Service;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ParametersService {

    public static List<Map> parametersObject(List<Map> entities) {

        for(int i=0; i<entities.size(); i++) {

            String parameters = (String) entities.get(i).get("parameters");

            Object object = new Gson().fromJson(parameters, Object.class);

            entities.get(i).put("parameters", object);
        }

        return entities;
    }
}
