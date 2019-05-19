var Feng = {
    ctxPath: "",
    ctxStatic: "",
    addCtx: function (ctx) {
        if (this.ctxPath == "") {
            this.ctxPath = ctx;
        }
    },
    addCtxStatic: function (ctxStatic) {
        if (this.ctxStatic == "") {
            this.ctxStatic = ctxStatic;
        }
    },
    getHeight: function () {
        return $(window).height() - 25;
    },
    confirm: function (tip, ensure) {//询问框
        parent.layer.confirm(tip, {
            btn: ['确定', '取消']
        }, function (index) {
            ensure();
            parent.layer.close(index);
        }, function (index) {
            parent.layer.close(index);
        });
    },
    log: function (info) {
        console.log(info);
    },
    alert: function (info, iconIndex) {
        parent.layer.msg(info, {
            icon: iconIndex
        });
    },
    info: function (info) {
        Feng.alert(info, 0);
    },
    success: function (info) {
        Feng.alert(info, 1);
    },
    error: function (info) {
        Feng.alert(info, 2);
    },
    infoDetail: function (title, info) {
        var display = "";
        if (typeof info == "string") {
            display = info;
        } else {
            if (info instanceof Array) {
                for (var x in info) {
                    display = display + info[x] + "<br/>";
                }
            } else {
                display = info;
            }
        }
        parent.layer.open({
            title: title,
            type: 1,
            skin: 'layui-layer-rim', //加上边框
            area: ['950px', '600px'], //宽高
            content: '<div style="padding: 20px;">' + display + '</div>'
        });
    },
    writeObj: function (obj) {
        var description = "";
        for (var i in obj) {
            var property = obj[i];
            description += i + " = " + property + ",";
        }
        layer.alert(description, {
            skin: 'layui-layer-molv',
            closeBtn: 0
        });
    },
    getQueryString: function (name, url) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        if (!url || url == "") {
            url = window.location.search;
        } else {
            url = url.substring(url.indexOf("?"));
        }
        r = url.substr(1).match(reg)
        if (r != null)
            return unescape(r[2]);
        return null;
    },
    showInputTree: function (inputId, inputTreeContentId, leftOffset, rightOffset) {
        var onBodyDown = function (event) {
            if (!(event.target.id == "menuBtn" || event.target.id == inputTreeContentId || $(event.target).parents("#" + inputTreeContentId).length > 0)) {
                $("#" + inputTreeContentId).fadeOut("fast");
                $("body").unbind("mousedown", onBodyDown);// mousedown当鼠标按下就可以触发，不用弹起
            }
        };

        if (leftOffset == undefined && rightOffset == undefined) {
            var inputDiv = $("#" + inputId);
            var inputDivOffset = $("#" + inputId).offset();
            $("#" + inputTreeContentId).css({
                left: inputDivOffset.left + "px",
                top: inputDivOffset.top + inputDiv.outerHeight() + "px"
            }).slideDown("fast");
        } else {
            $("#" + inputTreeContentId).css({
                left: leftOffset + "px",
                top: rightOffset + "px"
            }).slideDown("fast");
        }

        $("body").bind("mousedown", onBodyDown);
    },
    baseAjax: function (url, tip) {
        var ajax = new $ax( url, function (data) {
            Feng.success(tip + "成功!");
        }, function (data) {
            Feng.error(tip + "失败!" + data.responseJSON.message + "!");
        });
        return ajax;
    },
    changeAjax: function (url) {
        return Feng.baseAjax(url, "修改");
    },
    zTreeCheckedNodes: function (zTreeId) {
        var zTree = $.fn.zTree.getZTreeObj(zTreeId);
        var nodes = zTree.getCheckedNodes();
        var ids = "";
        for (var i = 0, l = nodes.length; i < l; i++) {
            ids += "," + nodes[i].id;
        }
        return ids.substring(1);
    },
    eventParseObject: function (event) {//获取点击事件的源对象
        event = event ? event : window.event;
        var obj = event.srcElement ? event.srcElement : event.target;
        return $(obj);
    },
    sessionTimeoutRegistry: function () {
        $.ajaxSetup({
            contentType: "application/x-www-form-urlencoded;charset=utf-8",
            complete: function (XMLHttpRequest, textStatus) {
                //通过XMLHttpRequest取得响应头，sessionstatus，
                var sessionstatus = XMLHttpRequest.getResponseHeader("sessionstatus");
                if (sessionstatus == "timeout") {
                    //如果超时就处理 ，指定要跳转的页面
                    window.location = "/global/sessionError";
                }
            }
        });
    },
//    initValidator: function (formId, fields) {
//        $('#' + formId).bootstrapValidator({
//            feedbackIcons: {
//                valid: 'fa fa-ok',
//                invalid: 'fa fa-remove',
//                validating: 'fa fa-refresh'
//            },
//            fields: fields,
//            live: 'enabled',
//            message: '该字段不能为空'
//        });
//    },
    dateFormatter: function (value, row, index) {
        if (value) {
            var d = chGMT(value);
            return d.format('yyyy-MM-dd');
        } else
            return value;
    },
    datetimeFormatter: function (value, row, index) {
        if (value) {
            var d = chGMT(value);
            return d.format('yyyy-MM-dd hh:mm:ss');
        } else
            return value;
    },
    timeStampFormatter: function (value, row, index) {
        if (value) {
//            var d = new Date(value);
            var d = chGMT(value);
//            return d.format1('yyyy-MM-dd hh:mm:ss');
            return d.format('yyyy-MM-dd hh:mm:ss.S');
        } else
            return value;
    },
    booleanFormatter: function (value, row, index) {
        if (value)
            return '是';
        else
            return '否';
    },
    iconFormatter: function (value, row, index) {
        var s = "";
        if (value)
            s = '<i class="fa fa-' + value + ' fa-2x"></i>';

        return s;
    }



};

Date.prototype.format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds()             //毫秒 
    };
    if (/(y+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    for (var k in o) {
        if (new RegExp("(" + k + ")").test(fmt)) {
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        }
    }
    return fmt;
};
$.validator.setDefaults({
    onfocusout: function (element) {
        $(element).valid();
    },
    onkeyup: false,
    highlight: function (element) {
        $(element).closest('.form-group').removeClass('has-success').addClass('has-danger');
    },
    success: function (element) {
        element.closest('.form-group').removeClass('has-danger').addClass('has-success');
    },
    errorElement: "span",
    errorPlacement: function (error, element) {
        if (element.is(":radio") || element.is(":checkbox")) {
//            error.appendTo(element.parent().parent().parent());
        } else {
            error.appendTo(element.parent());
        }
    },
    errorClass: "help-block m-b-none",
    validClass: "help-block m-b-none"
});
function chGMT(gmtDateString) {
    var mydate = new Date(gmtDateString);
    mydate.setHours(mydate.getHours() + 8);
    return mydate;
//    return mydate.format("yyyy-MM-dd hh:mm:ss");    
}
var icon = "<i class='fa fa-times-circle'></i> ";