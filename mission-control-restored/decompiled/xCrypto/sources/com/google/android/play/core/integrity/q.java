package com.google.android.play.core.integrity;

import X1.AbstractC0753n;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class q implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f10180a;

    private q() {
    }

    public final q a(Context context) {
        context.getClass();
        this.f10180a = context;
        return this;
    }

    @Override // com.google.android.play.core.integrity.x
    public final s b() {
        AbstractC0753n.a(this.f10180a, Context.class);
        return new s(this.f10180a, null);
    }

    public /* synthetic */ q(p pVar) {
    }
}
