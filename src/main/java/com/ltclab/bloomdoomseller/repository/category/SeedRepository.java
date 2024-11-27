package com.ltclab.bloomdoomseller.repository.category;

import com.ltclab.bloomdoomseller.entity.account.Account;
import com.ltclab.bloomdoomseller.entity.category.Seed;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeedRepository extends JpaRepository<Seed, Long> {
    boolean existsBySubCategory(String subCategory);

    @Query("SELECT s FROM Seed s WHERE LOWER(s.type) LIKE LOWER(CONCAT('%', :type, '%'))")
    Page<Seed> findByTypeContainingIgnoreCase(@Param("type") String type, Pageable pageable);

    List<Seed> findByAccount(Account account);
}