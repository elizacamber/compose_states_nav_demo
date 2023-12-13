package com.elizacamber.composestatesdemo.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.elizacamber.composestatesdemo.ui.theme.ComposeStatesDemoTheme

//3

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MsgInputBar() {
    Row(modifier = Modifier.padding(4.dp)) {
        var msg  = "" //0
        OutlinedTextField(value = msg, onValueChange = { msg = it }, modifier = Modifier.weight(1F))

        //1
        //2
        IconButton(onClick = { }) {
            Icon(Icons.Default.Send, contentDescription = "send")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MsgInputPreview() {
    ComposeStatesDemoTheme {
        MsgInputBar()
    }
}