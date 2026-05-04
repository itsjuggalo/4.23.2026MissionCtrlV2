package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements DynamiteModule.b {
    @Override // com.google.android.gms.dynamite.DynamiteModule.b
    public final DynamiteModule.b.C0098b a(Context context, String str, DynamiteModule.b.a aVar) {
        DynamiteModule.b.C0098b c0098b = new DynamiteModule.b.C0098b();
        int iB = aVar.b(context, str);
        c0098b.f5832a = iB;
        c0098b.f5834c = iB != 0 ? -1 : 0;
        return c0098b;
    }
}
