package com.test.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.test.entity.StoryBook;

@Repository
public interface StoryBookRepository extends ReactiveCrudRepository<StoryBook, Long>
{
	@Query("delete b from StoryBook b where b.id=?1")
	void deleteBookById(long id);
	
}


