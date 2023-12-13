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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.elizacamber.composestatesdemo.ui.theme.ComposeStatesDemoTheme
import kotlinx.coroutines.flow.MutableStateFlow

class MsgInputBarScreenViewModel : ViewModel() {
    var msg = MutableStateFlow("")
        private set

    fun onMsgChange(message: String) { msg.value = message }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MsgInputBarScreen(viewModel: MsgInputBarScreenViewModel = viewModel()) {
    val msg = viewModel.msg.collectAsState()
    val enabled by remember { derivedStateOf { msg.value.isNotEmpty() } }
    MsgInputBar(msg.value, enabled) { viewModel.onMsgChange(it) }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MsgInputBar(msg: String, enabled: Boolean, onMsgChange: (String) -> Unit) {
    Row(modifier = Modifier.padding(4.dp)) {
        OutlinedTextField(value = msg, onValueChange = onMsgChange, modifier = Modifier.weight(1F))

        IconButton(onClick = { } , enabled = enabled ) {
            Icon(Icons.Default.Send, contentDescription = "send")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MsgInputPreview() {
    ComposeStatesDemoTheme {
        MsgInputBarScreen()
    }
}