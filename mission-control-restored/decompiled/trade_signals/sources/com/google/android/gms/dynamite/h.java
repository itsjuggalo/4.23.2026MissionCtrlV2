package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* JADX INFO: loaded from: classes.dex */
public final class h implements DynamiteModule.b {
    @Override // com.google.android.gms.dynamite.DynamiteModule.b
    public final DynamiteModule.b.C0251b a(Context context, String str, DynamiteModule.b.a aVar) {
        DynamiteModule.b.C0251b c0251b = new DynamiteModule.b.C0251b();
        int iB = aVar.b(context, str);
        c0251b.f15081a = iB;
        int i8 = 1;
        int i9 = 0;
        int iA = iB != 0 ? aVar.a(context, str, false) : aVar.a(context, str, true);
        c0251b.f15082b = iA;
        int i10 = c0251b.f15081a;
        if (i10 == 0) {
            if (iA == 0) {
                i8 = 0;
            }
            c0251b.f15083c = i8;
            return c0251b;
        }
        i9 = i10;
        if (iA < i9) {
            i8 = -1;
        }
        c0251b.f15083c = i8;
        return c0251b;
    }
}
