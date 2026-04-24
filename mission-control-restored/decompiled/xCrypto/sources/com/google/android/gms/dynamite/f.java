package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* JADX INFO: loaded from: classes.dex */
public final class f implements DynamiteModule.b {
    @Override // com.google.android.gms.dynamite.DynamiteModule.b
    public final DynamiteModule.b.C0149b a(Context context, String str, DynamiteModule.b.a aVar) {
        int iA;
        DynamiteModule.b.C0149b c0149b = new DynamiteModule.b.C0149b();
        int iB = aVar.b(context, str);
        c0149b.f10014a = iB;
        int i4 = 1;
        int i5 = 0;
        if (iB != 0) {
            iA = aVar.a(context, str, false);
            c0149b.f10015b = iA;
        } else {
            iA = aVar.a(context, str, true);
            c0149b.f10015b = iA;
        }
        int i6 = c0149b.f10014a;
        if (i6 == 0) {
            if (iA == 0) {
                i4 = 0;
            }
            c0149b.f10016c = i4;
            return c0149b;
        }
        i5 = i6;
        if (i5 >= iA) {
            i4 = -1;
        }
        c0149b.f10016c = i4;
        return c0149b;
    }
}
