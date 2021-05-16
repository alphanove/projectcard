package com.example.springbootderby.dao;

import com.example.springbootderby.model.Card;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface CardRepository extends CrudRepository<Card, Integer>{


}
