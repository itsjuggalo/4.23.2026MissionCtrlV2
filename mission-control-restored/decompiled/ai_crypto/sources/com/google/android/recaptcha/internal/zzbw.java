package com.google.android.recaptcha.internal;

import H5.d;
import H5.g;
import Q5.k;
import Q5.o;
import Y5.f;
import b6.InterfaceC1062c0;
import b6.InterfaceC1096u;
import b6.InterfaceC1100w;
import b6.InterfaceC1101w0;
import b6.InterfaceC1102x;
import b6.T;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes.dex */
public final class zzbw implements T {
    private final /* synthetic */ InterfaceC1102x zza;

    public zzbw(InterfaceC1102x interfaceC1102x) {
        this.zza = interfaceC1102x;
    }

    @Override // b6.InterfaceC1101w0
    public final InterfaceC1096u attachChild(InterfaceC1100w interfaceC1100w) {
        return this.zza.attachChild(interfaceC1100w);
    }

    @Override // b6.T
    public final Object await(d dVar) {
        return this.zza.await(dVar);
    }

    @Override // b6.InterfaceC1101w0
    public final /* synthetic */ void cancel() {
        this.zza.cancel();
    }

    @Override // H5.g.b, H5.g
    public final Object fold(Object obj, o oVar) {
        return this.zza.fold(obj, oVar);
    }

    @Override // H5.g.b, H5.g
    public final g.b get(g.c cVar) {
        return this.zza.get(cVar);
    }

    @Override // b6.InterfaceC1101w0
    public final CancellationException getCancellationException() {
        return this.zza.getCancellationException();
    }

    @Override // b6.InterfaceC1101w0
    public final f getChildren() {
        return this.zza.getChildren();
    }

    @Override // b6.T
    public final Object getCompleted() {
        return this.zza.getCompleted();
    }

    @Override // b6.T
    public final Throwable getCompletionExceptionOrNull() {
        return this.zza.getCompletionExceptionOrNull();
    }

    @Override // H5.g.b
    public final g.c getKey() {
        return this.zza.getKey();
    }

    @Override // b6.T
    public final j6.c getOnAwait() {
        return this.zza.getOnAwait();
    }

    @Override // b6.InterfaceC1101w0
    public final j6.a getOnJoin() {
        return this.zza.getOnJoin();
    }

    @Override // b6.InterfaceC1101w0
    public final InterfaceC1101w0 getParent() {
        return this.zza.getParent();
    }

    @Override // b6.InterfaceC1101w0
    public final InterfaceC1062c0 invokeOnCompletion(k kVar) {
        return this.zza.invokeOnCompletion(kVar);
    }

    @Override // b6.InterfaceC1101w0
    public final boolean isActive() {
        return this.zza.isActive();
    }

    @Override // b6.InterfaceC1101w0
    public final boolean isCancelled() {
        return this.zza.isCancelled();
    }

    @Override // b6.InterfaceC1101w0
    public final boolean isCompleted() {
        return this.zza.isCompleted();
    }

    @Override // b6.InterfaceC1101w0
    public final Object join(d dVar) {
        return this.zza.join(dVar);
    }

    @Override // H5.g.b, H5.g
    public final g minusKey(g.c cVar) {
        return this.zza.minusKey(cVar);
    }

    @Override // H5.g
    public final g plus(g gVar) {
        return this.zza.plus(gVar);
    }

    @Override // b6.InterfaceC1101w0
    public final boolean start() {
        return this.zza.start();
    }

    @Override // b6.InterfaceC1101w0
    public final void cancel(CancellationException cancellationException) {
        this.zza.cancel(cancellationException);
    }

    @Override // b6.InterfaceC1101w0
    public final InterfaceC1062c0 invokeOnCompletion(boolean z7, boolean z8, k kVar) {
        return this.zza.invokeOnCompletion(z7, z8, kVar);
    }

    @Override // b6.InterfaceC1101w0
    public final InterfaceC1101w0 plus(InterfaceC1101w0 interfaceC1101w0) {
        return this.zza.plus(interfaceC1101w0);
    }

    @Override // b6.InterfaceC1101w0
    public final /* synthetic */ boolean cancel(Throwable th) {
        return this.zza.cancel(th);
    }
}
