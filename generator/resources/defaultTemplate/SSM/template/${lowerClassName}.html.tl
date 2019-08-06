<section xmlns:th="http://www.thymeleaf.org" class="content-header">
    <h1>
        ${data.describe}
        <small>${data.describe}页面</small>
    </h1>
    <ol class="breadcrumb">
        <li><a th:href="\@{/}"><i class="fa fa-dashboard"></i> 主页</a></li>
        <li><a href="#">${data.describe}管理</a></li>
        <li class="active">${data.describe}页面</li>
    </ol>
</section>

<section class="content">
    <div class="row">
        <div class="col-xs-12">
            <div class="box">
                <!-- /.box-header -->
                <div class="box-body">
                    <div class="btn-group btn-group-sm" id="toolbar">
                        <!-- Provides extra visual weight and identifies the primary action in a set of buttons -->
                        <button type="button" id="addBtn" class="btn btn-default" data-toggle="modal"
                                data-target="#addModal"><i class="glyphicon glyphicon-plus"></i> 添加
                        </button>
                        <!-- Indicates caution should be taken with this action -->
                        <button type="button" id="editBtn" class="btn btn-default" data-toggle="modal"
                                data-target="#editModal"
                                data-action="{type:'editable',form:'#editForm',table:'#table',after:'editAfter'}"
                                disabled><i class="glyphicon glyphicon-edit"></i> 修改
                        </button>
                        <!-- Indicates a dangerous or potentially negative action -->
                        <button type="button" id="deleteBtn" class="btn btn-default" data-toggle="modal"
                                data-target="#deleteModal"
                                data-action="{type:'delete',form:'#deleteForm',idField:'id',table:'#table'}" disabled><i
                                class="glyphicon glyphicon-remove"></i> 删除
                        </button>
                    </div>
                    <table id="table"></table>
                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.box -->

        </div>
        <!-- /.col -->
    </div>
    <!-- /.row -->
</section>
<!-- /.content -->

<!-- add Modal -->
<div xmlns:th="http://www.thymeleaf.org" class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="addModalLabel">添加${data.describe}</h4>
            </div>
            <div class="modal-body">
                <form id="addForm">
                @for(c in data.columns){
                    @if(!c.blank){
                        @if(c.hidden){
                        <input id="${c.property}" type="hidden" name="${c.property}">
                        @} else {
                        <div class="form-group">
                            <label class="control-label" for="${c.property}"><span class="asterisk">*</span>${c.simpleColumnComment}:</label>
                            <input id="${c.property}" type="text" class="form-control" name="${c.property}" placeholder="输入${c.simpleColumnComment}" required>
                            <div class="help-block with-errors"></div>
                        </div>
                        @}
                    @}
                @}
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="submit" form="addForm" class="btn btn-primary"
                        data-action="{type:'submit',form:'#addForm',url:'${data.lowerClassName}/create',after:'$.myAction.refreshTable'}">
                    确定
                </button>
            </div>
        </div>
    </div>
</div>
<!-- edit Modal -->
<div xmlns:th="http://www.thymeleaf.org" class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="editModalLabel">修改${data.describe}</h4>
            </div>
            <div class="modal-body">
                <div>
                    <form id="editForm">
                        <input type="hidden" name="id">
                        @for(c in data.columns){
                        @if(!c.blank){
                            @if(c.hidden){
                            <input id="e${c.property}" type="hidden" name="${c.property}">
                            @} else {
                            <div class="form-group">
                                <label class="control-label" for="e${c.property}"><span class="asterisk">*</span>${c.simpleColumnComment}:</label>
                                <input id="e${c.property}" type="text" class="form-control" name="${c.property}" placeholder="输入${c.simpleColumnComment}" required>
                                <div class="help-block with-errors"></div>
                            </div>
                            @}
                        @}
                        @}
                    </form>
                </div>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="submit" form="editForm" class="btn btn-primary"
                        data-action="{type:'submit',form:'#editForm',url:'${data.lowerClassName}/update',after:'$.myAction.refreshTable'}">
                    确定
                </button>
            </div>
        </div>
    </div>
