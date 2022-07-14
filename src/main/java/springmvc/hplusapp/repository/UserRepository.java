package springmvc.hplusapp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import springmvc.hplusapp.bean.User;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {

    @Query("select u from User u where u.userName= :name")
    public User searchByName(@Param("name") String username);
}
