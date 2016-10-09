package com.github.forevery.wegallery;

import android.support.annotation.Nullable;
import android.view.View;


public class SimpleFantasyListener implements FantasyListener {
    @Override
    public boolean onHover(@Nullable View view) {
        return false;
    }

    @Override
    public boolean onSelect(View view) {
        return false;
    }

    @Override
    public void onCancel() {

    }
}
