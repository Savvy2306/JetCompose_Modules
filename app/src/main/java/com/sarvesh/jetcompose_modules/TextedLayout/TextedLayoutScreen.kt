package com.sarvesh.jetcompose_modules.TextedLayout

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp

@Composable
fun TextedLayoutScreen(){
    
    Text(text = "Hello",
        fontSize = 25.sp,
        fontWeight = FontWeight.Bold,
        //fontFamily = FontFamily.Cursive,
        fontStyle = FontStyle.Italic,
        letterSpacing = 5.sp,
        lineHeight = 10.sp,
        //maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        //textAlign = TextAlign.Center,
        //textDecoration = TextDecoration.LineThrough
    )

}
