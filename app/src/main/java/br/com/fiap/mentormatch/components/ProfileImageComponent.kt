package br.com.fiap.mentormatch.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.mentormatch.R.*
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun ProfileImageComponent (
    imageProfile: Int,
    description: String,
    sizeImage: Dp,
    borderWidth: Dp,
    imageBorderColor: Int,
    nameProfile: String = "",
    nameProfileFontSize: TextUnit = 0.sp,
    button: Boolean,
    nav: Any,
    userId: Long
) {
    val poppyns = FontFamily(
        Font(font.poppins_regular)
    )

    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            if(button) {
                Button(onClick = {
                    if (nav is NavController) {
                        nav.navigate("profileUsers/$userId")
                    }
                },
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = color.white))
                ) {
                    Box(
                        modifier = Modifier
                            .border(
                                BorderStroke(
                                    width = borderWidth,
                                    color = colorResource(id = imageBorderColor)
                                ),
                                shape = CircleShape
                            )
                    ){
                        Image(
                            painter = painterResource(id = imageProfile),
                            contentDescription = description,
                            modifier = Modifier
                                .size(sizeImage)
                                .clip(shape = CircleShape)
                        )
                    }
                }
            } else {
                Box(
                    modifier = Modifier
                        .border(
                            BorderStroke(
                                width = borderWidth,
                                color = colorResource(id = imageBorderColor)
                            ),
                            shape = CircleShape
                        )
                ){
                    Image(
                        painter = painterResource(id = imageProfile),
                        contentDescription = description,
                        modifier = Modifier
                            .size(sizeImage)
                            .clip(shape = CircleShape)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = nameProfile,
            color = colorResource(id = color.gray_title),
            fontFamily = poppyns,
            fontSize = nameProfileFontSize
        )

        Spacer(modifier = Modifier.height(20.dp))

    }
}