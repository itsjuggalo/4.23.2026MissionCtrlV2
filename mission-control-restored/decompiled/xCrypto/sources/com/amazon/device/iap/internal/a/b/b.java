package com.amazon.device.iap.internal.a.b;

import com.amazon.a.a.n.a.h;
import com.amazon.device.iap.PurchasingService;

/* JADX INFO: loaded from: classes.dex */
abstract class b extends h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final String f9104b = "purchase_updates";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final boolean f9105c;

    public b(com.amazon.device.iap.internal.a.c cVar, String str, boolean z4) {
        super(cVar, f9104b, str, cVar.d().toString(), PurchasingService.SDK_VERSION);
        this.f9105c = z4;
    }

    @Override // com.amazon.a.a.n.a.a
    public void e() {
        super.e();
        a(com.amazon.a.a.o.b.f8754b, this.f9105c ? null : com.amazon.device.iap.internal.util.a.a((String) ((com.amazon.device.iap.internal.a.c) j()).a().a("userId")));
        a(com.amazon.a.a.o.b.ac, Boolean.valueOf(com.amazon.device.iap.internal.d.f().d()));
    }
}
