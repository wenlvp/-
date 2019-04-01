package com.personal.application.repository;

import com.personal.application.pojo.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News,Integer> {
}
