package me.salisuwy.entities;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@Table(name = "Blog")
public class Blog extends AbstractEntity {
    @Lob
    @Basic
    @Nationalized
    @ApiModelProperty(notes = "The topic description")
    @Column(name = "Description")
    @Size(min = 2, max = 1500, message = "Description must be between 2 and 1500 characters long")
    private String description;

    @Nationalized
    @ApiModelProperty(notes = "The topic title")
    @Column(name = "Title")
    @Size(min = 2, max = 100, message = "Title must be between 2 and 100 characters long")
    private String title;
}
