package dev.davwheat.railway.gateline_errors.composable

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.davwheat.railway.gateline_errors.R
import dev.davwheat.railway.gateline_errors.data.ErrorCodes
import dev.davwheat.railway.gateline_errors.ui.theme.AppTheme

@Composable
fun ErrorCodeDisplay(
  modifier: Modifier = Modifier,
  errorCode: String,
) {
  Card(modifier = modifier.animateContentSize()) {
    Column(modifier = Modifier.padding(16.dp)) {
      AnimatedContent(
        targetState = errorCode,
        label = "ErrorCodeDisplay",
        transitionSpec = { fadeIn() togetherWith fadeOut() },
      ) {
        if (it.isBlank()) {
          Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Text(
              stringResource(R.string.no_code_blurb_1),
              textAlign = TextAlign.Center,
              modifier = Modifier.fillMaxWidth(),
              style = MaterialTheme.typography.bodyLarge,
            )
            Text(
              stringResource(R.string.no_code_blurb_2),
              textAlign = TextAlign.Center,
              modifier = Modifier.fillMaxWidth(),
              style = MaterialTheme.typography.bodyLarge,
            )
          }
        } else {
          val num = it.toIntOrNull()

          if (num == null) {
            Text(
              stringResource(R.string.error_code_invalid_int),
              textAlign = TextAlign.Center,
              modifier = Modifier.fillMaxWidth(),
              style = MaterialTheme.typography.bodyLarge,
            )
          } else if (ErrorCodes.containsKey(num)) {
            ErrorCodeDetail(errorCode = ErrorCodes[num]!!)
          } else {
            Text(
              stringResource(R.string.error_code_unknown, num),
              textAlign = TextAlign.Center,
              modifier = Modifier.fillMaxWidth(),
              style = MaterialTheme.typography.bodyLarge,
            )
          }
        }
      }
    }
  }
}

@Preview
@Composable
fun ErrorCodeDisplayPreviewValid() {
  AppTheme { ErrorCodeDisplay(errorCode = "01") }
}

@Preview
@Composable
fun ErrorCodeDisplayPreviewInvalid() {
  AppTheme { ErrorCodeDisplay(errorCode = "abc") }
}

@Preview
@Composable
fun ErrorCodeDisplayPreviewEmpty() {
  AppTheme { ErrorCodeDisplay(errorCode = "") }
}

@Preview
@Composable
fun ErrorCodeDisplayPreviewUnknown() {
  AppTheme { ErrorCodeDisplay(errorCode = "999") }
}
