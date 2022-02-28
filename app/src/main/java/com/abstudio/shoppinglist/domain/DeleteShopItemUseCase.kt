package com.abstudio.shoppinglist.domain

class DeleteShopItemUseCase(private val repository: ShopItemRepository) {

    fun deleteShopItem(item: ShopItem) {
       repository.deleteShopItem(item)
    }
}