/**
 * ztree插件的封装
 */
(function () {

    var $ZTree = function (id, url) {
        this.id = id;   //树在html页面中的id
        this.url = url; //静态加载树数据的url，不用于ajax
        this.onClick = null;
        this.settings = null;
        this.ondblclick = null;
        this.tree = null; //ztree对象
    };

    $ZTree.prototype = {
        /**
         * 初始化ztree的设置
         */
        initSetting: function () {
            var settings = {
//                check:{enable:true},
                view: {
                    dblClickExpand: true,
                    selectedMulti: false
                },
                data: {simpleData: {enable: true}},
                callback: {
                    onClick: this.onClick,
                    onDblClick: this.ondblclick
                }
            };
            return settings;
        },

        /**
         * 手动设置ztree的设置
         */
        setSettings: function (val) {
            this.settings = val;
        },

        /**
         * 初始化ztree
         */
        init: function (inited) {
            var zNodeSeting = null;
            if (this.settings != null) {
                zNodeSeting =  $.extend(this.initSetting(), this.settings);
                console.log(zNodeSeting);
            } else {
                zNodeSeting = this.initSetting();
            }
            if (inited) {
                var zNodes = this.loadNodes();
                this.tree = $.fn.zTree.init($("#" + this.id), zNodeSeting, zNodes);
            } else
                this.tree = $.fn.zTree.init($("#" + this.id), zNodeSeting);

        },

        /**
         * 绑定onclick事件
         */
        bindOnClick: function (func) {
            this.onClick = func;
        },
        /**
         * 绑定双击事件
         */
        bindOnDblClick: function (func) {
            this.ondblclick = func;
        },

        /**
         * 加载节点
         */
        loadNodes: function () {
            var zNodes = null;
            var ajax = new $ax( this.url, function (data) {
                zNodes = data;
            }, function (data) {
                Feng.error("加载ztree信息失败!");
            });
            ajax.start();
            return zNodes;
        },

        /**
         * 获取选中的值
         */
        getSelectedVal: function () {
            var zTree = $.fn.zTree.getZTreeObj(this.id);
            var nodes = zTree.getSelectedNodes();
            return nodes[0].name;
        }
    };

    window.$ZTree = $ZTree;

}());