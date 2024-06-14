package org.d3if3007.assessment3.ui.screen


import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import org.d3if3007.assessment3.R
import org.d3if3007.assessment3.ui.theme.Assessment3Theme

@Composable
fun HapusDialog(
    userId: String,
    id: String,
    onDismissRequest: () -> Unit,
    onConfrimation: (String, String) -> Unit
) {
    Dialog(onDismissRequest = { onDismissRequest }) {
        Card(
            modifier = Modifier.padding(16.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.hapus_data),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 16.dp),
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.Center

            ) {
                OutlinedButton(
                    onClick = { onDismissRequest },
                    modifier = Modifier.padding(8.dp),
                ) {
                    Text(text = stringResource(id = R.string.hapus))
                }
                OutlinedButton(
                    onClick = {
                        Log.d("DeleteDialog", "Mengirim userId: $userId, id: $id")
                        onConfrimation(userId, id)
                    },
                    modifier = Modifier.padding(8.dp),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.error)

                ) {
                    Text(
                        text = stringResource(id = R.string.hapus),
                        color = MaterialTheme.colorScheme.error
                    )

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun HapusDialogPreview() {
    Assessment3Theme {
        HapusDialog(userId = "danen@gmail.com", id = "2", onDismissRequest = { }, onConfrimation = {_,_ ->})
    }
}