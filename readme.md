# 紫牛小筑帮助文档
---
## [数据建模文档(第一版)：](https://www.zybuluo.com/yeoman-hsj/note/918929)

标签（空格分隔）： 紫牛小筑 MongoDB

---

### 数据库 znxz
#### 用户(集合/文档) user
- *用户相关信息，包括用户信息和角色。*
```
User {
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
Config {
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
JcRec {
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
Course {
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
CourseCmt {
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

### security过滤框架的使用注意點：

####书写前端页面时候的注意点 
  -  每个AJAX请求需要带上token,token放置在请求头中 这里我设置一个全局事件，在ajax启动的时候自动触发
  
####书写后端的注意点 
  -  后端写接口的时候控制访问的权限，通过注解的方式 (例子：@RolesAllowed（{"ROLE_NAME"}）  @PermitAll   @DenyAll   )