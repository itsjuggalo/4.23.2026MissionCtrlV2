package com.amazon.a.a.l;

import android.app.Activity;
import android.content.Intent;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Activity f4368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f4369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f4370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Intent f4371d;

    public a(Activity activity, int i10, int i11, Intent intent) {
        this.f4368a = activity;
        this.f4369b = i10;
        this.f4370c = i11;
        this.f4371d = intent;
    }

    public Activity a() {
        return this.f4368a;
    }

    public int b() {
        return this.f4369b;
    }

    public Intent c() {
        return this.f4371d;
    }

    public int d() {
        return this.f4370c;
    }

    public String toString() {
        return "ActivtyResult: [ requestCode: " + this.f4369b + ", resultCode: " + this.f4370c + ", activity: " + this.f4368a + ", intent: " + this.f4371d + "]";
    }
}
