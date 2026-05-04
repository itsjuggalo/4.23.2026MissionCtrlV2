package com.google.firebase.sessions;

import android.content.Context;
import com.google.firebase.sessions.b;
import l1.i;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements wa.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bd.a f6588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bd.a f6589b;

    public d(bd.a aVar, bd.a aVar2) {
        this.f6588a = aVar;
        this.f6589b = aVar2;
    }

    public static d a(bd.a aVar, bd.a aVar2) {
        return new d(aVar, aVar2);
    }

    public static i c(Context context, gd.i iVar) {
        return (i) wa.d.d(b.InterfaceC0106b.f6585a.j(context, iVar));
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public i get() {
        return c((Context) this.f6588a.get(), (gd.i) this.f6589b.get());
    }
}
