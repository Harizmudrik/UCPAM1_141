package com.example.exe1pam_141


import android.text.style.BackgroundColorSpan
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderSection()
        Pemesanan()

    }
}

@Composable
fun HeaderSection() {
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column (modifier = Modifier.padding(14.dp)) {
            Text(text = "Good Afternoon,")
            Text(text = "Muhammad Hariz Mudrik",style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold))
        }
        Icon(
            Icons.Filled.Notifications,
            contentDescription = null,
            modifier = Modifier
                .size(90.dp)
                .padding(25.dp)
                .offset(x = (300).dp, y = (-10).dp),
            tint = Color.Black
        )

    }
}



@Composable
fun Pemesanan() {

    Column (modifier = Modifier.padding(14.dp)) {
        Text(text = "Pemesanan",style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold))
    }

    var asal by remember { mutableStateOf("") }
    var tujuan by remember { mutableStateOf("") }
    var tglsampai by remember { mutableStateOf("") }
    var tgltiba by remember { mutableStateOf("") }
    var tipe by remember { mutableStateOf("") }

    val datatipe = listOf("Ekonomi", "Bussiness")

    var confasal by remember { mutableStateOf("") }
    var conftujuan by remember { mutableStateOf("") }
    var conftglsampai by remember { mutableStateOf("") }
    var conftgltiba by remember { mutableStateOf("") }
    var conftipe by remember { mutableStateOf("") }


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
    ) {

        Row(modifier = Modifier.fillMaxWidth().padding(16.dp).background(Color.White)) {


            Column(modifier = Modifier.padding(14.dp)) {
                TextField(
                    value = asal,
                    onValueChange = { asal = it },
                    label = { Text(text = "Nama Kota asal") },
                    placeholder = { Text(text = "Isi asal Anda") },
                    modifier = Modifier.fillMaxWidth().padding(5.dp)
                )

                TextField(
                    value = tujuan,
                    onValueChange = { tujuan = it },
                    label = { Text(text = "Nama Kota Tujuan") },
                    placeholder = { Text(text = "Isi asal Anda") },
                    modifier = Modifier.fillMaxWidth().padding(5.dp)
                )

                TextField(
                    value = tglsampai,
                    onValueChange = { tglsampai = it },
                    label = { Text(text = "Tanggal berangkat") },
                    placeholder = { Text(text = "Isi asal Anda") },
                    modifier = Modifier.fillMaxWidth().padding(5.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )

                TextField(
                    value = tgltiba,
                    onValueChange = { tgltiba = it },
                    label = { Text(text = "Tanggal Tiba") },
                    placeholder = { Text(text = "Isi asal Anda") },
                    modifier = Modifier.fillMaxWidth().padding(5.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )

                Row(modifier = Modifier.fillMaxWidth()) {
                    datatipe.forEach { selectedType ->
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(
                                selected = tipe == selectedType,
                                onClick = { tipe = selectedType }
                            )
                            Text(text = selectedType)
                        }
                    }
                }

                Button(onClick = {
                    confasal = asal
                    conftujuan = tujuan
                    conftglsampai = tglsampai
                    conftgltiba = tgltiba
                    conftipe = tipe
                }, modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White),) {
                    Text(text = "Submit")
                }

                DisplayData(param = "asal", arg = confasal)
                DisplayData(param = "tujuan", arg = conftujuan)
                DisplayData(param = "berangkat", arg = conftglsampai)
                DisplayData(param = "tiba", arg = conftgltiba)
                DisplayData(param = "tipe", arg = conftipe)


            }
        }
    }
}

@Composable
fun DisplayData(param: String, arg: String) {
    Column(modifier = Modifier.padding(16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = param, modifier = Modifier.weight(0.8f))
            Text(text = ":", modifier = Modifier.weight(0.1f))
            Text(text = arg, modifier = Modifier.weight(2f))
        }
    }
}