package com.google.android.gms.common.internal;

import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public abstract class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Uri f15038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Uri f15039b;

    static {
        Uri uri = Uri.parse("https://plus.google.com/");
        f15038a = uri;
        f15039b = uri.buildUpon().appendPath("circles").appendPath("find").build();
    }
}
