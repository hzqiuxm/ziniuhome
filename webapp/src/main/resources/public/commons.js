/**
 * Created by 明 on 2017/7/19.
 */
var Namespace=function(){var e={};var t=[];var n=function(e){if(typeof e=="object"&&e.sort){return e}return new Array(e)};var r=function(){var e;try{e=new XMLHttpRequest}catch(t){try{e=new ActiveXObject("Msxml2.XMLHTTP.6.0")}catch(t){try{e=new ActiveXObject("Msxml2.XMLHTTP.3.0")}catch(t){try{e=new ActiveXObject("Msxml2.XMLHTTP")}catch(t){try{e=new ActiveXObject("Microsoft.XMLHTTP")}catch(t){throw new Error("This browser does not support XMLHttpRequest.")}}}}}return e};var i=function(e){return e>=200&&e<300||e==304||e==1223||!e&&(location.protocol=="file:"||location.protocol=="chrome:")};var s=function(e){var t=document.createElement("script");t.type="text/javascript";t.text=e;document.body.appendChild(t)};var o=function(t,n){if(!e[t])return;n.event=t;for(var r=0,i=e[t].length;r<i;r++){e[t][r](n)}};var u=function(e){var t=arguments[1]||false;var n=window;if(e!=""){var r=e.split(Namespace.separator);for(var i=0,s=r.length;i<s;i++){if(!n[r[i]]){n[r[i]]={}}n=n[r[i]]}}if(t){for(var u in t){n[u]=t[u]}}o("create",{identifier:e});return n};u.exist=function(e){if(e=="")return true;var t=e.split(Namespace.separator);var n=window;for(var r=0,i=t.length;r<i;r++){if(!n[t[r]]){return false}n=n[t[r]]}return true};u.mapIdentifierToUri=function(e){var t=new RegExp("\\"+Namespace.separator,"g");return Namespace.baseUri+e.replace(t,"/")+".js"};_loadScript=function(e){var t=arguments[1]||false;var n=arguments[2]||false;var a=t!=false;var f=u.mapIdentifierToUri(e);var l={identifier:e,uri:f,async:a,callback:t};var c=r();c.open("GET",f,a);if(a){c.onreadystatechange=function(){if(c.readyState==4){if(i(c.status||0)){s(c.responseText);o("include",l);t();return}l.status=c.status;o("includeError",l);n&&n()}}}c.send(null);if(!a){if(i(c.status||0)){s(c.responseText);o("include",l);return true}l.status=c.status;o("includeError",l);return false}};u.include=function(e){var n=arguments[1]||false;var r=arguments[2]||false;if(t[e]){n&&n();return true}if(n){_loadScript(e,function(){t[e]=true;n()},r)}else{if(_loadScript(e)){t[e]=true;return true}return false}};u.use=function(e){var t=n(e);var r=arguments[1]||false;var i=arguments.length>2?arguments[2]:Namespace.autoInclude;var s={identifier:e};for(var a=0,f=t.length;a<f;a++){e=t[a];var l=e.split(Namespace.separator);var c=l.pop();var h=u(l.join(Namespace.separator));if(c=="*"){for(var p in h){window[p]=h[p]}}else{if(h[c]){window[c]=h[c]}else{if(i){if(r){u.include(e,function(){window[c]=h[c];if(a+1<t.length){u.unpack(t.slice(a+1),r,i)}else{o("use",s);r&&r()}});return}else{u.include(e);window[c]=h[c]}}}}}o("use",s);r&&r()};u.from=function(e){return{include:function(){var t=arguments[0]||false;u.include(e,t)},use:function(t){var n=arguments[1]||false;if(t.charAt(0)=="."){t=e+t}if(n){u.include(e,function(){u.use(t,n,false)})}else{u.include(e);u.use(t,n,false)}}}};u.provide=function(e){var r=n(e);for(var i=0,s=r.length;i<s;i++){if(!(e in t)){o("provide",{identifier:e});t[e]=true}}};u.addEventListener=function(t,n){if(!e[t])e[t]=[];e[t].push(n)};u.removeEventListener=function(t,n){if(!e[t])return;for(var r=0,i=e[t].length;r<i;r++){if(e[t][r]==n){delete e[t][r];return}}};u.registerNativeExtensions=function(){String.prototype.namespace=function(){var e=arguments[0]||{};return u(this.valueOf(),e)};String.prototype.include=function(){var e=arguments[0]||false;return u.include(this.valueOf(),e)};String.prototype.use=function(){var e=arguments[0]||false;return u.use(this.valueOf(),e)};String.prototype.from=function(){return u.from(this.valueOf())};String.prototype.provide=function(){return u.provide(this.valueOf())};Array.prototype.use=function(){var e=arguments[0]||false;return u.use(this,e)};Array.prototype.provide=function(){return u.provide(this)}};return u}();Namespace.separator=".";Namespace.baseUri="./";Namespace.autoInclude=true;
'use strict';
Namespace('znxz.commons');
znxz.commons = {
    getUrlParam: function (name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return decodeURI(r[2]);
        return null;
    },
    dateFmt: function (fmt, date) {
        var o = {
            "M+": date.getMonth() + 1,                 //月份
            "d+": date.getDate(),                    //日
            "h+": date.getHours(),                   //小时
            "m+": date.getMinutes(),                 //分
            "s+": date.getSeconds(),                 //秒
            "q+": Math.floor((date.getMonth() + 3) / 3), //季度
            "S": date.getMilliseconds()             //毫秒
        };
        if (/(y+)/.test(fmt))
            fmt = fmt.replace(RegExp.$1, (date.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(fmt))
                fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    }
};