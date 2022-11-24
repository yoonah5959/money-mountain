package heenu.moon.moneymountain.ui.extension

import heenu.moon.moneymountain.ui.Home

data class BasicCardWithList(
    val home: Home,
    val content: Long,
    val list: List<Long>
)