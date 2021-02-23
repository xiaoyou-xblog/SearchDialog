# SearchDialog  一款好看的安卓搜索框

本项目修改自：[xiaoyou-xblog/SearchDialog (github.com)](https://github.com/xiaoyou-xblog/SearchDialog)

## 效果图

原效果

<img src="images/1.gif" alt="img" style="zoom:50%;" />

修改后支持设置关键词预测和跳转功能

<img src="images/image-20210223152446915.png" alt="image-20210223152446915" style="zoom: 33%;" />

修改内容
-------

### v2.2

1.适配androidx

2.添加编辑框内容改变的回调事件

3.支持设置关键词预测和修改功能

引入依赖
--------

```groovy
 implementation 'com.github.xiaoyou-xblog:SearchDialog:v2.2'
```


如何使用
--------
1.实例化(这个T就是关键词预测携带的数据):

```java
 SearchFragment<T> searchFragment = SearchFragment.newInstance();
```
2.设置回调:

```java
searchFragment.setOnSearchClickListener(new IOnSearchClickListener<String>() {
    /**
    *  点击搜索按钮时触发
    * @param keyword 搜索的关键词
    */
    @Override
    public void onSearchClick(String keyword) {
        searchInfo.setText(keyword);
    }

    /**
     *  点击关键词预测链接时触发
     * @param data 链接携带的数据
     */
    @Override
    public void onLinkClick(String data) {
        searchInfo.setText(data);
    }

    /**
   	*  当搜索框内容改变时触发
    * @param keyword 搜索的关键词
    */
    @Override
    public void onTextChange(String keyword) {
        // 数据初始化
        List<CustomLink<String>> data = new ArrayList<>();
        data.add(new CustomLink<>("链接1","数据1"));
        data.add(new CustomLink<>("链接2","数据2"));
        data.add(new CustomLink<>("链接3","数据3"));
        // 这里我们设置关键词预测显示的内容
        searchFragment.setLinks(data);
    }
});
```
3.显示搜索框:

```java
searchFragment.showFragment(getSupportFragmentManager(),SearchFragment.TAG);
```

4.如果需要设置关键词预测，进行如下操作

```java
// 数据初始化
List<CustomLink<String>> data = new ArrayList<>();
data.add(new CustomLink<>("链接1","数据1"));
data.add(new CustomLink<>("链接2","数据2"));
data.add(new CustomLink<>("链接3","数据3"));
// 这里我们设置关键词预测显示的内容
searchFragment.setLinks(data);
```

# License

    Copyright 2020 xiaoyou
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
        http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
