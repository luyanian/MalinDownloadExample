package com.malin.download.entity;

/**
 * Author: luyanian(luyanian@foxmail.com)
 * Date: 2017/03/16
 * FIXME
 */
public class DownloadEvent {
    private int flag = DownloadFlag.NORMAL;
    private DownloadStatus downloadStatus = new DownloadStatus();
    private Throwable mError;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public DownloadStatus getDownloadStatus() {
        return downloadStatus;
    }

    public void setDownloadStatus(DownloadStatus downloadStatus) {
        this.downloadStatus = downloadStatus;
    }

    public Throwable getError() {
        return mError;
    }

    public void setError(Throwable error) {
        mError = error;
    }
}
