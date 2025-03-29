package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Column (
                    Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){

                    Row (
                        Modifier
                            .fillMaxSize()
                            .weight(1f),
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center
                    ){
                        TitlePicture(modifier = Modifier)
                    }
                    Row (
                        Modifier.weight(1f)
                    ){

                        Column (
                            modifier = Modifier.padding(top = 10.dp, bottom = 10.dp).fillMaxSize(),
                            verticalArrangement = Arrangement.SpaceBetween,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Row {
                                TextContentCard(
                                    "Kaio Bruno",
                                    "Software engineer",
                                    modifier = Modifier
                                )
                            }

                            Column (
                                modifier = Modifier.padding(bottom = 24.dp)
                            ) {
                                InformationSection("+55 (74) 98862 - 7737", Icons.Default.Call, modifier = Modifier)
                                InformationSection("@kaiobrunobm", Icons.Default.AccountCircle, modifier = Modifier)
                                InformationSection("bmkaiobruno@gmail.com",Icons.Outlined.MailOutline , modifier = Modifier)
                            }

                        }
                    }

                }
            }
        }
    }
}

@Composable
fun TitlePicture (modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.profile)
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(260.dp)

            )
    }


@Composable
fun TextContentCard (name: String, title: String, modifier: Modifier = Modifier) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            fontSize = 36.sp
        )

        Text(
            text = title,
            fontSize = 14.sp,
            color = Color(0xFF404040)
        )
    }
}

@Composable
fun InformationSection (text: String, iconSelected: ImageVector, modifier: Modifier = Modifier) {
    Row (
        modifier.padding(bottom = 6.dp, top = 6.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    )
    {
        Icon(iconSelected, contentDescription = null, modifier.size(30.dp))
        Text(
            text = text,
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
    }
}