package com.example.ucppam

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview (showBackground = true)
@Composable
fun inputnya(modifier: Modifier = Modifier){
    var name by remember { mutableStateOf("") }
    var NoHp by remember { mutableStateOf("") }
    var memilih by remember { mutableStateOf("") }

    var namasv by remember { mutableStateOf("") }
    var NoHpsv by remember { mutableStateOf("") }
    var memilihsv by remember { mutableStateOf("") }

    val Jeniskel = listOf("Laki-Laki", "Perempuan")
    Column (modifier = Modifier
        .fillMaxSize()
        .padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        header()
        TextField(
            modifier = Modifier.fillMaxWidth() .padding(5.dp),
            value = name,
            onValueChange = { name = it },
            label = {Text("nama")},
            placeholder = {Text("Masukkan Nama")}
        )
        TextField(
            modifier = Modifier.fillMaxWidth() .padding(5.dp),
            value = NoHp,
            onValueChange = { NoHp = it },
            label = {Text("Nomor Hp")},
            placeholder = {Text("Masukkan No Handphone")}
        )
        Row{
            Jeniskel.forEach { item ->
                Row (verticalAlignment = Alignment.CenterVertically){ RadioButton(
                    selected = memilih == item,
                    onClick = { memilih = item }
                )
                    Text(item)
                }
            }
        }
        Button (onClick = {
            namasv = name
            NoHpsv = NoHp
            memilihsv = memilih
        }) {
            Text(text = "Simpan"
                )
        }
        ElevatedCard(
            colors = CardDefaults.cardColors(containerColor = Color.LightGray),
            modifier = Modifier
                .fillMaxWidth()
        ){
            Text("nomor Hp")
            DetailSurat(judul = "nomor Hp", isi = NoHpsv)
            Text("jenis kelamin")
            DetailSurat(judul = "jenis kelamin", isi = memilihsv)
        }
    }
}
@Composable
fun header(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(color = Color.Cyan)
        .padding(15.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "Hallo,",
                    color = Color.White,
                    fontSize = 50.sp
                )
            }
            Box(
                contentAlignment = Alignment.BottomStart
            ) {
                Image(
                    painter = painterResource(id = R.drawable.lemon),
                    contentDescription = " ",
                    modifier = Modifier.size(100.dp)
                        .clip(CircleShape)
                )
            }
        }
    }
}
@Composable
fun DetailSurat(
    judul: String, isi: String
){
    Column (modifier = Modifier
        .fillMaxWidth()
        .padding(15.dp),
    ){


        Row (
            modifier = Modifier.fillMaxWidth()
        ){
            Text(text = judul,
                modifier = Modifier.weight(0.8f))
            Text(text = ":",
                modifier = Modifier.weight(0.1f))
            Text(text = isi,
                modifier = Modifier.weight(2f))
        }
    }
}


