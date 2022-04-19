package repository;

import model.Customer;

import java.util.List;

public interface ICRUDRepository<E> {
    List<E> getList();
}
