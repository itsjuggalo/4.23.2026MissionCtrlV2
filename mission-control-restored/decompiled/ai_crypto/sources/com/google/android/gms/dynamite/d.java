package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* JADX INFO: loaded from: classes.dex */
public final class d implements DynamiteModule.b {
    @Override // com.google.android.gms.dynamite.DynamiteModule.b
    public final DynamiteModule.b.C0182b a(Context context, String str, DynamiteModule.b.a aVar) {
        DynamiteModule.b.C0182b c0182b = new DynamiteModule.b.C0182b();
        int iA = aVar.a(context, str, false);
        c0182b.f11198b = iA;
        c0182b.f11199c = iA != 0 ? 1 : 0;
        return c0182b;
    }
}
