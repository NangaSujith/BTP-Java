package com.example.hellobtp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "USER_INFO", schema = "DBADMIN")
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "USER_NAME", length = 50)
	private String userName;

	@Column(name = "EMAIL_ID", length = 250, unique = true, updatable = false)
	private String emailId;

	@Column(name = "EMP_ID", length = 50)
	private String empId;

	@Column(name = "PASSWORD", length = 250, nullable = false)
	private String password;

	@Column(name = "CREATED_BY", length = 100)
	private String createdBy;

	@Column(name = "CREATED_DATE")
	private LocalDateTime createdDate;

	@Column(name = "MODIFIED_BY", length = 100)
	private String modifiedBy;

	@Column(name = "MODIFIED_DATE")
	private LocalDateTime modifiedDate;

	@Column(name = "IS_DELETE")
	private Boolean isDelete;
}
