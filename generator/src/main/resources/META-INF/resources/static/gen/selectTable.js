var DbTable = {
    infoData: {},
    validations: {
        rules: {
            name: {
                required: true,
                remote: {
                    url: "/gen/genTable/tableNameCheck",
                    cache: false,
                    async: true,
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
        }
    });
    $("#inputForm").validate(result);
});
