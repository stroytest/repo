package com.abstudio.shoppinglist.domain

import androidx.lifecycle.LiveData

class GetShopListUseCase(private val repository: ShopItemRepository) {

    fun getShopList(): LiveData<List<ShopItem>> {
        return repository.getShopList()
    }
}