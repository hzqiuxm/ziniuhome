
/**
 * Copyright © 2017年 ziniuxiaozhu. All rights reserved.
 *
 * @author shengwuyou
 * @data 2017/11/15 0015 14:17
 */


//设置全局事件
 $.ajaxSetup({
        beforeSend:function(XMLHttpRequest){
            XMLHttpRequest.setRequestHeader("Authorization","Bearer"+localStorage.getItem("token"));
        }
 });