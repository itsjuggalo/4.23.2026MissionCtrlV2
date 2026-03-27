package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import z1.AbstractC1995m;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0943v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Resources f9984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9985b;

    public C0943v(Context context) {
        AbstractC0940s.k(context);
        Resources resources = context.getResources();
        this.f9984a = resources;
        this.f9985b = resources.getResourcePackageName(AbstractC1995m.f16109a);
    }

    public String a(String str) {
        int identifier = this.f9984a.getIdentifier(str, "string", this.f9985b);
        if (identifier == 0) {
            return null;
        }
        return this.f9984a.getString(identifier);
    }
}
