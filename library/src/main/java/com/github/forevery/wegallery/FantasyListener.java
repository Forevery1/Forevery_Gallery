package com.github.forevery.wegallery;

import android.support.annotation.Nullable;
import android.view.View;



public interface FantasyListener {

    boolean onHover(@Nullable View view);

    boolean onSelect(View view);

    void onCancel();
}
