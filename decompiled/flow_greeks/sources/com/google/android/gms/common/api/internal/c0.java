package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.c;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c0 implements c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f5529a;

    public c0(g gVar) {
        Objects.requireNonNull(gVar);
        this.f5529a = gVar;
    }

    @Override // com.google.android.gms.common.api.internal.c.a
    public final void a(boolean z10) {
        Boolean boolValueOf = Boolean.valueOf(z10);
        g gVar = this.f5529a;
        gVar.g().sendMessage(gVar.g().obtainMessage(1, boolValueOf));
    }
}
