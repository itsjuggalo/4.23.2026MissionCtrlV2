package com.google.android.play.core.integrity;

import X1.AbstractC0753n;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class u implements av {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f10187a;

    private u() {
    }

    public final u a(Context context) {
        context.getClass();
        this.f10187a = context;
        return this;
    }

    @Override // com.google.android.play.core.integrity.av
    public final aw b() {
        AbstractC0753n.a(this.f10187a, Context.class);
        return new w(this.f10187a, null);
    }

    public /* synthetic */ u(t tVar) {
    }
}
