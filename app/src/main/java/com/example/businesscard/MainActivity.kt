package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme
import com.example.businesscard.ui.theme.black


class MainActivity : ComponentActivity() {
    private val details= CardDetails(
        getString(R.string.ajay_kumar_teli),
        getString(R.string.android_developer_expert),
        getString(R.string.ajaykumarteli472_gmail_com),
        R.drawable.android_logo,
        getString(R.string.ajaygup),
        getString(R.string.mobile_no)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Card(details)
            }
        }
    }
}

@Composable
fun Card(cardDetails: CardDetails) {
    Column(
        modifier = Modifier
            .background(Color.Gray)
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .background(black)

        ) {
            Image(
                painter = painterResource(cardDetails.profileDp),
                contentDescription = "",
                modifier = Modifier
                    .height(100.dp)
                    .width(95.dp)
                    .padding(5.dp)
            )
        }
        Text(
            text = cardDetails.name,
            modifier = Modifier.padding(8.dp),
            fontSize = 25.sp,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Light
        )

        Text(
            text = cardDetails.role,
            color = Color.Green,
            fontSize = 17.sp
        )
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(bottom = 40.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.padding(top = 10.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Phone,
                contentDescription = "Email",
                tint = Color.Cyan,
                modifier = Modifier.padding(end = 8.dp)
            )

            Text(
                text = cardDetails.mobileNumber,
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .padding(start = 5.dp),
                textAlign = TextAlign.Start
            )
        }

        Row(
            modifier = Modifier.padding(top = 10.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Share,
                contentDescription = "Email",
                tint = Color.Cyan,
                modifier = Modifier.padding(end = 8.dp)
            )

            Text(
                text = cardDetails.userName,
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .padding(start = 7.dp),
                textAlign = TextAlign.Start
            )
        }

        Row(
            modifier = Modifier.padding(top = 10.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Email,
                contentDescription = "Email",
                tint = Color.Cyan,
                modifier = Modifier
                    .padding(end = 8.dp)
            )

            Text(
                text = cardDetails.email,
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .padding(start = 5.dp),
                textAlign = TextAlign.Start
            )
        }


    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CardPreview() {
    BusinessCardTheme {
        Card(
            cardDetails = CardDetails(
                stringResource(R.string.ajay_kumar_teli),
                stringResource(R.string.android_developer_expert),
                stringResource(R.string.ajaykumarteli472_gmail_com),
                R.drawable.android_logo,
                stringResource(R.string.ajaygup),
                stringResource(R.string.mobile_no)
            )
        )
    }
}