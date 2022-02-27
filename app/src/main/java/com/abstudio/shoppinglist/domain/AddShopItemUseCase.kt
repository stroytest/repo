package com.abstudio.shoppinglist.domain

class AddShopItemUseCase(private val repository: ShopItemRepository) {

    fun addShopItem(item: ShopItem) {
        repository.addShopItem(item)
    }
}