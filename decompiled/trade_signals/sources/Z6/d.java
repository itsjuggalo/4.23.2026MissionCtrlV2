package Z6;

import B5.k;
import H5.i;
import Y6.C0994a0;
import Y6.InterfaceC1015l;
import Y6.V;
import Y6.x0;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2470H;
import s5.InterfaceC2711i;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends e implements V {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f9797c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f9798d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f9799e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f9800f;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC1015l f9801a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f9802b;

        public a(InterfaceC1015l interfaceC1015l, d dVar) {
            this.f9801a = interfaceC1015l;
            this.f9802b = dVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f9801a.g(this.f9802b, C2470H.f21956a);
        }
    }

    public d(Handler handler, String str) {
        this(handler, str, false);
    }

    public static final C2470H E0(d dVar, Runnable runnable, Throwable th) {
        dVar.f9797c.removeCallbacks(runnable);
        return C2470H.f21956a;
    }

    public final void C0(InterfaceC2711i interfaceC2711i, Runnable runnable) {
        x0.c(interfaceC2711i, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        C0994a0.b().v0(interfaceC2711i, runnable);
    }

    @Override // Y6.E0
    /* JADX INFO: renamed from: D0, reason: merged with bridge method [inline-methods] */
    public d z0() {
        return this.f9800f;
    }

    @Override // Y6.V
    public void U(long j8, InterfaceC1015l interfaceC1015l) {
        final a aVar = new a(interfaceC1015l, this);
        if (this.f9797c.postDelayed(aVar, i.e(j8, 4611686018427387903L))) {
            interfaceC1015l.p(new k() { // from class: Z6.c
                @Override // B5.k
                public final Object invoke(Object obj) {
                    return d.E0(this.f9795a, aVar, (Throwable) obj);
                }
            });
        } else {
            C0(interfaceC1015l.getContext(), aVar);
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (dVar.f9797c == this.f9797c && dVar.f9799e == this.f9799e) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return System.identityHashCode(this.f9797c) ^ (this.f9799e ? 1231 : 1237);
    }

    @Override // Y6.I
    public String toString() {
        String strA0 = A0();
        if (strA0 != null) {
            return strA0;
        }
        String string = this.f9798d;
        if (string == null) {
            string = this.f9797c.toString();
        }
        if (!this.f9799e) {
            return string;
        }
        return string + ".immediate";
    }

    @Override // Y6.I
    public void v0(InterfaceC2711i interfaceC2711i, Runnable runnable) {
        if (this.f9797c.post(runnable)) {
            return;
        }
        C0(interfaceC2711i, runnable);
    }

    @Override // Y6.I
    public boolean w0(InterfaceC2711i interfaceC2711i) {
        return (this.f9799e && AbstractC2304t.b(Looper.myLooper(), this.f9797c.getLooper())) ? false : true;
    }

    public /* synthetic */ d(Handler handler, String str, int i8, AbstractC2296k abstractC2296k) {
        this(handler, (i8 & 2) != 0 ? null : str);
    }

    public d(Handler handler, String str, boolean z7) {
        super(null);
        this.f9797c = handler;
        this.f9798d = str;
        this.f9799e = z7;
        this.f9800f = z7 ? this : new d(handler, str, true);
    }
}
