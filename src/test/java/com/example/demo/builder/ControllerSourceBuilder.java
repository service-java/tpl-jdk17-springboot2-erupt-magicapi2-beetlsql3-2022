package com.example.demo.builder;

import com.example.demo.util.LowerFirstFnUtil;
import org.beetl.core.Template;
import org.beetl.sql.gen.BaseProject;
import org.beetl.sql.gen.Entity;
import org.beetl.sql.gen.SourceConfig;
import org.beetl.sql.gen.simple.BaseTemplateSourceBuilder;

import java.io.Writer;

public class ControllerSourceBuilder extends BaseTemplateSourceBuilder {
    public static String pojoPath = "controller.html";
    private boolean alias = false;

    public ControllerSourceBuilder() {
        super("controller");
    }

    public ControllerSourceBuilder(boolean alias) {
        super("controller");
        this.alias = alias;
    }

    public void generate(BaseProject project, SourceConfig config, Entity entity) {
        Template template = groupTemplate.getTemplate(pojoPath);
        // 注册方法
        groupTemplate.registerFunction("lowerFirst", new LowerFirstFnUtil());

        template.binding("className", entity.getName());
        template.binding("table", entity.getTableName());
        template.binding("package", project.getBasePackage(this.name));
        Writer writer = project.getWriterByName(this.name, entity.getName() + "Controller.java");
        template.renderTo(writer);
    }
}
