package cn.repository;

import cn.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends JpaRepository<SysUser,String> {
}
