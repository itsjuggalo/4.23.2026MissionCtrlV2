package com.revenuecat.purchases.utils;

import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public interface UrlConnection {
    void disconnect();

    InputStream getInputStream();

    int getResponseCode();
}
