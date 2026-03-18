package cst.unibucfmiif2026

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import cst.unibucfmiif2026.ui.theme.UniBucFMIIF2026Theme

fun Int.isAgeValid() = this >= 18
fun String?.isNameValid(): Boolean = this?.let { length >= 3 } ?: false

enum class Colors(id: Int, nameResId: Int, colorResId: Int) {
	GREEN(0, R.string.green, R.color.green),
	YELLOW(1, R.string.yellow, R.color.yellow),
	RED(2, R.string.red, R.color.red)
}

class MainActivity : ComponentActivity() {

	val firstName: String = "Name"
	var lastName: String? = ""

	val age: Int by lazy {
		18
	}

	lateinit var address: String

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			UniBucFMIIF2026Theme {
				Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
					Greeting(
						name = "Android",
						modifier = Modifier.padding(innerPadding)
					)
				}
			}
		}

		MySingleton.firstName

		lastName?.length

		var myName: String = lastName ?: firstName

		lastName?.apply {
			Log.e("TAG", "${this.length}")
			Log.e("TAG", "${this@MainActivity.firstName.length}")
		}

		myName = lastName?.let { ln ->
			"$ln $firstName"
		} ?: "Unknown"

		if (age.isAgeValid()) {
			Log.e("TAG", "Age is valid")
		} else {
			Log.e("TAG", "Age is not valid")
		}

		if (firstName.isNameValid() && lastName.isNameValid()) {
			Log.e("TAG", "Name is valid")
		} else {
			Log.e("TAG", "Name is not valid")
		}

		address.length
		address = "Address"

		lastName = null

		Log.e("TAG", "$age")
		Log.e("TAG", "onCreate:")
	}

	override fun onStart() {
		super.onStart()

		Log.e("TAG", "onStart:")
	}

	override fun onResume() {
		super.onResume()

		Log.e("TAG", "onResume:")
	}

	override fun onPause() {
		super.onPause()

		Log.e("TAG", "onPause:")
	}

	override fun onStop() {
		super.onStop()

		Log.e("TAG", "onStop:")
	}

	override fun onDestroy() {
		super.onDestroy()

		Log.e("TAG", "onDestroy:")
	}
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

	val context = LocalContext.current

	Button(
		onClick = {
			Log.e("TAG", "onClick:")

			val intent = Intent(context, MainViewsActivity::class.java)
			context.startActivity(intent)
			(context as? ComponentActivity)?.finish()
		},
		modifier = Modifier.fillMaxWidth()
	) {
		Text(
			text = "Hello $name!",
			modifier = modifier
		)
	}
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
	UniBucFMIIF2026Theme {
		Greeting("Android")
	}
}