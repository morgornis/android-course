package com.example.myapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapp.ui.theme.MyAppTheme

@Composable
fun ShowcaseBlock(
    apps: List<AppInfo>,
    onAppClick: (AppInfo) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Витрина",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(16.dp)
        )

        val pagesCount = 3
        val appsPerPage = 3
        val pagerState = rememberPagerState(pageCount = { pagesCount })

        HorizontalPager(state = pagerState) { page ->
            Row(modifier = Modifier.fillMaxWidth()) {
                val startIndex = page * appsPerPage
                for (i in startIndex until startIndex + appsPerPage) {
                    if (i < apps.size) {
                        AppItem(
                            app = apps[i],
                            modifier = Modifier.weight(1f).padding(4.dp),
                            onClick = { onAppClick(apps[i]) }
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowcaseBlock() {
    MyAppTheme {
        AppScreen()
    }
}