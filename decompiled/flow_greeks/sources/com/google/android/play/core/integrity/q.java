package com.google.android.play.core.integrity;

import android.content.Context;
import n6.c0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class q implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f5997a;

    private q() {
        throw null;
    }

    public final q a(Context context) {
        context.getClass();
        this.f5997a = context;
        return this;
    }

    @Override // com.google.android.play.core.integrity.x
    public final s b() {
        c0.a(this.f5997a, Context.class);
        return new s(this.f5997a, null);
    }

    public /* synthetic */ q(p pVar) {
    }
}
