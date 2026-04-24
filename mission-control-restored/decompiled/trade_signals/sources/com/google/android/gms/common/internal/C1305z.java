package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1305z extends B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Intent f15060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Activity f15061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f15062c;

    public C1305z(Intent intent, Activity activity, int i8) {
        this.f15060a = intent;
        this.f15061b = activity;
        this.f15062c = i8;
    }

    @Override // com.google.android.gms.common.internal.B
    public final void a() {
        Intent intent = this.f15060a;
        if (intent != null) {
            this.f15061b.startActivityForResult(intent, this.f15062c);
        }
    }
}
