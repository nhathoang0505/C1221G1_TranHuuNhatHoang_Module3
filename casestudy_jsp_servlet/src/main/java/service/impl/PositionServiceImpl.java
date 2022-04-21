package service.impl;

import model.Position;
import repository.IPositionRepository;
import repository.impl.PositionRepositoryImpl;
import service.IPositionService;

import java.util.List;

public class PositionServiceImpl implements IPositionService {
    IPositionRepository positionRepository = new PositionRepositoryImpl();

    @Override
    public List<Position> getList() {
        return positionRepository.getList();
    }
}
