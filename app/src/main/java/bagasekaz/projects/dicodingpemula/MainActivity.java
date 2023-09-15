package bagasekaz.projects.dicodingpemula;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import bagasekaz.projects.dicodingpemula.adapter.ListGamesAdapter;
import bagasekaz.projects.dicodingpemula.databinding.ActivityMainBinding;
import bagasekaz.projects.dicodingpemula.model.Games;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ArrayList<Games> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.recyclerview.setHasFixedSize(true);

        list.addAll(getListHeroes());
        showRecyclerList();

        binding.aboutMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveIntent = new Intent(MainActivity.this, AboutMe.class);
                startActivity(moveIntent);
            }
        });
    }
    public ArrayList<Games> getListHeroes() {
        String[] dataName = getResources().getStringArray(R.array.game_name);
        String[] dataPrice = getResources().getStringArray(R.array.game_price);
        String[] dataRelease = getResources().getStringArray(R.array.game_release);
        String[] dataDescription = getResources().getStringArray(R.array.game_description);
        TypedArray dataImage = getResources().obtainTypedArray(R.array.game_img);
        ArrayList<Games> listHero = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Games games = new Games();
            games.setName(dataName[i]);
            games.setPrice(dataPrice[i]);
            games.setReleaseDate(dataRelease[i]);
            games.setDescription(dataDescription[i]);
            games.setImage(dataImage.getResourceId(i, -1));
            listHero.add(games);
        }
        return listHero;
    }

    private void showRecyclerList(){
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(this));

        ListGamesAdapter listHeroAdapter = new ListGamesAdapter(list);
        binding.recyclerview.setAdapter(listHeroAdapter);
    }

}