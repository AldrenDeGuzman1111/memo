package com.aldren.memo.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MEMO")
@SQLDelete(sql = "UPDATE MEMO SET deleted = true WHERE id=?")
@SQLRestriction("DELETED = FALSE")
public final class MemoEntity {

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String note;

	@Column
	private String createdBy;
	
    @Column
    private boolean deleted = Boolean.FALSE;
}
