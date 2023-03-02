package com.end.forth_project.entity.token;

import com.end.forth_project.entity.token.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<Token, String> {

}