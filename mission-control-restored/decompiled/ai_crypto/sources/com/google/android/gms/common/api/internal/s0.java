package com.google.android.gms.common.api.internal;

import P1.C0648b;
import android.app.Dialog;
import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: loaded from: classes.dex */
public final class s0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q0 f11000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t0 f11001b;

    public s0(t0 t0Var, q0 q0Var) {
        this.f11001b = t0Var;
        this.f11000a = q0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f11001b.f11002a) {
            C0648b c0648bB = this.f11000a.b();
            if (c0648bB.D()) {
                t0 t0Var = this.f11001b;
                t0Var.mLifecycleFragment.startActivityForResult(GoogleApiActivity.a(t0Var.getActivity(), (PendingIntent) AbstractC1207s.k(c0648bB.C()), this.f11000a.a(), false), 1);
                return;
            }
            t0 t0Var2 = this.f11001b;
            if (t0Var2.f11005d.b(t0Var2.getActivity(), c0648bB.A(), null) != null) {
                t0 t0Var3 = this.f11001b;
                t0Var3.f11005d.w(t0Var3.getActivity(), t0Var3.mLifecycleFragment, c0648bB.A(), 2, this.f11001b);
                return;
            }
            if (c0648bB.A() != 18) {
                this.f11001b.a(c0648bB, this.f11000a.a());
                return;
            }
            t0 t0Var4 = this.f11001b;
            Dialog dialogR = t0Var4.f11005d.r(t0Var4.getActivity(), t0Var4);
            t0 t0Var5 = this.f11001b;
            t0Var5.f11005d.s(t0Var5.getActivity().getApplicationContext(), new r0(this, dialogR));
        }
    }
}
