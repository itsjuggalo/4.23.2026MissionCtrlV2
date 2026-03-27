package com.amazon.a.a.l;

import android.app.Activity;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Activity f8556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f8557b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f8558c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Intent f8559d;

    public a(Activity activity, int i4, int i5, Intent intent) {
        this.f8556a = activity;
        this.f8557b = i4;
        this.f8558c = i5;
        this.f8559d = intent;
    }

    public Activity a() {
        return this.f8556a;
    }

    public int b() {
        return this.f8557b;
    }

    public Intent c() {
        return this.f8559d;
    }

    public int d() {
        return this.f8558c;
    }

    public String toString() {
        return "ActivtyResult: [ requestCode: " + this.f8557b + ", resultCode: " + this.f8558c + ", activity: " + this.f8556a + ", intent: " + this.f8559d + "]";
    }
}
