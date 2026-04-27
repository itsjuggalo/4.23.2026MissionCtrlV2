package com.google.android.play.core.integrity;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final class bg extends bm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f11915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f11916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f11917c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f11918d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ bn f11919e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bg(bn bnVar, TaskCompletionSource taskCompletionSource, int i7, String str, long j7, long j8, TaskCompletionSource taskCompletionSource2) {
        super(bnVar, taskCompletionSource);
        this.f11919e = bnVar;
        this.f11915a = str;
        this.f11916b = j7;
        this.f11917c = j8;
        this.f11918d = taskCompletionSource2;
    }

    @Override // F2.H
    public final void b() {
        if (bn.k(this.f11919e)) {
            super.a(new StandardIntegrityException(-2, null));
            return;
        }
        try {
            bn bnVar = this.f11919e;
            ((F2.w) bnVar.f11934a.e()).B(bn.a(bnVar, this.f11915a, this.f11916b, this.f11917c, 0), new bk(this.f11919e, this.f11918d, this.f11916b));
        } catch (RemoteException e7) {
            this.f11919e.f11935b.c(e7, "requestExpressIntegrityToken(%s, %s)", this.f11915a, Long.valueOf(this.f11916b));
            this.f11918d.trySetException(new StandardIntegrityException(-100, e7));
        }
    }
}
