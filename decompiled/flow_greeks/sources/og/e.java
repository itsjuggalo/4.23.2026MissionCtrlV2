package og;

import android.os.Handler;
import android.os.Looper;
import cd.h0;
import gd.i;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.t;
import ng.b2;
import ng.c1;
import ng.e1;
import ng.l2;
import ng.n;
import ng.w0;
import pd.k;
import vd.l;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends f implements w0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f18140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f18141d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f18142e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e f18143f;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f18144a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f18145b;

        public a(n nVar, e eVar) {
            this.f18144a = nVar;
            this.f18145b = eVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f18144a.j(this.f18145b, h0.f3852a);
        }
    }

    public e(Handler handler, String str, boolean z10) {
        super(null);
        this.f18140c = handler;
        this.f18141d = str;
        this.f18142e = z10;
        this.f18143f = z10 ? this : new e(handler, str, true);
    }

    public static final void k0(e eVar, Runnable runnable) {
        eVar.f18140c.removeCallbacks(runnable);
    }

    public static final h0 l0(e eVar, Runnable runnable, Throwable th) {
        eVar.f18140c.removeCallbacks(runnable);
        return h0.f3852a;
    }

    @Override // ng.w0
    public e1 K(long j10, final Runnable runnable, i iVar) {
        if (this.f18140c.postDelayed(runnable, l.e(j10, 4611686018427387903L))) {
            return new e1() { // from class: og.c
                @Override // ng.e1
                public final void dispose() {
                    e.k0(this.f18136a, runnable);
                }
            };
        }
        i0(iVar, runnable);
        return l2.f17156a;
    }

    @Override // ng.k0
    public void Z(i iVar, Runnable runnable) {
        if (this.f18140c.post(runnable)) {
            return;
        }
        i0(iVar, runnable);
    }

    @Override // ng.k0
    public boolean a0(i iVar) {
        return (this.f18142e && t.b(Looper.myLooper(), this.f18140c.getLooper())) ? false : true;
    }

    @Override // ng.w0
    public void b(long j10, n nVar) {
        final a aVar = new a(nVar, this);
        if (this.f18140c.postDelayed(aVar, l.e(j10, 4611686018427387903L))) {
            nVar.f(new k() { // from class: og.d
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return e.l0(this.f18138a, aVar, (Throwable) obj);
                }
            });
        } else {
            i0(nVar.getContext(), aVar);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return eVar.f18140c == this.f18140c && eVar.f18142e == this.f18142e;
    }

    public int hashCode() {
        return System.identityHashCode(this.f18140c) ^ (this.f18142e ? 1231 : 1237);
    }

    public final void i0(i iVar, Runnable runnable) {
        b2.c(iVar, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        c1.b().Z(iVar, runnable);
    }

    @Override // ng.i2
    /* JADX INFO: renamed from: j0, reason: merged with bridge method [inline-methods] */
    public e e0() {
        return this.f18143f;
    }

    @Override // ng.k0
    public String toString() {
        String strF0 = f0();
        if (strF0 != null) {
            return strF0;
        }
        String string = this.f18141d;
        if (string == null) {
            string = this.f18140c.toString();
        }
        if (!this.f18142e) {
            return string;
        }
        return string + ".immediate";
    }

    public /* synthetic */ e(Handler handler, String str, int i10, kotlin.jvm.internal.k kVar) {
        this(handler, (i10 & 2) != 0 ? null : str);
    }

    public e(Handler handler, String str) {
        this(handler, str, false);
    }
}
