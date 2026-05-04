package com.google.firebase.sessions;

import android.content.Context;
import com.google.firebase.sessions.b;
import l1.i;
import ua.f0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements wa.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bd.a f6590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bd.a f6591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bd.a f6592c;

    public e(bd.a aVar, bd.a aVar2, bd.a aVar3) {
        this.f6590a = aVar;
        this.f6591b = aVar2;
        this.f6592c = aVar3;
    }

    public static e a(bd.a aVar, bd.a aVar2, bd.a aVar3) {
        return new e(aVar, aVar2, aVar3);
    }

    public static i c(Context context, gd.i iVar, f0 f0Var) {
        return (i) wa.d.d(b.InterfaceC0106b.f6585a.m(context, iVar, f0Var));
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public i get() {
        return c((Context) this.f6590a.get(), (gd.i) this.f6591b.get(), (f0) this.f6592c.get());
    }
}
