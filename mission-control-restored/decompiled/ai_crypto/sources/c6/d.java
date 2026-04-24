package c6;

import E5.E;
import H5.g;
import Q5.k;
import W5.l;
import android.os.Handler;
import android.os.Looper;
import b6.A0;
import b6.C1058a0;
import b6.InterfaceC1062c0;
import b6.InterfaceC1085o;
import b6.K0;
import b6.V;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends e implements V {
    private volatile d _immediate;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f9499c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f9500d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f9501e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f9502f;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC1085o f9503a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f9504b;

        public a(InterfaceC1085o interfaceC1085o, d dVar) {
            this.f9503a = interfaceC1085o;
            this.f9504b = dVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f9503a.i(this.f9504b, E.f1657a);
        }
    }

    public static final class b extends s implements k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f9506b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Runnable runnable) {
            super(1);
            this.f9506b = runnable;
        }

        public final void a(Throwable th) {
            d.this.f9499c.removeCallbacks(this.f9506b);
        }

        @Override // Q5.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return E.f1657a;
        }
    }

    public d(Handler handler, String str, boolean z7) {
        super(null);
        this.f9499c = handler;
        this.f9500d = str;
        this.f9501e = z7;
        this._immediate = z7 ? this : null;
        d dVar = this._immediate;
        if (dVar == null) {
            dVar = new d(handler, str, true);
            this._immediate = dVar;
        }
        this.f9502f = dVar;
    }

    public static final void H0(d dVar, Runnable runnable) {
        dVar.f9499c.removeCallbacks(runnable);
    }

    public final void F0(g gVar, Runnable runnable) {
        A0.c(gVar, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        C1058a0.b().y0(gVar, runnable);
    }

    @Override // b6.V
    public void G(long j7, InterfaceC1085o interfaceC1085o) {
        a aVar = new a(interfaceC1085o, this);
        if (this.f9499c.postDelayed(aVar, l.e(j7, 4611686018427387903L))) {
            interfaceC1085o.g(new b(aVar));
        } else {
            F0(interfaceC1085o.getContext(), aVar);
        }
    }

    @Override // b6.I0
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public d B0() {
        return this.f9502f;
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && ((d) obj).f9499c == this.f9499c;
    }

    public int hashCode() {
        return System.identityHashCode(this.f9499c);
    }

    @Override // b6.V
    public InterfaceC1062c0 i(long j7, final Runnable runnable, g gVar) {
        if (this.f9499c.postDelayed(runnable, l.e(j7, 4611686018427387903L))) {
            return new InterfaceC1062c0() { // from class: c6.c
                @Override // b6.InterfaceC1062c0
                public final void a() {
                    d.H0(this.f9497a, runnable);
                }
            };
        }
        F0(gVar, runnable);
        return K0.f9009a;
    }

    @Override // b6.I
    public String toString() {
        String strC0 = C0();
        if (strC0 != null) {
            return strC0;
        }
        String string = this.f9500d;
        if (string == null) {
            string = this.f9499c.toString();
        }
        if (!this.f9501e) {
            return string;
        }
        return string + ".immediate";
    }

    @Override // b6.I
    public void y0(g gVar, Runnable runnable) {
        if (this.f9499c.post(runnable)) {
            return;
        }
        F0(gVar, runnable);
    }

    @Override // b6.I
    public boolean z0(g gVar) {
        return (this.f9501e && r.b(Looper.myLooper(), this.f9499c.getLooper())) ? false : true;
    }

    public /* synthetic */ d(Handler handler, String str, int i7, AbstractC2148j abstractC2148j) {
        this(handler, (i7 & 2) != 0 ? null : str);
    }

    public d(Handler handler, String str) {
        this(handler, str, false);
    }
}
