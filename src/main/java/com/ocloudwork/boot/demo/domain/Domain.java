package com.ocloudwork.boot.demo.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * <p>Description: 基础域</p>  
 * <p>Copyright: Copyright (c) 2018</p>  
 * <p>Company: www.ocloudwork.com</p>  
 * @author minghui
 * @datetime 2018年9月20日-下午12:00:51
 */
@MappedSuperclass
public class Domain implements Serializable {

	private static final long serialVersionUID = 9174216117528433153L;

	@Id
	@GeneratedValue(generator = "jpa-uuid")
	private String id;

	@Column(name = "create_by", updatable = false, columnDefinition = "varchar(128) not null comment '创建人'")
	private String createBy;

	@Column(name = "create_date", insertable = false, updatable = false, columnDefinition = "timestamp default current_timestamp not null comment '创建时间'")
	private Date createDate;

	@Column(name = "update_by", insertable = false, columnDefinition = "varchar(128) comment '修改人'")
	private String updateBy;

	@Column(name = "update_date", insertable = false, columnDefinition = "timestamp default current_timestamp on update current_timestamp comment '修改时间'")
	private Date updateDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
