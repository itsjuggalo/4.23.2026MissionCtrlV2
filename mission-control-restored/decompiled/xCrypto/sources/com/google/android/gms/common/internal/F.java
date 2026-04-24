package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public final class F extends H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Intent f9845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Activity f9846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f9847c;

    public F(Intent intent, Activity activity, int i4) {
        this.f9845a = intent;
        this.f9846b = activity;
        this.f9847c = i4;
    }

    @Override // com.google.android.gms.common.internal.H
    public final void a() {
        Intent intent = this.f9845a;
        if (intent != null) {
            this.f9846b.startActivityForResult(intent, this.f9847c);
        }
    }
}
