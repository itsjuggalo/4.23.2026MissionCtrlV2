package com.amazon.a.a.l;

import android.app.Activity;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Activity f13852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f13853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f13854c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Intent f13855d;

    public a(Activity activity, int i8, int i9, Intent intent) {
        this.f13852a = activity;
        this.f13853b = i8;
        this.f13854c = i9;
        this.f13855d = intent;
    }

    public Activity a() {
        return this.f13852a;
    }

    public int b() {
        return this.f13853b;
    }

    public Intent c() {
        return this.f13855d;
    }

    public int d() {
        return this.f13854c;
    }

    public String toString() {
        return "ActivtyResult: [ requestCode: " + this.f13853b + ", resultCode: " + this.f13854c + ", activity: " + this.f13852a + ", intent: " + this.f13855d + "]";
    }
}
