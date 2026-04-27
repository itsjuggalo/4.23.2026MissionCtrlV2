package com.amazon.device.iap.internal.a;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.amazon.a.a.i.h;

/* JADX INFO: loaded from: classes.dex */
public class a extends h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f9092b = "a";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f9093e = "http://www.amazon.com/gp/mas/get-appstore/android/ref=mas_mx_mba_iap_dl";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f9094f = "Amazon Appstore required";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f9095g = "Amazon Appstore Update Required";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final long f9096j = 31536000;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.a.a f9097h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.amazon.a.a.i.c f9098i;

    public a(com.amazon.a.a.i.c cVar) {
        super(cVar);
        this.f9098i = cVar;
    }

    @Override // com.amazon.a.a.e.c
    public long h() {
        return 31536000L;
    }

    @Override // com.amazon.a.a.i.h
    public void i() {
        com.amazon.device.iap.internal.util.b.a(f9092b, "doAction");
        if (f9094f.equalsIgnoreCase(this.f9098i.e()) || f9095g.equalsIgnoreCase(this.f9098i.e())) {
            try {
                Activity activityB = this.f9097h.b();
                if (activityB == null) {
                    activityB = this.f9097h.a();
                }
                activityB.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(f9093e)));
            } catch (Exception e4) {
                com.amazon.device.iap.internal.util.b.b(f9092b, "Exception in PurchaseItemCommandTask.OnSuccess: " + e4);
            }
        }
    }

    public String toString() {
        return f9092b;
    }
}
