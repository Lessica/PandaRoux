package pandaroux.Service.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pandaroux.Repository.QuestionTypeRepository;

@Service
public class QuestionTypeService {

    @Autowired
    private QuestionTypeRepository questionTypeRepository;
}
