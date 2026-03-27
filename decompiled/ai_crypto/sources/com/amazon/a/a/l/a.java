package com.amazon.a.a.l;

import android.app.Activity;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Activity f9741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f9742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f9743c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Intent f9744d;

    public a(Activity activity, int i7, int i8, Intent intent) {
        this.f9741a = activity;
        this.f9742b = i7;
        this.f9743c = i8;
        this.f9744d = intent;
    }

    public Activity a() {
        return this.f9741a;
    }

    public int b() {
        return this.f9742b;
    }

    public Intent c() {
        return this.f9744d;
    }

    public int d() {
        return this.f9743c;
    }

    public String toString() {
        return "ActivtyResult: [ requestCode: " + this.f9742b + ", resultCode: " + this.f9743c + ", activity: " + this.f9741a + ", intent: " + this.f9744d + "]";
    }
}
