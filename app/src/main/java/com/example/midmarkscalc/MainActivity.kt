package com.example.midmarkscalc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.midmarkscalc.ui.theme.MIDMARKSCALCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MIDMARKSCALCTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    midMarks()
                }
            }
        }
    }
}

@Composable
fun midMarks()
{
    var mid1 by remember { mutableStateOf( "" ) }
    var mid2 by remember { mutableStateOf( "" ) }
    var ans by remember { mutableStateOf( "click to get marks" ) }
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Welcome to Mid Marks Calc", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "best 80 and rest 20")
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = mid1, onValueChange = {mid1=it} )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = mid2, onValueChange = {mid2=it} )
        Button(onClick = { ans= calc(mid1,mid2) })
        {
            Text(text = "click here")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = ans )
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "GDSC SVEC")
        


    }
}


@Preview(showSystemUi = true)
@Composable
fun midMarksPreview()
{
    midMarks()
}

fun calc(a:String,b:String):String
{
    var a1=a.toInt()
    var b1=b.toInt()
    if (b1>a1)
    {
        var temp=a1
        a1=b1
        b1=temp
    }
    var ans=a1*0.8+b1*0.2
    var ansStr=ans.toString()
    if (ansStr.length>5)
    {
        ansStr = ansStr.substring(0,5)
    }
    return ansStr
}