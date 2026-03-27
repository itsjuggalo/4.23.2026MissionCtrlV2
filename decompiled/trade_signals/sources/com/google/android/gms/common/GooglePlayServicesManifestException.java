package com.google.android.gms.common;

import com.google.android.gms.common.annotation.KeepName;

/* JADX INFO: loaded from: classes.dex */
@KeepName
public abstract class GooglePlayServicesManifestException extends IllegalStateException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14903a;

    public GooglePlayServicesManifestException(int i8, String str) {
        super(str);
        this.f14903a = i8;
    }
}
