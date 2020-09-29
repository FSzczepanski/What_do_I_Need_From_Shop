package com.example.whatdoineedfromshop.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.whatdoineedfromshop.R
import com.example.whatdoineedfromshop.data.db.entities.ShoppingItem
import kotlinx.android.synthetic.main.shopping_item.view.*
import java.util.*

class FragmentNeededInFutureItemAdapter(var items: LinkedList<ShoppingItem>,
                                        private val viewModel: FragmentNeededInFutureViewModel
) : RecyclerView.Adapter<FragmentNeededInFutureItemAdapter.ShoppingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val curShoppingItem = items[position]

        holder.itemView.tvName.text = curShoppingItem.name
        holder.itemView.tvAmount.text = "${curShoppingItem.amount}"

        holder.itemView.ivDelete.setOnClickListener {
            viewModel.delete(curShoppingItem)
        }

        holder.itemView.ivPlus.setOnClickListener {
            curShoppingItem.amount++
            viewModel.upsert(curShoppingItem)
        }

        holder.itemView.ivMinus.setOnClickListener {
            if (curShoppingItem.amount > 0) {
                curShoppingItem.amount--
                viewModel.upsert(curShoppingItem)
            }
        }
    }

    inner class ShoppingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}