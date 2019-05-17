var GenScheme = {
    id: "GenScheme", //表格id
    seItem: null, //选中的条目
    table: null,
    layerIndex: -1
};
/**
 * 初始化表格的列
 */
GenScheme.initColumn = function () {
    var columns = [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: true, align: 'center', valign: 'middle', sortable: true},
        {title: '方案名称', field: 'name', align: 'center', valign: 'middle', sortable: true},

        {title: '操作', align: 'center', valign: 'middle', sortable: false, formatter: actionFormatter}

    ];
    return columns;
};

function dateFormatter(value, row, index) {
    if (value) {
        var d = new Date(value);
        return d.format('yyyy-MM-dd');
    } else
        return value;
}



function actionFormatter(value, row, index) {
    var s = "";
    var enableStr = '<a class="btn btn-success " href="#"  onclick="SubSys.enableSubSys(\'' + row['id'] + '\')">启用</a> ';
    var disableStr = '<a class="btn btn-warning " href="#"  onclick="SubSys.disableSubSys(\'' + row['id'] + '\')">停用</a> ';

    if (row['useable'] === true) {
        s = disableStr;
    } else {
        s = enableStr;
    }
    return s;
}

function booleanFormatter(value, row, index) {
    if (value)
        return '是';
    else
        return '否';
}
GenScheme.checkMore = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if (selected.length == 0) {
        Feng.info("请先选中表格中的至少一条记录！");
        return false;
    } else {
        GenScheme.seItems = selected;
        var ids = new Array();
        for (var i = 0; i < GenScheme.seItems.length; i++) {
            ids.push(GenScheme.seItems[i].id);
        }
        GenScheme.seIds = ids;
        return true;
    }
};
/**
 * 检查是否选中
 */
GenScheme.checkOne = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    Feng.log(selected);
    if (selected.length == 0 || selected.length > 1) {
        Feng.info("请先选中表格中的某一且只选一条记录！");
        return false;
    } else {
        GenScheme.seItem = selected[0];
        return true;
    }
};


GenScheme.openAddGenScheme = function () {
    var index = layer.open({
        type: 2,
        title: '添加业务表',
        area: ['800px', '90%'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/gen/genScheme/genSchemeForm'
    });
    layer.full(index);
    this.layerIndex = index;
};
GenScheme.openEditGenScheme = function () {
    if (this.checkOne()) {
        var index = layer.open({
            type: 2,
            title: '编辑业务表',
           area: ['800px', '90%'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/gen/genScheme/genSchemeForm?id=' + this.seItem.id
        });
        layer.full(index);
        this.layerIndex = index;
    }
};
GenScheme.delete = function () {
//    console.log(SubSys.seItem.id);
    if (this.checkOne()) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/gen/genScheme/delete", function () {
                Feng.success("删除成功!");
                GenScheme.table.refresh();
            }, function (data) {
                console.log(data);
                Feng.log(data);
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            console.log(GenScheme.seItem);
            ajax.set("genSchemeId", GenScheme.seItem.id);
            ajax.start();
        };
        Feng.confirm("是否刪除该生成方案?", operation);
    }
};
GenScheme.resetSearch = function () {
    GenScheme.search();
};

GenScheme.search = function () {
    var queryData = {};
    GenScheme.table.refresh({query: queryData});
};
$(function () {
    var defaultColunms = GenScheme.initColumn();
    var table = new BSTable("GenScheme", "/gen/genScheme/listData", defaultColunms);
    GenScheme.table = table.init();
//    SubSys.table = table.init({height: 500, pageSize: 2});
    $(window).resize(function () {
        GenScheme.table.resetSize(Feng.getHeight());
    });

});
