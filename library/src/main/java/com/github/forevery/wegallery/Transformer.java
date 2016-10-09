package com.github.forevery.wegallery;

import android.view.View;
import android.view.ViewGroup;



public interface Transformer {

    void apply(ViewGroup sideBar, View itemView, float touchY, float slideOffset, boolean isLeft);
}
