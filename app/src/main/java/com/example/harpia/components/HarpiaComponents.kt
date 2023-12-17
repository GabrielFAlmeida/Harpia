@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.harpia.components

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.harpia.R
import com.example.harpia.classes.SelectOption
import com.example.harpia.navigation.HarpiaAppRouter
import com.example.harpia.navigation.Screen
import com.example.harpia.ui.theme.Blue20
import com.example.harpia.ui.theme.Blue20_o1
import com.example.harpia.ui.theme.Blue30
import com.example.harpia.ui.theme.Blue40
import com.example.harpia.ui.theme.Typography
import com.example.harpia.ui.theme.White

// TEXTS
@Composable
fun CommonText(
    text: String,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .heightIn(min = 80.dp),
    textStyle: TextStyle = Typography.bodyLarge,
    color: Color = White,
    textAlign: TextAlign = TextAlign.Center,
) {
    Text(
        text = text,
        modifier = modifier,
        style = textStyle,
        color = color,
        textAlign = textAlign,
    )
}

@Preview
@Composable
fun CommonTextPreview() {
    CommonText(
        text = stringResource(id = R.string.about_content_1),
        textStyle = Typography.bodyLarge,
        color = White,
        textAlign = TextAlign.Justify
    )
}

@Composable
fun NavigatorClickableText(
    text: String,
    modifier: Modifier = Modifier.heightIn(min = 20.dp),
    destinationScreen: Screen,
    textStyle: TextStyle = Typography.displaySmall,
    color: Color = Blue30
) {
    val annotatedText = buildAnnotatedString {
        withStyle(style = SpanStyle(color = color)) {
            append(text)
        }
    }
    Box(
        modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
    ) {
        ClickableText(
            text = annotatedText,
            onClick = { HarpiaAppRouter.navigateTo(destinationScreen) },
            modifier = modifier,
            style = textStyle
        )
    }
}

@Preview
@Composable
fun NavigatorClickableTextPreview() {
    NavigatorClickableText(
        text = stringResource(id = R.string.login_redirect_text_1),
        destinationScreen = Screen.AboutScreen
    )
}

// LISTS
@Composable
fun CommonBulletList(
    items: List<String>,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .heightIn(min = 80.dp),
    textStyle: TextStyle = Typography.bodyLarge,
    indent: Dp = 20.dp,
    lineSpacing: Dp = 0.dp,
    color: Color = White,
    textAlign: TextAlign = TextAlign.Center
) {
    Column(modifier = modifier) {
        items.forEach {
            Row {
                Text(
                    text = "\u2022",
                    style = textStyle,
                    modifier = Modifier.width(indent),
                    color = color,
                    textAlign = textAlign
                )
                Text(
                    text = it,
                    style = textStyle,
                    modifier = Modifier.weight(1f, fill = true),
                    color = color,
                    textAlign = textAlign
                )
            }
            if (lineSpacing > 0.dp && it != items.last()) {
                Spacer(modifier = Modifier.height(lineSpacing))
            }
        }
    }
}

@Preview
@Composable
fun CommonBulletListPreview() {
    CommonBulletList(
        items = listOf(
            stringResource(id = R.string.about_bullet_content_1),
            stringResource(id = R.string.about_bullet_content_2)
        ), textStyle = Typography.bodyLarge, color = White, textAlign = TextAlign.Justify
    )
}

// FIELDS
@Composable
fun CommonTextField(
    placeholder: String,
    placeholderStyle: TextStyle = Typography.displayMedium,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(
            start = 20.dp, top = 0.dp, end = 20.dp, bottom = 0.dp
        ),
    readonly: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
): String {
    var textValue by remember { mutableStateOf(TextFieldValue("")) }

    OutlinedTextField(
        value = textValue,
        onValueChange = { newText ->
            textValue = newText
        },
        placeholder = { Text(text = placeholder, style = placeholderStyle) },
        modifier = modifier,
        shape = RoundedCornerShape(15.dp),
        readOnly = readonly,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Blue20_o1,
            unfocusedContainerColor = Blue20_o1,
            focusedTextColor = Blue40,
            disabledTextColor = Blue40
        ),
        keyboardOptions = keyboardOptions,
        visualTransformation = visualTransformation
    )
    return textValue.text
}

@Preview
@Composable
fun CommonTextFieldPreview() {
    CommonTextField(
        placeholder = stringResource(id = R.string.signup_input_placeholder_4),
        modifier = Modifier.fillMaxWidth(),
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )
}

