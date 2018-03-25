# FoldingBuilder(代码折叠)
emmmmmmm  
[代码](https://github.com/HoshinoTented/intellij-plugin-development-notes/tree/master/src/main/kotlin/top/tented/note/year2018/month3/day26/MyCodeFolderBuilder.kt)

然后就是加到`plugin.xml`里
```xml
<idea-plugin>
    <extensions defaultExtensionNs="com.intellij">
        <lang.foldingBuilder
            language="JAVA"
            implementationClass="top.tented.note.year2018.month3.day26.MyCodeFolderBuilder"/>
    </extensions>
</idea-plugin>
```
<del>最近好懒啊emmmmmmmm</del>