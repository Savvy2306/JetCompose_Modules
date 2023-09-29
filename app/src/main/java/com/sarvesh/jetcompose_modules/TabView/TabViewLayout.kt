package com.sarvesh.jetcompose_modules.TabView

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabViewLayout() {

    val pagerState = rememberPagerState()
    val currentPage = pagerState.currentPage
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize()
    ){
        
        TabRow(selectedTabIndex = currentPage,
        backgroundColor = Color.Yellow
        ) {
            tabList.forEachIndexed(){ index, tabData ->
                Tab(selected = currentPage==index, onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }, modifier = Modifier.padding(5.dp)) {
                    Text(text = tabList[index].tab)
                }
            }
        }
        
         HorizontalPager(count = tabList.size, state = pagerState) { index->
             Text(text = tabList[index].des)
         }

    }

}

data class tabData(
    val tab: String,
    val des: String
)

val tabList = listOf(
    tabData(
        tab = "Home",
        des = "This is Home page."
    ),
    tabData(
        tab = "Image",
        des = "This is Image page."
    ),
    tabData(
        tab = "Video",
        des = "This is Video page."
    )
)