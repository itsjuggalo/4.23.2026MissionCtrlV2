package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.base.zau;
import java.util.concurrent.atomic.AtomicReference;
import z1.C1984b;
import z1.C1988f;

/* JADX INFO: loaded from: classes.dex */
public abstract class w0 extends AbstractC0907k implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f9828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference f9829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f9830c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final C1988f f9831e;

    public w0(InterfaceC0908l interfaceC0908l, C1988f c1988f) {
        super(interfaceC0908l);
        this.f9829b = new AtomicReference(null);
        this.f9830c = new zau(Looper.getMainLooper());
        this.f9831e = c1988f;
    }

    public static final int e(t0 t0Var) {
        if (t0Var == null) {
            return -1;
        }
        return t0Var.a();
    }

    public final void a(C1984b c1984b, int i4) {
        this.f9829b.set(null);
        b(c1984b, i4);
    }

    public abstract void b(C1984b c1984b, int i4);

    public abstract void c();

    public final void d() {
        this.f9829b.set(null);
        c();
    }

    public final void h(C1984b c1984b, int i4) {
        AtomicReference atomicReference;
        t0 t0Var = new t0(c1984b, i4);
        do {
            atomicReference = this.f9829b;
            if (com.amazon.a.a.l.d.a(atomicReference, null, t0Var)) {
                this.f9830c.post(new v0(this, t0Var));
                return;
            }
        } while (atomicReference.get() == null);
    }

    @Override // com.google.android.gms.common.api.internal.AbstractC0907k
    public final void onActivityResult(int i4, int i5, Intent intent) {
        t0 t0Var = (t0) this.f9829b.get();
        if (i4 != 1) {
            if (i4 == 2) {
                int iG = this.f9831e.g(getActivity());
                if (iG == 0) {
                    d();
                    return;
                } else {
                    if (t0Var == null) {
                        return;
                    }
                    if (t0Var.b().i() == 18 && iG == 18) {
                        return;
                    }
                }
            }
        } else if (i5 == -1) {
            d();
            return;
        } else if (i5 == 0) {
            if (t0Var != null) {
                a(new C1984b(intent != null ? intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13) : 13, null, t0Var.b().toString()), e(t0Var));
                return;
            }
            return;
        }
        if (t0Var != null) {
            a(t0Var.b(), t0Var.a());
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        a(new C1984b(13, null), e((t0) this.f9829b.get()));
    }

    @Override // com.google.android.gms.common.api.internal.AbstractC0907k
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f9829b.set(bundle.getBoolean("resolving_error", false) ? new t0(new C1984b(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    @Override // com.google.android.gms.common.api.internal.AbstractC0907k
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        t0 t0Var = (t0) this.f9829b.get();
        if (t0Var == null) {
            return;
        }
        bundle.putBoolean("resolving_error", true);
        bundle.putInt("failed_client_id", t0Var.a());
        bundle.putInt("failed_status", t0Var.b().i());
        bundle.putParcelable("failed_resolution", t0Var.b().l());
    }

    @Override // com.google.android.gms.common.api.internal.AbstractC0907k
    public void onStart() {
        super.onStart();
        this.f9828a = true;
    }

    @Override // com.google.android.gms.common.api.internal.AbstractC0907k
    public void onStop() {
        super.onStop();
        this.f9828a = false;
    }
}
