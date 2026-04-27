package com.amazon.device.iap.internal.a.e;

import android.app.Activity;
import android.content.Intent;
import com.amazon.a.a.n.a.h;
import com.amazon.d.a.j;
import com.amazon.device.iap.PurchasingService;
import com.amazon.device.iap.internal.util.MetricsHelper;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
abstract class a extends h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final String f9131b = "purchase_item";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f9132f = "a";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.amazon.a.a.k.a
    protected com.amazon.a.a.n.b f9133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @com.amazon.a.a.k.a
    protected com.amazon.a.a.a.a f9134d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final String f9135e;

    public a(com.amazon.device.iap.internal.a.c cVar, String str, String str2) {
        super(cVar, f9131b, str, cVar.d().toString(), PurchasingService.SDK_VERSION);
        this.f9135e = str2;
        boolean zD = com.amazon.device.iap.internal.d.f().d();
        a("sku", str2);
        a(com.amazon.a.a.o.b.ac, Boolean.valueOf(zD));
    }

    @Override // com.amazon.a.a.n.a.h
    public boolean b(j jVar) {
        Map mapB = jVar.b();
        String str = f9132f;
        com.amazon.device.iap.internal.util.b.a(str, "data: " + mapB);
        if (!mapB.containsKey(com.amazon.a.a.o.b.f8778z)) {
            com.amazon.device.iap.internal.util.b.b(str, "did not find intent");
            return false;
        }
        com.amazon.device.iap.internal.util.b.a(str, "found intent");
        final Intent intent = (Intent) mapB.remove(com.amazon.a.a.o.b.f8778z);
        this.f9133c.b(com.amazon.a.a.n.b.d.FOREGROUND, new com.amazon.a.a.n.a() { // from class: com.amazon.device.iap.internal.a.e.a.1
            @Override // com.amazon.a.a.n.a
            public void a() {
                try {
                    Activity activityB = a.this.f9134d.b();
                    if (activityB == null) {
                        activityB = a.this.f9134d.a();
                    }
                    com.amazon.device.iap.internal.util.b.a(a.f9132f, "About to fire intent with activity " + activityB);
                    activityB.startActivity(intent);
                } catch (Exception e4) {
                    MetricsHelper.submitExceptionMetrics(a.this.k(), a.f9132f + ".onResult().execute()", e4);
                    com.amazon.device.iap.internal.util.b.b(a.f9132f, "Exception when attempting to fire intent: " + e4);
                }
            }
        });
        return true;
    }
}
