package com.amazon.a.a.i;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public class a extends h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f13769b = "a";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f13770e = "http://www.amazon.com/gp/mas/get-appstore/android/ref=mas_mx_mba_iap_dl";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f13771f = "Amazon Appstore required";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f13772g = "Amazon Appstore Update Required";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final long f13773j = 31536000;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.a.a f13774h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final c f13775i;

    public a(c cVar) {
        super(cVar);
        this.f13775i = cVar;
    }

    @Override // com.amazon.a.a.e.c
    public long h() {
        return 31536000L;
    }

    @Override // com.amazon.a.a.i.h
    public void i() {
        if (f13771f.equalsIgnoreCase(this.f13775i.e()) || f13772g.equalsIgnoreCase(this.f13775i.e())) {
            try {
                Activity activityB = this.f13774h.b();
                if (activityB == null) {
                    activityB = this.f13774h.a();
                }
                activityB.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(f13770e)));
            } catch (Exception unused) {
            }
        }
    }

    public String toString() {
        return f13769b;
    }
}
