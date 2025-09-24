package com.beasthr10.lld4.repo;

import com.beasthr10.lld4.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseUserRepository extends JpaRepository<Expense,Long> {
}
