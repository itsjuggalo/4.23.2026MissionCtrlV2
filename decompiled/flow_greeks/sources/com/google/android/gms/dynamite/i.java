package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements DynamiteModule.b {
    @Override // com.google.android.gms.dynamite.DynamiteModule.b
    public final DynamiteModule.b.C0098b a(Context context, String str, DynamiteModule.b.a aVar) {
        int iA;
        DynamiteModule.b.C0098b c0098b = new DynamiteModule.b.C0098b();
        int iB = aVar.b(context, str);
        c0098b.f5832a = iB;
        int i10 = 1;
        int i11 = 0;
        if (iB != 0) {
            iA = aVar.a(context, str, false);
            c0098b.f5833b = iA;
        } else {
            iA = aVar.a(context, str, true);
            c0098b.f5833b = iA;
        }
        int i12 = c0098b.f5832a;
        if (i12 == 0) {
            if (iA == 0) {
                i10 = 0;
            }
            c0098b.f5834c = i10;
            return c0098b;
        }
        i11 = i12;
        if (iA < i11) {
            i10 = -1;
        }
        c0098b.f5834c = i10;
        return c0098b;
    }
}
