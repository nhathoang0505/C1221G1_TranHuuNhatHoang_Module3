package service.impl;

import model.EducationDegree;
import repository.IEducationDegreeRepository;
import repository.impl.EducationDegreeRepositoryImpl;
import service.IEducationDegreeService;

import java.util.List;

public class EducationDegreeImpl implements IEducationDegreeService {
    IEducationDegreeRepository educationDegreeRepository = new EducationDegreeRepositoryImpl();

    @Override
    public List<EducationDegree> getList() {
        return educationDegreeRepository.getList();
    }
}
