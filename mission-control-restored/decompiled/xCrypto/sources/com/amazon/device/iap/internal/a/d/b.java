package com.amazon.device.iap.internal.a.d;

import com.amazon.a.a.n.a.h;
import com.amazon.d.a.j;
import com.amazon.device.iap.PurchasingService;
import com.amazon.device.iap.internal.a.c;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class b extends h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f9125d = "purchase_fulfilled";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Set<String> f9126b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final String f9127c;

    public b(c cVar, Set<String> set, String str) {
        super(cVar, f9125d, com.amazon.a.a.o.b.ah, cVar.d().toString(), PurchasingService.SDK_VERSION);
        this.f9126b = set;
        this.f9127c = str;
        b(false);
        a(com.amazon.a.a.o.b.f8732F, set);
        a(com.amazon.a.a.o.b.f8759g, str);
    }

    @Override // com.amazon.a.a.n.a.h
    public boolean b(j jVar) {
        return true;
    }

    @Override // com.amazon.a.a.n.a.h
    public void l() {
        Object objA = j().a().a(com.amazon.a.a.o.b.ao);
        if (objA != null && Boolean.FALSE.equals(objA)) {
            a(com.amazon.a.a.o.b.f8759g, com.amazon.device.iap.internal.model.a.DELIVERY_ATTEMPTED.toString());
        }
        super.l();
    }
}
