package com.google.android.play.core.integrity;

import X1.B;
import X1.C0746g;
import X1.H;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final class af extends H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte[] f10074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Long f10075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f10076c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ IntegrityTokenRequest f10077d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ aj f10078e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public af(aj ajVar, TaskCompletionSource taskCompletionSource, byte[] bArr, Long l4, Parcelable parcelable, TaskCompletionSource taskCompletionSource2, IntegrityTokenRequest integrityTokenRequest) {
        super(taskCompletionSource);
        this.f10078e = ajVar;
        this.f10074a = bArr;
        this.f10075b = l4;
        this.f10076c = taskCompletionSource2;
        this.f10077d = integrityTokenRequest;
    }

    @Override // X1.H
    public final void a(Exception exc) {
        if (exc instanceof C0746g) {
            super.a(new IntegrityServiceException(-9, exc));
        } else {
            super.a(exc);
        }
    }

    @Override // X1.H
    public final void b() {
        try {
            ((B) this.f10078e.f10088a.e()).h(aj.a(this.f10078e, this.f10074a, this.f10075b, null), new ai(this.f10078e, this.f10076c));
        } catch (RemoteException e4) {
            this.f10078e.f10089b.c(e4, "requestIntegrityToken(%s)", this.f10077d);
            this.f10076c.trySetException(new IntegrityServiceException(-100, e4));
        }
    }
}
