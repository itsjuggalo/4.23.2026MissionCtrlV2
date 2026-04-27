package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.g0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1337g0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC1357k0 f15412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final G0 f15413b;

    public RunnableC1337g0(AbstractC1357k0 abstractC1357k0, G0 g02) {
        this.f15412a = abstractC1357k0;
        this.f15413b = g02;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f15412a.f15491a != this) {
            return;
        }
        if (AbstractC1387q0.k(this.f15412a, this, AbstractC1357k0.t(this.f15413b))) {
            AbstractC1357k0.w(this.f15412a, false);
        }
    }
}
