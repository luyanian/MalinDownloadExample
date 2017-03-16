package com.malin.download.example.download_manager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.malin.download.MalinDownload;
import com.malin.download.entity.DownloadRecord;
import com.malin.download.example.R;
import com.malin.download.function.Utils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import zlc.season.practicalrecyclerview.PracticalRecyclerView;

public class DownloadManagerActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.recycler)
    PracticalRecyclerView mRecycler;

    private DownloadAdapter mAdapter;
    private MalinDownload rxDownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_manager);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

        rxDownload = MalinDownload.getInstance(this);

        mAdapter = new DownloadAdapter();
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mRecycler.setAdapterWithLoading(mAdapter);
        loadData();
    }

    @OnClick({R.id.start, R.id.pause})
    public void onClick(View view) {
        List<DownloadItem> list = mAdapter.getData();
        switch (view.getId()) {
            case R.id.start:
                for (DownloadItem each : list) {
                    rxDownload.serviceDownload(each.record.getUrl())
                            .subscribe(new Consumer<Object>() {
                                @Override
                                public void accept(Object o) throws Exception {

                                }
                            }, new Consumer<Throwable>() {
                                @Override
                                public void accept(Throwable throwable) throws Exception {
                                    Utils.log(throwable);
                                }
                            });
                }
                break;
            case R.id.pause:
                for (DownloadItem each : list) {
                    rxDownload.pauseServiceDownload(each.record.getUrl())
                            .subscribe(new Consumer<Object>() {
                                @Override
                                public void accept(Object o) throws Exception {

                                }
                            }, new Consumer<Throwable>() {
                                @Override
                                public void accept(Throwable throwable) throws Exception {
                                    Utils.log(throwable);
                                }
                            });
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        List<DownloadItem> list = mAdapter.getData();
        for (DownloadItem each : list) {
            Utils.dispose(each.disposable);
        }
    }

    private void loadData() {
        List<DownloadRecord> downloadRecords = MalinDownload.getInstance(this).getTotalDownloadRecords();
        List<DownloadItem> result = new ArrayList<>();
        for (DownloadRecord each : downloadRecords) {
            DownloadItem bean = new DownloadItem();
            bean.record = each;
            result.add(bean);
        }
        mAdapter.addAll(result);
    }
}
