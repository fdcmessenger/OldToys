var GenTable = {
    id: "GenTable", //表格id
    seItem: null, //选中的条目
    table: null,
    dbTableName: null,
    layerIndex: -1
};
/**
 * 初始化表格的列
 */
GenTable.initColumn = function () {
    var columns = [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: true, align: 'center', valign: 'middle', sortable: true},
        {title: '表名称', field: 'name', align: 'center', valign: 'middle', sortable: true},
        {title: '说明', field: 'comments', align: 'center', valign: 'middle', sortable: true},
        {title: '类名', field: 'className', align: 'center', valign: 'middle', sortable: true},
        {title: '父表', field: 'parentTable', align: 'center', valign: 'middle', sortable: true},

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
GenTable.checkMore = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if (selected.length == 0) {
        Feng.info("请先选中表格中的至少一条记录！");
        return false;
    } else {
        GenTable.seItems = selected;
        var ids = new Array();
        for (var i = 0; i < GenTable.seItems.length; i++) {
            ids.push(GenTable.seItems[i].id);
        }
        GenTable.seIds = ids;
        return true;
    }
};
/**
 * 检查是否选中
 */
GenTable.checkOne = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    Feng.log(selected);
    if (selected.length == 0 || selected.length > 1) {
        Feng.info("请先选中表格中的某一且只选一条记录！");
        return false;
    } else {
        GenTable.seItem = selected[0];
        return true;
    }
};


/**
 * 点击添加批次
 */
GenTable.selectDbTableBeforeAddGenTable = function () {
    var index = layer.open({
        type: 2,
        shadeClose: true,
        shade: 0.8,
        title: '选择数据库表',
        area: ['800px', '650px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/gen/genTable/selectDbTable'
    });
    this.layerIndex = index;
};
GenTable.openAddGenTable = function () {
    var index = layer.open({
        type: 2,
        title: '添加业务表',
        area: ['100%', '100%'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/gen/genTable/genTableForm?name=' + this.dbTableName
    });
    layer.full(index);
    this.layerIndex = index;
};
GenTable.openEditGenTable = function () {
    if (this.checkOne()) {
        var index = layer.open({
            type: 2,
            title: '编辑业务表',
            area: ['100%', '100%'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/gen/genTable//genTableForm?id=' + this.seItem.id
        });
        layer.full(index);
        this.layerIndex = index;
    }
};
GenTable.delete = function () {
//    console.log(SubSys.seItem.id);
    if (this.checkOne()) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/gen/genTable/delete", function () {
                Feng.success("删除成功!");
                GenTable.table.refresh();
            }, function (data) {
                console.log(data);
                Feng.log(data);
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            console.log(GenTable.seItem);
            ajax.set("genTableId", GenTable.seItem.id);
            ajax.start();
        };
        Feng.confirm("是否刪除该业务表配置?", operation);
    }
};
GenTable.resetSearch = function () {
    GenTable.search();
};

GenTable.search = function () {
    var queryData = {};
    GenTable.table.refresh({query: queryData});
};
$(function () {
    var defaultColunms = GenTable.initColumn();
    var table = new BSTable("GenTable", "/gen/genTable/listData", defaultColunms);
    GenTable.table = table.init();
    $(window).resize(function () {
        GenTable.table.resetSize(Feng.getHeight());
    });

});
