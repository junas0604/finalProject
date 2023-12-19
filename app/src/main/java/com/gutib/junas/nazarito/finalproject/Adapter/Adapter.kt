import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gutib.junas.nazarito.finalproject.databinding.ItemReflectionBinding

class Adapter(private val reflections: List<String>) :
    RecyclerView.Adapter<Adapter.ReflectionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReflectionViewHolder {
        val binding = ItemReflectionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReflectionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReflectionViewHolder, position: Int) {
        holder.bind(reflections[position])
    }

    override fun getItemCount(): Int = reflections.size

    class ReflectionViewHolder(private val binding: ItemReflectionBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(reflectionText: String) {
            binding.tvReflectionText.text = reflectionText
        }
    }
}