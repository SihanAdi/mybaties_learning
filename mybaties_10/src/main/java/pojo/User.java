package pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {//实体类序列化
    private int id;
    private String name;
    private String pwd;
}
