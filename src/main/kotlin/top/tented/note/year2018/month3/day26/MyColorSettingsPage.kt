package top.tented.note.year2018.month3.day26

import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import org.intellij.lang.annotations.Language

class MyColorSettingsPage : ColorSettingsPage {
	companion object {
		private val DESCRIPTIONS = arrayOf(
			AttributesDescriptor("名称", TODO() /*对应的TextAttributesKey对象, 一般是从Highlighter里面拿出来的吧*/)
		)

		//这个不知道干啥的...冰酱帮我写的w
		private val ADDITIONAL_MAP = mapOf(
			"Something" to TODO()
		)
	}

	override fun getAdditionalHighlightingTagToDescriptorMap() = ADDITIONAL_MAP
	override fun getAttributeDescriptors() = DESCRIPTIONS
	override fun getIcon() = null		//图标, 不解释
	override fun getColorDescriptors() = ColorDescriptor.EMPTY_ARRAY			//不知道为什么返回这个
	override fun getDisplayName() = "显示的名称, Julia里用的是JuliaFileType.name"
	override fun getHighlighter(): SyntaxHighlighter = TODO()		//这个要返回Highlighter...可是我不会呜呜呜

	@Language("kotlin")			//可以在这里打注解, 以得到代码高亮和补全
	override fun getDemoText() =
		"""
			//这里写示例代码
			fun main(args : Array<String>) {
				println("Hello world!")
			}
		""".trimIndent()
}