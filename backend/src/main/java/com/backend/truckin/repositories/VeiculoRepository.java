package com.backend.truckin.repositories;

import com.backend.truckin.models.User;
import com.backend.truckin.models.Veiculo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends CrudRepository<Veiculo, Long>
{
    Iterable<Veiculo> findAllByPlaca(String NomePesqPlaca);
    Veiculo findById(long idVei);
}