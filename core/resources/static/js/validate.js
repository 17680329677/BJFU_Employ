// 学生信息表单验证
$(function () {
    $('#stuForm').bootstrapValidator({
        message: 'This value is not valid',
        live: 'enabled',
        group: '.rowGroup',
        excluded: [':disabled', ':hidden', ':not(:visible)'],
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            phone: {
                validators: {
                    notEmpty: {
                        message: '手机号不能为空'
                    },
                    regexp: {
                        regexp: /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/,
                        message: '手机号格式不正确'
                    }
                }
            },
            email: {
                validators: {
                    notEmpty: {
                        message: '邮箱不能为空'
                    },
                    regexp: {
                        regexp: /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/,
                        message: '邮箱格式不正确'
                    }
                }
            },
            ethnicity: {
                validators: {
                    notEmpty: {
                        message: '请选择民族'
                    }
                }
            },
            political: {
                validators: {
                    notEmpty: {
                        message: '请选择政治面貌'
                    }
                }
            },
            wechat: {
                validators: {
                    notEmpty: {
                        message: '微信号不能为空'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z]{1}[-_a-zA-Z0-9]{5,19}$/,
                        message: '微信号格式不正确'
                    }
                }
            },
            province: {
                validators: {
                    notEmpty: {
                        message: '请选择省份'
                    }
                }
            },
            city: {
                validators: {
                    notEmpty: {
                        message: '请选择城市'
                    }
                }
            },
            district: {
                validators: {
                    notEmpty: {
                        message: '请选择区/县'
                    }
                }
            },
            degree: {
                validators: {
                    notEmpty: {
                        message: '请选择学位'
                    }
                }
            },
            education: {
                validators: {
                    notEmpty: {
                        message: '请选择学历'
                    }
                }
            },
            training: {
                validators: {
                    notEmpty: {
                        message: '请选择培养方式'
                    }
                }
            },
            normal: {
                validators: {
                    notEmpty: {
                        message: '请选择师范生类别'
                    }
                }
            },
            undergraduateCat: {
                validators: {
                    notEmpty: {
                        message: '请选择本科类别'
                    }
                }
            },
            mentor: {
                validators: {
                    notEmpty: {
                        message: '请输入导师姓名'
                    }
                }
            },
            mentorTitle: {
                validators: {
                    notEmpty: {
                        message: '选择导师职称'
                    }
                }
            },
            undergraduate: {
                validators: {
                    notEmpty: {
                        message: '请填写本科院校'
                    }
                }
            },
        }
    })
});

// 就业信息表单验证
$(function () {
    $('#employForm').bootstrapValidator({
        message: 'This value is not valid',
        live: 'enabled',
        group: '.rowGroup',
        excluded: [':disabled', ':hidden', ':not(:visible)'],
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            comEmail: {
                validators: {
                    regexp: {
                        regexp: /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/,
                        message: '邮箱格式不正确'
                    }
                }
            },
            province: {
                validators: {
                    notEmpty: {
                        message: '请选择省份'
                    }
                }
            },
            city: {
                validators: {
                    notEmpty: {
                        message: '请选择城市'
                    }
                }
            },
            district: {
                validators: {
                    notEmpty: {
                        message: '请选择区/县'
                    }
                }
            },
            comPostcode: {
                validators: {
                    regexp: {
                        regexp: /^[0-9][0-9]{5}$/,
                        message: '邮政编码格式不正确'
                    }
                }
            },
        }
    })
});


// 档案信息表单验证
$(function () {
    $('#recordForm').bootstrapValidator({
        message: 'This value is not valid',
        live: 'enabled',
        group: '.rowGroup',
        excluded: [':disabled', ':hidden', ':not(:visible)'],
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            employForm: {
                validators: {
                    notEmpty: {
                        message: '请请选择就业形式'
                    }
                }
            },
            destination: {
                validators: {
                    notEmpty: {
                        message: '请请选择毕业去向'
                    }
                }
            },
            recordPostcode: {
                validators: {
                    regexp: {
                        regexp: /^[0-9][0-9]{5}$/,
                        message: '邮政编码格式不正确'
                    }
                }
            },
            specialEmploy: {
                validators: {
                    notEmpty: {
                        message: '请请选择特殊就业类别'
                    }
                }
            },
            registerType: {
                validators: {
                    notEmpty: {
                        message: '请请选择报到证签发类别'
                    }
                }
            },
        }
    })
});

// 问卷创建表单验证
$(function () {
    $('#paperAddForm').bootstrapValidator({
        message: 'This value is not valid',
        live: 'enable',
        excluded: [':disabled', ':hidden', ':not(:visible)'],
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            title: {
                validators: {
                    notEmpty: {
                        message: '请填写问卷标题'
                    }
                }
            },
            status: {
                validators: {
                    notEmpty: {
                        message: '请选择问卷状态'
                    }
                }
            },
            paperType: {
                validators: {
                    notEmpty: {
                        message: '请选择问卷类型'
                    }
                }
            },
        }
    })
});


// 问卷修改表单验证
$(function () {
    $('#paperEditForm').bootstrapValidator({
        message: 'This value is not valid',
        live: 'enable',
        excluded: [':disabled', ':hidden', ':not(:visible)'],
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            title: {
                validators: {
                    notEmpty: {
                        message: '请填写问卷标题'
                    }
                }
            },
            status: {
                validators: {
                    notEmpty: {
                        message: '请选择问卷状态'
                    }
                }
            },
            paperType: {
                validators: {
                    notEmpty: {
                        message: '请选择问卷类型'
                    }
                }
            },
        }
    })
});

// 问题创建表单验证
$(function () {
    $('#questionAddForm').bootstrapValidator({
        message: 'This value is not valid',
        live: 'enable',
        excluded: [':disabled', ':hidden', ':not(:visible)'],
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            questionType: {
                validators: {
                    notEmpty: {
                        message: '请选择问题类型'
                    }
                }
            },
            questionTitle: {
                validators: {
                    notEmpty: {
                        message: '请填写问题标题'
                    }
                }
            }
        }
    })
});

// 问题创建表单验证
$(function () {
    $('#questionEditForm').bootstrapValidator({
        message: 'This value is not valid',
        live: 'enable',
        excluded: [':disabled', ':hidden', ':not(:visible)'],
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            questionType: {
                validators: {
                    notEmpty: {
                        message: '请选择问题类型'
                    }
                }
            },
            questionTitle: {
                validators: {
                    notEmpty: {
                        message: '请填写问题标题'
                    }
                }
            }
        }
    })
});