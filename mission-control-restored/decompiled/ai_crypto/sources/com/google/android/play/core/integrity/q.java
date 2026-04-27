package com.google.android.play.core.integrity;

import F2.AbstractC0476n;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class q implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f11963a;

    private q() {
    }

    public final q a(Context context) {
        context.getClass();
        this.f11963a = context;
        return this;
    }

    @Override // com.google.android.play.core.integrity.x
    public final s b() {
        AbstractC0476n.a(this.f11963a, Context.class);
        return new s(this.f11963a, null);
    }

    public /* synthetic */ q(p pVar) {
    }
}
