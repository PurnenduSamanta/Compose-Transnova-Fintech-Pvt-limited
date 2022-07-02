package com.purnendu.compose.loginUi


import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.purnendu.compose.R


@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    isTrailingIconAvailable: Boolean = false,
    label: String

) {

    var text by remember { mutableStateOf("") }
    TextField(
        modifier = modifier
            .fillMaxWidth(),
        value = text,
        textStyle = TextStyle(color = Color.White, textDecoration = TextDecoration.None),
        singleLine = true,
        onValueChange = { text = it },
        placeholder = { Text(text = label, color = Color.Gray) },
        trailingIcon = {
            if (isTrailingIconAvailable) {
                Icon(
                    painter = painterResource(id = R.drawable.visibility),
                    tint = Color.White,
                    contentDescription = "",
                    modifier = Modifier.size(25.dp)
                )
            }
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Gray,
            unfocusedBorderColor = Color.Gray
        )
    )


}

@Preview
@Composable
fun Test2() {
    CustomTextField(label = "hello")
}