package br.com.fiap.mentormatch.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.mentormatch.R
import br.com.fiap.mentormatch.database.repository.UserRepository
import kotlinx.coroutines.launch

@Composable
fun HeaderComponent(
    drawerAction: () -> Unit
) {
    val poppyns = FontFamily(
        Font(R.font.poppins_regular)
    )

    Box(contentAlignment = Alignment.CenterStart) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                IconButton(
                    onClick = {
                        drawerAction()
                    },
                    modifier = Modifier
                        .offset(y = (-3).dp, x = (-15).dp)
                        .width(95.dp)
                        .height(50.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Menu Icon",
                        tint = colorResource(id = R.color.green_light),
                        modifier = Modifier
                            .width(100.dp)
                            .height(55.dp)
                    )
                }
                Spacer(modifier = Modifier.width(25.dp))

                Text(
                    text = "MentorMatch",
                    color = colorResource(id = R.color.logo),
                    fontFamily = poppyns,
                    fontSize = 18.sp
                )
            }
        }
    }

}