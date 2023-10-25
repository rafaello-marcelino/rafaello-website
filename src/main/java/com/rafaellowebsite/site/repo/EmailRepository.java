package com.rafaellowebsite.site.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rafaellowebsite.site.entity.Email;

@Repository
public interface EmailRepository extends CrudRepository<Email, Long>{


}
