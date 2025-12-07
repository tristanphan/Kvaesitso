package de.mm20.launcher2.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalWindowInfo

/**
 * Doubles the number of columns if we determine it's a tablet
 * This is useful for folding phones to look normal in unfolded mode
 * Maybe it's a good idea to add another slider for the number of columns in unfolded mode
 * However that's a config schema change that might corrupt stuff if we undo this change so...
 */
@Composable
fun getActualColumns(columns: Int): Int {
    val windowSize = LocalWindowInfo.current.containerSize
    val aspectRatio = if (windowSize.height == 0) 1f else windowSize.width.toFloat() / windowSize.height
    val isTablet = aspectRatio >= 0.7
    return if (isTablet) columns * 2 else columns
}