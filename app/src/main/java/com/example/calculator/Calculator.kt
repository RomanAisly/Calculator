package com.example.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.calculator.ui.theme.gradBot1
import com.example.calculator.ui.theme.gradBot2
import com.example.calculator.ui.theme.gradNum1
import com.example.calculator.ui.theme.gradNum2
import com.example.calculator.ui.theme.gradOp1
import com.example.calculator.ui.theme.gradOp2
import com.example.calculator.ui.theme.gradTop1
import com.example.calculator.ui.theme.gradTop2
import com.example.calculator.ui.theme.gradTopD1
import com.example.calculator.ui.theme.gradTopD2

@Composable
fun Calculator(state: CalculatorState,
               modifier: Modifier = Modifier,
               buttonSpacing: Dp = 8.dp,
               onAction: (CalculatorAction) -> Unit) {
    Box(modifier = modifier) {
        AnimLoad()
        Column(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)) {
            Text(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
                maxLines = 2,
                text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                textAlign = TextAlign.End,
                fontWeight = FontWeight.Normal,
                fontSize = 60.sp,
                color = Color.White)
            
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                CalculatorButton(symbol = "AC",
                    modifier = Modifier
                        .background(brush = Brush.linearGradient(colors = listOf(gradTop1,
                            gradTop2)))
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = { onAction(CalculatorAction.Clear) })
                CalculatorButton(symbol = "DEL",
                    modifier = Modifier
                        .background(brush = Brush.radialGradient(colors = listOf(gradTopD1,
                            gradTopD2)))
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorAction.Delete) })
                CalculatorButton(symbol = "/",
                    modifier = Modifier
                        .background(brush = Brush.radialGradient(colors = listOf(gradOp1, gradOp2)))
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorAction.Operation(CalculatorOperation.Divide)) })
            }
            
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                CalculatorButton(symbol = "7",
                    modifier = Modifier
                        .background(brush = Brush.radialGradient(colors = listOf(gradNum1,
                            gradNum2)))
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorAction.Number(7)) })
                CalculatorButton(symbol = "8",
                    modifier = Modifier
                        .background(brush = Brush.radialGradient(colors = listOf(gradNum1,
                            gradNum2)))
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorAction.Number(8)) })
                CalculatorButton(symbol = "9",
                    modifier = Modifier
                        .background(brush = Brush.radialGradient(colors = listOf(gradNum1,
                            gradNum2)))
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorAction.Number(9)) })
                CalculatorButton(symbol = "x",
                    modifier = Modifier
                        .background(brush = Brush.radialGradient(colors = listOf(gradOp1, gradOp2)))
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorAction.Operation(CalculatorOperation.Multiply)) })
            }
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                CalculatorButton(symbol = "4",
                    modifier = Modifier
                        .background(brush = Brush.radialGradient(colors = listOf(gradNum1,
                            gradNum2)))
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorAction.Number(4)) })
                CalculatorButton(symbol = "5",
                    modifier = Modifier
                        .background(brush = Brush.radialGradient(colors = listOf(gradNum1,
                            gradNum2)))
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorAction.Number(5)) })
                CalculatorButton(symbol = "6",
                    modifier = Modifier
                        .background(brush = Brush.radialGradient(colors = listOf(gradNum1,
                            gradNum2)))
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorAction.Number(6)) })
                CalculatorButton(symbol = "-",
                    modifier = Modifier
                        .background(brush = Brush.radialGradient(colors = listOf(gradOp1, gradOp2)))
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorAction.Operation(CalculatorOperation.Minus)) })
            }
            
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                CalculatorButton(symbol = "1",
                    modifier = Modifier
                        .background(brush = Brush.radialGradient(colors = listOf(gradNum1,
                            gradNum2)))
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorAction.Number(1)) })
                CalculatorButton(symbol = "2",
                    modifier = Modifier
                        .background(brush = Brush.radialGradient(colors = listOf(gradNum1,
                            gradNum2)))
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorAction.Number(2)) })
                CalculatorButton(symbol = "3",
                    modifier = Modifier
                        .background(brush = Brush.radialGradient(colors = listOf(gradNum1,
                            gradNum2)))
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorAction.Number(3)) })
                CalculatorButton(symbol = "+",
                    modifier = Modifier
                        .background(brush = Brush.radialGradient(colors = listOf(gradOp1, gradOp2)))
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorAction.Operation(CalculatorOperation.Plus)) })
            }
            
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                CalculatorButton(symbol = "0",
                    modifier = Modifier
                        .background(brush = Brush.linearGradient(colors = listOf(gradBot1,
                            gradBot2)))
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = { onAction(CalculatorAction.Number(0)) })
                CalculatorButton(symbol = ".",
                    modifier = Modifier
                        .background(brush = Brush.radialGradient(colors = listOf(gradBot1,
                            gradBot2)))
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorAction.Decimal) })
                CalculatorButton(symbol = "=",
                    modifier = Modifier
                        .background(brush = Brush.radialGradient(colors = listOf(gradBot1,
                            gradBot2)))
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorAction.Calculate) })
            }
        }
    }
}

@Preview
@Composable
fun AnimLoad() {
    
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {
        
        Box(modifier = Modifier.size(130.dp)) {
            val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.animation_lks6lh1g))
            val progress by animateLottieCompositionAsState(composition,
                iterations = LottieConstants.IterateForever,
                isPlaying = true)
            LottieAnimation(composition = composition, progress = { progress })
        }
        
        Box(modifier = Modifier.size(110.dp)) {
            val composition2 by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.anim_n2))
            val progress2 by animateLottieCompositionAsState(composition2,
                iterations = LottieConstants.IterateForever,
                isPlaying = true)
            LottieAnimation(composition = composition2, progress = { progress2 })
        }
    }
    
    
}