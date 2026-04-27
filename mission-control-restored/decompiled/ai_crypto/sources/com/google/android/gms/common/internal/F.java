package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public final class F extends H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Intent f11028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Activity f11029b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f11030c;

    public F(Intent intent, Activity activity, int i7) {
        this.f11028a = intent;
        this.f11029b = activity;
        this.f11030c = i7;
    }

    @Override // com.google.android.gms.common.internal.H
    public final void a() {
        Intent intent = this.f11028a;
        if (intent != null) {
            this.f11029b.startActivityForResult(intent, this.f11030c);
        }
    }
}
