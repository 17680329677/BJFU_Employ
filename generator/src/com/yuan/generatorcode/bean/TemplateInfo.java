package com.yuan.generatorcode.bean;

import org.beetl.core.Template;

/**
 * @author YouYuan
 * @version 1.0
 * @Email xiyousuiyuan@163.com
 * @Date 2017/12/16 01:04
 */
public class TemplateInfo {
    private Template template;
    private String templatePath;
    private String outputPath;

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }

    public String getTemplatePath() {
        return templatePath;
    }

    public void setTemplatePath(String templatePath) {
        this.templatePath = templatePath;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }

    @Override
    public String toString() {
        return "TemplateInfo{" +
                "template=" + template +
                ", templatePath='" + templatePath + '\'' +
                ", outputPath='" + outputPath + '\'' +
                '}';
    }
}
