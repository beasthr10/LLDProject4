package com.beasthr10.lld4.repo;

import com.beasthr10.lld4.models.Expense;
import com.beasthr10.lld4.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
