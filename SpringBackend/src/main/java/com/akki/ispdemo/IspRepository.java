package com.akki.ispdemo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IspRepository extends JpaRepository<IspEntity, Long> {
}
