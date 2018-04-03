package com.web2h.betmates.restapp.model.entity.competition;

import static com.web2h.betmates.restapp.model.entity.FieldLength.COMPETITION_TYPE_MAX_LENGTH;
import static com.web2h.betmates.restapp.model.entity.FieldLength.NAME_MAX_LENGTH;
import static com.web2h.betmates.restapp.model.entity.FieldLength.TEXT_MIN_LENGTH;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.web2h.betmates.restapp.model.deserializer.JsonTrimmerDeserializer;
import com.web2h.betmates.restapp.model.validation.Field;
import com.web2h.betmates.restapp.model.validation.group.CreationChecks;
import com.web2h.betmates.restapp.model.validation.group.EditionChecks;
import com.web2h.tools.StringTools;

/**
 * Competition user entity class.
 * 
 * @author web2h
 */
@Entity
@Table(name = "competitions")
public class Competition {

	/** ID - Internal competition ID. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull(groups = EditionChecks.class)
	@Null(groups = CreationChecks.class)
	protected Long id;

	/** NAME_EN - Competition name in English. */
	@Column(name = "name_en", length = NAME_MAX_LENGTH, nullable = false)
	@NotNull
	@Size(min = TEXT_MIN_LENGTH, max = NAME_MAX_LENGTH)
	@JsonDeserialize(using = JsonTrimmerDeserializer.class)
	private String nameEn;

	/** NAME_FR - Competition name in French. */
	@Column(name = "name_fr", length = NAME_MAX_LENGTH, nullable = false)
	@NotNull
	@Size(min = TEXT_MIN_LENGTH, max = NAME_MAX_LENGTH)
	@JsonDeserialize(using = JsonTrimmerDeserializer.class)
	private String nameFr;

	/** TYPE - Competition type. */
	@Enumerated(EnumType.STRING)
	@Column(name = "competition_type", length = COMPETITION_TYPE_MAX_LENGTH, nullable = false)
	@NotNull
	private CompetitionType type;

	@Override
	public int hashCode() {
		HashCodeBuilder hcb = new HashCodeBuilder();
		hcb.append(nameEn);
		hcb.append(nameFr);
		hcb.append(type);
		return hcb.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Competition)) {
			return false;
		}
		Competition that = (Competition) obj;
		EqualsBuilder eb = new EqualsBuilder();
		eb.append(nameEn, that.nameEn);
		eb.append(nameFr, that.nameFr);
		eb.append(type, that.type);
		return eb.isEquals();
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer("COMPETITION");
		buffer.append(StringTools.getFieldAndValueToString(Field.ID, id));
		buffer.append(StringTools.getFieldAndValueToString(Field.NAME_EN, nameEn));
		buffer.append(StringTools.getFieldAndValueToString(Field.NAME_FR, nameFr));
		buffer.append(StringTools.getFieldAndValueToString(Field.TYPE, type));
		return buffer.toString();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getNameFr() {
		return nameFr;
	}

	public void setNameFr(String nameFr) {
		this.nameFr = nameFr;
	}

	public CompetitionType getType() {
		return type;
	}

	public void setType(CompetitionType type) {
		this.type = type;
	}
}