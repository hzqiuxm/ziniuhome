# 紫牛小筑帮助文档
---
## [数据建模文档(第一版)：](https://www.zybuluo.com/yeoman-hsj/note/918929)

标签（空格分隔）： 紫牛小筑 MongoDB

---

### 数据库 znxz
#### 用户(集合/文档) user
- *用户相关信息，包括用户信息和角色。*
```
user {
    "id" : ObjectId //主键ID
    "loginName" : String(32) //登录用户名
    "showName" : String(32) //显示的用户名称
    "cellNum" : String(16) //通讯号码
    "passwd" : String(64) //登录密码
    "sex" : Byte(1) //性别
    "age" : Integer //年龄
    "stage" : Byte(1) //状态
    "rank" : String(16) //职级(段位)
    "roles" : List<String> //角色列表
    "jc" : Integer //节操
    "avatar" : Res {
            "bucket" : String(32) //储存空间
            "fileKey" : String(64) //文件key
            "url" : String(128) //外连URL
        }
    "gmtModify" : Date //修改时间
}
```
#### 规则配置(集合/文档) config
- *配置信息，可以做配置，也可以做规则配置*
```
config {
    "code" : String(64) //配置编码，主键
    "name" : String(64) //配置名称
    "type" : Byte(1) //类型，默认为0
    "stage" : Byte(1) //有效状态：0为使用中，1为已弃用，2为保留。
    "descrip" : String(32) //配置值说明
    "byteVar" : Byte(2) //1~2位数值型数据
    "intVar" : Integer //1~9位数值型数据
    "longVar" : Long(18) //10~18位数值型数据
    "strVar" : String(64) //短字符串型数据
    "str1024Var" : String(1024) //长字符串型数据
    "gmtModify" : Date //修改时间
}
```
#### 节操流水(集合/文档) jcRec
- *节操流水，记录节操流通信息*
```
jcRec {
    "id" : ObjectId //主键ID
    "outer" : String(32) //节操流出方的loginName
    "amount" : Integer //数量
    "iner" : String(32) //节操流入方的loginName
    "type" : Byte(1) //类型，系统发放为0，系统奖励为1，系统返还为2，用户打赏为5，其他用户消耗为6
    "descrip" : String(32) //说明
}
```
#### 课程(集合/文档) course
- *课程相关信息，包括课程资源信息。*
```
course {
    "id" : ObjectId //主键ID
    "title" : String(32) //主题
    "descrip" : String(128) //课程介绍
    "lecturer" : String(32) //讲师的loginName
    "lecturerName" : String(32) //讲师的showName
    "audience" : String(32) //受众描述
    "gmtLecture" : Date //开讲时间
    "addr" : String(128) //讲课地点
    "stage" : Byte(1) //课程阶段：0为发布，1为审核，2为保留，3为报名，4为闭课，5为开课，6为结课，7为公开。
    "ruleCode" : String(64) //规则编码
    "signups" : List<Signup> [ //报名列表
            {
                "loginName" : String(32) //登录用户名
                "showName" : String(32) //显示的用户名称
                "rewardCnt" : Integer //赞赏次数，大于0的最长不超过4位的纯数字
                "gmtSignup" : Date //报名时间
            }
        ]
    "cover" : Res { //封面图片
            "bucket" : String(32) //储存空间
            "fileKey" : String(64) //文件key
            "url" : String(128) //外连URL
        }
    "ppt" : DownableRes { //演示文档
            "bucket" : String(32) //储存空间
            "fileKey" : String(64) //文件key
            "url" : String(128) //外连URL
            "fsize" : Integer //文件大小，单位为B字节
            "downCnt" : Integer //下载次数
        }
    "speech" : DownableRes { //课程文稿
            "bucket" : String(32) //储存空间
            "fileKey" : String(64) //文件key
            "url" : String(128) //外连URL
            "fsize" : Integer //文件大小，单位为B字节
            "downCnt" : Integer //下载次数
        }
    "audio" : PlayableRes { //演讲音频
            "bucket" : String(32) //储存空间
            "fileKey" : String(64) //文件key
            "url" : String(128) //外连URL
            "fsize" : Integer //文件大小，单位为B字节
            "playCnt" : Integer //播放次数
            "downCnt" : Integer //下载次数
        }
    "video" : PlayableRes { //演讲视频
            "bucket" : String(32) //储存空间
            "fileKey" : String(64) //文件key
            "url" : String(128) //外连URL
            "fsize" : Integer //文件大小，单位为B字节
            "playCnt" : Integer //播放次数
            "downCnt" : Integer //下载次数
        }
    "gmtModify" : Date //修改时间
}
```
#### 课程评论(集合/文档) courseCmt
- *课程评论相关信息，包括评论课程的用户、评论、被赞父评论ID等信息。*
```
courseCmt {
    "id" : ObjectId //主键ID
    "courseId" : Long(11) //课程ID
    "loginName" : String(32) //登录用户名
    "showName" : String(32) //显示的用户名称
    "cmtPid" : ObjectId //回复的评论的ID
    "likes" : List<String> [ //点赞的用户
            "loginName" : String(32) //登录用户名
        ]
    "content" : String(256) //评论内容
    "gmtModify" : Date //修改时间
}
```

