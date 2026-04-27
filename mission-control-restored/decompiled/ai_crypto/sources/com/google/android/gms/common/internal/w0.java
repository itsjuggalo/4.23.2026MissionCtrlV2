package com.google.android.gms.common.internal;

import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public abstract class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Uri f11171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Uri f11172b;

    static {
        Uri uri = Uri.parse("https://plus.google.com/");
        f11171a = uri;
        f11172b = uri.buildUpon().appendPath("circles").appendPath("find").build();
    }
}
