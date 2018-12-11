package ca.thanasi.photoapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import ca.thanasi.photoapp.models.Photo
import com.bumptech.glide.Glide

class MainAdapter(var photos:List<Photo>, var clickListener : View.OnClickListener) : RecyclerView.Adapter<MainAdapter.PhotoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(LayoutInflater.from(parent?.context)
            .inflate(R.layout.photo_item, parent, false))
    }

    fun getPhoto(adapterPosition: Int) : Photo {
        return photos[adapterPosition]
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photo = photos[position]
        holder?.tags?.text = photo.tags
        holder?.likes?.text = photo.likes.toString()
        holder?.favourites?.text = photo.favourites.toString()
        if(photo.previewURL.isNotEmpty()) {
            Glide.with(holder?.tags?.context)
                .load(photo.previewURL)
                .into(holder?.photo_item)
        }
    }

    inner class PhotoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tags: TextView
        var likes: TextView
        var favourites: TextView
        var photo_item: ImageView

        init {
            if(clickListener != null) {
                itemView.setOnClickListener(clickListener)
            }
            itemView.tag = this
            tags = itemView.findViewById(R.id.tags) as TextView
            likes = itemView.findViewById(R.id.likes) as TextView
            favourites = itemView.findViewById(R.id.favourites) as TextView
            photo_item = itemView.findViewById(R.id.photo_item) as ImageView
        }
    }
}