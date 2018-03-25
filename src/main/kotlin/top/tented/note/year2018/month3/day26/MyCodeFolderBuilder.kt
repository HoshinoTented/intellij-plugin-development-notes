package top.tented.note.year2018.month3.day26

import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingBuilderEx
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.psi.PsiElement

class MyCodeFolderBuilder : FoldingBuilderEx() {

	private class MyCodeFoldingDescirptor(element : PsiElement, private val holder : String) : FoldingDescriptor(element.node, element.textRange) {
		override fun getPlaceholderText() = holder
	}

	/**
	 * 折叠的主要方法
	 * @param root 文件的根PsiElement
	 * @param document 不知道
	 * @param quick 不知道
	 * @return 返回FoldingDescriptor的一个数组
	 */
	override fun buildFoldRegions(root: PsiElement, document: Document, quick: Boolean): Array<FoldingDescriptor> {
		val descriptors = ArrayList<FoldingDescriptor>()
		//在这里我选择遍历root, 然后找到需要被折叠的PsiElement(用 is 关键字)
		//然后用那个element和折叠之后的字符串
		//实例化一个MyCodeFoldingDescriptor

		//Do something
		val element = root		//需要被折叠的element, 这里用root代替
		descriptors.add(MyCodeFoldingDescirptor(element, "这个PsiElement被折叠了"))

		return descriptors.toTypedArray()			//事实上可以用 .apply {  }
	}

	//不知道干嘛的, 返回true就好了吧
	override fun isCollapsedByDefault(node: ASTNode) = true

	//这个也不知道干嘛的...
	override fun getPlaceholderText(node: ASTNode) = "..."
}