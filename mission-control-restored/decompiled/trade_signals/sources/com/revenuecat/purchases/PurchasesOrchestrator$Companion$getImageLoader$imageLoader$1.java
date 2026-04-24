package com.revenuecat.purchases;

import android.content.Context;
import coil.disk.DiskCache;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.AbstractC2306v;
import z5.j;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcoil/disk/DiskCache;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class PurchasesOrchestrator$Companion$getImageLoader$imageLoader$1 extends AbstractC2306v implements Function0 {
    final /* synthetic */ String $cacheFolder;
    final /* synthetic */ Context $context;
    final /* synthetic */ long $maxCacheSizeBytes;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PurchasesOrchestrator$Companion$getImageLoader$imageLoader$1(Context context, String str, long j8) {
        super(0);
        this.$context = context;
        this.$cacheFolder = str;
        this.$maxCacheSizeBytes = j8;
    }

    @Override // kotlin.jvm.functions.Function0
    public final DiskCache invoke() {
        DiskCache.Builder builder = new DiskCache.Builder();
        File cacheDir = this.$context.getCacheDir();
        AbstractC2304t.e(cacheDir, "context.cacheDir");
        return builder.directory(j.h(cacheDir, this.$cacheFolder)).maxSizeBytes(this.$maxCacheSizeBytes).build();
    }
}
