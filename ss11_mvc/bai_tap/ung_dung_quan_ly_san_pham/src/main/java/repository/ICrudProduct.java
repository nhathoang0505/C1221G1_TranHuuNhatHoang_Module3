package repository;

import model.Product;

import java.util.List;

public interface ICrudProduct<E> {
    List<E> getList();
}
