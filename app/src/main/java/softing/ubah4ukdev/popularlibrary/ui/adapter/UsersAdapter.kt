package softing.ubah4ukdev.popularlibrary.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import softing.ubah4ukdev.popularlibrary.presenter.IUserListPresenter
import softing.ubah4ukdev.popularlibrary.ui.IUserItemView
import softing.ubah4ukdev.populatelibrary.databinding.UserBinding

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.ui.adapter

Created by Ivan Sheynmaer

2021.08.05
v1.0
 */
class UsersAdapter(val presenter: IUserListPresenter) :
    RecyclerView.Adapter<UsersAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ItemViewHolder(
            UserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ).apply {
            itemView.setOnClickListener { presenter.itemClickListener?.invoke(this) }
        }

    override fun getItemCount() = presenter.getCount()

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) =
        presenter.bindView(holder.apply { pos = position })

    inner class ItemViewHolder(
        private val vb: UserBinding
    ) : RecyclerView.ViewHolder(vb.root),
        IUserItemView {
        override var pos = -1

        override fun setLogin(text: String) = with(vb) {
            tvLogin.text = text
        }
    }
}