package com.abstudio.shoppinglist.domain

class GetShopListUseCase(private val repository: ShopItemRepository) {

    fun getShopList(): List<ShopItem> {
        return repository.getShopList()
    }
}