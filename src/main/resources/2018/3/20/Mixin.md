# Mixin(<del>迷信</del>)
emmmm这个要跟Parser一起用才好玩  
这个具体我也不了解。。。  
因为我只负责processDeclaration(捂脸
```kotlin
//必须为抽象
abstract class JuliaLoopDeclarationMixin(node : ASTNode) : 
  JuliaDeclaration(node), JuliaForExpr {    //JuliaDeclaration不知道为什么要继承, 只是感觉有一股力量在吸引着本小姐
        //JuliaForExpr 就是被迷信的...Parser定义?
  /**
   * 标识符, 冰酱说返回个JuliaSymbol就好了...
   */
  override fun getNameIdentifier() {
    //...
    //这部分代码就省略了( https://github.com/ice1000/julia-intellij/blob/master/src/org/ice1000/julia/lang/psi/impl/julia-psi-mixin.kt
  }
  
  /**
   * 处理定义的东西(虽然说的很含糊。。可是我真的不知道怎么说呜
   * @param processor 不知道干啥的, 反正记得processor.execute就好了
   * @param substitutor 这个也不知道干啥的
   * @param lastParent 这个更不知道
   * @param place 接受寻找声明的PsiElement对象
   */
  override fun processDeclarations(
  	processor: PsiScopeProcessor, 
    substitutor: ResolveState, 
    lastParent: PsiElement?, 
    place: PsiElement
  ) {
    //例如ForExpr, 我们就要从for的声明里找, 找不到让父类去找
    //详细代码就不说了, 因为我也不知道怎么说
  }
}
```