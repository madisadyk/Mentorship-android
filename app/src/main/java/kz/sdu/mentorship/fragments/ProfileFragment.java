package kz.sdu.mentorship.fragments;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.amulyakhare.textdrawable.TextDrawable;

import java.util.ArrayList;
import java.util.List;

import kz.sdu.mentorship.R;
import kz.sdu.mentorship.activities.SettingsActivity;
import kz.sdu.mentorship.adapters.ProfileCardsAdapter;
import kz.sdu.mentorship.adapters.ProfileSkillsAdapter;

public class ProfileFragment extends Fragment {
    private Context context;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        context = view.getContext();
        setDummyContent(view);
        initSkillRecyclerView(view);
        initEducationRecyclerView(view);
        initExperienceRecyclerView(view);
        initAchievementsRecyclerView(view);
        initLicensesRecyclerView(view);
        initLanguagesRecyclerView(view);
        setOnSettingsClickListener(view);
        return view;
    }

    private void setOnSettingsClickListener(View view) {
        Button settingsButon = view.findViewById(R.id.settings_button);
        settingsButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SettingsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initSkillRecyclerView(View view) {
        RecyclerView skillsView = view.findViewById(R.id.rv_skills);
        List<Integer> skillImages = generateDummyImages(R.drawable.dummy_skill, 10);
        ProfileSkillsAdapter skillsAdapter = new ProfileSkillsAdapter(skillImages);
        skillsView.setAdapter(skillsAdapter);
        skillsView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
    }

    private void initEducationRecyclerView(View view) {
        RecyclerView educationView = view.findViewById(R.id.rv_education);

        List<String> titles = new ArrayList<>();
        titles.add("Information Systems");
        titles.add("Pupil");

        List<List<String>> chips = new ArrayList<>();

        List<String> firstChips = new ArrayList<>();
        firstChips.add("GPA 3.95");
        firstChips.add("Bachelor");

        List<String> secondChips = new ArrayList<>();
        secondChips.add("GPA 4");
        chips.add(firstChips);
        chips.add(secondChips);

        List<String> timePeriods = new ArrayList<>();
        timePeriods.add("2018 – Present");
        timePeriods.add("2016 – 2018");

        setVerticalAdapter(educationView, titles, chips, timePeriods);
    }

    private void setVerticalAdapter(RecyclerView recyclerView, List<String> titles, List<List<String>> chips, List<String> timePeriods) {
        ProfileCardsAdapter cardsAdapter = new ProfileCardsAdapter(titles, chips, timePeriods);
        recyclerView.setAdapter(cardsAdapter);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
    }

    private void initExperienceRecyclerView(View view) {
        RecyclerView experienceView = view.findViewById(R.id.rv_experience);

        List<String> titles = new ArrayList<>();
        titles.add("Information Security");
        titles.add("System Administrator");

        List<List<String>> chips = new ArrayList<>();

        List<String> firstChips = new ArrayList<>();
        firstChips.add("Digital Generation");

        List<String> secondChips = new ArrayList<>();
        secondChips.add("Intern");

        chips.add(firstChips);
        chips.add(secondChips);

        List<String> timePeriods = new ArrayList<>();
        timePeriods.add("Jun 2020 – Aug 2020");
        timePeriods.add("May 2020 – Jun 2020");

        setVerticalAdapter(experienceView, titles, chips, timePeriods);
    }

    private void initAchievementsRecyclerView(View view) {
        RecyclerView achievementsView = view.findViewById(R.id.rv_achievements);

        List<String> titles = new ArrayList<>();
        titles.add("Hackathon");

        List<List<String>> chips = new ArrayList<>();
        List<String> firstChips = new ArrayList<>();
        firstChips.add("1st place");
        chips.add(firstChips);

        List<String> timePeriods = new ArrayList<>();
        timePeriods.add("Mar 2019");

        setVerticalAdapter(achievementsView, titles, chips, timePeriods);
    }

    private void initLicensesRecyclerView(View view) {
        RecyclerView licensesView = view.findViewById(R.id.rv_licenses);

        List<String> titles = new ArrayList<>();
        titles.add("Driver License");

        List<List<String>> chips = new ArrayList<>();
        List<String> firstChips = new ArrayList<>();
        firstChips.add("B category");
        chips.add(firstChips);

        List<String> timePeriods = new ArrayList<>();
        timePeriods.add("Sep 2019");

        setVerticalAdapter(licensesView, titles, chips, timePeriods);
    }

    private void initLanguagesRecyclerView(View view) {
        RecyclerView languagesView = view.findViewById(R.id.rv_languages);

        List<String> titles = new ArrayList<>();
        titles.add("Russian");
        titles.add("Kazakh");
        titles.add("English");

        List<List<String>> chips = new ArrayList<>();

        List<String> firstChips = new ArrayList<>();
        firstChips.add("Proficiency");

        List<String> secondChips = new ArrayList<>();
        secondChips.add("Native");

        List<String> thirdChips = new ArrayList<>();
        thirdChips.add("Pre-Intermediate");

        chips.add(firstChips);
        chips.add(secondChips);
        chips.add(thirdChips);

        List<String> timePeriods = new ArrayList<>();

        setVerticalAdapter(languagesView, titles, chips, timePeriods);
    }

    private List<Integer> generateDummyImages(int source, int count) {
        List<Integer> images = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            images.add(source);
        }
        return images;
    }

    private void setDummyContent(View view) {
        TextView nameView = view.findViewById(R.id.full_name);
        nameView.setText("Adil Akhmetov");
        TextView descriptionView = view.findViewById(R.id.description);
        descriptionView.setText("DevOps Engineer");
        TextView locationView = view.findViewById(R.id.location);
        locationView.setText("Almaty, Kazakhstan");
        TextView educationView = view.findViewById(R.id.education);
        educationView.setText("Suleyman Demirel University");
        setDefaultProfileImage(view, String.valueOf(nameView.getText().charAt(0)));
    }

    private void setDefaultProfileImage(View view, String firstLetter) {
        ImageView profileImage = view.findViewById(R.id.profile_image);
        TextDrawable drawable = TextDrawable.builder()
                .buildRound(firstLetter, Color.BLACK);
        profileImage.setImageDrawable(drawable);
    }
}
