package com.xiang.oauth2.server.repository;

import com.xiang.oauth2.server.domain.user.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Jiangcheng Xiang
 */
@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long>, JpaSpecificationExecutor<UserAccount> {

    @Query("select o from UserAccount o where o.username = :username")
    UserAccount findByUsername(@Param("username") String username);
}
