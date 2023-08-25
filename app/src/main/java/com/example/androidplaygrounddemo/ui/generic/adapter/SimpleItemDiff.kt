package com.example.androidplaygrounddemo.ui.generic.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

/**
 * A simple implementation of [DiffUtil.ItemCallback] which compares the identifiers of the old and new item.
 *
 * This class is useful to simplify the ItemCallback for data classes with an identifying property.
 * Note: Should not be used for non-data classes or classes without an equals override as the contents can't be properly
 * compared.
 */
class SimpleItemDiff<T : Any>(private val identifier: T.() -> Any) : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean =
        oldItem.identifier() == newItem.identifier()

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean =
        oldItem == newItem
}
