package com.abstudio.shoppinglist.data

import com.abstudio.shoppinglist.domain.ShopItem
import com.abstudio.shoppinglist.domain.ShopItemRepository
import java.lang.RuntimeException

object ShopItemRepositoryImpl : ShopItemRepository {

    private val shopList = mutableListOf<ShopItem>()
    private var autoIncrementId = 0

    override fun getShopList(): List<ShopItem> {
        return shopList.toList()
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList.find { it.id == shopItemId }
            ?: throw RuntimeException("Element with id $shopItemId not found")
    }

    override fun addShopItem(item: ShopItem) {
        if (item.id == ShopItem.UNDEFINED_ID){
            item.id = autoIncrementId
            autoIncrementId++
        }

        shopList.add(item)
    }

    override fun editShopItem(item: ShopItem) {
        val oldItem = getShopItem(item.id)
        removeShopItem(oldItem)
        addShopItem(item)
    }

    override fun removeShopItem(item: ShopItem) {
        shopList.remove(item)
    }
}