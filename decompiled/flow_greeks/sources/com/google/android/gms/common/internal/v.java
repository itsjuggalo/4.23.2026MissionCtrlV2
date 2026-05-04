package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Resources f5801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5802b;

    public v(Context context) {
        s.k(context);
        Resources resources = context.getResources();
        this.f5801a = resources;
        this.f5802b = resources.getResourcePackageName(m5.m.f15947a);
    }

    public String a(String str) {
        String str2 = this.f5802b;
        Resources resources = this.f5801a;
        int identifier = resources.getIdentifier(str, "string", str2);
        if (identifier == 0) {
            return null;
        }
        return resources.getString(identifier);
    }
}
