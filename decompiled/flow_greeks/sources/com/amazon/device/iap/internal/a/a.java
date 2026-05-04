package com.amazon.device.iap.internal.a;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.amazon.a.a.i.h;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a extends h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f4886b = "a";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f4887e = "http://www.amazon.com/gp/mas/get-appstore/android/ref=mas_mx_mba_iap_dl";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f4888f = "Amazon Appstore required";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f4889g = "Amazon Appstore Update Required";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final long f4890j = 31536000;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.a.a f4891h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.amazon.a.a.i.c f4892i;

    public a(com.amazon.a.a.i.c cVar) {
        super(cVar);
        this.f4892i = cVar;
    }

    @Override // com.amazon.a.a.e.c
    public long h() {
        return 31536000L;
    }

    @Override // com.amazon.a.a.i.h
    public void i() {
        com.amazon.device.iap.internal.util.b.a(f4886b, "doAction");
        if (f4888f.equalsIgnoreCase(this.f4892i.e()) || f4889g.equalsIgnoreCase(this.f4892i.e())) {
            try {
                Activity activityB = this.f4891h.b();
                if (activityB == null) {
                    activityB = this.f4891h.a();
                }
                activityB.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(f4887e)));
            } catch (Exception e10) {
                com.amazon.device.iap.internal.util.b.b(f4886b, "Exception in PurchaseItemCommandTask.OnSuccess: " + e10);
            }
        }
    }

    public String toString() {
        return f4886b;
    }
}
