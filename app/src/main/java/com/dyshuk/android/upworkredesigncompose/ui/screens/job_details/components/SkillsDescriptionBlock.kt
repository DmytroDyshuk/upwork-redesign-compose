package com.dyshuk.android.upworkredesigncompose.ui.screens.job_details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dyshuk.android.upworkredesigncompose.data.model.Job
import com.dyshuk.android.upworkredesigncompose.ui.theme.CharcoalGray
import com.dyshuk.android.upworkredesigncompose.ui.theme.MintCream
import com.dyshuk.android.upworkredesigncompose.ui.theme.PrimaryGreen

@Composable
fun SkillsDescriptionBlock(modifier: Modifier = Modifier, job: Job) {
    val skills = listOf(
        "Figma", "Sketch", "UI Design", "UX Design", "Wireframes",
        "Prototyping", "User Flows", "Design Systems", "Collaboration", "Testing", "Analysis"
    )
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(110.dp)
            .background(
                shape = RoundedCornerShape(15.dp),
                color = Color.White
            )
            .padding(20.dp)
    ) {
        Text(
            modifier = Modifier,
            text = "Skills and Expertise",
            color = CharcoalGray,
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(Modifier.height(11.dp))
        LazyHorizontalGrid(
            modifier = Modifier,
            rows = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp),
            userScrollEnabled = false
        ) {
            items(skills.take(8)) { skill ->
                SkillItem(skill)
            }
        }
    }
}

@Composable
fun SkillItem(text: String) {
    Text(
        modifier = Modifier
            .requiredHeight(20.dp)
            .background(
                color = MintCream,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(horizontal = 9.dp)
            .padding(top = 3.dp),
        text = text,
        color = PrimaryGreen,
        style = MaterialTheme.typography.headlineSmall,
    )
}