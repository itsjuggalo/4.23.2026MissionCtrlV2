package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.internal.InterfaceC0403f;
import com.google.android.gms.common.api.internal.InterfaceC0413p;
import com.google.android.gms.common.internal.C0430h;

/* JADX INFO: loaded from: classes.dex */
final class zzv extends a {
    @Override // com.google.android.gms.common.api.a
    public final /* synthetic */ g buildClient(Context context, Looper looper, C0430h c0430h, Object obj, InterfaceC0403f interfaceC0403f, InterfaceC0413p interfaceC0413p) {
        return new zzi(context, looper, c0430h, interfaceC0403f, interfaceC0413p);
    }
}
