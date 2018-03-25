# ColorSettingsPage(代码高亮颜色配置)
这个要跟`SyntaxHighlighter`一起玩才可以  
不过这东西我不会。。。  

然后这个`ColorSettingsPage`...  
[示例代码](https://github.com/HoshinoTented/intellij-plugin-development-notes/tree/master/src/main/kotlin/top/tented/note/year2018/month3/day26/MyColorSettingsPage.kt)  
<del>emmmmmm用md编辑器写代码真的好难</del>  
事实上我并没有很深入的了解这个东西  
<del>因为测试的时候冰酱写了个Kotlin的bug</del>  

最后记得把这个放到`plugin.xml`里: 
```xml
<idea-plugin>
    <extensions defaultExtensionNs="com.intellij">
        <colorSettingsPage implementation="top.tented.note.year2018.month3.day26.MyColorSettingsPage"/>
    </extensions>
</idea-plugin>
```