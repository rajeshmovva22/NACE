package com.nace.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "NACE_DETAILS")
public class NACEDetails {

    @NotNull
    @Id
    @Column(name="ordernumber")
    private Long order;
    @Column(name="level")
    private String level;
    @Column(name="code")
    private String code;
    @Column(name="parent")
    private String parent;
    public NACEDetails() {
		super();
	}
	@Column(name="description")
    private String description;
    @Column(name="item_includes", length = 10000)
    private String item_includes;
    @Column(name="item_also_includes", length = 1000)
    private String item_also_includes;
    @Column(name="rulings", length = 500)
    private String rulings;
    @Column(name="item_excludes", length = 5000)
    private String item_excludes;
    @Column(name="reference_isic")
    private String reference;
	public NACEDetails(@NotEmpty Long order, String level, String code, String parent, String description,
			String item_includes, String item_also_includes, String rulings, String item_excludes, String reference) {
		super();
		this.order = order;
		this.level = level;
		this.code = code;
		this.parent = parent;
		this.description = description;
		this.item_includes = item_includes;
		this.item_also_includes = item_also_includes;
		this.rulings = rulings;
		this.item_excludes = item_excludes;
		this.reference = reference;
	}
	public Long getOrder() {
		return order;
	}
	public void setOrder(Long order) {
		this.order = order;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getItem_includes() {
		return item_includes;
	}
	public void setItem_includes(String item_includes) {
		this.item_includes = item_includes;
	}
	public String getItem_also_includes() {
		return item_also_includes;
	}
	public void setItem_also_includes(String item_also_includes) {
		this.item_also_includes = item_also_includes;
	}
	public String getRulings() {
		return rulings;
	}
	public void setRulings(String rulings) {
		this.rulings = rulings;
	}
	public String getItem_excludes() {
		return item_excludes;
	}
	public void setItem_excludes(String item_excludes) {
		this.item_excludes = item_excludes;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
}
