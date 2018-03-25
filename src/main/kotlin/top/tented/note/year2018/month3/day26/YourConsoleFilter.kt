package top.tented.note.year2018.month3.day26

import com.intellij.execution.filters.ConsoleFilterProviderEx
import com.intellij.execution.filters.Filter
import com.intellij.execution.filters.UrlFilter
import com.intellij.openapi.project.Project
import com.intellij.psi.search.GlobalSearchScope

class YourConsoleFilter : Filter {
	/**
	 * 主要方法, 用于过滤命令行
	 * @param line 当前行字符串
	 * @param entireLength 目前总共的字符数
	 * @return 不知道
	 */
	override fun applyFilter(line: String?, entireLength: Int): Filter.Result? {
		//这个能做很多东西(吧
		//所以也不写具体实现(就是懒
		return null
	}
}

class MyConsoleFilterProvider : ConsoleFilterProviderEx {
	override fun getDefaultFilters(project: Project, scope: GlobalSearchScope) = getDefaultFilters(project)
	override fun getDefaultFilters(project: Project) = arrayOf(YourConsoleFilter(), UrlFilter())
}