package com.lgtm.asset_manager

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties

/** Shared visual treatment for dialogs throughout the app. */
@Composable
fun AppAlertDialog(
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    properties: DialogProperties = DialogProperties(),
    icon: (@Composable () -> Unit)? = null,
    title: (@Composable () -> Unit)? = null,
    text: (@Composable () -> Unit)? = null,
    dismissButton: (@Composable () -> Unit)? = null,
    confirmButton: @Composable () -> Unit,
) {
    val scheme = MaterialTheme.colorScheme
    val dialogScheme = scheme.copy(
        onPrimary = Color.White,
        primaryContainer = scheme.surfaceVariant,
        onPrimaryContainer = scheme.onSurface,
    )
    val dialogShapes = MaterialTheme.shapes.copy(
        small = RoundedCornerShape(14.dp),
        medium = RoundedCornerShape(18.dp),
        large = RoundedCornerShape(24.dp),
    )

    MaterialTheme(colorScheme = dialogScheme, shapes = dialogShapes) {
        AlertDialog(
            onDismissRequest = onDismissRequest,
            modifier = modifier,
            properties = properties,
            icon = icon,
            title = title,
            text = text,
            dismissButton = dismissButton,
            confirmButton = confirmButton,
            shape = RoundedCornerShape(28.dp),
            containerColor = Color.White,
            iconContentColor = dialogScheme.onSurface,
            titleContentColor = dialogScheme.onSurface,
            textContentColor = dialogScheme.onSurfaceVariant,
            tonalElevation = 0.dp,
        )
    }
}

@Composable
fun AppDialogHeader(
    title: String,
    subtitle: String? = null,
    icon: ImageVector? = null,
    destructive: Boolean = false,
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(14.dp),
    ) {
        if (icon != null) {
            Surface(
                modifier = Modifier.size(46.dp),
                shape = RoundedCornerShape(16.dp),
                color = if (destructive) MaterialTheme.colorScheme.errorContainer else MaterialTheme.colorScheme.surfaceVariant,
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = if (destructive) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                }
            }
        }
        Column(verticalArrangement = Arrangement.spacedBy(3.dp)) {
            Text(title, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold, color = MaterialTheme.colorScheme.onSurface)
            if (!subtitle.isNullOrBlank()) {
                Text(subtitle, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }
    }
}
