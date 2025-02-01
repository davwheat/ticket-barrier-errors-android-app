package dev.davwheat.railway.gateline_errors.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.davwheat.railway.gateline_errors.ui.theme.AppTheme

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun MainUi(modifier: Modifier = Modifier, showAds: Boolean) {
  var errorCodeEntry by rememberSaveable { mutableStateOf("") }
  val intErrorCode = errorCodeEntry.toIntOrNull()

  var adHeight by remember { mutableIntStateOf(0) }
  val adHeightDp = with(LocalDensity.current) { adHeight.toDp() }

  val scaffoldState =
    rememberBottomSheetScaffoldState(
      bottomSheetState =
      SheetState(
        initialValue = SheetValue.Expanded,
        confirmValueChange = { false },
        skipHiddenState = true,
        skipPartiallyExpanded = true,
        density = LocalDensity.current,
      ),
    )

  Scaffold(modifier) { innerPadding ->
    Box(modifier = Modifier.fillMaxSize()) {
      BottomSheetScaffold(
        sheetDragHandle = {},
        sheetSwipeEnabled = false,
        scaffoldState = scaffoldState,
        sheetContent = {
          Column(
            modifier =
            Modifier.padding(start = 36.dp, end = 36.dp, top = 24.dp, bottom = 36.dp),
            verticalArrangement = Arrangement.Bottom,
          ) {
            ErrorCodeEntry(
              modifier = Modifier.fillMaxWidth(),
              value = errorCodeEntry,
              onInput = { text -> errorCodeEntry = text },
            )
          }
        },
      ) {
        Box(modifier = Modifier
          .padding(innerPadding)
          .padding(it)
          .fillMaxSize()
          .padding(bottom = 84.dp)) {
          Column(
            modifier =
            Modifier
              .fillMaxSize()
              .verticalScroll(rememberScrollState())
              .padding(
                top = 24.dp,
                start = 24.dp,
                end = 24.dp,
                bottom = 24.dp + adHeightDp + 8.dp,
              ),
            verticalArrangement = Arrangement.spacedBy(16.dp),
          ) {
            ErrorCodeDisplay(
              modifier = Modifier.fillMaxWidth(),
              errorCode = errorCodeEntry,
            )

            AnimatedVisibility(
              visible = (intErrorCode ?: -1) >= 100,
              enter = fadeIn() + expandVertically(),
              exit = fadeOut() + shrinkVertically(),
            ) {
              NrValidationGlossary()
            }
          }

          if (showAds) {
            AdmobBanner(
              modifier =
              Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
                .align(Alignment.BottomCenter)
                .onGloballyPositioned { adHeight = it.size.height },
            )
          }
        }
      }
    }
  }
}

@Preview
@Composable
private fun MainUiPreview() {
  AppTheme { MainUi(showAds = false) }
}
