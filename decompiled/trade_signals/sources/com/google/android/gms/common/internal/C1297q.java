package com.google.android.gms.common.internal;

import Q1.AbstractC0801m;
import android.content.Context;
import android.content.res.Resources;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1297q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Resources f15051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15052b;

    public C1297q(Context context) {
        AbstractC1294n.j(context);
        Resources resources = context.getResources();
        this.f15051a = resources;
        this.f15052b = resources.getResourcePackageName(AbstractC0801m.f6706a);
    }

    public String a(String str) {
        int identifier = this.f15051a.getIdentifier(str, "string", this.f15052b);
        if (identifier == 0) {
            return null;
        }
        return this.f15051a.getString(identifier);
    }
}
