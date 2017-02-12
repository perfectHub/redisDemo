Redis缓存demo
//http://www.sxt.cn/u/2839/blog/4363
//http://blog.csdn.net/yingxiake/article/details/51472879

实现redis第一种：使用UserDao（我使用的是第一种，第二种好像报错）
    User实例化，在redis-context.xml中声明keySerializer、valueSerializer序列
第二种：使用UserDao2
    不需要序列
