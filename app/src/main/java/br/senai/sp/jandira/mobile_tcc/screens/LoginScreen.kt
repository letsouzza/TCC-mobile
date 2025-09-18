package br.senai.sp.jandira.mobile_tcc.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.mobile_tcc.R
import br.senai.sp.jandira.mobile_tcc.screens.components.LoginDropdown
import br.senai.sp.jandira.mobile_tcc.ui.theme.poppinsFamily

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {

    var emailState by remember {mutableStateOf("")}
    var senhaState by remember {mutableStateOf("")}
    var tipoLogin by remember { mutableStateOf("") }
    var senhaVisivel by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1B4227))
    ){
        Column(
            modifier= Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = painterResource(R.drawable.logoclara),
                contentDescription = "",
                modifier.padding(10.dp).size(305.dp)
            )
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(580.dp),
                colors = CardDefaults.cardColors(Color(0xFFFFF9EB)),
                shape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp)
            ){
                Column(
                    modifier.fillMaxSize().padding(20.dp)
                ){
                    Spacer(Modifier.padding(5.dp))
                    Text(
                        text= stringResource(R.string.login),
                        fontSize = 40.sp,
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFF1B4227),
                        modifier= Modifier
                            .padding(start = 20.dp)
                    )
                    Spacer(Modifier.padding(15.dp))
                    OutlinedTextField(
                        value = emailState,
                        onValueChange = { it ->
                            emailState = it
                        },
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedContainerColor = Color(0xFFFFE6B1),
                            focusedContainerColor = Color(0xFFFFE6B1),
                            unfocusedBorderColor = Color.Transparent,
                            focusedBorderColor = Color.Transparent,
                            focusedTextColor = Color.Black,
                            unfocusedTextColor = Color.Black
                        ),
                        shape = RoundedCornerShape(30.dp),
                        label = {
                            Text(
                                text = stringResource(
                                    R.string.email
                                ),
                                fontSize = 20.sp,
                                fontFamily = poppinsFamily,
                                color = Color(0x99000000)
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                    Spacer(Modifier.padding(10.dp))
                    OutlinedTextField(
                        value = senhaState,
                        onValueChange = { it ->
                            senhaState = it
                        },
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedContainerColor = Color(0xFFFFE6B1),
                            focusedContainerColor = Color(0xFFFFE6B1),
                            unfocusedBorderColor = Color.Transparent,
                            focusedBorderColor = Color.Transparent,
                            focusedTextColor = Color.Black,
                            unfocusedTextColor = Color.Black
                        ),
                        shape = RoundedCornerShape(30.dp),
                        trailingIcon = {
                            val icon = if (senhaVisivel) Icons.Default.Visibility else Icons.Default.VisibilityOff

                            IconButton(onClick = { senhaVisivel = !senhaVisivel }) {
                                Icon(
                                    imageVector = icon,
                                    contentDescription = "",
                                    tint = Color(0xFF1B4227)
                                )
                            }
                        },
                        visualTransformation =
                            if (senhaVisivel) VisualTransformation.None
                            else PasswordVisualTransformation(),
                        label = {
                            Text(
                                text = stringResource(
                                    R.string.senha
                                ),
                                fontSize = 20.sp,
                                fontFamily = poppinsFamily,
                                color = Color(0x99000000)
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                    Spacer(Modifier.padding(5.dp))
                    Text(
                        text = stringResource(R.string.esqueci_senha),
                        fontSize = 14.sp,
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1B4227),
                        modifier = Modifier
                            .align(Alignment.End)
                            .padding(end = 25.dp)
                    )
                    Column {
                        LoginDropdown()
                    }
                    Spacer(Modifier.padding(5.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ){
                        Text(
                            text = stringResource(R.string.nao_tem_login),
                            fontSize = 16.sp,
                            fontFamily = poppinsFamily,
                            fontWeight = FontWeight.Normal,
                            color = Color.Black,
                            modifier = Modifier
                                .padding(end = 5.dp)
                        )
                        Text(
                            text = stringResource(R.string.cadastre_se),
                            fontSize = 16.sp,
                            fontFamily = poppinsFamily,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF1B4227)
                        )
                    }
                    Button(
                        onClick = {},
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(top = 30.dp)
                            .width(180.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xFF1B4227)),
                    ) {
                        Text(
                            text = stringResource(R.string.entrar),
                            fontSize = 20.sp,
                            fontFamily = poppinsFamily,
                            color = Color.White

                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    LoginScreen()
}