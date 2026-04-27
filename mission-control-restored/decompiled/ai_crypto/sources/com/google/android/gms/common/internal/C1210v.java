package com.google.android.gms.common.internal;

import P1.AbstractC0659m;
import android.content.Context;
import android.content.res.Resources;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1210v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Resources f11167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f11168b;

    public C1210v(Context context) {
        AbstractC1207s.k(context);
        Resources resources = context.getResources();
        this.f11167a = resources;
        this.f11168b = resources.getResourcePackageName(AbstractC0659m.f4312a);
    }

    public String a(String str) {
        int identifier = this.f11167a.getIdentifier(str, "string", this.f11168b);
        if (identifier == 0) {
            return null;
        }
        return this.f11167a.getString(identifier);
    }
}
