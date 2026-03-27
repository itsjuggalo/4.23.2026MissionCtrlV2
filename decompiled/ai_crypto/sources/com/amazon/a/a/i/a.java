package com.amazon.a.a.i;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public class a extends h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f9658b = "a";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f9659e = "http://www.amazon.com/gp/mas/get-appstore/android/ref=mas_mx_mba_iap_dl";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f9660f = "Amazon Appstore required";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f9661g = "Amazon Appstore Update Required";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final long f9662j = 31536000;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.a.a f9663h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final c f9664i;

    public a(c cVar) {
        super(cVar);
        this.f9664i = cVar;
    }

    @Override // com.amazon.a.a.e.c
    public long h() {
        return 31536000L;
    }

    @Override // com.amazon.a.a.i.h
    public void i() {
        if (f9660f.equalsIgnoreCase(this.f9664i.e()) || f9661g.equalsIgnoreCase(this.f9664i.e())) {
            try {
                Activity activityB = this.f9663h.b();
                if (activityB == null) {
                    activityB = this.f9663h.a();
                }
                activityB.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(f9659e)));
            } catch (Exception unused) {
            }
        }
    }

    public String toString() {
        return f9658b;
    }
}
