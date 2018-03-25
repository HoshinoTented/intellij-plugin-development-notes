# ConsoleFilter(命令行过滤)
[代码](https://github.com/HoshinoTented/intellij-plugin-development-notes/tree/master/src/main/kotlin/top/tented/note/year2018/month3/day26/YourConsoleFilter.kt)  
 
 `plugin.xml`
 ```xml
<idea-plugin>
    <extensions defaultExtensionNs="com.intellij">
        <consoleFilterProvider implementation="top.tented.note.year2018.month3.day26.MyConsoleFilterProvider"/>
    </extensions>
</idea-plugin>
```

有缘再会, 晚安