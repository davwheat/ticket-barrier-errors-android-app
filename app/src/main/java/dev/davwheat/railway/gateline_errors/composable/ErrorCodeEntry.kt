package dev.davwheat.railway.gateline_errors.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import dev.davwheat.railway.gateline_errors.R
import dev.davwheat.railway.gateline_errors.ui.theme.AppTheme

@Composable
fun ErrorCodeEntry(modifier: Modifier = Modifier, value: String, onInput: (String) -> Unit) {
  Column(modifier = modifier) {
    OutlinedTextField(
      modifier = Modifier.fillMaxWidth(),
      value = value,
      onValueChange = {
        if (it.length >= 3) {
          onInput(it.substring(0, 3))
        } else {
          onInput(it)
        }
      },
      label = { Text(stringResource(R.string.error_code_input_label)) },
      supportingText = {
        Text(
          modifier = Modifier.fillMaxWidth(),
          text = stringResource(R.string.error_code_input_char_count, value.length),
          textAlign = TextAlign.End,
        )
      },
      keyboardOptions =
      KeyboardOptions(
        autoCorrectEnabled = false,
        capitalization = KeyboardCapitalization.None,
        imeAction = ImeAction.Search,
        keyboardType = KeyboardType.Number,
      ),
    )
  }
}

@Preview
@Composable
private fun ErrorCodeEntryPreview() {
  AppTheme { ErrorCodeEntry(value = "123", onInput = {}) }
}
