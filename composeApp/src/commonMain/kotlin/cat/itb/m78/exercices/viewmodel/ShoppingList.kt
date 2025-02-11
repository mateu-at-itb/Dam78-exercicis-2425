package cat.itb.m78.exercices.viewmodel

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

data class Product(val name: String, val amount: Int)

class ShoppingListViewModel : ViewModel() {
    val name = mutableStateOf("")
    val amount = mutableStateOf("")
    val products = mutableStateOf(listOf<Product>())

    fun changeName(newName: String) {
        name.value = newName
    }

    fun changeAmount(newAmount: String) {
        amount.value = newAmount
    }

    fun add() {
        if (amount.value.toIntOrNull() == null) return

        val newProduct = Product(name.value, amount.value.toInt())
        val newList = products.value + newProduct
        products.value = newList
        name.value = ""
        amount.value = ""
    }
}

@Composable
fun ShoppingListScreen() {
    val viewModel = viewModel { ShoppingListViewModel() }
    ShoppingListScreen(
        name = viewModel.name.value,
        amount = viewModel.amount.value,
        products = viewModel.products.value,
        onNameChanged = viewModel::changeName,
        onAmountChanged = viewModel::changeAmount,
        onAdd = viewModel::add
    )
}

@Composable
fun ShoppingListScreen(
    name: String,
    amount: String,
    products: List<Product>,
    onNameChanged: (String) -> Unit,
    onAmountChanged: (String) -> Unit,
    onAdd: () -> Unit
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Card {
            Column(Modifier.padding(10.dp)) {
                OutlinedTextField(name, onNameChanged,
                    label = { Text("Name") })
                OutlinedTextField(amount, onAmountChanged,
                    label = { Text("Amount") })
                Button(onAdd) {
                    Text("Add")
                }
            }

        }
        Spacer(Modifier.height(10.dp))
        LazyColumn {
            items(products) { product ->
                Card {
                    Row(Modifier.fillMaxWidth().padding(10.dp)) {
                        Text(product.name, Modifier.weight(1f))
                        Text(product.amount.toString())
                    }
                }
                Spacer(Modifier.height(10.dp))
            }
        }
    }

}