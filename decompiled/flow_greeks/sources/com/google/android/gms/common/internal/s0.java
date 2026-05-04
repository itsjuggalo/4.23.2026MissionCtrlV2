package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class s0 extends c1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f5789d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Bundle f5790e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ c f5791f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s0(c cVar, int i10, Bundle bundle) {
        super(cVar, Boolean.TRUE);
        Objects.requireNonNull(cVar);
        this.f5791f = cVar;
        this.f5789d = i10;
        this.f5790e = bundle;
    }

    @Override // com.google.android.gms.common.internal.c1
    public final /* bridge */ /* synthetic */ void a(Object obj) {
        int i10 = this.f5789d;
        if (i10 != 0) {
            this.f5791f.zzd(1, null);
            Bundle bundle = this.f5790e;
            f(new m5.b(i10, bundle != null ? (PendingIntent) bundle.getParcelable(c.KEY_PENDING_INTENT) : null));
        } else {
            if (e()) {
                return;
            }
            this.f5791f.zzd(1, null);
            f(new m5.b(8, null));
        }
    }

    public abstract boolean e();

    public abstract void f(m5.b bVar);
}
