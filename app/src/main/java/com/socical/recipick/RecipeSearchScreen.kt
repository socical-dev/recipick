package com.socical.recipick

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeSearchScreen(
    allRecipes: List<String>, modifier: Modifier = Modifier
) {
    // 입력 상태: 사용자가 TextField에 입력하는 값 (변하면 관련 UI만 다시 그림)
    // 이 화면(Composable)이 그려지는 동안(Composition)에 있는 동안(remember), 초기값이 TextFieldValue("")인 관찰 가능한 상태(mutableStateOf)를 만들고, 그 상태의 get/set을 by로 위임해 query라는 변수로 다룬다.
    var query by remember { mutableStateOf(TextFieldValue("")) }

    // 파생 상태: query나 allRecipes가 바뀔 때만 필터 연산 수행 (불필요한 재계산 방지)
    val filtered by remember(query, allRecipes) {
        derivedStateOf {
            val q = query.text.trim()
            if (q.isEmpty()) allRecipes
            else allRecipes.filter { it.contains(q, ignoreCase = true) }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Recipick") }    //상단바 타이틀
            )
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding)  //Scaffold가 준 안전 여백(상단바 등)
                .fillMaxSize()
                .padding(16.dp)         //화면 기준 여백
        ) {
            // 검색 입력창: value(현재 상태) + onValueChange(상태 갱신)가 핵심
            OutlinedTextField(
                value = query,
                onValueChange = { query = it },
                label = { Text("재료/레시피 검색") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )
            Spacer(Modifier.height(12.dp))

            // 결과 리스트: LazyColumn은 화면에 보이는 아이템만 효율적으로 그림
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(filtered) { recipe ->
                    ListItem(
                        headlineContent = { Text(recipe) },
                        supportingContent = { Text("레시피 상세 보기 (추후 연결)") })
                    // 구분선: Divider는 deprecated -> HorizontalDivider 사용
                    HorizontalDivider()
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun Preview_RecipeSearchScreen() {
    RecipeSearchScreen(
        allRecipes = listOf(
            "김치볶음밥", "계란말이", "토마토파스타", "된장찌개", "버섯볶음", "미역국"
        )
    )
}