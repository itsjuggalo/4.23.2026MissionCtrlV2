package S1;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class N5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f4129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f4131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ n7 f4132d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ C0565e6 f4133e;

    public N5(C0565e6 c0565e6, AtomicReference atomicReference, String str, String str2, String str3, n7 n7Var) {
        this.f4129a = atomicReference;
        this.f4130b = str2;
        this.f4131c = str3;
        this.f4132d = n7Var;
        Objects.requireNonNull(c0565e6);
        this.f4133e = c0565e6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        C0565e6 c0565e6;
        InterfaceC0601j2 interfaceC0601j2N;
        AtomicReference atomicReference2 = this.f4129a;
        synchronized (atomicReference2) {
            try {
                try {
                    c0565e6 = this.f4133e;
                    interfaceC0601j2N = c0565e6.N();
                } catch (RemoteException e4) {
                    this.f4133e.f4245a.a().o().d("(legacy) Failed to get conditional properties; remote exception", null, this.f4130b, e4);
                    this.f4129a.set(Collections.EMPTY_LIST);
                    atomicReference = this.f4129a;
                }
                if (interfaceC0601j2N == null) {
                    c0565e6.f4245a.a().o().d("(legacy) Failed to get conditional properties; not connected to service", null, this.f4130b, this.f4131c);
                    atomicReference2.set(Collections.EMPTY_LIST);
                    atomicReference2.notify();
                    return;
                }
                if (TextUtils.isEmpty(null)) {
                    n7 n7Var = this.f4132d;
                    AbstractC0940s.k(n7Var);
                    atomicReference2.set(interfaceC0601j2N.C(this.f4130b, this.f4131c, n7Var));
                } else {
                    atomicReference2.set(interfaceC0601j2N.u(null, this.f4130b, this.f4131c));
                }
                c0565e6.J();
                atomicReference = this.f4129a;
                atomicReference.notify();
            } catch (Throwable th) {
                this.f4129a.notify();
                throw th;
            }
        }
    }
}
