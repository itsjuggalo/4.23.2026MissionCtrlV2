package com.amazon.device.iap.internal.a;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.amazon.a.a.i.h;

/* JADX INFO: loaded from: classes.dex */
public class a extends h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f10277b = "a";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f10278e = "http://www.amazon.com/gp/mas/get-appstore/android/ref=mas_mx_mba_iap_dl";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f10279f = "Amazon Appstore required";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f10280g = "Amazon Appstore Update Required";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final long f10281j = 31536000;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.a.a f10282h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.amazon.a.a.i.c f10283i;

    public a(com.amazon.a.a.i.c cVar) {
        super(cVar);
        this.f10283i = cVar;
    }

    @Override // com.amazon.a.a.e.c
    public long h() {
        return 31536000L;
    }

    @Override // com.amazon.a.a.i.h
    public void i() {
        com.amazon.device.iap.internal.util.b.a(f10277b, "doAction");
        if (f10279f.equalsIgnoreCase(this.f10283i.e()) || f10280g.equalsIgnoreCase(this.f10283i.e())) {
            try {
                Activity activityB = this.f10282h.b();
                if (activityB == null) {
                    activityB = this.f10282h.a();
                }
                activityB.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(f10278e)));
            } catch (Exception e7) {
                com.amazon.device.iap.internal.util.b.b(f10277b, "Exception in PurchaseItemCommandTask.OnSuccess: " + e7);
            }
        }
    }

    public String toString() {
        return f10277b;
    }
}
