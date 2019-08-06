(function ($) {
    'use strict';
    var _upload = function(){
       return this.on('click',function () {
            var url = $(this).attr("name");
            var formData = new FormData($('#uploadForm')[0]);
            $.ajax({
                type: 'post',
                url: url+"/upload",
                data: formData,
                cache: false,
                dataType: 'json',
                processData: false,
                contentType: false,
                success: function (obj) {
                    $.myAction.refreshTable({}, obj);
                    if (obj.code === "200")
                        $.myNotify.success(obj.msg);
                    else
                        $.myNotify.warning(obj.msg);
                },
                error: function () {
                    $.myNotify.danger("发生不可预知的错误")
                }
            });
        });
    };

    var _sub = function(form,url){
        return this.on('submit',function (e) {
            e.preventDefault();
            var formData = new FormData($(form)[0]);
            $.ajax({
                type: 'post',
                url: url,
                data: formData,
                cache: false,
                dataType: 'json',
                processData: false,
                contentType: false,
                success: function (obj) {
                    $.myAction.refreshTable({}, obj);
                    if (obj.code == 200) {
                        $.myNotify.success(obj.msg);
                        let next = obj.to;
                        setTimeout(function () {
                            window.location.href="#" + next;
                            window.location.reload();
                        }, 3000)
                    }
                    else {
                        $.myNotify.warning(obj.msg);
                    }
                },
                error: function () {
                    $.myNotify.danger("发生不可预知的错误")
                }
            });
        });
    };

    var _generate_api = {
        loadInfo:function (url,fun) {
            $.ajax({
                type: 'post',
                url: url,
                cache:false,
                dataType: 'json',
                success: function (data) {
                    fun(data);
                }
            });
        },
        /**
         * 使用bootstrap-select 添加多字段搜索 2019.1.19
         */
        selectField:function () {
            $("#sel_column").attr("class","form-control selectpicker");
            $("#sel_column").attr("multiple",true);
            $('.selectpicker').selectpicker({
                maxOptionsText: 3,
                width: 180
            });
        }
    };

    //上传
    $.fn.upload = _upload;

    //提交
    $.fn.sub = _sub;

    $.generateApi = _generate_api;

})(jQuery);






