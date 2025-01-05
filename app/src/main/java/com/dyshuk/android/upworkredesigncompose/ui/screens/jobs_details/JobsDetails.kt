package com.dyshuk.android.upworkredesigncompose.ui.screens.jobs_details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dyshuk.android.upworkredesigncompose.R
import com.dyshuk.android.upworkredesigncompose.ui.components.FavouriteButton
import com.dyshuk.android.upworkredesigncompose.ui.components.JobTag
import com.dyshuk.android.upworkredesigncompose.ui.components.LabeledValuePairRow
import com.dyshuk.android.upworkredesigncompose.ui.components.PaymentVerifiedBadge
import com.dyshuk.android.upworkredesigncompose.ui.components.StarRating
import com.dyshuk.android.upworkredesigncompose.ui.theme.BrightGray
import com.dyshuk.android.upworkredesigncompose.ui.theme.CharcoalGray
import com.dyshuk.android.upworkredesigncompose.ui.theme.CoralRed
import com.dyshuk.android.upworkredesigncompose.ui.theme.LightSilver
import com.dyshuk.android.upworkredesigncompose.ui.theme.MintCream
import com.dyshuk.android.upworkredesigncompose.ui.theme.PrimaryGreen
import com.dyshuk.android.upworkredesigncompose.ui.theme.SilverGray
import com.dyshuk.android.upworkredesigncompose.ui.theme.SkyBlue
import com.dyshuk.android.upworkredesigncompose.ui.theme.SnowWhite
import com.dyshuk.android.upworkredesigncompose.ui.theme.UpworkRedesignComposeTheme

@Composable
fun JobDetailsScreen() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .verticalScroll(state = scrollState)
    ) {

    }
}

@Composable
fun JobDescription(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier.padding(end = 35.dp, top = 17.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.padding(start = 15.dp, end = 9.dp),
                imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_back),
                contentDescription = "Back arrow",
                tint = PrimaryGreen
            )
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    modifier = Modifier,
                    text = "Hourly - Posted 2 hours ago",
                    color = LightSilver,
                    style = MaterialTheme.typography.titleSmall
                )
                Text(
                    modifier = Modifier,
                    text = "Upwork Redesign Project",
                    color = PrimaryGreen,
                    style = MaterialTheme.typography.titleMedium
                )
            }
            FavouriteButton {
                //Button clicked
            }
        }

        Spacer(Modifier.height(5.dp))

        Text(
            modifier = Modifier.padding(start = 34.dp),
            text = "Product Designer",
            color = CharcoalGray,
            style = MaterialTheme.typography.titleSmall
        )

        Spacer(Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 35.dp)
        ) {
            JobTag(text = "Ongoing project", textColor = SilverGray)
            Spacer(Modifier.width(29.dp))
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(color = SkyBlue)) {
                        append("6")
                    }
                    withStyle(style = SpanStyle(color = SilverGray)) {
                        append(" / 126 Connects Required")
                    }
                },
                modifier = Modifier
                    .background(
                        color = SnowWhite,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(horizontal = 9.dp, vertical = 4.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }

        Spacer(Modifier.height(12.dp))

        Text(
            modifier = Modifier.padding(horizontal = 35.dp),
            text = "I am looking for a Co-Founder to join me visualize an idea to fruition. The Macro Idea is an Platform BYOB which stands for  BeYourOwnBoss will be a social media to give a platform to entrepreneurs and investors and freelancers enhance the way they regularly network and to create for themselves and as our slogan says \"Make it Real\".\n" +
                    "\n" +
                    "You will need to show only one or two examples of your best quality work with proof, so original sketch file (screenshots ok)\n" +
                    "\n" +
                    "Will need to be turned around quickly, so working over the weekend ay be necessary. ",
            color = CharcoalGray,
            style = MaterialTheme.typography.bodyMedium,
        )

        Spacer(Modifier.height(10.dp))

        Row(modifier = Modifier.padding(horizontal = 35.dp)) {
            JobTag(text = "job.timeRequirement", textColor = SilverGray)
            Spacer(Modifier.width(5.dp))
            JobTag(text = "job.duration", textColor = SilverGray)
        }

        Spacer(Modifier.height(25.dp))
    }
}

