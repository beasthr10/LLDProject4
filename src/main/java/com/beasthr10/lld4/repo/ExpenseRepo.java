package com.beasthr10.lld4.repo;

import com.beasthr10.lld4.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepo extends JpaRepository<Expense,Long> {
}
