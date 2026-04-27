package u3;

import W2.E;
import Z2.i;
import android.os.Handler;
import android.os.Looper;
import i3.k;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import o3.AbstractC1681l;
import t3.A0;
import t3.C1803a0;
import t3.InterfaceC1807c0;
import t3.InterfaceC1830o;
import t3.K0;
import t3.V;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends e implements V {
    private volatile d _immediate;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f15103c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f15104d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f15105e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f15106f;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC1830o f15107a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f15108b;

        public a(InterfaceC1830o interfaceC1830o, d dVar) {
            this.f15107a = interfaceC1830o;
            this.f15108b = dVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f15107a.j(this.f15108b, E.f5463a);
        }
    }

    public static final class b extends s implements k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f15110b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Runnable runnable) {
            super(1);
            this.f15110b = runnable;
        }

        public final void a(Throwable th) {
            d.this.f15103c.removeCallbacks(this.f15110b);
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return E.f5463a;
        }
    }

    public d(Handler handler, String str, boolean z4) {
        super(null);
        this.f15103c = handler;
        this.f15104d = str;
        this.f15105e = z4;
        this._immediate = z4 ? this : null;
        d dVar = this._immediate;
        if (dVar == null) {
            dVar = new d(handler, str, true);
            this._immediate = dVar;
        }
        this.f15106f = dVar;
    }

    public static final void m0(d dVar, Runnable runnable) {
        dVar.f15103c.removeCallbacks(runnable);
    }

    @Override // t3.V
    public InterfaceC1807c0 a0(long j4, final Runnable runnable, i iVar) {
        if (this.f15103c.postDelayed(runnable, AbstractC1681l.e(j4, 4611686018427387903L))) {
            return new InterfaceC1807c0() { // from class: u3.c
                @Override // t3.InterfaceC1807c0
                public final void dispose() {
                    d.m0(this.f15101a, runnable);
                }
            };
        }
        k0(iVar, runnable);
        return K0.f14951a;
    }

    @Override // t3.I
    public void d0(i iVar, Runnable runnable) {
        if (this.f15103c.post(runnable)) {
            return;
        }
        k0(iVar, runnable);
    }

    @Override // t3.I
    public boolean e0(i iVar) {
        return (this.f15105e && r.b(Looper.myLooper(), this.f15103c.getLooper())) ? false : true;
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && ((d) obj).f15103c == this.f15103c;
    }

    public int hashCode() {
        return System.identityHashCode(this.f15103c);
    }

    public final void k0(i iVar, Runnable runnable) {
        A0.c(iVar, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        C1803a0.b().d0(iVar, runnable);
    }

    @Override // t3.I0
    /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] */
    public d g0() {
        return this.f15106f;
    }

    @Override // t3.V
    public void p(long j4, InterfaceC1830o interfaceC1830o) {
        a aVar = new a(interfaceC1830o, this);
        if (this.f15103c.postDelayed(aVar, AbstractC1681l.e(j4, 4611686018427387903L))) {
            interfaceC1830o.g(new b(aVar));
        } else {
            k0(interfaceC1830o.getContext(), aVar);
        }
    }

    @Override // t3.I
    public String toString() {
        String strH0 = h0();
        if (strH0 != null) {
            return strH0;
        }
        String string = this.f15104d;
        if (string == null) {
            string = this.f15103c.toString();
        }
        if (!this.f15105e) {
            return string;
        }
        return string + ".immediate";
    }

    public /* synthetic */ d(Handler handler, String str, int i4, AbstractC1585j abstractC1585j) {
        this(handler, (i4 & 2) != 0 ? null : str);
    }

    public d(Handler handler, String str) {
        this(handler, str, false);
    }
}
