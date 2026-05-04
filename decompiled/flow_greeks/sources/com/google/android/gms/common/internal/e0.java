package com.google.android.gms.common.internal;

import android.content.Intent;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e0 extends f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Intent f5692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.common.api.internal.k f5693b;

    public e0(Intent intent, com.google.android.gms.common.api.internal.k kVar, int i10) {
        this.f5692a = intent;
        this.f5693b = kVar;
    }

    @Override // com.google.android.gms.common.internal.f0
    public final void a() {
        Intent intent = this.f5692a;
        if (intent != null) {
            this.f5693b.startActivityForResult(intent, 2);
        }
    }
}
