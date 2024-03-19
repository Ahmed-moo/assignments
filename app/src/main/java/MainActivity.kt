import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.calc.R
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity(), CalculatorView {

    private lateinit var presenter: CalculatorPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = CalculatorPresenter(this)

        calculateButton.setOnClickListener {
            val num1 = editTextNum1.text.toString().toDoubleOrNull() ?: 0.0
            val num2 = editTextNum2.text.toString().toDoubleOrNull() ?: 0.0
            val operator = operatorSpinner.selectedItem.toString()

            presenter.performCalculation(num1, num2, operator)
        }
    }

    override fun showResult(result: Double) {
        resultTextView.text = result.toString()
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
