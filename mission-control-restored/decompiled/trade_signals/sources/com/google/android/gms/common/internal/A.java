package com.google.android.gms.common.internal;

import S1.InterfaceC0876h;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public final class A extends B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Intent f14919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0876h f14920b;

    public A(Intent intent, InterfaceC0876h interfaceC0876h, int i8) {
        this.f14919a = intent;
        this.f14920b = interfaceC0876h;
    }

    @Override // com.google.android.gms.common.internal.B
    public final void a() {
        Intent intent = this.f14919a;
        if (intent != null) {
            this.f14920b.startActivityForResult(intent, 2);
        }
    }
}