@Composable
fun CommonSelect(
    placeholder: String,
    textStyle: TextStyle = Typography.displayMedium,
    options: List<SelectOption>
): String {
    var isExpanded by remember { mutableStateOf(false) }
    var optionValue by remember { mutableStateOf("") }

    ExposedDropdownMenuBox(expanded = isExpanded, onExpandedChange = { newValue ->
        isExpanded = newValue
    }) {
        OutlinedTextField(
            value = optionValue,
            onValueChange = {},
            readOnly = true,
            placeholder = { Text(text = placeholder, style = textStyle) },
            modifier = Modifier.menuAnchor(),
            shape = RoundedCornerShape(15.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Blue20_o1,
                unfocusedContainerColor = Blue20_o1,
                focusedTextColor = Blue40,
                disabledTextColor = Blue40
            ),
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) },
        )
        ExposedDropdownMenu(
            expanded = isExpanded,
            onDismissRequest = {
                isExpanded = false
            }
        ) {
            for (option in options) {
                DropdownMenuItem(
                    text = {
                        Text(text = option.displayValue, style = textStyle)
                    },
                    onClick = {
                        optionValue = option.value
                        isExpanded = false
                    }
                )
            }
        }
    }
    return optionValue
}

@Preview
@Composable
fun CommonSelectPreview() {
    CommonSelect(
        placeholder = stringResource(id = R.string.new_experience_input_placeholder_3),
        options = listOf(
            SelectOption("6° ano", "6"),
            SelectOption("7° ano", "7"),
            SelectOption("8° ano", "8"),
            SelectOption("9° ano", "9"),
            SelectOption("1° ano do E.M.", "1_EM"),
            SelectOption("2° ano do E.M.", "2_EM"),
            SelectOption("3° ano do E.M.", "3_EM"),
        )
    )
}

// BUTTONS
@Composable
fun CommonButton(
    text: String,
    buttonColor: Color = Blue30,
    textColor: Color = White,
    onCLick: () -> Unit
) {
    Button(
        onClick = onCLick,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        contentPadding = PaddingValues(),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .background(buttonColor),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text.uppercase(), style = Typography.titleMedium, color = textColor
            )
        }
    }
}

@Preview
@Composable
fun CommonButtonPreview() {
    CommonButton(
        text = stringResource(id = R.string.create_account_text),
        onCLick = { Log.i("Component test", "Common button click works") })
}

@Composable
fun NavigatorIconButton(
    destinationScreen: Screen = Screen.SignUpScreen,
    text: String,
    color: Color = White,
    imageVector: ImageVector = Icons.Filled.ArrowBack,
    contentDescription: String = "Voltar"
) {
    Column(
        modifier = Modifier.background(Color.Transparent),
    ) {
        IconButton(
            onClick = { HarpiaAppRouter.navigateTo(destinationScreen) },
        ) {
            Icon(
                imageVector = imageVector, contentDescription = contentDescription, tint = color
            )
        }
        Text(
            text = text.uppercase(),
            modifier = Modifier
                .heightIn(min = 20.dp)
                .align(CenterHorizontally),
            style = Typography.displaySmall,
            color = color,
            textAlign = TextAlign.Center,
        )
    }
}

@Preview
@Composable
fun NavigatorIconButtonPreview() {
    NavigatorIconButton(
        destinationScreen = Screen.SignUpScreen,
        text = stringResource(id = R.string.back_text),
        color = White
    )
}

@Composable
fun ClickableImageButton(
    modifier: Modifier = Modifier.background(Color.Transparent),
    destinationScreen: Screen = Screen.HomeScreen,
    text: String,
    color: Color = White,
    imageId: Int = R.drawable.icone_compartilhar_experiencia,
    contentDescription: String = "Compartilha experiência"
) {
    Column(
        modifier = modifier,
    ) {
        Surface(
            modifier = Modifier.background(Color.Transparent),
            onClick = { HarpiaAppRouter.navigateTo(destinationScreen) }) {
            Image(
                painter = painterResource(id = imageId),
                contentDescription = contentDescription,
                contentScale = ContentScale.Fit,
            )
        }
        Text(
            text = text.uppercase(),
            modifier = Modifier.align(CenterHorizontally),
            style = Typography.labelSmall,
            color = color,
            textAlign = TextAlign.Center,
        )
    }
}

@Preview
@Composable
fun ClickableImageButtonPreview() {
    ClickableImageButton(
        destinationScreen = Screen.HomeScreen,
        text = stringResource(id = R.string.home_button_content_1),
        color = Blue30
    )
}

//BOXES
@Composable
fun CommonCard(
    borderColor: Color = Blue20,
    backgroundColor: Color = Blue20_o1,
    textColor: Color = Blue20,
    text: String = "Voltar",
    modifier: Modifier = Modifier.defaultMinSize(minHeight = 100.dp)
) {
    Card(
        border = BorderStroke(2.dp, borderColor),
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        modifier = modifier
    ) {
        Text(
            text = text,
            style = Typography.bodyMedium,
            color = textColor,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview
@Composable
fun CommonCardPreview() {
    CommonCard(
        borderColor = Blue20, backgroundColor = Blue20_o1, textColor = Blue20, text = "Voltar"
    )
}

//TOAST NOTIFICATIONS
fun commonToast(context: Context, length: Int = Toast.LENGTH_LONG, text: String) {
    Toast.makeText(
        context,
        text,
        length
    ).show()
}