</div>
<!-- delete modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="deleteSmallModalLabel">
    <div class="modal-dialog modal-sm" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="deleteSmallModalLabel">删除${data.describe}</h4>
            </div>
            <div class="modal-body">
                <form id="deleteForm"></form>
                确定要删除选中的 <span class="records"></span> 条记录?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" form="deleteForm" class="btn btn-primary"
                        data-action="{type:'submit',form:'#deleteForm',url:'${data.lowerClassName}/delete',after:'$.myAction.refreshTable'}">
                    确定
                </button>
            </div>
        </div>
    </div>
</div>

<div>
                <table class="table table-hover">
                  <tbody>
                    @for(c in data.columns){
                        @if((cLP.index-1)%4==0){
                        <tr>
                        @}
                        @if(!c.blank){
                            @if(!c.hidden){
                              <th>${c.simpleColumnComment}</th>
                              <td><input type="text" name="${c.property}"></td>
                            @}
                        @}
                        @if((cLP.index+4)%4==0){
                        </tr>
                        @}
                        @}
                  </tbody>
                 </table>
</div>

<script>

    var $table = $('#table');

    $(function () {
        // bootstrap table初始化
        // http://bootstrap-table.wenzhixin.net.cn/zh-cn/documentation/
        $table.bootstrapTable({
            url: '${data.lowerClassName}/list',
            idField: 'id',
            queryParams:function (params) {
                //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                var temp = {
                    limit: params.limit,                         //页面大小
                    offset: params.offset,   //页码
                    sort: params.sort,      //排序列名
                    order: params.order, //排位命令（desc，asc）
                    scolumn:params.scolumn?params.scolumn.toString():'year',//默认当前年度
                    search:params.search?params.search:(new Date()).getFullYear()
                };
                return temp;
            },
            columns: [
                {checkbox: true,searchable:false},
                @for(c in data.columns){
                @if(!c.blank){
                    @if(!c.hidden){
                {field: '${c.property}', title: '${c.simpleColumnComment}', sortable: true, halign: 'left',searchable:true},
                    @}
                @}
                @}
                {field: 'updateTime', title: '最近时间',searchable:false, halign: 'left',formatter:function (value, row, index) {
                        return new Date(value*1000).toLocaleString();
                    }},
                {field: 'status', title: '状态',halign: 'left',formatter:"forbid"},
                {
                    field: 'action',
                    title: '操作',
                    halign: 'center',
                    align: 'center',
                    formatter: 'actionFormatter',
                    events: 'actionEvents',
                    searchable:false
                }
            ]
        });
    });

    // 数据表格展开内容
    function detailFormatter(index, row) {
        var html = [];
        $.each(row, function (key, value) {
            html.push('<p><b>' + key + ':</b> ' + value + '</p>');
        });
        return html.join('');
    }


    function forbid(value, row, index) {
        var info;
        switch (value){
            case 0:
                info = '<button type="button"  class="btn btn-default btn-xs">未审</button>';
                break;
            case 1:
                info = '<button type="button" class="btn btn-success btn-xs">已审</button>';
                break;
            case -1:
                info = '<button type="button" class="btn btn-primary btn-xs">已锁定</button>';
                break;
            case -2:
                info = '<button type="button" class="btn btn-info btn-xs">已修改</button>';
                break;
            case -3:
                info = '<button type="button" class="btn btn-warning btn-xs">未通过</button>';
                break;
            case -4:
                info = '<button type="button" class="btn btn-danger btn-xs">不修改</button>';
                break;
            default:
                info = "无";
        }
        return info;
    }

    function editAfter(obj,row) {
        $.myAdmin.refreshComponent();
    }

    function actionFormatter(value, row, index) {
        return '\
        <a class="edit ml10" href="javascript:void(0)" data-toggle="tooltip" title="编辑"><i class="glyphicon glyphicon-edit"></i></a>　\
        \
        <a class="remove ml10" href="javascript:void(0)" data-toggle="tooltip" title="删除"><i class="glyphicon glyphicon-remove"></i></a>　\
        ';
    }

    window.actionEvents = {
        'click .edit': function (e, value, row, index) {
            $('#editModal').modal('show');
            $('#editForm').fillForm(row);
            editAfter('',row);
        },
        'click .remove': function (e, value, row, index) {
            $('#deleteModal').modal('show');
            $('.records').html('1');
            var html = '';
            for (var key in row) {
                html += '<input type="hidden" name="' + key + '" value="' + row[key] + '">';
            }
            $('#deleteForm').html(html);
        }
    };

</script>