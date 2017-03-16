package com.malin.download.example.download_manager;

import com.malin.download.entity.DownloadRecord;

import io.reactivex.disposables.Disposable;
import zlc.season.practicalrecyclerview.ItemType;

/**
 * Author: Season(ssseasonnn@gmail.com)
 * Date: 2016/10/28
 * Time: 09:30
 * FIXME
 */
public class DownloadItem implements ItemType {
    Disposable disposable;
    DownloadRecord record;

    @Override
    public int itemType() {
        return 0;
    }
}
