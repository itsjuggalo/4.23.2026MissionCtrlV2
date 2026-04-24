package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* JADX INFO: loaded from: classes.dex */
public final class h implements DynamiteModule.b {
    @Override // com.google.android.gms.dynamite.DynamiteModule.b
    public final DynamiteModule.b.C0182b a(Context context, String str, DynamiteModule.b.a aVar) {
        int iA;
        DynamiteModule.b.C0182b c0182b = new DynamiteModule.b.C0182b();
        int iB = aVar.b(context, str);
        c0182b.f11197a = iB;
        int i7 = 1;
        int i8 = 0;
        if (iB != 0) {
            iA = aVar.a(context, str, false);
            c0182b.f11198b = iA;
        } else {
            iA = aVar.a(context, str, true);
            c0182b.f11198b = iA;
        }
        int i9 = c0182b.f11197a;
        if (i9 == 0) {
            if (iA == 0) {
                i7 = 0;
            }
            c0182b.f11199c = i7;
            return c0182b;
        }
        i8 = i9;
        if (iA < i8) {
            i7 = -1;
        }
        c0182b.f11199c = i7;
        return c0182b;
    }
}
