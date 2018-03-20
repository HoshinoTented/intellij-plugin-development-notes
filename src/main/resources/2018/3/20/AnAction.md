# AnAction
`Action`应该算是插件里面的一个基础构成吧  
例如新建文件。。。  
一个Action的新建应该是酱紫的  
先让一个类继承AnAction
```kotlin
class SomeAction(
    text : String,    //这个Action的名称
    description : String,   //这个Action的描述
    icon : Icon   //这个Action的图标(通过IconLoader获得
) : AnAction(text, description, icon) {
  /**
   * 当这个Action被触发的时候
   * @param e AnActionEvent, 不知道干嘛的(毕竟这个地方碰的比较少啊
   */
  override fun actionPerformed(e : AnActionEvent) {
    //TODO something
  }
}
```
emmmm对于语言支持插件  
冰酱是搞了个专门的Action...
```kotlin
abstract class JuliaAction(
  text : String,
  description : String
) : AnAction(text, description, null) {
  protected fun fileType(e: AnActionEvent) = 
    e.getData(CommonDataKeys.VIRTUAL_FILE)?.fileType == JuliaFileType
  override fun update(e: AnActionEvent) {
    e.presentation.isEnabledAndVisible = fileType(e)
  }
}
```
当然我也不知道为什么要这么写