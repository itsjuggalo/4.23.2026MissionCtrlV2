package com.google.firebase.sessions;

import com.google.firebase.sessions.b;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements wa.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bd.a f6587a;

    public c(bd.a aVar) {
        this.f6587a = aVar;
    }

    public static ua.b a(a7.g gVar) {
        return (ua.b) wa.d.d(b.InterfaceC0106b.f6585a.e(gVar));
    }

    public static c b(bd.a aVar) {
        return new c(aVar);
    }

    @Override // bd.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public ua.b get() {
        return a((a7.g) this.f6587a.get());
    }
}
