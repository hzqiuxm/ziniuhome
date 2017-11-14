//设置全局事件
 $.ajaxSetup({
        beforeSend:function(XMLHttpRequest){
            XMLHttpRequest.setRequestHeader("Authorization","Bearer"+localStorage.getItem("token"));
        }
 });