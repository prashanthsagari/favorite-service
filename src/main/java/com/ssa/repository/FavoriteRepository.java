package com.ssa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssa.entity.Favorite;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

	// Custom query methods (e.g., find by user_id and flat_id)
	Favorite findByUserIdAndFlatId(Long userId, Long flatId);

	List<Favorite> findByUserId(Long userId);

	void deleteByUserIdAndFlatId(Long userId, Long flatId);
}
