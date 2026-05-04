package com.amazon.a.a.i;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a extends h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f4285b = "a";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f4286e = "http://www.amazon.com/gp/mas/get-appstore/android/ref=mas_mx_mba_iap_dl";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f4287f = "Amazon Appstore required";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f4288g = "Amazon Appstore Update Required";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final long f4289j = 31536000;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.a.a f4290h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final c f4291i;

    public a(c cVar) {
        super(cVar);
        this.f4291i = cVar;
    }

    @Override // com.amazon.a.a.e.c
    public long h() {
        return 31536000L;
    }

    @Override // com.amazon.a.a.i.h
    public void i() {
        if (f4287f.equalsIgnoreCase(this.f4291i.e()) || f4288g.equalsIgnoreCase(this.f4291i.e())) {
            try {
                Activity activityB = this.f4290h.b();
                if (activityB == null) {
                    activityB = this.f4290h.a();
                }
                activityB.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(f4286e)));
            } catch (Exception unused) {
            }
        }
    }

    public String toString() {
        return f4285b;
    }
}
