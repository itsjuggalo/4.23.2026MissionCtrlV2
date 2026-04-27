package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* JADX INFO: loaded from: classes.dex */
public final class b implements DynamiteModule.b {
    @Override // com.google.android.gms.dynamite.DynamiteModule.b
    public final DynamiteModule.b.C0182b a(Context context, String str, DynamiteModule.b.a aVar) {
        DynamiteModule.b.C0182b c0182b = new DynamiteModule.b.C0182b();
        int iA = aVar.a(context, str, true);
        c0182b.f11198b = iA;
        if (iA != 0) {
            c0182b.f11199c = 1;
        } else {
            int iB = aVar.b(context, str);
            c0182b.f11197a = iB;
            if (iB != 0) {
                c0182b.f11199c = -1;
            }
        }
        return c0182b;
    }
}
