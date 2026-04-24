package com.google.android.gms.common.api.internal;

import P1.C0648b;
import P1.C0652f;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.base.zau;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class t0 extends AbstractC1173j implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f11002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference f11003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f11004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C0652f f11005d;

    public t0(InterfaceC1174k interfaceC1174k, C0652f c0652f) {
        super(interfaceC1174k);
        this.f11003b = new AtomicReference(null);
        this.f11004c = new zau(Looper.getMainLooper());
        this.f11005d = c0652f;
    }

    public static final int e(q0 q0Var) {
        if (q0Var == null) {
            return -1;
        }
        return q0Var.a();
    }

    public final void a(C0648b c0648b, int i7) {
        this.f11003b.set(null);
        b(c0648b, i7);
    }

    public abstract void b(C0648b c0648b, int i7);

    public abstract void c();

    public final void d() {
        this.f11003b.set(null);
        c();
    }

    public final void h(C0648b c0648b, int i7) {
        AtomicReference atomicReference;
        q0 q0Var = new q0(c0648b, i7);
        do {
            atomicReference = this.f11003b;
            if (com.amazon.a.a.l.d.a(atomicReference, null, q0Var)) {
                this.f11004c.post(new s0(this, q0Var));
                return;
            }
        } while (atomicReference.get() == null);
    }

    @Override // com.google.android.gms.common.api.internal.AbstractC1173j
    public final void onActivityResult(int i7, int i8, Intent intent) {
        q0 q0Var = (q0) this.f11003b.get();
        if (i7 != 1) {
            if (i7 == 2) {
                int iG = this.f11005d.g(getActivity());
                if (iG == 0) {
                    d();
                    return;
                } else {
                    if (q0Var == null) {
                        return;
                    }
                    if (q0Var.b().A() == 18 && iG == 18) {
                        return;
                    }
                }
            }
        } else if (i8 == -1) {
            d();
            return;
        } else if (i8 == 0) {
            if (q0Var != null) {
                a(new C0648b(intent != null ? intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13) : 13, null, q0Var.b().toString()), e(q0Var));
                return;
            }
            return;
        }
        if (q0Var != null) {
            a(q0Var.b(), q0Var.a());
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        a(new C0648b(13, null), e((q0) this.f11003b.get()));
    }

    @Override // com.google.android.gms.common.api.internal.AbstractC1173j
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f11003b.set(bundle.getBoolean("resolving_error", false) ? new q0(new C0648b(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    @Override // com.google.android.gms.common.api.internal.AbstractC1173j
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        q0 q0Var = (q0) this.f11003b.get();
        if (q0Var == null) {
            return;
        }
        bundle.putBoolean("resolving_error", true);
        bundle.putInt("failed_client_id", q0Var.a());
        bundle.putInt("failed_status", q0Var.b().A());
        bundle.putParcelable("failed_resolution", q0Var.b().C());
    }

    @Override // com.google.android.gms.common.api.internal.AbstractC1173j
    public void onStart() {
        super.onStart();
        this.f11002a = true;
    }

    @Override // com.google.android.gms.common.api.internal.AbstractC1173j
    public void onStop() {
        super.onStop();
        this.f11002a = false;
    }
}
