package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* JADX INFO: loaded from: classes.dex */
public final class b implements DynamiteModule.b {
    @Override // com.google.android.gms.dynamite.DynamiteModule.b
    public final DynamiteModule.b.C0149b a(Context context, String str, DynamiteModule.b.a aVar) {
        DynamiteModule.b.C0149b c0149b = new DynamiteModule.b.C0149b();
        int iA = aVar.a(context, str, true);
        c0149b.f10015b = iA;
        if (iA != 0) {
            c0149b.f10016c = 1;
            return c0149b;
        }
        int iB = aVar.b(context, str);
        c0149b.f10014a = iB;
        if (iB != 0) {
            c0149b.f10016c = -1;
        }
        return c0149b;
    }
}
