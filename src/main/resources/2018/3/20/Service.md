# Service
emmmm  
这东西似乎被拿来存设置?  
冰酱是这样子搞的...
```kotlin
//首先搞个接口, 写出要存的对象
interface SomeService {
  val settings : SomeSettings
}

//这个是SomeSettings的内容...
class SomeSettings (
  var data : String = "Hello world!"
)

//然后写个getter, 用来拿Service
val Project.someSettings : SomeService =
  //这里的第0个参数如果不写的话就是全局的service了
  //第一个参数。。不说也知道吧..?
  get() = ServiceManaeger.getService(this, SomeService::class.java)
  
@State(   //可爱的注解
		name = "ZigProjectSettings",    //这个Service的名字(吧
		//file是存储的地方, scheme不知道是干嘛的orz
		storages = [Storage(file = "zigConfig.xml", scheme = StorageScheme.DIRECTORY_BASED)])
class SomeProjectServiceImpl : SomeProjectService, PersistentStateComponent<SomeSettings> {
	override val settings = SomeSettings()
	override fun getState(): SomeSettings? = XmlSerializerUtil.createCopy(settings)
	override fun loadState(state: ZigSettings?) {
		state?.let { XmlSerializerUtil.copyBean(it, settings) }
	}
}
```
<del>QAQ困洗</del>  
好了睡觉  
那个  
SomeProjectServiceImpl的内容。。。照着抄就好了吧。。。我也是照着抄的\(雾