package com.abstudio.shoppinglist.domain

class RemoveShopItemUseCase(private val repository: ShopItemRepository) {

    fun removeShopItem(item: ShopItem) {
       repository.removeShopItem(item)
    }
}