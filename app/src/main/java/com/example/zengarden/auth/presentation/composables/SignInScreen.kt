package com.example.zengarden.auth.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zengarden.R
import com.example.zengarden.auth.presentation.AuthEvent
import com.example.zengarden.auth.presentation.AuthState
import com.example.zengarden.ui.theme.ZenGardenTheme

@Composable
fun SignInScreen(
    paddingValues: PaddingValues,
    state: AuthState.SignInState,
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
        Column(
            modifier = Modifier
                .fillMaxWidth(0.8f)
        ) {

            Text(
                text = stringResource(R.string.sign_in) + " " + stringResource(R.string.potted_plant_emj),
                color = ZenGardenTheme.colors.onAccent,
                style = TextStyle(
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 28.sp
                ),
                modifier = Modifier
                    .padding(start = 10.dp)
            )

            Spacer(Modifier.height(20.dp))

            UsernameTextField(
                text = state.username,
                onValueChange = { onEvent(AuthEvent.OnSignInUsernameChanged(it)) },
                placeholder = "Username",
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(Modifier.height(10.dp))

            PasswordTextField(
                text = state.password,
                onValueChange = { onEvent(AuthEvent.OnSignInPasswordChanged(it)) },
                placeholder = "Password",
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(Modifier.height(25.dp))

            ActionButton(
                onClick = { onEvent(AuthEvent.SubmitSignUp) },
                text = stringResource(R.string.sign_in),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
            )

            Spacer(Modifier.height(10.dp))

            Text(
                text = stringResource(R.string.to_sign_up),
                color = ZenGardenTheme.colors.onAccent,
                style = TextStyle(
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 20.sp
                ),
                modifier = Modifier
                    .padding(start = 20.dp)
                    .clickable {
                        onEvent(AuthEvent.SwitchToSignUp)
                    }
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun SignInScreenPreview() {
    ZenGardenTheme {
        SignInScreen(
            paddingValues = PaddingValues(0.dp),
            state = AuthState.SignInState(),
            onEvent = {},
            modifier = Modifier
                .fillMaxSize()
                .background(ZenGardenTheme.colors.background)
        )
    }
}