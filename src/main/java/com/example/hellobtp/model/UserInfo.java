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

	@Column(name = "CLIENT_ID")
	private Long clientId;

	@Column(name = "EMP_CODE", length = 50)
	private String empCode;

	@Column(name = "EMP_NAME", length = 100)
	private String empName;

	@Column(name = "COMPANY_CODE", length = 25)
	private String companyCode;

	@Column(name = "BRANCH_CODE", length = 25)
	private String branchCode;

	@Column(name = "EMAIL_ID", length = 250)
	private String emailId;

	@Column(name = "PASSWORD", length = 50)
	private String password;

	@Column(name = "ACCESS_TYPE_ID")
	private Long accessTypeId;

	@Column(name = "IS_ACTIVE")
	private Boolean isActive;

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
