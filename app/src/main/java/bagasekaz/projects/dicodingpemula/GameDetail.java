package bagasekaz.projects.dicodingpemula;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import bagasekaz.projects.dicodingpemula.databinding.ActivityGameDetailBinding;
import bagasekaz.projects.dicodingpemula.model.Games;

public class GameDetail extends AppCompatActivity {

    private ActivityGameDetailBinding binding;
    public static final String EXTRA_DATA = "extra_data";
    private Games games;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGameDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        binding.preOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GameDetail.this, "Not Available", Toast.LENGTH_SHORT).show();
            }
        });

        if (android.os.Build.VERSION.SDK_INT >= 33) {
            games = getIntent().getParcelableExtra(EXTRA_DATA, Games.class);
        } else {
            games = getIntent().getParcelableExtra(EXTRA_DATA);
        }

        binding.tvTitle.setText(games.getName());
        binding.tvRelease.setText(games.getReleaseDate());
        binding.tvDesc.setText(games.getDescription());
        binding.tvPrice.setText(games.getPrice());
        binding.imgGames.setImageResource(games.getImage());
    }
}