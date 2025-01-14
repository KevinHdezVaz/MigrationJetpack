package com.example.migrationjetpack.view.navigation

sealed class NavigationCompose(val route: String) {
    object PaymentMethods : NavigationCompose("payment_methods")
    object ElektraRapido : NavigationCompose("elektra_rapido")
    object ElektraNormal : NavigationCompose("elektra_normal")
    object GiftCard : NavigationCompose("giftcard")
}
