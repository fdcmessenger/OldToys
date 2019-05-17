var DbTable = {
    infoData: {},
    validations: {
        rules: {

            name: {
                required: true,
                remote: {
                    url: Feng.ctxPath + "/gen/genTable/tableNameCheck",
                    cache: false,
                    async: false,
                    data:
                            {
                                tableName: function ()
                                {
                                    return $('#name').val();
                                }
                            }
                }
            }
        },
        messages: {

            name: {

                required: icon + "请选择数据库表",
                remote: "数据库表已存在"
            }
        }
    }
};

/**
 * 关闭此对话框
 */
DbTable.close = function () {
    parent.layer.close(window.parent.GenTable.layerIndex);
}

/**
 * 提交修改
 */
//DbTable.editSubmit = function () {
//    var ajax = new $ax(Feng.ctxPath + "/gen/genTable/genTableForm", function (data) {
//        if (data.message)
//            Feng.success(data.message);
//        else
//            Feng.success("修改成功!");
//        window.parent.SubSys.search();
//        DbTable.close();
//    }, function (data) {
//        Feng.log(data);
//        Feng.error("修改失败!" + data.responseJSON.message + "!");
//    });
//    ajax.setData(this.infoData);
//    ajax.start();
//};


$(function () {

    var result = $.extend(DbTable.validations, {
        onfocusout: function (element) {
            $(element).valid();
        },
        onkeyup: false,
        submitHandler: function (form) {
            window.parent.GenTable.dbTableName = $("#name").val();
            DbTable.close();
            window.parent.GenTable.openAddGenTable();
//            var serdata = $(form).serializeArray();
//            DbTable.infoData = serdata;
//            DbTable.editSubmit();
        }
    });
    $("#inputForm").validate(result);
});
