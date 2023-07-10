package com.example.mscartoes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mscartoes.models.Cartao;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Integer> {

}
