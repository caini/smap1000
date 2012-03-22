package org.wekit.web.model.test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="user")
public class UserModel {
  
	@Id
	@GeneratedValue(generator="id_gen",strategy=GenerationType.TABLE)
	@TableGenerator(
			name="id_gen",
			table="sys_id_gen",
			pkColumnName="S_ID",
			valueColumnName="S_NEXTNUM",
			pkColumnValue="code",
			allocationSize=100
	)
	private long id;
	
	@Column(name="name")
	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
