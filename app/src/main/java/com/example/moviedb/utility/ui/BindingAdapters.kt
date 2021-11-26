import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.moviedb.R
import com.example.moviedb.movie.MovieGridAdapter
import com.example.moviedb.network.ResultsItem

@BindingAdapter("imageUrl")
fun ImageView.bindImage(imageUrl: String?) {
    imageUrl?.let {
        val imageUri = imageUrl.toUri().buildUpon().scheme("https").build()
        this.load(imageUri) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }
    }
}

//@BindingAdapter("listData")
//fun RecyclerView.bindRecyclerView(data: List<ResultsItem>) {
////    if (this.adapter == null) {
////        this.adapter = MovieGridAdapter()
////    }
//    val adapter = this.adapter as MovieGridAdapter
//    adapter.submitList(data)
//}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<ResultsItem>) {
//    if (this.adapter == null) {
//        this.adapter = MovieGridAdapter()
//    }
    val adapter = recyclerView.adapter as MovieGridAdapter
    adapter.submitList(data)
}
