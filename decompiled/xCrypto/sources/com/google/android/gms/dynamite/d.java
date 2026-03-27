package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* JADX INFO: loaded from: classes.dex */
public final class d implements DynamiteModule.b {
    @Override // com.google.android.gms.dynamite.DynamiteModule.b
    public final DynamiteModule.b.C0149b a(Context context, String str, DynamiteModule.b.a aVar) {
        DynamiteModule.b.C0149b c0149b = new DynamiteModule.b.C0149b();
        int iA = aVar.a(context, str, false);
        c0149b.f10015b = iA;
        c0149b.f10016c = iA != 0 ? 1 : 0;
        return c0149b;
    }
}
