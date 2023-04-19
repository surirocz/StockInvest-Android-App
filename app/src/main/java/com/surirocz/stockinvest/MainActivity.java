package com.surirocz.stockinvest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.surirocz.stockinvest.modules.LocalStorage;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    private static final int TRIGGER_AUTO_COMPLETE = 100;
    private static final long AUTO_COMPLETE_DELAY = 300;
    private static final long AUTO_REFRESH_PERIOD_MSEC = 15000;

    public static final String EXTRA_TICKER = "com.example.csci571andriodstocks.MESSAGE";
    public static final String SEARCH_URL = "https://csci571-trading-platform.wl.r.appspot.com/api/search/";
    public static final String PRICE_URL = "https://csci571-trading-platform.wl.r.appspot.com/api/price/";
    public static final int TOT_API_CALLS = 2;

    private RecyclerView recyclerView;
    private NestedScrollView homeViewContainer;
    private TextView date;
    private Context ctx;
    private View spinnerContainer;
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;
    private int numApiCalls;
    private boolean isApiFailed;
    private Timer timer;
    private boolean isSelectedFromList;
    private LocalStorage storage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences(LocalStorage.SHARED_PREFS_FILE, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        storage = new LocalStorage(sharedPreferences, editor);

        Toolbar myToolbar = findViewById(R.id.mToolbar);
        setSupportActionBar(myToolbar);

    }
}