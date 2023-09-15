package bagasekaz.projects.dicodingpemula;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import bagasekaz.projects.dicodingpemula.databinding.ActivityAboutMeBinding;

public class AboutMe extends AppCompatActivity {

    private ActivityAboutMeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAboutMeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}