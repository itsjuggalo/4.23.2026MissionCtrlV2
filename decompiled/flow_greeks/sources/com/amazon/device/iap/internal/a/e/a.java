package com.amazon.device.iap.internal.a.e;

import android.app.Activity;
import android.content.Intent;
import com.amazon.a.a.n.a.h;
import com.amazon.d.a.j;
import com.amazon.device.iap.PurchasingService;
import com.amazon.device.iap.internal.util.MetricsHelper;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
abstract class a extends h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final String f4925b = "purchase_item";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f4926f = "a";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.amazon.a.a.k.a
    protected com.amazon.a.a.n.b f4927c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @com.amazon.a.a.k.a
    protected com.amazon.a.a.a.a f4928d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final String f4929e;

    public a(com.amazon.device.iap.internal.a.c cVar, String str, String str2) {
        super(cVar, f4925b, str, cVar.d().toString(), PurchasingService.SDK_VERSION);
        this.f4929e = str2;
        boolean zD = com.amazon.device.iap.internal.d.f().d();
        a("sku", str2);
        a(com.amazon.a.a.o.b.f4542ac, Boolean.valueOf(zD));
    }

    @Override // com.amazon.a.a.n.a.h
    public boolean b(j jVar) {
        Map mapB = jVar.b();
        String str = f4926f;
        com.amazon.device.iap.internal.util.b.a(str, "data: " + mapB);
        if (!mapB.containsKey(com.amazon.a.a.o.b.f4572z)) {
            com.amazon.device.iap.internal.util.b.b(str, "did not find intent");
            return false;
        }
        com.amazon.device.iap.internal.util.b.a(str, "found intent");
        final Intent intent = (Intent) mapB.remove(com.amazon.a.a.o.b.f4572z);
        this.f4927c.b(com.amazon.a.a.n.b.d.FOREGROUND, new com.amazon.a.a.n.a() { // from class: com.amazon.device.iap.internal.a.e.a.1
            @Override // com.amazon.a.a.n.a
            public void a() {
                try {
                    Activity activityB = a.this.f4928d.b();
                    if (activityB == null) {
                        activityB = a.this.f4928d.a();
                    }
                    com.amazon.device.iap.internal.util.b.a(a.f4926f, "About to fire intent with activity " + activityB);
                    activityB.startActivity(intent);
                } catch (Exception e10) {
                    MetricsHelper.submitExceptionMetrics(a.this.k(), a.f4926f + ".onResult().execute()", e10);
                    com.amazon.device.iap.internal.util.b.b(a.f4926f, "Exception when attempting to fire intent: " + e10);
                }
            }
        });
        return true;
    }
}
