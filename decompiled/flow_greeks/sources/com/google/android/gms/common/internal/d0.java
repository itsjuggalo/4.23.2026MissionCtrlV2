package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d0 extends f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Intent f5672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Activity f5673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5674c;

    public d0(Intent intent, Activity activity, int i10) {
        this.f5672a = intent;
        this.f5673b = activity;
        this.f5674c = i10;
    }

    @Override // com.google.android.gms.common.internal.f0
    public final void a() {
        Intent intent = this.f5672a;
        if (intent != null) {
            this.f5673b.startActivityForResult(intent, this.f5674c);
        }
    }
}
