package com.cesar.accessibilitytest

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MenuScreen(
    paddings: PaddingValues
) {
    Box(
        modifier = Modifier
            .padding(paddings)
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.White)
        ){
            Text(
                "¿A qué hora jugará Chile contra Perú?",
                style = TextStyle(fontSize = 24.sp),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.semantics { heading() }
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                "El partido entre la selección de Chile en contra de su par de Perú se jugará este viernes 15 de noviembre a las 22.30 horas (horario de Chile) en el Estadio Monumental de Lima. Será el último partido de la undécima fecha de las eliminatorias."
                ,
                style = TextStyle(fontSize = 18.sp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                "Dónde ver el partido por televisión"
                ,
                style = TextStyle(fontSize = 24.sp),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.semantics { heading() }
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                "El duelo entre chilenos y peruanos se emitirá en la televisión abierta chilena a través del canal Chilevisión. También se transmitirá por la señal paga de ESPN, además de la emisión por streaming en la plataforma Disney+."
                ,
                style = TextStyle(fontSize = 18.sp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                "La formación de Gareca"
                ,
                style = TextStyle(fontSize = 24.sp),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.semantics { heading() }
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                "El retorno de Vidal —que a fines de la semana pasada ganó el título del campeonato nacional con Colo Colo— implicará un cambio en el esquema de Ricardo Gareca, que en los últimos partidos ha intentado buscar alternativas en jugadores jóvenes que no pertenecen a la llamada generación dorada del fútbol chileno. Bajo estas circunstancias, el equipo titular que se presentará en Lima estará conformado por el portero Brayan Cortés; los defensas Felipe Loyola, Guillermo Maripán, Paulo Díaz y Gabriel Suazo; los centrocampistas Rodrigo Echeverría, Vicente Pizarro, Arturo Vidal y Diego Valdés; y los delanteros Alexander Aravena y Eduardo Vargas."
                ,
                style = TextStyle(fontSize = 18.sp)
            )
        }
    }

}

@Preview(name="Apps",showSystemUi = true)
@Composable
fun MenuScreenPreview() {

}