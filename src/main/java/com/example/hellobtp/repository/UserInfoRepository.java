package com.example.hellobtp.repository;
import com.example.hellobtp.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    UserInfo findByEmailId(String emailId);

    @Query(value = "select * from user_info where EMAIL_ID=?1 and is_delete=?2 ", nativeQuery = true)
    UserInfo findUserInfoByEmailIdAndIsDelete(String emailId, short isDelete);

    @Query(value = "select * from user_info where emp_code=?1 and is_delete=?2 ", nativeQuery = true)
    UserInfo findUserInfoByEmpCodeAndIsDelete(String empCode, short isDelete);

    @Transactional
    @Modifying
    @Query(value = "update user_info set password=?2 where email_id=?1", nativeQuery = true)
    void updatePassword(String emailId, String password);

    @Query(value = "select * from user_info where id=?1 and is_delete=?2", nativeQuery = true)
    UserInfo findByIdAndIsDelete(Long id, short isDelete);


}
