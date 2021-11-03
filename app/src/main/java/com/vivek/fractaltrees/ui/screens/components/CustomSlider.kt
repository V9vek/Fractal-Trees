package com.vivek.fractaltrees.ui.screens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Slider
import androidx.compose.material.SliderDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vivek.fractaltrees.ui.theme.SliderBGColorActive
import com.vivek.fractaltrees.ui.theme.SliderBGColorInactive

@Composable
fun CustomSlider(
    sliderText: String,
    sliderValue: Float,
    onSliderValueChange: (Float) -> Unit,
    valueRange: ClosedFloatingPointRange<Float>
) {
    Column(modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp)) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colors.onBackground.copy(alpha = 0.1f))
                .padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
            Text(
                text = sliderText,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
            )
        }

        Slider(
            value = sliderValue,
            onValueChange = onSliderValueChange,
            valueRange = valueRange,
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colors.onBackground,
                inactiveTrackColor = SliderBGColorInactive,
                activeTrackColor = SliderBGColorActive
            ),
        )
    }
}