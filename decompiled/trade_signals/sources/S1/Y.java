package S1;

import Q1.C0790b;
import Q1.C0794f;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class Y extends AbstractC0875g implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f7382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference f7383c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f7384d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final C0794f f7385e;

    public Y(InterfaceC0876h interfaceC0876h, C0794f c0794f) {
        super(interfaceC0876h);
        this.f7383c = new AtomicReference(null);
        this.f7384d = new c2.h(Looper.getMainLooper());
        this.f7385e = c0794f;
    }

    public static final int p(V v8) {
        if (v8 == null) {
            return -1;
        }
        return v8.a();
    }

    @Override // S1.AbstractC0875g
    public final void e(int i8, int i9, Intent intent) {
        V v8 = (V) this.f7383c.get();
        if (i8 != 1) {
            if (i8 == 2) {
                int iG = this.f7385e.g(b());
                if (iG == 0) {
                    o();
                    return;
                } else {
                    if (v8 == null) {
                        return;
                    }
                    if (v8.b().a() == 18 && iG == 18) {
                        return;
                    }
                }
            }
        } else if (i9 == -1) {
            o();
            return;
        } else if (i9 == 0) {
            if (v8 != null) {
                l(new C0790b(intent != null ? intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13) : 13, null, v8.b().toString()), p(v8));
                return;
            }
            return;
        }
        if (v8 != null) {
            l(v8.b(), v8.a());
        }
    }

    @Override // S1.AbstractC0875g
    public final void f(Bundle bundle) {
        super.f(bundle);
        if (bundle != null) {
            this.f7383c.set(bundle.getBoolean("resolving_error", false) ? new V(new C0790b(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    @Override // S1.AbstractC0875g
    public final void i(Bundle bundle) {
        super.i(bundle);
        V v8 = (V) this.f7383c.get();
        if (v8 == null) {
            return;
        }
        bundle.putBoolean("resolving_error", true);
        bundle.putInt("failed_client_id", v8.a());
        bundle.putInt("failed_status", v8.b().a());
        bundle.putParcelable("failed_resolution", v8.b().e());
    }

    @Override // S1.AbstractC0875g
    public void j() {
        super.j();
        this.f7382b = true;
    }

    @Override // S1.AbstractC0875g
    public void k() {
        super.k();
        this.f7382b = false;
    }

    public final void l(C0790b c0790b, int i8) {
        this.f7383c.set(null);
        m(c0790b, i8);
    }

    public abstract void m(C0790b c0790b, int i8);

    public abstract void n();

    public final void o() {
        this.f7383c.set(null);
        n();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        l(new C0790b(13, null), p((V) this.f7383c.get()));
    }

    public final void s(C0790b c0790b, int i8) {
        AtomicReference atomicReference;
        V v8 = new V(c0790b, i8);
        do {
            atomicReference = this.f7383c;
            if (com.amazon.a.a.l.d.a(atomicReference, null, v8)) {
                this.f7384d.post(new X(this, v8));
                return;
            }
        } while (atomicReference.get() == null);
    }
}
