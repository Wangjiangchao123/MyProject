package sinosoft.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

/**
 * @Author 王江超
 * @Date 2020/3/5 22:31
 * @Description:
 */
@Data
public class Role implements Serializable {

    private int id;

    private String name;

    private String description;

    private Set<Permission> permission;


}
