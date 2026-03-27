package com.revenuecat.purchases.utils;

import android.content.Context;
import android.net.Uri;
import coil.request.ImageRequest;
import com.revenuecat.purchases.PurchasesOrchestrator;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class CoilImageDownloader {
    private final Context applicationContext;

    public CoilImageDownloader(Context applicationContext) {
        r.f(applicationContext, "applicationContext");
        this.applicationContext = applicationContext;
    }

    public final void downloadImage(Uri uri) {
        r.f(uri, "uri");
        PurchasesOrchestrator.Companion.getImageLoader(this.applicationContext).enqueue(new ImageRequest.Builder(this.applicationContext).data(uri).build());
    }
}
