package dev.davwheat.railway.gateline_errors.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.davwheat.railway.gateline_errors.R
import dev.davwheat.railway.gateline_errors.ui.theme.AppTheme
import dev.davwheat.railway.gateline_errors.ui.theme.LcdDisplayFont

private val glossaryData =
    listOf(
        Pair("DDDD", "Destination station code"),
        Pair("OOOO", "Origin station code"),
        Pair("DDMMYY", "Date"),
        Pair("FFFF", "Fare"),
        Pair("LLLL", "London Underground station code"),
        Pair("PP", "Passenger type"),
        Pair("PZ", "Ticket pass zone"),
        Pair("RR", "Special rule number"),
        Pair("TTTT", "Ticket type"),
        Pair("YY", "London Underground ticket type"),
        Pair("XX", "National Rail ticket type"),
    )

@Composable
fun NrValidationGlossary(modifier: Modifier = Modifier) {
  Card(modifier = modifier) {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
      Row(
          horizontalArrangement = Arrangement.spacedBy(8.dp),
          modifier = Modifier.padding(bottom = 4.dp),
          verticalAlignment = Alignment.CenterVertically,
      ) {
        Icon(
            Icons.Rounded.Info,
            contentDescription = stringResource(R.string.icon_info_description),
        )
        Text(
            stringResource(R.string.glossary_note),
            modifier = Modifier.weight(1f),
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.bodyMedium,
        )
      }

      glossaryData.forEach {
        Row(
            horizontalArrangement = Arrangement.spacedBy(0.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
          Text(
              it.first,
              style = MaterialTheme.typography.bodyMedium,
              fontFamily = LcdDisplayFont,
              color = MaterialTheme.colorScheme.onSurfaceVariant,
              fontSize = 20.sp,
          )
          Text(
              it.second,
              style = MaterialTheme.typography.bodyMedium,
              modifier = Modifier.weight(1f),
              textAlign = TextAlign.End,
          )
        }
      }
    }
  }
}

@Preview
@Composable
private fun NrValidationGlossaryPreview() {
  AppTheme { NrValidationGlossary() }
}
