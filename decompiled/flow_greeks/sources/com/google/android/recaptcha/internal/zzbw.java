package com.google.android.recaptcha.internal;

import gd.e;
import gd.i;
import java.util.concurrent.CancellationException;
import jg.h;
import ng.e1;
import ng.u;
import ng.u0;
import ng.w;
import ng.x;
import ng.y1;
import pd.k;
import pd.o;
import vg.a;
import vg.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbw implements u0 {
    private final /* synthetic */ x zza;

    public zzbw(x xVar) {
        this.zza = xVar;
    }

    @Override // ng.y1
    public final u attachChild(w wVar) {
        return this.zza.attachChild(wVar);
    }

    @Override // ng.u0
    public final Object await(e eVar) {
        return this.zza.await(eVar);
    }

    @Override // ng.y1
    public final /* synthetic */ void cancel() {
        this.zza.cancel();
    }

    @Override // gd.i.b, gd.i
    public final Object fold(Object obj, o oVar) {
        return this.zza.fold(obj, oVar);
    }

    @Override // gd.i.b, gd.i
    public final i.b get(i.c cVar) {
        return this.zza.get(cVar);
    }

    @Override // ng.y1
    public final CancellationException getCancellationException() {
        return this.zza.getCancellationException();
    }

    @Override // ng.y1
    public final h getChildren() {
        return this.zza.getChildren();
    }

    @Override // ng.u0
    public final Object getCompleted() {
        return this.zza.getCompleted();
    }

    @Override // ng.u0
    public final Throwable getCompletionExceptionOrNull() {
        return this.zza.getCompletionExceptionOrNull();
    }

    @Override // gd.i.b
    public final i.c getKey() {
        return this.zza.getKey();
    }

    @Override // ng.u0
    public final c getOnAwait() {
        return this.zza.getOnAwait();
    }

    @Override // ng.y1
    public final a getOnJoin() {
        return this.zza.getOnJoin();
    }

    @Override // ng.y1
    public final y1 getParent() {
        return this.zza.getParent();
    }

    @Override // ng.y1
    public final e1 invokeOnCompletion(k kVar) {
        return this.zza.invokeOnCompletion(kVar);
    }

    @Override // ng.y1
    public final boolean isActive() {
        return this.zza.isActive();
    }

    @Override // ng.y1
    public final boolean isCancelled() {
        return this.zza.isCancelled();
    }

    @Override // ng.y1
    public final boolean isCompleted() {
        return this.zza.isCompleted();
    }

    @Override // ng.y1
    public final Object join(e eVar) {
        return this.zza.join(eVar);
    }

    @Override // gd.i.b, gd.i
    public final i minusKey(i.c cVar) {
        return this.zza.minusKey(cVar);
    }

    @Override // gd.i
    public final i plus(i iVar) {
        return this.zza.plus(iVar);
    }

    @Override // ng.y1
    public final boolean start() {
        return this.zza.start();
    }

    @Override // ng.y1
    public final void cancel(CancellationException cancellationException) {
        this.zza.cancel(cancellationException);
    }

    @Override // ng.y1
    public final e1 invokeOnCompletion(boolean z10, boolean z11, k kVar) {
        return this.zza.invokeOnCompletion(z10, z11, kVar);
    }

    @Override // ng.y1
    public final y1 plus(y1 y1Var) {
        return this.zza.plus(y1Var);
    }

    @Override // ng.y1
    public final /* synthetic */ boolean cancel(Throwable th) {
        return this.zza.cancel(th);
    }
}
