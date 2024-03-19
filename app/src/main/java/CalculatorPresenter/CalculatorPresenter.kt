class CalculatorPresenter(private val view: CalculatorView) {

    private val model = CalculatorModel()

    fun performCalculation(num1: Double, num2: Double, operator: String) {
        try {
            val result = when (operator) {
                "+" -> model.add(num1, num2)
                "-" -> model.subtract(num1, num2)
                "*" -> model.multiply(num1, num2)
                "/" -> model.divide(num1, num2)
                else -> throw IllegalArgumentException("Invalid operator")
            }
            view.showResult(result)
        } catch (e: IllegalArgumentException) {
            view.showError(e.message ?: "An error occurred")
        }
    }
}
