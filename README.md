# JavaSegment
使用Java完成的正文提取和分词,
使用策略模式进行选择分词模式: 中文分词 或者 英文分词

# 总述
大体上这个任务还是很简单的,在网络请求和请求正文html方面使用的是 [ContentExtractor](https://github.com/hfut-dmic/ContentExtractor)库,
但是其实也可以是使用Square的Okhttp 请求网络上的html.在ContentExtractor中使用的是Jsoup自带的api先对网页请求然后分析节点,最后正文提取.

## 英文分词实现
这个项目有点像之前坐过的Stanford的Ngrams lab,使用map进行记录key,然后在对应的map上增加value,关于Ngrams可以看一下[我的这篇博客](https://www.jianshu.com/p/49f25b38967f)
问题:
- 有可能因为墙的限制导致网页内容请求超时.
我使用了IDEA 来进行编程,自己配置了代理,然后就可以流畅的请求到英文网页数据
- 标点符号:
比如这样的一段内容:
"something in the water" 使用Scanner进行取出Token的话会有这样的情况出现: "something , in, the , water" 这样的话,在之后的记录中,something
和"something 就不是同一个key了,会导致记录value出错,所以需要正则表达式进行去除非英文字符

## 中文分词实现
- 使用[结巴分词](https://github.com/huaban/jieba-analysis)进行分词,没有自己写分词器(弱..
