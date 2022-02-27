package com.abstudio.shoppinglist.domain

interface ShopItemRepository {

    fun getShopList(): List<ShopItem>
    fun getShopItem(shopItemId: Int): ShopItem
    fun addShopItem(item: ShopItem)
    fun editShopItem(item: ShopItem)
    fun removeShopItem(item: ShopItem)

}