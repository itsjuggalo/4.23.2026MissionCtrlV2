package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.internal.AbstractC0940s;
import z1.C1984b;

/* JADX INFO: loaded from: classes.dex */
public final class v0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t0 f9826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w0 f9827b;

    public v0(w0 w0Var, t0 t0Var) {
        this.f9827b = w0Var;
        this.f9826a = t0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f9827b.f9828a) {
            C1984b c1984bB = this.f9826a.b();
            if (c1984bB.m()) {
                w0 w0Var = this.f9827b;
                w0Var.mLifecycleFragment.startActivityForResult(GoogleApiActivity.a(w0Var.getActivity(), (PendingIntent) AbstractC0940s.k(c1984bB.l()), this.f9826a.a(), false), 1);
                return;
            }
            w0 w0Var2 = this.f9827b;
            if (w0Var2.f9831e.b(w0Var2.getActivity(), c1984bB.i(), null) != null) {
                w0 w0Var3 = this.f9827b;
                w0Var3.f9831e.w(w0Var3.getActivity(), w0Var3.mLifecycleFragment, c1984bB.i(), 2, this.f9827b);
                return;
            }
            if (c1984bB.i() != 18) {
                this.f9827b.a(c1984bB, this.f9826a.a());
                return;
            }
            w0 w0Var4 = this.f9827b;
            Dialog dialogR = w0Var4.f9831e.r(w0Var4.getActivity(), w0Var4);
            w0 w0Var5 = this.f9827b;
            w0Var5.f9831e.s(w0Var5.getActivity().getApplicationContext(), new u0(this, dialogR));
        }
    }
}
