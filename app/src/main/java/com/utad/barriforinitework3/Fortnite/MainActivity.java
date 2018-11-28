package com.utad.barriforinitework3.Fortnite;
import android.arch.lifecycle.ViewModelProviders;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.EditText;
import android.widget.Spinner;

import com.utad.barriforinitework3.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText mNickname_fortnite;
    private Spinner mSpinner;
    private MyAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private FloatingActionButton mButton;
    private ViewModelFortnite mViewModelFortnite;
    private String mPlatformGame;
    private String mEpic_nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNickname_fortnite = findViewById(R.id.userName);
        mSpinner = findViewById(R.id.spinnerPlatform);
        mButton = findViewById(R.id.button);
        changeData("","");
        onclick();

    }

    private void changeData(String platformGame,String epic_nickname){
        mViewModelFortnite = ViewModelProviders.of(this).get(ViewModelFortnite.class);
        mViewModelFortnite.fortniteData.observe(this, stadisticObjectData -> {
            if(stadisticObjectData!=null){
                Log.d("ServicioFornite","Cambios: "+stadisticObjectData);
                generateForniteList(stadisticObjectData);
            }
        });
        mViewModelFortnite.getData(platformGame, epic_nickname);
    }

    private void generateForniteList(List<RankFortnite> listFornite) {
        mRecyclerView = findViewById(R.id.recycleviewCard);
        mAdapter = new MyAdapter(listFornite);
        mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void onclick(){
        mButton.setOnClickListener(v -> {
            mPlatformGame = mSpinner.getSelectedItem().toString();
            mEpic_nickname = mNickname_fortnite.getText().toString();
            mViewModelFortnite.getData(mPlatformGame, mEpic_nickname);

        });

    }
}
