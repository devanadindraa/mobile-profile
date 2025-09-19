package com.example.mobileprofile
import androidx.compose.ui.text.style.TextAlign
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobileprofile.ui.theme.MobileProfileTheme
import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MobileProfileTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFFE0F7FA))
                ) { innerPadding ->
                    ProfileScreen(
                        name = "Deva Nadindra",
                        email = "devanadindra@gmail.com",
                        bio = "Hi Everyone \uD83D\uDC4B\uD83C\uDFFB\nam a passionate and aspiring Junior Full Stack Developer who is still in the early stages of my journey. I am actively learning to build and maintain both frontend and backend systems, and continuously exploring new technologies to improve my skills and grow as a developer.",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ProfileScreen(
    name: String,
    email: String,
    bio: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Avatar
        Image(
            painter = painterResource(id = R.drawable.profile), // nama file tanpa ekstensi
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Nama
        Text(
            text = name,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        // Email
        Text(
            text = email,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Bio
        Text(
            text = bio,
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(horizontal = 20.dp),
            lineHeight = 20.sp,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    MobileProfileTheme {
        ProfileScreen(
            name = "Deva Nadindra",
            email = "devanadindra.p@gmail.com",
            bio = "Hi Everyone \uD83D\uDC4B\uD83C\uDFFB,"
        )
    }
}
