package com.app.dailyhistory.repository;

import com.app.dailyhistory.domain.starry.Starry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StarryRepository extends JpaRepository<Starry , Long> {
}
