package com.google.android.play.core.integrity;

import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import n6.q0;
import n6.w0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class af extends w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte[] f5890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Long f5891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Parcelable f5892c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f5893d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ IntegrityTokenRequest f5894e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ aj f5895f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public af(aj ajVar, TaskCompletionSource taskCompletionSource, byte[] bArr, Long l10, Parcelable parcelable, TaskCompletionSource taskCompletionSource2, IntegrityTokenRequest integrityTokenRequest) {
        super(taskCompletionSource);
        this.f5890a = bArr;
        this.f5891b = l10;
        this.f5892c = parcelable;
        this.f5893d = taskCompletionSource2;
        this.f5894e = integrityTokenRequest;
        this.f5895f = ajVar;
    }

    @Override // n6.w0
    public final void a(Exception exc) {
        if (exc instanceof n6.g) {
            super.a(new IntegrityServiceException(-9, exc));
        } else {
            super.a(exc);
        }
    }

    @Override // n6.w0
    public final void b() {
        try {
            ((q0) this.f5895f.f5905a.e()).s(aj.a(this.f5895f, this.f5890a, this.f5891b, this.f5892c), new ai(this.f5895f, this.f5893d));
        } catch (RemoteException e10) {
            this.f5895f.f5906b.c(e10, "requestIntegrityToken(%s)", this.f5894e);
            this.f5893d.trySetException(new IntegrityServiceException(-100, e10));
        }
    }
}
