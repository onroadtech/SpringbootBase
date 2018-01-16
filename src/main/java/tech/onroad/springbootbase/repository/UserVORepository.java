package tech.onroad.springbootbase.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tech.onroad.springbootbase.entity.UserVO;


public interface UserVORepository extends CrudRepository<UserVO, Long>{   //extends JpaRepository的区别是什么？

    @Query("select u from UserVO u where u.username=:username")
    public UserVO findUserByName(@Param("username") String username);
    
}
