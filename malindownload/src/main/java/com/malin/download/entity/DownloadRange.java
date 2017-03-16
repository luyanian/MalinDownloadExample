package com.malin.download.entity;

/**
 * Author: luyanian(luyanian@foxmail.com)
 * Date: 2017/03/16
 * Download Range
 */
public class DownloadRange {
    public long start;
    public long end;
    public long size;

    public DownloadRange(long start, long end) {
        this.start = start;
        this.end = end;
        this.size = end - start + 1;
    }

    public boolean legal() {
        return start <= end;
    }
}
