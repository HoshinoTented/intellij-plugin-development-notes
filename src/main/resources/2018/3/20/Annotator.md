# Annotator
`Annotator`...  
敲代码的时候的警告, 错误之类的东西, 都由Annotator负责  
<del>我写这个md文档的时候, 下面的那个代码块全是绿的, 就是因为这玩意</del>  
<del>惨遭纠错: md代码块背景变绿是因为Injector</del>  
实现一个Annotator...
```kotlin
class MyAnnotator : Annotator {
  /**
   * Annotator唯一需要实现的方法
   * @param element 接受提示的PsiElement对象
   * @param holder 所有提示通过这个东西实现
   */
  override fun annotator(
    element : PsiElement, 
    holder : AnnotationHolder
  ) {
    when {
      element.text == "a" -> {
        holder.createInfoAnnotation(
          element,    //第0个参数是接受提示的PsiElement对象, 一般就传入参数的那个就好了
          "This element`s text is a"    //第1个参数是提示的内容
        ).run {
          registerFix(    //如果有需要, 可以调用这个函数来注册一个修复选项(Alt Enter弹出来的那个)
            //这个函数接收一个IntentionAction对象
            //例如julia-intellij就封装了个JuliaReplaceWithTextIntention
            //具体实现我也不是很懂(不似我搞的啦
          )
        }
      }
    }
  }
}
```