package com.u4.projectmanagement.dao;

import com.u4.projectmanagement.entities.UserAccount;
import org.springframework.data.repository.CrudRepository;

public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {
}