---

## 子模块说明
 - common：公共层，一些共用工具类、静态常量类、枚举类等
 - data：数据层，数据存取接口、实体对象等
 - service：服务层，对数据功能进行封装的接口，承担外部接口与数据层的桥梁，实现复杂业务逻辑的处理
 - control：控制层，提供Http接口，承担请求的权限和安全的控制，参数的校验和简单业务逻辑的控制
 - webapp：Web层，启动入口、配置等，前端页面、脚本、样式和资源等
## 开发规范
### 配置
 - 使用Gradle管理依赖，依赖的包要加在就近引用的子模块，各模块避免重复引入
 - 配置文件统一放在/resources/config目录下，要求精简，并且风格统一，不保留无用的配置
 - 框架配置类统一放在webapp子模块的config包下
### 后端
 - 实体对象类都要加Document注解，子类与父类共用同一集合的，子类需要使用collection指定集合名
 - 持久层接口统一从MongoRepository接口继承，其中自定义的方法请遵循Mongodb约定命名
 - 服务层接口建议继承BaseService接口，实现对返回的数据进行封装，以ModelMap类型返回，设置对象主键为key，对象为value
 - 服务层也要做必要的校验和异常处理，以及格式化日志输出
 - 控制层接口建议继承BaseController类，返回数据请调用BaseController类中封装的方法
 - Http接口非特殊不返回页面，统一返回JSON格式的数据，并按下一条规范进行封装
 - 返回数据封装字段：success、code、msg、data，返回失败时，无数据data可以省略
### 前端
 - Html页面统一放在/resources/static目录下，并且按功能或模块分子目录
 - Js和Css等统一放在/resources/public目录下，并且按功能或模块分子目录
 - 对静态资源的引用统一使用项目根路径
 - 统一使用Ajax请求后端接口
 
---

###  security过滤框架的使用注意點：

#### 书写前端页面时候的注意点 
  -  每个AJAX请求需要带上token,token放置在请求头中 这里我设置一个全局事件，在ajax启动的时候自动触发
  
#### 书写后端的注意点 
  -  后端写接口的时候控制访问的权限，通过注解的方式 (例子：@RolesAllowed（{"ROLE_NAME"}）  @PermitAll   @DenyAll   )
  
##### 编码规约
- 所有的人都要设置文件头，格式如下：
```
/**
 * Copyright © 2017年 ziniuxiaozhu. All rights reserved.
 * @author 临江仙 hzqiuxm@163.com
 * @Date  ${DATE} ${TIME}
 * 
 */
```

- 每个类和每个方法都要写上注释，注释请参考优秀的spring源码
- 安装阿里代码规约插件和findbug插件，提交时务必对自己代码进行扫描