package service.impl;

import model.Division;
import repository.IDivisionRepository;
import repository.impl.DivisionRepositoryImpl;
import service.IDivisionService;

import java.util.List;

public class DivisionServiceImpl implements IDivisionService {
    IDivisionRepository divisionRepository = new DivisionRepositoryImpl();
    @Override
    public List<Division> getList() {
        return divisionRepository.getList();
    }
}
