package com.abstudio.shoppinglist.domain

class EditShopItemUseCase(private val repository: ShopItemRepository) {

    fun editShopItem(item: ShopItem) {
        repository.editShopItem(item)
    }
}