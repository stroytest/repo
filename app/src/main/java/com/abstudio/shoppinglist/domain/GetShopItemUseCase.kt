package com.abstudio.shoppinglist.domain

class GetShopItemUseCase(private val repository: ShopItemRepository) {

    fun getShopItem(shopItemId: Int): ShopItem {
        return repository.getShopItem(shopItemId)
    }
}