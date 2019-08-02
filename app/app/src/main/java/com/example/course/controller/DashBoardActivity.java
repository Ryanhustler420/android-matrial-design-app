package com.example.course.controller;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.course.R;
import com.example.course.data.CourseListAdaptor;

public class DashBoardActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    private CourseListAdaptor adaptor;
    private Menu menu;
    private boolean isListView = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        isListView = true;

        recyclerView = findViewById(R.id.courseRecyclerView);
        adaptor = new CourseListAdaptor();

        staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        recyclerView.setAdapter(adaptor);

        adaptor.setOnClickListener(new CourseListAdaptor.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                startActivity(newIntent(DashBoardActivity.this, position));
            }
        });
    }

    public Intent newIntent(Context ctx, int position) {
        Intent intent  = new Intent(ctx, DetailsActivity.class);
        intent.putExtra("course_id", position);
        return intent;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        this.menu = menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_toggle) {
            toggle();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void toggle() {
        if(isListView) {
            showGridView();
        }else {
            showListView();
        }
    }

    private void showListView() {
        staggeredGridLayoutManager.setSpanCount(1);
        MenuItem item = menu.findItem(R.id.action_toggle);
        item.setIcon(R.drawable.grid);
        item.setTitle(getString(R.string.action_show_as_grid));
        this.isListView = !this.isListView;
    }

    private void showGridView() {
        staggeredGridLayoutManager.setSpanCount(2);
        MenuItem item = menu.findItem(R.id.action_toggle);
        item.setIcon(R.drawable.bars);
        item.setTitle(getString(R.string.action_show_as_list));
        this.isListView = !this.isListView;
    }
}
