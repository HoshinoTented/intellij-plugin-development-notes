# Annotator
`Annotator`...  
敲代码的时候的警告, 错误之类的东西, 都由Annotator负责  
<del>我写这个md文档的时候, 下面的那个代码块全是绿的, 就是因为这玩意</del>  
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
        )
      }
    }
  }
}
```