package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiActivity;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class m1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k1 f5605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n1 f5606b;

    public m1(n1 n1Var, k1 k1Var) {
        Objects.requireNonNull(n1Var);
        this.f5606b = n1Var;
        this.f5605a = k1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        n1 n1Var = this.f5606b;
        if (n1Var.f5608a) {
            k1 k1Var = this.f5605a;
            m5.b bVarB = k1Var.b();
            if (bVarB.U()) {
                n1Var.mLifecycleFragment.startActivityForResult(GoogleApiActivity.a(n1Var.getActivity(), (PendingIntent) com.google.android.gms.common.internal.s.k(bVarB.T()), k1Var.a(), false), 1);
                return;
            }
            Activity activity = n1Var.getActivity();
            int iR = bVarB.R();
            m5.e eVar = n1Var.f5611d;
            if (eVar.b(activity, iR, null) != null) {
                eVar.r(n1Var.getActivity(), n1Var.mLifecycleFragment, bVarB.R(), 2, n1Var);
            } else if (bVarB.R() != 18) {
                n1Var.h(bVarB, k1Var.a());
            } else {
                eVar.v(n1Var.getActivity().getApplicationContext(), new l1(this, eVar.u(n1Var.getActivity(), n1Var)));
            }
        }
    }
}
