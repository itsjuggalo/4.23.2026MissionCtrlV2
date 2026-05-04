package com.amazon.device.iap.internal.a.b;

import com.amazon.a.a.n.a.h;
import com.amazon.device.iap.PurchasingService;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
abstract class b extends h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final String f4898b = "purchase_updates";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final boolean f4899c;

    public b(com.amazon.device.iap.internal.a.c cVar, String str, boolean z10) {
        super(cVar, f4898b, str, cVar.d().toString(), PurchasingService.SDK_VERSION);
        this.f4899c = z10;
    }

    @Override // com.amazon.a.a.n.a.a
    public void e() {
        super.e();
        a("cursor", this.f4899c ? null : com.amazon.device.iap.internal.util.a.a((String) ((com.amazon.device.iap.internal.a.c) j()).a().a("userId")));
        a(com.amazon.a.a.o.b.f4542ac, Boolean.valueOf(com.amazon.device.iap.internal.d.f().d()));
    }
}
