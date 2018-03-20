# Create File From Template
<del>哇, 好困</del>  
emmmmmm  
直接上代码好了。。
```kotlin
class NewFileAction : 
  CreateFileFromTempalte(
    "新建文件(标题)",  
    "新建一个空文件(描述)", 
    null/*这里是图标*/
) {
  /**
   * 需要返回这个Action的名字(目前的插件开发。。似乎是返回title...
   */
  override fun getActionName(dir : PsiDirectory?, name : String?, templateName : String?) =
    "新建文件(标题)"
    
  /**
   * 构建Dialog, 主要是对builder进行操作
   * 吧
   */
  override fun buildDialog(project : Project?, dir : PsiDirectory?, builder : CreateFileFromTemplateDialog.Builder) {
    builder
      .setTitle("对话框的标题, 一般还是选择title吧")
      .setValidator(FileNameValidator)     //文件名过滤器, 把一些奇葩的名称给refuse掉
      .addKind("这里是下拉菜单显示的文本", null/*这个是对应的图标哦*/, "这个是模板名称")
      //.addKine(...)可以添加多个, 当只添加1个的时候, 下拉菜单不会出现
  }
  
  override fun createFileFromTemplate(name: String, template: FileTemplate, dir: PsiDirectory) {
    //这部分是真不会。。。
    //https://github.com/ice1000/zig-intellij/blob/master/src/org/ziglang/action/zig-file-actions.kt
  }
}
```

emmmmm然后是关于文件名过滤的实现...  
似乎是要实现一个叫做`InputValidatorEx`的接口
```kotlin
//这种东西就用单例好啦
object FileNameValidator : InputValidatorEx {
  //这个是...不知道, 我猜是 窗口是否可以关闭
  override fun canClose(input : String?) = checkInput(input) 
  //这里就是对input的格式判断了emmmm
  override fun checkInput(input : String?) = true
  //这个是 当checkInput返回为false的时候弹出的提示框内容(吧
  override fun getErrorText(input : String?) = "明明都返回true了, 怎么可能还出现这条消息"
}
```

哦对。。还有plugin.xml的配置内容 emmmmm
```xml
<idea-plugin>
  <extensions defaultExtensionNs="com.intellij">
    <internalFileTemplate name="这个是模板名称"/>
    <!--所有要注册的模板都放在这里注册哦, 跟上面一样ovo-->
  </extensions>
  
  <actions>
    <!--这里注册Action哦, 例如上面的NewFileAction就这样注册-->
    <action class="NewFileAction" id="Note.NewFile">
      <add-to-group 
        group-id="NewGroup" 
        anchor="after" 
        relative-to-action="NewFile"/>
      <!--add-to-group 是用来把这个Action加到某个Group里的, 例如NewGroup就是新建文件的Group(吧-->
      <!--anchor 大概是相对的方式, 例如after就是相对于...之后-->
      <!--relative-to-action 是相对的Action, 例如NewFile就是New File这个选项(我不知道这个值哪来的-->
    </action>  
  </actions>
</idea-plugin>
```

模板默认内容~  
以下的文件需要放在res/fileTemplates文件夹里来着...  
这个是 这个是模板名称.文件名后缀.ft  
就是模板的内容  
```
这个是模板内容
当通过 NewFileAction 创建文件的时候, 文件内容将会是这些
```

这个呢, 是 这个是模板名称.文件名后缀.html  
就是模板的简介(模板编辑框下面的辣个
```html
<!DOCTYPE HTML>
<html>
<body>
<h1>Hello world!</h1>
<p>这个是一个段落</p>
<del>你看不到我...你看不到我...</del>
</body>
</html>
```