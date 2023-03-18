package me.ooi.codegenerator;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;


/**
 * @author jun.zhao
 */
@Getter
@Setter
@ToString
public abstract class BaseEntity implements Serializable {

    protected String id;

}
