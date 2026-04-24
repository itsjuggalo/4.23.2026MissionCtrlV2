package com.google.firebase.sessions;

import android.content.Context;
import c0.InterfaceC1119h;
import c4.InterfaceC1143b;
import com.google.firebase.sessions.b;

/* JADX INFO: loaded from: classes.dex */
public final class d implements InterfaceC1143b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final D5.a f12302a;

    public d(D5.a aVar) {
        this.f12302a = aVar;
    }

    public static d a(D5.a aVar) {
        return new d(aVar);
    }

    public static InterfaceC1119h c(Context context) {
        return (InterfaceC1119h) c4.d.d(b.InterfaceC0196b.f12295a.b(context));
    }

    @Override // D5.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public InterfaceC1119h get() {
        return c((Context) this.f12302a.get());
    }
}
