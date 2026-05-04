package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.base.zao;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class n1 extends j implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f5608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference f5609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f5610c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m5.e f5611d;

    public n1(k kVar, m5.e eVar) {
        super(kVar);
        this.f5609b = new AtomicReference(null);
        this.f5610c = new zao(Looper.getMainLooper());
        this.f5611d = eVar;
    }

    public static final int c(k1 k1Var) {
        if (k1Var == null) {
            return -1;
        }
        return k1Var.a();
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void g() {
        this.f5609b.set(null);
        e();
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final void h(m5.b bVar, int i10) {
        this.f5609b.set(null);
        d(bVar, i10);
    }

    public abstract void d(m5.b bVar, int i10);

    public abstract void e();

    public final void f(m5.b bVar, int i10) {
        k1 k1Var = new k1(bVar, i10);
        if (com.amazon.a.a.l.d.a(this.f5609b, null, k1Var)) {
            this.f5610c.post(new m1(this, k1Var));
        }
    }

    @Override // com.google.android.gms.common.api.internal.j
    public final void onActivityResult(int i10, int i11, Intent intent) {
        k1 k1Var = (k1) this.f5609b.get();
        if (i10 != 1) {
            if (i10 == 2) {
                int iG = this.f5611d.g(getActivity());
                if (iG == 0) {
                    g();
                    return;
                } else {
                    if (k1Var == null) {
                        return;
                    }
                    if (k1Var.b().R() == 18 && iG == 18) {
                        return;
                    }
                }
            }
        } else if (i11 == -1) {
            g();
            return;
        } else if (i11 == 0) {
            if (k1Var != null) {
                h(new m5.b(intent != null ? intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13) : 13, null, k1Var.b().toString()), c(k1Var));
                return;
            }
            return;
        }
        if (k1Var != null) {
            h(k1Var.b(), k1Var.a());
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        h(new m5.b(13, null), c((k1) this.f5609b.get()));
    }

    @Override // com.google.android.gms.common.api.internal.j
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f5609b.set(bundle.getBoolean("resolving_error", false) ? new k1(new m5.b(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    @Override // com.google.android.gms.common.api.internal.j
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        k1 k1Var = (k1) this.f5609b.get();
        if (k1Var == null) {
            return;
        }
        bundle.putBoolean("resolving_error", true);
        bundle.putInt("failed_client_id", k1Var.a());
        bundle.putInt("failed_status", k1Var.b().R());
        bundle.putParcelable("failed_resolution", k1Var.b().T());
    }

    @Override // com.google.android.gms.common.api.internal.j
    public void onStart() {
        super.onStart();
        this.f5608a = true;
    }

    @Override // com.google.android.gms.common.api.internal.j
    public void onStop() {
        super.onStop();
        this.f5608a = false;
    }
}
