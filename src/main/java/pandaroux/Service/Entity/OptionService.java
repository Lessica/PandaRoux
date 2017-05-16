package pandaroux.Service.Entity;

import jdk.nashorn.internal.runtime.options.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pandaroux.Entity.Option;
import pandaroux.Entity.Question;
import pandaroux.Repository.OptionRepository;

import java.util.List;
import java.util.Map;

@Service
public class OptionService {

    @Autowired
    private OptionRepository optionRepository;

    public void save(Option option) {
        optionRepository.save(option);

    }
    public void saveAll(List<Option> options){
        for(int i=0; i<options.size();i++){
            save(options.get(i));
        }
    }



}
