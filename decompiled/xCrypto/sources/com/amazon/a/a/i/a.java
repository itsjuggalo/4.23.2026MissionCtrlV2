package com.amazon.a.a.i;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public class a extends h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f8473b = "a";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f8474e = "http://www.amazon.com/gp/mas/get-appstore/android/ref=mas_mx_mba_iap_dl";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f8475f = "Amazon Appstore required";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f8476g = "Amazon Appstore Update Required";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final long f8477j = 31536000;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.a.a f8478h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final c f8479i;

    public a(c cVar) {
        super(cVar);
        this.f8479i = cVar;
    }

    @Override // com.amazon.a.a.e.c
    public long h() {
        return 31536000L;
    }

    @Override // com.amazon.a.a.i.h
    public void i() {
        if (f8475f.equalsIgnoreCase(this.f8479i.e()) || f8476g.equalsIgnoreCase(this.f8479i.e())) {
            try {
                Activity activityB = this.f8478h.b();
                if (activityB == null) {
                    activityB = this.f8478h.a();
                }
                activityB.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(f8474e)));
            } catch (Exception unused) {
            }
        }
    }

    public String toString() {
        return f8473b;
    }
}
