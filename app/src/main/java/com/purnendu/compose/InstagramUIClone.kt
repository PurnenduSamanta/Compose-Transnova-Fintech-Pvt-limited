package com.purnendu.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.purnendu.compose.R
import kotlin.collections.List

class InstagramUIClone : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp)
            ) {

                val systemUiController = rememberSystemUiController()
                systemUiController.setSystemBarsColor(
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(30.dp))
                TopBar(name = "Purnendu_Samanta")
                Spacer(modifier = Modifier.height(4.dp))
                ProfileSection()
                ProfileDescription(
                    displayName = "Android App Developer",
                    description = "2 years of coding experience💻\n" +
                            "Want me to make your App?Send me email!📧\n" +
                            "For Android content follow me on LinkedIn",
                    url = "https://www.linkedin.com/in/purnendu9614/",
                    followedBy = listOf("Swarnedu", "Swapna"),
                    otherCount = 20
                )
                Spacer(modifier = Modifier.height(25.dp))
                ButtonSection(modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(25.dp))
                HighlightSection(
                    highlights = listOf(
                        StoryHighlight(painterResource(id = R.drawable.youtube), "YouTube"),
                        StoryHighlight(painterResource(id = R.drawable.qa), "Q&A"),
                        StoryHighlight(painterResource(id = R.drawable.discord), "Discord"),
                        StoryHighlight(painterResource(id = R.drawable.telegram), "Telegram")

                    )
                )
                Spacer(modifier = Modifier.height(25.dp))
                PostTabView(
                    modifier = Modifier.fillMaxWidth(),
                    iconLists = listOf(
                        R.drawable.ic_grid,
                        R.drawable.ic_vidiocam,
                        R.drawable.ic_igtv,
                        R.drawable.ic_reels,
                    )
                )
                {

                }
                PostSection(
                    modifier = Modifier.fillMaxWidth(),
                    posts = listOf(
                        painterResource(id = R.drawable.pic),
                        painterResource(id = R.drawable.pic),
                        painterResource(id = R.drawable.pic),
                        painterResource(id = R.drawable.pic),
                        painterResource(id = R.drawable.pic),
                        painterResource(id = R.drawable.pic),
                        painterResource(id = R.drawable.pic),
                        painterResource(id = R.drawable.pic),
                        painterResource(id = R.drawable.pic)
                    )
                )
            }

        }

    }

    @Composable
    fun TopBar(
        name: String,
        modifier: Modifier = Modifier
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack, contentDescription = "back button",
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )

            Text(
                text = name,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            Icon(
                painter = painterResource(id = R.drawable.ic_bell),
                contentDescription = "Notification",
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )

            Icon(
                painter = painterResource(id = R.drawable.ic_menu), contentDescription = "Menu",
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )


        }

    }

    @Composable
    fun ProfileSection(
        modifier: Modifier = Modifier
    ) {
        Column(modifier = modifier.fillMaxWidth()) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()

            ) {
                RoundImage(
                    painter = painterResource(id = R.drawable.my_pic),
                    modifier = Modifier
                        .size(100.dp)
                    //.weight(3f)
                )

                StatSection()

            }

        }

    }

    @Composable
    fun RoundImage(
        painter: Painter,
        modifier: Modifier = Modifier
    ) {
        Image(
            painter = painter, contentDescription = "Image",
            modifier = modifier
                .aspectRatio(1f, matchHeightConstraintsFirst = true)
                .border(
                    width = 1.dp,
                    color = Color.LightGray,
                    shape = CircleShape
                )
                .padding(5.dp)
                .clip(CircleShape)
        )

    }

    @Composable
    fun StatSection(
        modifier: Modifier = Modifier,
    ) {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ProfileStat(numberText = "601", text = "Posts")
            Spacer(modifier = Modifier.width(25.dp))
            ProfileStat(numberText = "99.8K", text = "Followers")
            Spacer(modifier = Modifier.width(25.dp))
            ProfileStat(numberText = "72", text = "Following")


        }

    }

    @Composable
    fun ProfileStat(
        numberText: String,
        text: String,
        modifier: Modifier = Modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
        ) {
            Text(
                text = numberText,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = text,
                fontSize = 15.sp,
            )

        }

    }

    @Composable
    fun ProfileDescription(
        displayName: String,
        description: String,
        url: String,
        followedBy: List<String>,
        otherCount: Int
    ) {
        val letterSpacing = 0.5.sp
        val lineHeight = 20.sp

        Column(modifier = Modifier.fillMaxWidth()) {

            Text(
                text = displayName,
                fontWeight = FontWeight.Bold,
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )

            Text(
                text = description,
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
            Text(
                text = url,
                letterSpacing = letterSpacing,
                lineHeight = lineHeight,
                color = Color(0xFF3D3D91)
            )
            Text(
                text = buildAnnotatedString {

                    val spanStyle = SpanStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    append("Followed by ")
                    followedBy.forEachIndexed { index, name ->
                        pushStyle(spanStyle)
                        append(name)
                        pop()
                        if (index < followedBy.size - 1) {
                            append(",")
                        }
                    }
                    append(" and ")
                    pushStyle(spanStyle)
                    append("$otherCount others")

                },
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )

        }

    }

    @Composable
    fun ButtonSection(modifier: Modifier = Modifier) {

        val minWidth = 95.dp
        val height = 35.dp

        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            ActionButton(
                modifier = Modifier
                    .defaultMinSize(minWidth = minWidth)
                    .height(height), text = "Following", icon = Icons.Default.KeyboardArrowDown
            )
            ActionButton(
                Modifier
                    .defaultMinSize(minWidth = minWidth)
                    .height(height), text = "Message"
            )
            ActionButton(
                Modifier
                    .defaultMinSize(minWidth = minWidth)
                    .height(height), text = "Email"
            )
            ActionButton(
                Modifier
                    .height(height), icon = Icons.Default.ArrowDropDown
            )
        }
    }

    @Composable
    fun ActionButton(
        modifier: Modifier = Modifier,
        text: String? = null,
        icon: ImageVector? = null
    ) {

        Row(
            modifier = modifier
                .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(5.dp))
                .padding(6.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (text != null) {
                Text(
                    text = text,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp
                )

            }
            if (icon != null) {
                Icon(imageVector = icon, contentDescription = "Icon", tint = Color.Black)

            }

        }

    }

    @Composable
    fun HighlightSection(
        modifier: Modifier = Modifier,
        highlights: List<StoryHighlight>
    ) {
        LazyRow(modifier = modifier)
        {
            items(highlights.size)
            {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(end = 10.dp)
                ) {
                    RoundImage(
                        painter = highlights[it].icon,
                        modifier = Modifier.size(70.dp)
                    )
                    Text(
                        text = highlights[it].text,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Center
                    )

                }
            }
        }

    }

    @Composable
    fun PostTabView(
        modifier: Modifier = Modifier,
        iconLists: List<Int>,
        onTabSelected: (selectedIndex: Int) -> Unit
    ) {

        var selectedTabIndex by remember {
            mutableStateOf(0)
        }
        val inactiveColor = Color(0xFF777777)

        TabRow(
            selectedTabIndex = selectedTabIndex,
            backgroundColor = Color.Transparent,
            contentColor = Color.Black,
            modifier = modifier
        ) {

            for (i in 0..3) {
                CustomTabRow(
                    index = i,
                    iconId = iconLists[i],
                    selectedTabIndex = i,
                    inactiveColor = inactiveColor,
                )
                {
                    selectedTabIndex = it
                    onTabSelected(it)
                }
            }
        }
    }

    @Composable
    fun CustomTabRow(
        index: Int, iconId: Int,
        selectedTabIndex: Int,
        inactiveColor: Color, onTabSelected: (index: Int) -> Unit
    ) {
        Tab(selected = selectedTabIndex == index,
            selectedContentColor = Color.Black,
            unselectedContentColor = inactiveColor,
            onClick = {
                onTabSelected(index)
            }) {
            Icon(
                painter = painterResource(id = iconId),
                tint = if (selectedTabIndex == index) Color.Black else inactiveColor,
                contentDescription = "Posts",
                modifier = Modifier
                    .padding(10.dp)
                    .size(20.dp)
            )
        }

    }


    @Composable
    fun PostSection(
        posts: List<Painter>,
        modifier: Modifier = Modifier
    ) {
        LazyVerticalGrid(
            modifier = modifier.scale(1.01f),
            columns = GridCells.Fixed(3)
        )
        {
            items(posts.size)
            {
                Image(
                    painter = posts[it], contentDescription = "Post",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .border(
                            color = Color.White,
                            width = 1.dp
                        )
                )
            }
        }

    }
}


data class StoryHighlight(val icon: Painter, val text: String)
