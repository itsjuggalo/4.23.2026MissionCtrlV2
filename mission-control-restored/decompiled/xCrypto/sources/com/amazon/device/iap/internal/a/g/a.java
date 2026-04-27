package com.amazon.device.iap.internal.a.g;

import com.amazon.a.a.n.a.h;
import com.amazon.d.a.j;
import com.amazon.device.iap.PurchasingService;

/* JADX INFO: loaded from: classes.dex */
abstract class a extends h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final String f9145b = "response_received";

    public a(com.amazon.device.iap.internal.a.c cVar, String str) {
        super(cVar, f9145b, str, cVar.d().toString(), PurchasingService.SDK_VERSION);
        b(false);
    }

    @Override // com.amazon.a.a.n.a.h
    public boolean b(j jVar) {
        return true;
    }
}
