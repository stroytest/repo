package com.abstudio.shoppinglist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.abstudio.shoppinglist.domain.ShopItem
import com.abstudio.shoppinglist.domain.ShopItemRepository
import java.lang.RuntimeException

object ShopItemRepositoryImpl : ShopItemRepository {

    private val shopListLiveData = MutableLiveData<List<ShopItem>>()
    private val shopList = mutableListOf<ShopItem>()
    private var autoIncrementId = 0

    init {
        for (i in 0 until 10){
            val item = ShopItem("Item $i", i, true)
            addShopItem(item)
        }
        shopListLiveData.value = shopList.toList()
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopListLiveData
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
        shopListLiveData.value = shopList.toList()
    }

    override fun editShopItem(item: ShopItem) {
        val oldItem = getShopItem(item.id)
        deleteShopItem(oldItem)
        addShopItem(item)
    }

    override fun deleteShopItem(item: ShopItem) {
        shopList.remove(item)
        shopListLiveData.value = shopList.toList()
    }
}