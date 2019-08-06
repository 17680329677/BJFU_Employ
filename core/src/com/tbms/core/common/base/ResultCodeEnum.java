package com.tbms.core.common.base;

/**
 * @author cjbi
 */
public enum ResultCodeEnum {

    OK("200","处理成功"),
    BadRequest("400","请求参数有误"),
    Unauthorized("401","未授权"),
    ParamsMiss("483","缺少接口中必填参数"),
    ParamError("484","参数非法"),
    FailedDelOwn("485","不能删除自己"),
    FailedUserAlreadyExist("486","该用户已存在"),
    InternalServerError("500","服务器内部错误"),
    NotUserPassword("100", "密码不匹配"),
    ErrorOldPassword("101", "旧密码不正确"),
    FileNotExist("102", "文件不存在"),
    NotExcelFile("103", "非excel文件"),
    EmptyFile("104", "文件内容为空"),
    FieldError("105", "字段信息错误,请检查表单数据"),
    FailChecked("106", "审核失败"),
    NotImplemented("501","业务异常");

    private String code;
    private String msg;

    private ResultCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
