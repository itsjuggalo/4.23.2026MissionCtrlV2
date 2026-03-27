package com.google.android.play.core.integrity;

import F2.AbstractC0476n;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class u implements av {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f11970a;

    private u() {
    }

    public final u a(Context context) {
        context.getClass();
        this.f11970a = context;
        return this;
    }

    @Override // com.google.android.play.core.integrity.av
    public final aw b() {
        AbstractC0476n.a(this.f11970a, Context.class);
        return new w(this.f11970a, null);
    }

    public /* synthetic */ u(t tVar) {
    }
}
