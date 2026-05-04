package com.google.android.play.core.integrity;

import android.content.Context;
import n6.c0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class u implements av {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f6003a;

    private u() {
        throw null;
    }

    public final u a(Context context) {
        context.getClass();
        this.f6003a = context;
        return this;
    }

    @Override // com.google.android.play.core.integrity.av
    public final aw b() {
        c0.a(this.f6003a, Context.class);
        return new w(this.f6003a, null);
    }

    public /* synthetic */ u(t tVar) {
    }
}
