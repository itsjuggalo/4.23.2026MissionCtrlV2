package com.revenuecat.purchases.blockstore;

import com.google.android.gms.tasks.OnSuccessListener;
import i3.k;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class BlockstoreHelper$sam$com_google_android_gms_tasks_OnSuccessListener$0 implements OnSuccessListener {
    private final /* synthetic */ k function;

    public BlockstoreHelper$sam$com_google_android_gms_tasks_OnSuccessListener$0(k function) {
        r.f(function, "function");
        this.function = function;
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final /* synthetic */ void onSuccess(Object obj) {
        this.function.invoke(obj);
    }
}
