package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* JADX INFO: loaded from: classes.dex */
public final class d implements DynamiteModule.b {
    @Override // com.google.android.gms.dynamite.DynamiteModule.b
    public final DynamiteModule.b.C0251b a(Context context, String str, DynamiteModule.b.a aVar) {
        DynamiteModule.b.C0251b c0251b = new DynamiteModule.b.C0251b();
        int iA = aVar.a(context, str, false);
        c0251b.f15082b = iA;
        c0251b.f15083c = iA != 0 ? 1 : 0;
        return c0251b;
    }
}
