package com.amazon.device.iap.internal.a;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.amazon.a.a.i.h;

/* JADX INFO: loaded from: classes.dex */
public class a extends h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f14388b = "a";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f14389e = "http://www.amazon.com/gp/mas/get-appstore/android/ref=mas_mx_mba_iap_dl";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f14390f = "Amazon Appstore required";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f14391g = "Amazon Appstore Update Required";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final long f14392j = 31536000;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.a.a f14393h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.amazon.a.a.i.c f14394i;

    public a(com.amazon.a.a.i.c cVar) {
        super(cVar);
        this.f14394i = cVar;
    }

    @Override // com.amazon.a.a.e.c
    public long h() {
        return 31536000L;
    }

    @Override // com.amazon.a.a.i.h
    public void i() {
        com.amazon.device.iap.internal.util.b.a(f14388b, "doAction");
        if (f14390f.equalsIgnoreCase(this.f14394i.e()) || f14391g.equalsIgnoreCase(this.f14394i.e())) {
            try {
                Activity activityB = this.f14393h.b();
                if (activityB == null) {
                    activityB = this.f14393h.a();
                }
                activityB.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(f14389e)));
            } catch (Exception e8) {
                com.amazon.device.iap.internal.util.b.b(f14388b, "Exception in PurchaseItemCommandTask.OnSuccess: " + e8);
            }
        }
    }

    public String toString() {
        return f14388b;
    }
}
