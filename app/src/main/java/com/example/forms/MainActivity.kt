package com.example.forms

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import com.example.forms.ui.theme.FormsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FormsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    appPreview()
                }
            }
        }
    }
}

@Composable
fun app() {
    var value1 by remember { mutableStateOf("") }
    var value2 by remember { mutableStateOf("") }
    var value3 by remember { mutableStateOf("") }
    var value4 by remember { mutableStateOf("") }

    Column(
        Modifier
            .verticalScroll(rememberScrollState())
            .background(Color.White)
            .fillMaxWidth()
    ) {
        Row(
            Modifier
                .padding(20.dp, 0.dp, 0.dp, 0.dp)
                .fillMaxWidth()
                .background(Color.White),
            Arrangement.Start
        ) {
            Text(
                text = "\nFormulário",
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )

        }
        Row(
            Modifier
                .padding(8.dp)
        ) {
        }
        Row(
            Modifier
                .padding(20.dp, 0.dp, 0.dp, 0.dp)
                .fillMaxWidth(),
        ) {
            Text(
                text = "Nome: ",
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

        }
        TextField(
            value = value1,
            onValueChange = { value1 = it },
            label = { Text("Digite seu nome completo") },
            maxLines = 2,
            modifier = Modifier.padding(20.dp)
        )
        Row(
            Modifier
                .padding(20.dp, 0.dp, 0.dp, 0.dp)
                .fillMaxWidth(),
        ) {
            Text(
                text = "Endereço: ",
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

        }
        TextField(
            value = value2,
            onValueChange = { value2 = it },
            label = { Text("Digite...") },
            maxLines = 2,
            modifier = Modifier.padding(20.dp)
        )
        Row(
            Modifier
                .padding(20.dp, 0.dp, 0.dp, 0.dp)
                .fillMaxWidth(),
        ) {
            Text(
                text = "Telefone: ",
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

        }
        TextField(
            value = value3,
            onValueChange = { value3 = it },
            label = { Text("(XX) XXXXX - XXXX)") },
            maxLines = 2,
            modifier = Modifier.padding(20.dp)
        )


        Row(
            Modifier
                .padding(20.dp, 0.dp, 0.dp, 0.dp)
                .fillMaxWidth(),
        ) {
            Text(
                text = "Senha: ",
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

        }
        var password by rememberSaveable { mutableStateOf("") }
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Digite a senha...") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.padding(20.dp))

        var checked by remember { mutableStateOf(true) }

        Row(
            Modifier
                .padding(20.dp, 0.dp, 0.dp, 0.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,

            ) {
            Text(
                "Lembrar a senha?"
            )
            Checkbox(
                checked = checked,
                onCheckedChange = { checked = it }
            )
        }

        Row(
            Modifier
                .padding(20.dp, 0.dp, 0.dp, 0.dp)
                .fillMaxWidth(),
        ) {
            Text(
                text = "Comentário: ",
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

        }
        TextField(
            value = value4,
            onValueChange = { value4 = it },
            label = { Text("Digite aqui...") },
            maxLines = 4,
            modifier = Modifier.padding(20.dp)
        )

        Row() {
            var itemList = listOf<String>("Feedback", "Solicitação", "Denúncia")
            var selectedIndex by rememberSaveable { mutableStateOf(0) }
            var buttonModifier = Modifier.width(150.dp)

            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = "Motivo:  ",
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                DropdownList(
                    itemList = itemList,
                    selectedIndex = selectedIndex,
                    modifier = buttonModifier,
                    onItemClick = { selectedIndex = it })

            }
        }

        Row(
            Modifier
            .padding(20.dp, 0.dp, 0.dp, 20.dp)
        ){}
        Row() {
            var itemList = listOf<String>("Administração", "Logistica", "Recursos")
            var selectedIndex by rememberSaveable { mutableStateOf(0) }
            var buttonModifier = Modifier.width(150.dp)

            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = "Destino: ",
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                DropdownList(
                    itemList = itemList,
                    selectedIndex = selectedIndex,
                    modifier = buttonModifier,
                    onItemClick = { selectedIndex = it })

            }
        }
    Row(
        Modifier
            .padding(20.dp, 20.dp, 10.dp, 0.dp)
            .fillMaxWidth(),
    ) {
        Button(
            onClick = { /* TODO */ }
        ) {
            Text(text = "Cadastrar")
        }

    }
}
    }


@Composable
fun DropdownList(
    itemList: List<String>,
    selectedIndex: Int,
    modifier: Modifier,
    onItemClick: (Int) -> Unit){
    var showDropdown by rememberSaveable { mutableStateOf(false)}
    val scrollState = rememberScrollState()

    Box(
        modifier = modifier
            .padding(20.dp, 10.dp, 0.dp, 0.dp)
            .background(Color.LightGray)
            .clickable { showDropdown = true },
        contentAlignment = Alignment.Center

    ){
        Text(text = itemList[selectedIndex])
    }
    Box(){
        if(showDropdown){
            Popup(
                alignment = Alignment.TopCenter,
                properties = PopupProperties(
                    excludeFromSystemGesture = true
                ),
                onDismissRequest = { showDropdown = false}
            ){
                Column(
                    modifier = modifier
                        .padding(20.dp, 0.dp, 0.dp, 0.dp)
                        .heightIn(max = 100.dp)
                        .verticalScroll(state = scrollState)
                        .border(width = 1.dp, color = Color.Gray),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ){
                    itemList.onEachIndexed { index, item ->
                        if (index != 0){
                            Divider(thickness = 1.dp, color = Color.LightGray)
                        }
                        Box(
                            modifier = modifier
                                .background(Color.LightGray)
                                .fillMaxWidth()
                                .clickable {
                                    onItemClick(index)
                                    showDropdown = !showDropdown
                                },
                            contentAlignment = Alignment.Center
                        ){
                            Text(text = item)
                        }
                    }
                }
            }
        }
    }





}

@Preview
@Composable
fun appPreview(){
    FormsTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            app()
        }
    }
}