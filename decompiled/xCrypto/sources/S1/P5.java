package S1;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class P5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f4170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f4172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ n7 f4173d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f4174e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ C0565e6 f4175f;

    public P5(C0565e6 c0565e6, AtomicReference atomicReference, String str, String str2, String str3, n7 n7Var, boolean z4) {
        this.f4170a = atomicReference;
        this.f4171b = str2;
        this.f4172c = str3;
        this.f4173d = n7Var;
        this.f4174e = z4;
        Objects.requireNonNull(c0565e6);
        this.f4175f = c0565e6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        C0565e6 c0565e6;
        InterfaceC0601j2 interfaceC0601j2N;
        AtomicReference atomicReference2 = this.f4170a;
        synchronized (atomicReference2) {
            try {
                try {
                    c0565e6 = this.f4175f;
                    interfaceC0601j2N = c0565e6.N();
                } catch (RemoteException e4) {
                    this.f4175f.f4245a.a().o().d("(legacy) Failed to get user properties; remote exception", null, this.f4171b, e4);
                    this.f4170a.set(Collections.EMPTY_LIST);
                    atomicReference = this.f4170a;
                }
                if (interfaceC0601j2N == null) {
                    c0565e6.f4245a.a().o().d("(legacy) Failed to get user properties; not connected to service", null, this.f4171b, this.f4172c);
                    atomicReference2.set(Collections.EMPTY_LIST);
                    atomicReference2.notify();
                    return;
                }
                if (TextUtils.isEmpty(null)) {
                    n7 n7Var = this.f4173d;
                    AbstractC0940s.k(n7Var);
                    atomicReference2.set(interfaceC0601j2N.P(this.f4171b, this.f4172c, this.f4174e, n7Var));
                } else {
                    atomicReference2.set(interfaceC0601j2N.d(null, this.f4171b, this.f4172c, this.f4174e));
                }
                c0565e6.J();
                atomicReference = this.f4170a;
                atomicReference.notify();
            } catch (Throwable th) {
                this.f4170a.notify();
                throw th;
            }
        }
    }
}
