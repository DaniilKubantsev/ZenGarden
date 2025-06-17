package com.example.zengarden.auth.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zengarden.R
import com.example.zengarden.auth.presentation.AuthEvent
import com.example.zengarden.auth.presentation.AuthState
import com.example.zengarden.ui.theme.ZenGardenTheme
import com.example.zengarden.ui.theme.onPrimary

@Composable
fun SignUpScreen(
    paddingValues: PaddingValues,
    state: AuthState.SignUpState,
    onEvent: (AuthEvent) -> Unit,
    modifier: Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(paddingValues)
            .then(modifier)
    ) {
        OutlinedTextField(
            value = state.username,
            onValueChange = { onEvent(AuthEvent.OnSignUpUsernameChanged(it)) },
            placeholder = {
                Text(
                    text = "Username",
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.ExtraBold
                )
            },
            textStyle = TextStyle(
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.ExtraBold
            ),
            modifier = Modifier.fillMaxWidth(0.7f)
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = state.password,
            onValueChange = { onEvent(AuthEvent.OnSignUpPasswordChanged(it)) },
            placeholder = {
                Text(
                    text = "Password",
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.ExtraBold
                )
            },
            textStyle = TextStyle(
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.ExtraBold
            ),
            modifier = Modifier.fillMaxWidth(0.7f)
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = state.confirmPassword,
            onValueChange = { onEvent(AuthEvent.OnSignUpConfirmPasswordChanged(it)) },
            placeholder = {
                Text(
                    text = "Confirm password",
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.ExtraBold
                )
            },
            textStyle = TextStyle(
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.ExtraBold
            ),
            modifier = Modifier.fillMaxWidth(0.7f)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = { onEvent(AuthEvent.SubmitSignUp) },
            modifier = Modifier.fillMaxWidth(0.7f),
            colors = ButtonDefaults.buttonColors(
                containerColor = ZenGardenTheme.colors.accent,
                contentColor = ZenGardenTheme.colors.onAccent
            )
        ) {
            Text(
                text = "Submit",
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.ExtraBold
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    ZenGardenTheme {
        SignUpScreen(
            paddingValues = PaddingValues(5.dp),
            state = AuthState.SignUpState(),
            onEvent = {},
            modifier = Modifier
                .fillMaxSize()
                .background(ZenGardenTheme.colors.background)
        )
    }
}