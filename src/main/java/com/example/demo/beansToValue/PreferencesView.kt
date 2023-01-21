package com.example.demo.beansToValue

class PreferencesView : View() {

    private val greetingPicker: GreetingPicker = GreetingPicker()
    private val localePicker: LocalePicker = LocalePicker()
    private val currencyPicker: CurrencyPicker = CurrencyPicker()

    fun showModal(preferences: UserPreferences): UserPreferences {
        greetingPicker.greeting = preferences.greeting
        localePicker.locale = preferences.locale
        currencyPicker.currency = preferences.currency
        show()
        return UserPreferences(
            greeting = greetingPicker.greeting,
            locale = localePicker.locale,
            currency = currencyPicker.currency
        )
    }

    protected fun onGreetingChange() {
        preferences.greeting = greetingPicker.getGreeting()
    }

    protected fun onLocaleChange() {
        preferences.locale = localePicker.getLocale()
    }

    protected fun onCurrencyChange() {
        preferences.currency = currencyPicker.getCurrency()
    }
}