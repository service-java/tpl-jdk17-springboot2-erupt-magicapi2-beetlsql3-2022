package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.beetl.sql.annotation.entity.AutoID;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.DateType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/*
* 
* @Date 2022-04-09
*/

@DynamicUpdate
@DynamicInsert
@Getter
@Setter
// @Accessors(chain = true)
@Table(name="user")
@Erupt(name = "User"
	, power = @Power(
	    export = true
	    , importable = true
	  )
)
@Entity
public class User implements java.io.Serializable {

    public static String _cols = "id,name,age,create_time,update_time";

	/**
	 * ID
	 */
	@AutoID
    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "native")
    @EruptField(
            views = @View(title = "ID"),
            edit = @Edit(title = "ID"
                    // , notNull = true
                    
                    , search = @Search(vague = true)
            )
    )
	private Long id;


	/**
	 * 姓名
	 */
    @EruptField(
            views = @View(title = "姓名"),
            edit = @Edit(title = "姓名"
                    // , notNull = true
                    
                    , search = @Search(vague = true)
            )
    )
	private String name;


	/**
	 * 年龄
	 */
    @EruptField(
            views = @View(title = "年龄"),
            edit = @Edit(title = "年龄"
                    // , notNull = true
                    
                    , search = @Search(vague = true)
            )
    )
	private Integer age;


	/**
	 * 创建时间
	 */
    @EruptField(
            views = @View(title = "创建时间"),
            edit = @Edit(title = "创建时间"
                    // , notNull = true
                    , type = EditType.DATE, dateType = @DateType(type = DateType.Type.DATE)
                    , search = @Search(vague = true)
            )
    )
	private Date createTime;


	/**
	 * 更新时间
	 */
    @EruptField(
            views = @View(title = "更新时间"),
            edit = @Edit(title = "更新时间"
                    // , notNull = true
                    , type = EditType.DATE, dateType = @DateType(type = DateType.Type.DATE)
                    , search = @Search(vague = true)
            )
    )
	private Date updateTime;



}