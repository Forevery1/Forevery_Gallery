package com.github.forevery.wegallery.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.github.forevery.wegallery.gallery.Gallery_bt_MainActivity;
import com.github.forevery.wegallery.gallery.Gallery_jn_MainActivity;
import com.github.forevery.wegallery.gallery.Gallery_qz_MainActivity;
import com.github.forevery.wegallery.gallery.Gallery_wm_MainActivity;
import com.github.forevery.wegallery.gallery.Gallery_xmv_MainActivity;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.Utils;
import me.imid.swipebacklayout.lib.app.SwipeBackActivityBase;
import me.imid.swipebacklayout.lib.app.SwipeBackActivityHelper;

public class UniversalActivity extends AppCompatActivity implements SwipeBackActivityBase {

    private static String activitytitle;
    private SwipeBackActivityHelper swipeBackActivityHelper;

    public static Intent newIntent(Context context, String title) {
        Intent intent = new Intent(context, UniversalActivity.class);
        intent.putExtra("title", title);
        return intent;
    }
    public static void gett(String title){
       activitytitle= title;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        swipeBackActivityHelper = new SwipeBackActivityHelper(this);
        swipeBackActivityHelper.onActivityCreate();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent_bt = new Intent(this, Gallery_bt_MainActivity.class);
        Intent intent_qz = new Intent(this, Gallery_qz_MainActivity.class);
        Intent intent_xmv = new Intent(this, Gallery_xmv_MainActivity.class);
        Intent intent_jn = new Intent(this, Gallery_jn_MainActivity.class);
        Intent intent_wm = new Intent(this, Gallery_wm_MainActivity.class);
        setTitle(getIntent().getStringExtra("title"));
        if (activitytitle.equals("个人中心"))
            setContentView(R.layout.we_activity);
        if (activitytitle.equals("包头")){
            startActivity(intent_bt);
            finish();
        }
        if (activitytitle.equals("集宁")){
            startActivity(intent_jn);
            finish();
        }
        if (activitytitle.equals("气质美女")){
            startActivity(intent_qz);
            finish();
        }
        if (activitytitle.equals("小美女")){
            startActivity(intent_xmv);
            finish();
        }
        if (activitytitle.equals("我们")){
            startActivity(intent_wm);
            finish();
        }
}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return true;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        swipeBackActivityHelper.onPostCreate();
    }

    @Override
    public View findViewById(int id) {
        View v = super.findViewById(id);
        if (v == null && swipeBackActivityHelper != null)
            return swipeBackActivityHelper.findViewById(id);
        return v;
    }

    @Override
    public SwipeBackLayout getSwipeBackLayout() {
        return swipeBackActivityHelper.getSwipeBackLayout();
    }

    @Override
    public void setSwipeBackEnable(boolean enable) {
        getSwipeBackLayout().setEnableGesture(enable);
    }

    @Override
    public void scrollToFinishActivity() {
        Utils.convertActivityToTranslucent(this);
        getSwipeBackLayout().scrollToFinishActivity();
    }
}
