package dev.davwheat.railway.gateline_errors.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.davwheat.railway.gateline_errors.R
import dev.davwheat.railway.gateline_errors.data.ErrorCodes
import dev.davwheat.railway.gateline_errors.models.Rejection
import dev.davwheat.railway.gateline_errors.ui.theme.AppTheme
import dev.davwheat.railway.gateline_errors.ui.theme.LcdDisplayFont

@Composable
fun ErrorCodeDetail(
    modifier: Modifier = Modifier,
    errorCode: Rejection,
) {
  Column(
      modifier,
      verticalArrangement = Arrangement.spacedBy(8.dp),
  ) {
    Text(
        stringResource(R.string.seek_assistance, errorCode.code),
        modifier = Modifier.fillMaxWidth(),
        fontFamily = LcdDisplayFont,
        fontSize = 24.sp,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        textAlign = TextAlign.Center,
    )

    errorCode.textCode?.let { code ->
      DataPair(
          heading = "Text Error",
          text = { _modifier, style, align ->
            Text(
                modifier = _modifier,
                text = code,
                style = style,
                fontFamily = LcdDisplayFont,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = 18.sp,
                textAlign = align,
            )
          },
          modifier = Modifier.align(Alignment.CenterHorizontally),
          align = TextAlign.Center,
      )
    }

    DataPair(heading = "Definition") { _modifier, style, align ->
      Text(
          modifier = _modifier,
          text = errorCode.definition,
          style = style,
          textAlign = align,
          fontWeight = FontWeight.Bold,
      )
    }

    DataPair(heading = "Explanation", text = errorCode.helpText)

    errorCode.laymansReason?.let { DataPair(heading = "Possible reason(s)", text = it) }

    DataPair(heading = "Action needed", text = errorCode.actionByStaff)
  }
}

@Composable
private fun DataPair(
    modifier: Modifier = Modifier,
    align: TextAlign = TextAlign.Start,
    heading: String,
    text: String,
) {
  DataPair(
      modifier = modifier,
      heading = heading,
      text = { _modifier, style, _ ->
        Text(modifier = _modifier, text = text, style = style, textAlign = align)
      },
      align = align,
  )
}

@Composable
private fun DataPair(
    modifier: Modifier = Modifier,
    align: TextAlign = TextAlign.Start,
    heading: String,
    text: @Composable (modifier: Modifier, defaultStyle: TextStyle, textAlign: TextAlign) -> Unit,
) {
  Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(4.dp)) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = heading,
        style = MaterialTheme.typography.bodySmall,
        textAlign = align,
    )
    text(Modifier.fillMaxWidth(), MaterialTheme.typography.bodyMedium, align)
  }
}

@Preview(showBackground = true)
@Composable
private fun ErrorCodeDetailPreview() {
  AppTheme { ErrorCodeDetail(errorCode = ErrorCodes[1]!!) }
}
