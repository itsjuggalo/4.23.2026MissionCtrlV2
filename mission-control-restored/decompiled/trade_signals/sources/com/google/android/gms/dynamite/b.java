package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* JADX INFO: loaded from: classes.dex */
public final class b implements DynamiteModule.b {
    @Override // com.google.android.gms.dynamite.DynamiteModule.b
    public final DynamiteModule.b.C0251b a(Context context, String str, DynamiteModule.b.a aVar) {
        DynamiteModule.b.C0251b c0251b = new DynamiteModule.b.C0251b();
        int iA = aVar.a(context, str, true);
        c0251b.f15082b = iA;
        if (iA != 0) {
            c0251b.f15083c = 1;
        } else {
            int iB = aVar.b(context, str);
            c0251b.f15081a = iB;
            if (iB != 0) {
                c0251b.f15083c = -1;
            }
        }
        return c0251b;
    }
}
