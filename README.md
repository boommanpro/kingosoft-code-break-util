## 青果教务系统验证码识别

## 使用方式

1.引入依赖

2.开始使用

```java
InputStream in;
CodeBreak.codeBreak(in);
```


1.引入依赖方式

在release中下载依赖jar包

2.使用Maven引入依赖 待加入


## 启动加速

因首次使用需要加载图片缓存,使用如下方法在项目启动可以加速初次使用
```java
Class.forName("com.boommanpro.codebreak.cache.TrainImageCache");
```