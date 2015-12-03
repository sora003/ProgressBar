package com.sora.progressbar;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button add;
    private Button reduce;
    private Button reset;
    private ProgressBar progressBar;
    private EditText editText;
    private ProgressDialog progressDialog;
    private Button show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        init();
        add.setOnClickListener(new MyOnClickListener() {
            @Override
            public void onClick(View v) {
                super.onClick(v);
            }
        });
        reduce.setOnClickListener(new MyOnClickListener(){
            @Override
            public void onClick(View v) {
                super.onClick(v);
            }
        });
        reset.setOnClickListener(new MyOnClickListener(){
            @Override
            public void onClick(View v) {
                super.onClick(v);
            }
        });
        show.setOnClickListener(new MyOnClickListener(){
            @Override
            public void onClick(View v) {
                super.onClick(v);
            }
        });
    }

    private void init() {
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        add = (Button) findViewById(R.id.add);
        reduce = (Button) findViewById(R.id.reduce);
        reset = (Button) findViewById(R.id.reset);
        editText = (EditText) findViewById(R.id.editText);
        show = (Button) findViewById(R.id.show);

        int first = progressBar.getProgress();
        int second = progressBar.getSecondaryProgress();
        int max = progressBar.getMax();
        editText.setText("第一进度百分比："+(int)first/(float)max*100+"%    第二进度百分比："+(int)second/(float)max*100+"%");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private class MyOnClickListener implements OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.add:{
                    progressBar.incrementProgressBy(10);
                    progressBar.incrementSecondaryProgressBy(10);
                    break;
                }
                case R.id.reduce:{
                    progressBar.incrementProgressBy(-10);
                    progressBar.incrementSecondaryProgressBy(-10);
                    break;
                }
                case R.id.reset:{
                    progressBar.setProgress(50);
                    progressBar.setSecondaryProgress(80);
                    break;
                }
                case R.id.show:{
                    //页面显示风格
                    //新建ProgreeDialog对象
                    progressDialog = new ProgressDialog(MainActivity.this);
                    progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                    progressDialog.setTitle("我好方");
                    progressDialog.setMessage("我也很方");
                    progressDialog.setIcon(R.mipmap.ic_launcher);
                    //设定关于ProgressBar的一些属性
                    progressDialog.setMax(100);
                    progressDialog.incrementProgressBy(50);
                    progressDialog.setIndeterminate(false);
                    //设定一个确定按钮
                    progressDialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",new DialogInterface.OnClickListener(){

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this,"大家一起方",Toast.LENGTH_SHORT).show();
                        }
                    });
                    //设定取消按钮
                    progressDialog.setCancelable(true);
                    //显示ProgressDialog
                    progressDialog.show();
                    break;
                }
            }
            //editText.setText("第一进度百分比："+(int)(progressBar.getProgress()/(float)progressBar.getMax()*100)+
           //         "%    第二进度百分比："+(int)(progressBar.getSecondaryProgress()/(float)progressBar.getMax()*100)+"%");
        }
    }
}

