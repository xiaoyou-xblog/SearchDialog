package com.wyt.searchdialog;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.wyt.searchbox.SearchFragment;
import com.wyt.searchbox.custom.IOnSearchClickListener;
import com.wyt.searchbox.entity.CustomLink;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener, IOnSearchClickListener<String> {

    Toolbar toolbar;
    TextView searchInfo;

    private SearchFragment<String> searchFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 设置控件
        toolbar=findViewById(R.id.toolbar);
        searchInfo=findViewById(R.id.search_info);

        toolbar.setTitle("SearchDialog");//标题
        setSupportActionBar(toolbar);

        searchFragment = new SearchFragment<>();
        toolbar.setOnMenuItemClickListener(this);
        searchFragment.setOnSearchClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //加载菜单文件
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        // 点击搜索按钮
        if (item.getItemId() == R.id.action_search) {
            searchFragment.showFragment(getSupportFragmentManager(), SearchFragment.TAG);
        }
        return true;
    }

    @Override
    public void onSearchClick(String keyword) {
        searchInfo.setText(keyword);
    }

    /**
     * 点击链接时触发
     * @param data 链接携带的数据
     */
    @Override
    public void onLinkClick(String data) {
        searchInfo.setText(data);
    }


    @Override
    public void onTextChange(String key) {
        // 我们来设置一下数据
        List<CustomLink<String>> data = new ArrayList<>();
        data.add(new CustomLink<>("链接1","数据1"));
        data.add(new CustomLink<>("链接2","数据2"));
        data.add(new CustomLink<>("链接3","数据3"));
        searchFragment.setLinks(data);
    }
}
