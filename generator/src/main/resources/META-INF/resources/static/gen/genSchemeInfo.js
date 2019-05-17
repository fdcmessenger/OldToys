var GenSchemeInfo = {
    infoData: {},
    validations: {
        rules: {

        },
        messages: {

        }
    }
};

/**
 * 关闭此对话框
 */
GenSchemeInfo.close = function () {
    parent.layer.close(window.parent.GenScheme.layerIndex);
}

/**
 * 提交修改
 */
GenSchemeInfo.editSubmit = function () {
    var ajax = new $ax(Feng.ctxPath + "/gen/genScheme/save", function (data) {
        if (data.message)
            Feng.success(data.message);
        else
            Feng.success("修改成功!");
        window.parent.GenScheme.search();
        location.reload();
//        DbScheme.close();
    }, function (data) {
//        Feng.log(data);
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.setData(this.infoData);
    ajax.start();
};


$(function () {

    var result = $.extend(GenSchemeInfo.validations, {
        onfocusout: function (element) {
            $(element).valid();
        },
        onkeyup: false,
        submitHandler: function (form) {
//            loading('正在提交，请稍等...');
//            $("input[type=checkbox]").each(function () {
//                $(this).after("<input type=\"hidden\" name=\"" + $(this).attr("name") + "\" value=\""
//                        + ($(this).attr("checked") ? "true" : "false") + "\"/>");
////                $(this).attr("name", "_" + $(this).attr("name"));
//            });
//            form.submit();
 var serdata = $(form).serializeArray();
//            var serdata = $(form).serialize();
            console.log(serdata);
//            var formData = new FormData($(form)[0]);
//            console.log(formData);
//            var formData1 = new FormData($('#inputForm')[0]);
//            console.log(formData1);
            GenSchemeInfo.infoData = serdata;
            GenSchemeInfo.editSubmit();
        }
    });
    $("#inputForm").validate(result);
});
