package com.google.android.gms.common.internal;

import android.content.Intent;
import com.google.android.gms.common.api.internal.InterfaceC0908l;

/* JADX INFO: loaded from: classes.dex */
public final class G extends H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Intent f9848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0908l f9849b;

    public G(Intent intent, InterfaceC0908l interfaceC0908l, int i4) {
        this.f9848a = intent;
        this.f9849b = interfaceC0908l;
    }

    @Override // com.google.android.gms.common.internal.H
    public final void a() {
        Intent intent = this.f9848a;
        if (intent != null) {
            this.f9849b.startActivityForResult(intent, 2);
        }
    }
}