@Composable
fun SkillsDescription(modifier: Modifier = Modifier) {
    val skills = listOf(
        "Figma", "Sketch", "UI Design", "UX Design", "Wireframes",
        "Prototyping", "User Flows", "Design Systems", "Collaboration", "Testing", "Analysis"
    )
    Column(
        modifier = Modifier
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

@Composable
fun JobActivity(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(
                shape = RoundedCornerShape(15.dp),
                color = Color.White
            )
            .padding(20.dp)
    ) {
        Row {
            JobActivityTag(count = "5 to 10", title = "PROPOSAL")
            Spacer(modifier = Modifier.width(15.dp))
            JobActivityTag(count = "6", title = "INTERVIEWING")
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row {
            JobActivityTag(count = "15", title = "INVITES SENT")
            Spacer(modifier = Modifier.width(15.dp))
            JobActivityTag(count = "4", title = "UNANSWERED INVITES")
        }
    }
}

@Composable
fun JobActivityTag(modifier: Modifier = Modifier, count: String, title: String) {
    Column(
        modifier = modifier
            .height(60.dp)
            .width(145.dp)
            .background(
                color = SnowWhite,
                shape = RoundedCornerShape(10.dp)
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = count,
            color = CharcoalGray,
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = title,
            color = LightSilver,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Composable
fun AboutTheClient(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(
                shape = RoundedCornerShape(15.dp),
                color = Color.White
            )
            .padding(horizontal = 20.dp, vertical = 17.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        Text(
            text = "About the Client",
            style = MaterialTheme.typography.headlineMedium,
            color = CharcoalGray
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(40.dp)
        ) {
            PaymentVerifiedBadge()
            Row {
                StarRating(rating = 4)
                Text(
                    modifier = Modifier.padding(start = 5.dp),
                    text = "4.0 of 12 Review",
                    style = MaterialTheme.typography.bodySmall,
                    color = CharcoalGray
                )
            }
        }
        Column(verticalArrangement = Arrangement.spacedBy(11.dp)) {
            LabeledValuePairRow(mainText = "United States", secondaryText = "Tampa 02:32 PM")
            LabeledValuePairRow(mainText = "25 Jobs Posted", secondaryText = "80% Hire Rate, 1 Job Open")
            LabeledValuePairRow(mainText = "\$ 200M+ Total Spent", secondaryText = "372 Hires, 55 Active")
            LabeledValuePairRow(mainText = "\$ 37.25 Avg Hourly Rate Paid", secondaryText = "110,152 Hours")
        }
    }
}

@Composable
fun RecentHistoryButton(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .height(55.dp)
            .fillMaxWidth()
            .background(
                shape = RoundedCornerShape(15.dp),
                color = Color.White
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .padding(start = 15.dp, end = 4.dp)
                .background(
                    color = SnowWhite,
                    shape = RoundedCornerShape(5.dp)
                )
                .height(25.dp)
                .width(25.dp),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .background(
                        color = PrimaryGreen,
                        shape = RoundedCornerShape(3.dp)
                    )
                    .height(15.dp)
                    .width(15.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_history),
                    contentDescription = "History icon"
                )
            }
        }
        Text(
            text = "Client's Recent History",
            style = MaterialTheme.typography.bodyLarge,
            color = CharcoalGray
        )
        Spacer(Modifier.weight(1f))
        Icon(
            modifier = Modifier.padding(end = 20.dp),
            painter = painterResource(R.drawable.ic_drop_arrow),
            tint = Color.Unspecified,
            contentDescription = null
        )
    }
}

@Composable
fun InappropriateFlagButton(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .height(35.dp)
            .fillMaxWidth()
            .background(
                shape = RoundedCornerShape(10.dp),
                color = Color.White
            )
            .border(
                width = 2.dp,
                color = BrightGray,
                shape = RoundedCornerShape(10.dp)
            ),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.padding(end = 5.dp),
            painter = painterResource(R.drawable.ic_red_flag),
            tint = Color.Unspecified,
            contentDescription = null
        )
        Text(
            text = "Flag is Inappropriate",
            style = MaterialTheme.typography.titleMedium,
            color = CoralRed
        )
    }
}

@Preview
@Composable
fun JobDescriptionPreview() {
    UpworkRedesignComposeTheme {
        JobDescription()
    }
}

@Preview
@Composable
fun SkillsDescriptionPreview() {
    UpworkRedesignComposeTheme {
        SkillsDescription()
    }
}

@Preview
@Composable
fun JobActivityPreview() {
    UpworkRedesignComposeTheme {
        JobActivity()
    }
}

@Preview
@Composable
fun AboutTheClientPreview() {
    UpworkRedesignComposeTheme {
        AboutTheClient()
    }
}

@Preview
@Composable
fun RecentHistoryButtonPreview() {
    UpworkRedesignComposeTheme {
        RecentHistoryButton()
    }
}

@Preview
@Composable
fun InappropriateFlagButtonPreview() {
    UpworkRedesignComposeTheme {
        InappropriateFlagButton()
    }
}