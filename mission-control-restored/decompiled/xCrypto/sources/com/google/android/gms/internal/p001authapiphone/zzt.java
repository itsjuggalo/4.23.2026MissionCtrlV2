package com.google.android.gms.internal.p001authapiphone;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.InterfaceC0903g;
import com.google.android.gms.common.api.internal.InterfaceC0912p;
import com.google.android.gms.common.internal.C0927e;

/* JADX INFO: loaded from: classes.dex */
final class zzt extends a.AbstractC0145a {
    @Override // com.google.android.gms.common.api.a.AbstractC0145a
    public final /* synthetic */ a.f buildClient(Context context, Looper looper, C0927e c0927e, Object obj, InterfaceC0903g interfaceC0903g, InterfaceC0912p interfaceC0912p) {
        return new zzw(context, looper, c0927e, interfaceC0903g, interfaceC0912p);
    }
}
