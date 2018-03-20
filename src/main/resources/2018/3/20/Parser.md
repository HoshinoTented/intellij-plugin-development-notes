# Parser & Lexer
冰酱用的是bnf而不是手写`Parser`  
所以...
```bnf
//格式嘛, 基本就是 名字 ::= 内容
//::=当然就是定义啦
//基本跟正则差不多, 所以就不多说了
//bnf里的字符构成一般都从flex里拿
value ::= symbol | number
plus ::= value PLUS_SYM value
//以上是一个在实战中完全用不到的bnf代码
```

flex:
```flex
\+\+ { return JuliaToken.INC_SYM; }
\+ { return JuliaToken.PLUS_SYM; }
```
然后这个上下顺序是有讲究的
比如 `+` 和 `++`  
```kotlin
fun main(args : Array<String>) {
  (if("++".startsWith("+")) "++" else "+")
      .let { println("$it first") }
}
```