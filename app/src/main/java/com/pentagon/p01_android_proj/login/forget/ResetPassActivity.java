package com.pentagon.p01_android_proj.login.forget;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pentagon.p01_android_proj.R;

public class ResetPassActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout editLayout;
    private Toolbar toolbar;
    private ImageView rainbowImage;
    private EditText userAccountEdit;
    private EditText userPasswordEdit;
    private FloatingActionButton fab;
    private TextView registerText;
    private TextView forgetText;
    private LinearLayout wrongLayout;
    private TextView wrongTipsTextView;
    private TextView wrongOkTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_pass);
        initViews();
        loadImage();
        iniToolBar();
    }

    private void initViews() {
        editLayout = findViewById(R.id.edit_layout);
        toolbar = findViewById(R.id.toolbar);
        rainbowImage = findViewById(R.id.rainbow);
        userAccountEdit = findViewById(R.id.usr_account);
        userPasswordEdit = findViewById(R.id.usr_password);
        fab = findViewById(R.id.login);
        registerText = findViewById(R.id.register);
        wrongLayout = findViewById(R.id.wrong);
        wrongTipsTextView = findViewById(R.id.wrong_tips);
        wrongOkTextView = findViewById(R.id.wrong_ok);

        toolbar.setOnClickListener(this);
        userAccountEdit.setOnClickListener(this);
        userPasswordEdit.setOnClickListener(this);
        editLayout.setOnClickListener(this);
    }

    private void loadImage() {

        RequestOptions options = new RequestOptions()
                .centerCrop()
                //.placeholder(R.mipmap.ic_launcher_round)
                .error(android.R.drawable.stat_notify_error)
                .priority(Priority.HIGH)
                //.skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);

        Glide.with(this)
                .load(R.drawable.rainbow)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        return false;
                    }
                })
                .apply(options)
                //.thumbnail(Glide.with(this).load(R.mipmap.ic_launcher))
                .into(rainbowImage);
    }

    private void iniToolBar() {
        toolbar.setTitleTextColor(getResources().getColor(R.color.deepskyblue));
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Back");
    }

    public void resetEvent(View view) {
        if (userAccountEdit.getText().toString() == null || userAccountEdit.getText().toString().equals("")) {
            wrongTipsTextView.setText("账号不能为空");
            wrongLayout.setVisibility(View.VISIBLE);
            toolbar.setEnabled(false);
            userAccountEdit.setEnabled(false);
            userPasswordEdit.setEnabled(false);
            editLayout.setEnabled(false);
            return;
        }
        if (userPasswordEdit.getText().toString() == null || userPasswordEdit.getText().toString().equals("")) {
            wrongTipsTextView.setText("密码不能为空");
            wrongLayout.setVisibility(View.VISIBLE);
            toolbar.setEnabled(false);
            userAccountEdit.setEnabled(false);
            userPasswordEdit.setEnabled(false);
            editLayout.setEnabled(false);
            return;
        }
        Toast.makeText(this, "register", Toast.LENGTH_SHORT).show();
        finish();
    }

    public void tipsLayoutGone(View view) {
        wrongLayout.setVisibility(View.GONE);
        toolbar.setEnabled(true);
        userAccountEdit.setEnabled(true);
        userPasswordEdit.setEnabled(true);
        editLayout.setEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            if (wrongLayout.getVisibility() == View.VISIBLE) {
                return true;
            }
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

    }

}