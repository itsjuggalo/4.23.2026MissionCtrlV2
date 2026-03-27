package com.google.android.gms.common.internal;

import android.content.Intent;
import com.google.android.gms.common.api.internal.InterfaceC1174k;

/* JADX INFO: loaded from: classes.dex */
public final class G extends H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Intent f11031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ InterfaceC1174k f11032b;

    public G(Intent intent, InterfaceC1174k interfaceC1174k, int i7) {
        this.f11031a = intent;
        this.f11032b = interfaceC1174k;
    }

    @Override // com.google.android.gms.common.internal.H
    public final void a() {
        Intent intent = this.f11031a;
        if (intent != null) {
            this.f11032b.startActivityForResult(intent, 2);
        }
    }
}
