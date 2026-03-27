package N1;

import android.os.Binder;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzt;
import f0.RunnableC0584a;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.Callable;
import n3.C0874a;

/* JADX INFO: renamed from: N1.m0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CallableC0112m0 implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1695b;

    public /* synthetic */ CallableC0112m0(Object obj, int i) {
        this.f1694a = i;
        this.f1695b = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws IOException {
        String str;
        switch (this.f1694a) {
            case 0:
                return new zzt(((C0115n0) this.f1695b).f1723o);
            case 1:
                C0 c02 = (C0) this.f1695b;
                c02.f1121a.B();
                C0076a0 c0076a0 = c02.f1121a.f1384l;
                U1.T(c0076a0);
                c0076a0.p();
                throw new IllegalStateException("Unexpected call on client side");
            case 2:
                com.google.firebase.storage.w wVar = (com.google.firebase.storage.w) this.f1695b;
                wVar.f5615m.e = false;
                C0874a c0874a = wVar.f5622t;
                if (c0874a != null) {
                    c0874a.o();
                }
                C0874a c0874a2 = new C0874a(wVar.f5614l.b(), wVar.f5614l.f5583b.f5552a, wVar.f5619q);
                wVar.f5622t = c0874a2;
                wVar.f5615m.a(c0874a2, false);
                wVar.f5617o = wVar.f5622t.e;
                Exception exc = wVar.f5622t.f8561a;
                if (exc == null) {
                    exc = wVar.f5616n;
                }
                wVar.f5616n = exc;
                int i = wVar.f5617o;
                if ((i != 308 && (i < 200 || i >= 300)) || wVar.f5616n != null || wVar.f5604h != 4) {
                    throw new IOException("Could not open resulting stream.");
                }
                String strJ = wVar.f5622t.j("ETag");
                if (!TextUtils.isEmpty(strJ) && (str = wVar.f5623u) != null && !str.equals(strJ)) {
                    wVar.f5617o = 409;
                    throw new IOException("The ETag on the server changed.");
                }
                wVar.f5623u = strJ;
                C0874a c0874a3 = wVar.f5622t;
                int i6 = c0874a3.f8566g;
                return c0874a3.f8567h;
            default:
                RunnableC0584a runnableC0584a = (RunnableC0584a) this.f1695b;
                runnableC0584a.f6396d.set(true);
                try {
                    Process.setThreadPriority(10);
                    runnableC0584a.e.d();
                    Binder.flushPendingCommands();
                    return null;
                } finally {
                }
        }
    }

    public CallableC0112m0(C0 c02, C0134u c0134u, String str) {
        this.f1694a = 1;
        Objects.requireNonNull(c02);
        this.f1695b = c02;
    }
}
