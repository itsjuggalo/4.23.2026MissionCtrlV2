package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.h;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class s extends h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f5620a;

    public s(e eVar) {
        this.f5620a = eVar;
    }

    @Override // com.google.android.gms.common.api.internal.h
    public void onResult(Status status) {
        this.f5620a.setResult(status);
    }
}
