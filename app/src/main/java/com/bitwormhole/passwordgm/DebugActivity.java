package com.bitwormhole.passwordgm;

import android.os.Bundle;

import androidx.annotation.Nullable;

public class DebugActivity extends PgmActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_debug);
    }
}