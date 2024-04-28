package com.example.practice.ui.components

import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practice.R
import com.example.practice.ui.common.CNavigationDrawerItem
import com.exyte.animatednavbar.AnimatedNavigationBar
import com.exyte.animatednavbar.animation.balltrajectory.Straight
import com.exyte.animatednavbar.animation.indendshape.Height
import com.exyte.animatednavbar.animation.indendshape.shapeCornerRadius
import com.exyte.animatednavbar.utils.noRippleClickable

@Composable
fun BottomBarNavigation() {

    val itemIcon = listOf(
        IconList(
            selectedIcon = R.drawable.ic_home,
        ),
        IconList(
            selectedIcon = R.drawable.ic_heart,
        ),
        IconList(
            selectedIcon = R.drawable.ic_bag_3,
        ),
        IconList(
            selectedIcon = R.drawable.ic_notification,
            badges = 12,
        ),
    )
    val selected = remember { mutableStateOf(0) }

    AnimatedNavigationBar(
        selectedIndex = selected.value,
        modifier = Modifier.height(55.dp),
        cornerRadius = shapeCornerRadius(cornerRadius = 15.dp),
        indentAnimation = Height(tween(100)),
        ballAnimation = Straight(tween(300)),
        barColor = Color(0xffC67C4E),
        ballColor = Color(0xffC67C4E)
    ) {
        itemIcon.forEachIndexed { index, item ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .noRippleClickable { selected.value = index },
                contentAlignment = Alignment.Center
            ) {
                CNavigationDrawerItem(
                    selected = selected.value == index,
                    onClick = { selected.value = index },
                    icon = {
                        BadgedBox(
                            badge = {
                                if (item.badges != null) {
                                    Badge { Text(text = item.badges.toString()) }
                                }
                            }) {
                            if (selected.value == index) {
                                Icon(
                                    painter = painterResource(id = item.selectedIcon),
                                    contentDescription = null,
                                    tint = Color(0xffC67C4E)
                                )
                            }else {
                                Icon(
                                    painter = painterResource(id = item.selectedIcon),
                                    contentDescription = null,
                                )
                            }
                        }
                    }
                )
            }
        }
    }
}

data class IconList(
    val selectedIcon: Int,
    val badges: Int? = null,
)

@Preview
@Composable
fun BottomBarNavigationPreview() {
    BottomBarNavigation()
}