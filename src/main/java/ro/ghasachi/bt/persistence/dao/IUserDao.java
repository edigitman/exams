package ro.ghasachi.bt.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.ghasachi.bt.persistence.model.EUser;

/**
 * Created by edi on 12/19/2015.
 */
public interface IUserDao extends JpaRepository<EUser, Long>, JpaSpecificationExecutor<EUser> {

    @Query("SELECT u FROM EUser u WHERE u.email = :email")
    EUser retrieveByEmail(@Param("email") String email);

}
