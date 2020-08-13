# IDEA插件Easy Code模板

[![downloads](https://img.shields.io/github/downloads/wormhole/EasyCode-Template/total.svg)](https://github.com/wormhole/EasyCode-Template/releases)
[![forks](https://img.shields.io/github/forks/wormhole/EasyCode-Template.svg)](https://github.com/stdutil/EasyCode-Template/network/members)
[![stars](https://img.shields.io/github/stars/wormhole/EasyCode-Template.svg)](https://github.com/stdutil/EasyCode-Template/stargazers) 
[![repo size](https://img.shields.io/github/repo-size/wormhole/EasyCode-Template.svg)](https://github.com/wormhole/EasyCode-Template/archive/master.zip)
[![release](https://img.shields.io/github/release/wormhole/EasyCode-Template.svg)](https://github.com/wormhole/EasyCode-Template/releases)
[![license](https://img.shields.io/github/license/mashape/apistatus.svg)](https://github.com/wormhole/EasyCode-Template/blob/dev/LICENSE)

## 一、环境准备
### 1.1 安装IDEA
步骤略
### 1.2 安装Easy Code插件
* 打开`File->Settings->Plugins`，搜索`Easy Code`
* 点击`install`即可
* 如下图所示  
![install](img/install.png)

## 二、导入模板文件
### 2.1 新建模板
* 打开`File->Settings->Other Settings->Easy Code->Template Setting`
* 点击`+`号，新建`Group Name`，名称随便  
![group](img/group.png)
* 将工程中`template`目录下的模板文件依此添加到`Group Name`下的模板文件当中
* 将工程中`code`目录下的工具代码放置到自己的项目里，注意此步骤需要同步修改模板文件`DAO.java`中`QueryWrapper`类的包名  
![package](img/package.png)

## 三、如何使用
### 3.1 通过`IDEA`的`Database`工具配置数据库连接
步骤略

### 3.2 生成代码
* 在`database`工具中找到需要生成代码的表，右键`EasyCode->Generate Code`  
* 选择`Package`和`Path`，勾选`All`，点击`OK`即可  
![setting](img/setting.png)

## 四、用例
### 4.1 条件查询
```
QueryWrapperBuilder builder = new QueryWrapperBuilder();// new一个建造着对象
builder.eq("age", "23");                                // age = 23，可以有多个eq
builder.like("李", Arrays.asList("name", "note"));      // name like "%李%" or note like "%李%"，可以有多个like
builder.asc("age");                                     // order by age asc,name desc
builder.desc("name");
builder.page(0,10);                                     // limit 0, 10
QueryWrapper wrapper = builder.build();
List<User> user = userDAO.selectByCondition(wrapper);
```
以上代码等同于  
`select * from user where age = 23 and (name like "%李%" or note like "%李%") order by age asc, name desc limit 0, 10`

### 4.2 查询数量
```
QueryWrapperBuilder builder = new QueryWrapperBuilder();// new一个建造着对象
builder.eq("age", "23");                                // age = 23
builder.like("李", Arrays.asList("name", "note"));      // name like "%李%" or note like "%李%"
QueryWrapper wrapper = builder.build();
Integer total = userDAO.countByCondition(wrapper);      // 查询总数
```
以上代码等同于  
`select count(*) from user where age = 23 and (name like "%李%" or note like "%李%")`

### 4.3 新增，批量新增
略

### 4.4 更新，批量更新
略

### 4.5 删除，批量删除
略