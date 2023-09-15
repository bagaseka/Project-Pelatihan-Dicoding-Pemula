package bagasekaz.projects.dicodingpemula.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import bagasekaz.projects.dicodingpemula.GameDetail;
import bagasekaz.projects.dicodingpemula.R;
import bagasekaz.projects.dicodingpemula.model.Games;

public class ListGamesAdapter extends RecyclerView.Adapter<ListGamesAdapter.ListViewHolder> {

    private ArrayList<Games> listGame;

    public ListGamesAdapter(ArrayList<Games> listGame) {
        this.listGame = listGame;
    }

    @NonNull
    @Override
    public ListGamesAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_game_item, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListGamesAdapter.ListViewHolder holder, int position) {
        Games games = listGame.get(position);
        holder.tvTitle.setText(games.getName());
        holder.imgGames.setImageResource(games.getImage());
        holder.tvRelease.setText(games.getReleaseDate());
        holder.tvPrice.setText(games.getPrice());
        holder.tvDescription.setText(games.getDescription());

        holder.itemView.setOnClickListener(v -> {

            Intent intent = new Intent(holder.itemView.getContext(), GameDetail.class);
            intent.putExtra(GameDetail.EXTRA_DATA, games);
            holder.itemView.getContext().startActivity(intent);

        });
    }

    @Override
    public int getItemCount() {
        return listGame.size();
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgGames;
        TextView tvTitle, tvRelease, tvPrice, tvDescription;
        ListViewHolder(View itemView) {
            super(itemView);
            imgGames = itemView.findViewById(R.id.img_games);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvRelease = itemView.findViewById(R.id.tv_release);
            tvPrice = itemView.findViewById(R.id.tv_price);
            tvDescription = itemView.findViewById(R.id.tv_desc);
        }
    }
}
