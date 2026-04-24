package com.google.android.recaptcha.internal;

import Z2.e;
import Z2.i;
import i3.k;
import i3.o;
import java.util.concurrent.CancellationException;
import t3.InterfaceC1807c0;
import t3.InterfaceC1841u;
import t3.InterfaceC1845w;
import t3.InterfaceC1846w0;
import t3.InterfaceC1847x;
import t3.T;

/* JADX INFO: loaded from: classes.dex */
public final class zzbw implements T {
    private final /* synthetic */ InterfaceC1847x zza;

    public zzbw(InterfaceC1847x interfaceC1847x) {
        this.zza = interfaceC1847x;
    }

    @Override // t3.InterfaceC1846w0
    public final InterfaceC1841u attachChild(InterfaceC1845w interfaceC1845w) {
        return this.zza.attachChild(interfaceC1845w);
    }

    @Override // t3.T
    public final Object await(e eVar) {
        return this.zza.await(eVar);
    }

    @Override // t3.InterfaceC1846w0
    public final /* synthetic */ void cancel() {
        this.zza.cancel();
    }

    @Override // Z2.i.b, Z2.i
    public final Object fold(Object obj, o oVar) {
        return this.zza.fold(obj, oVar);
    }

    @Override // Z2.i.b, Z2.i
    public final i.b get(i.c cVar) {
        return this.zza.get(cVar);
    }

    @Override // t3.InterfaceC1846w0
    public final CancellationException getCancellationException() {
        return this.zza.getCancellationException();
    }

    @Override // t3.InterfaceC1846w0
    public final q3.e getChildren() {
        return this.zza.getChildren();
    }

    @Override // t3.T
    public final Object getCompleted() {
        return this.zza.getCompleted();
    }

    @Override // t3.T
    public final Throwable getCompletionExceptionOrNull() {
        return this.zza.getCompletionExceptionOrNull();
    }

    @Override // Z2.i.b
    public final i.c getKey() {
        return this.zza.getKey();
    }

    @Override // t3.T
    public final B3.c getOnAwait() {
        return this.zza.getOnAwait();
    }

    @Override // t3.InterfaceC1846w0
    public final B3.a getOnJoin() {
        return this.zza.getOnJoin();
    }

    @Override // t3.InterfaceC1846w0
    public final InterfaceC1846w0 getParent() {
        return this.zza.getParent();
    }

    @Override // t3.InterfaceC1846w0
    public final InterfaceC1807c0 invokeOnCompletion(k kVar) {
        return this.zza.invokeOnCompletion(kVar);
    }

    @Override // t3.InterfaceC1846w0
    public final boolean isActive() {
        return this.zza.isActive();
    }

    @Override // t3.InterfaceC1846w0
    public final boolean isCancelled() {
        return this.zza.isCancelled();
    }

    @Override // t3.InterfaceC1846w0
    public final boolean isCompleted() {
        return this.zza.isCompleted();
    }

    @Override // t3.InterfaceC1846w0
    public final Object join(e eVar) {
        return this.zza.join(eVar);
    }

    @Override // Z2.i.b, Z2.i
    public final i minusKey(i.c cVar) {
        return this.zza.minusKey(cVar);
    }

    @Override // Z2.i
    public final i plus(i iVar) {
        return this.zza.plus(iVar);
    }

    @Override // t3.InterfaceC1846w0
    public final boolean start() {
        return this.zza.start();
    }

    @Override // t3.InterfaceC1846w0
    public final void cancel(CancellationException cancellationException) {
        this.zza.cancel(cancellationException);
    }

    @Override // t3.InterfaceC1846w0
    public final InterfaceC1807c0 invokeOnCompletion(boolean z4, boolean z5, k kVar) {
        return this.zza.invokeOnCompletion(z4, z5, kVar);
    }

    @Override // t3.InterfaceC1846w0
    public final InterfaceC1846w0 plus(InterfaceC1846w0 interfaceC1846w0) {
        return this.zza.plus(interfaceC1846w0);
    }

    @Override // t3.InterfaceC1846w0
    public final /* synthetic */ boolean cancel(Throwable th) {
        return this.zza.cancel(th);
    }
}
