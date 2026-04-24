package com.google.firebase.storage;

import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.OnCanceledListener;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class u implements OnCanceledListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CancellationTokenSource f12500a;

    @Override // com.google.android.gms.tasks.OnCanceledListener
    public final void onCanceled() {
        this.f12500a.cancel();
    }
}
