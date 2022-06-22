package com.purnendu.compose.customUiComponent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

class TestingComponent : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {


            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                CustomCircularSlider()
            }

//            Column(
//                modifier = Modifier.fillMaxSize(),
//                horizontalAlignment = Alignment.CenterHorizontally
//            )
//            {
//                var value by remember {
//                    mutableStateOf(0)
//                }
//                CustomComponent(indicatorValue = value)
//
//                TextField(
//                    value = value.toString(), onValueChange = {
//                        value = if (it.isNotEmpty() && it.matches(Regex("[0-9]+"))) it.toInt()
//                        else 0
//                    },
//                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
//                )
//
//            }

//            Surface(
//                color = Color(0xFF101010),
//                modifier = Modifier.fillMaxSize()
//            ) {
//                Box(
//                    contentAlignment = Alignment.Center
//                ) {
//                    Timer(
//                        totalTime = 100L * 1000L,
//                        handleColor = Color.Green,
//                        inactiveBarColor = Color.DarkGray,
//                        activeBarColor = Color(0xFF37B900),
//                        modifier = Modifier.size(200.dp)
//                    )
//                }
//            }


        }
    }
}