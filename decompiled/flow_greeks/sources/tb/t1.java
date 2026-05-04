package tb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import rb.r0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class t1 extends rb.r0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final r0.e f21732g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public r0.i f21733h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public rb.p f21734i = rb.p.IDLE;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements r0.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r0.i f21735a;

        public a(r0.i iVar) {
            this.f21735a = iVar;
        }

        @Override // rb.r0.k
        public void a(rb.q qVar) {
            t1.this.i(this.f21735a, qVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21737a;

        static {
            int[] iArr = new int[rb.p.values().length];
            f21737a = iArr;
            try {
                iArr[rb.p.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21737a[rb.p.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f21737a[rb.p.READY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f21737a[rb.p.TRANSIENT_FAILURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Boolean f21738a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Long f21739b;

        public c(Boolean bool) {
            this(bool, null);
        }

        public c(Boolean bool, Long l10) {
            this.f21738a = bool;
            this.f21739b = l10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d extends r0.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r0.f f21740a;

        public d(r0.f fVar) {
            this.f21740a = (r0.f) p6.n.o(fVar, "result");
        }

        @Override // rb.r0.j
        public r0.f a(r0.g gVar) {
            return this.f21740a;
        }

        public String toString() {
            return p6.h.a(d.class).d("result", this.f21740a).toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class e extends r0.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r0.i f21741a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicBoolean f21742b = new AtomicBoolean(false);

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.f21741a.f();
            }
        }

        public e(r0.i iVar) {
            this.f21741a = (r0.i) p6.n.o(iVar, "subchannel");
        }

        @Override // rb.r0.j
        public r0.f a(r0.g gVar) {
            if (this.f21742b.compareAndSet(false, true)) {
                t1.this.f21732g.d().execute(new a());
            }
            return r0.f.g();
        }
    }

    public t1(r0.e eVar) {
        this.f21732g = (r0.e) p6.n.o(eVar, "helper");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(r0.i iVar, rb.q qVar) {
        r0.j eVar;
        r0.j dVar;
        rb.p pVarC = qVar.c();
        if (pVarC == rb.p.SHUTDOWN) {
            return;
        }
        rb.p pVar = rb.p.TRANSIENT_FAILURE;
        if (pVarC == pVar || pVarC == rb.p.IDLE) {
            this.f21732g.e();
        }
        if (this.f21734i == pVar) {
            if (pVarC == rb.p.CONNECTING) {
                return;
            }
            if (pVarC == rb.p.IDLE) {
                e();
                return;
            }
        }
        int i10 = b.f21737a[pVarC.ordinal()];
        if (i10 != 1) {
            if (i10 == 2) {
                dVar = new d(r0.f.g());
            } else if (i10 == 3) {
                eVar = new d(r0.f.h(iVar));
            } else {
                if (i10 != 4) {
                    throw new IllegalArgumentException("Unsupported state:" + pVarC);
                }
                dVar = new d(r0.f.f(qVar.d()));
            }
            j(pVarC, dVar);
        }
        eVar = new e(iVar);
        dVar = eVar;
        j(pVarC, dVar);
    }

    private void j(rb.p pVar, r0.j jVar) {
        this.f21734i = pVar;
        this.f21732g.f(pVar, jVar);
    }

    @Override // rb.r0
    public rb.k1 a(r0.h hVar) {
        c cVar;
        Boolean bool;
        List listA = hVar.a();
        if (listA.isEmpty()) {
            rb.k1 k1VarR = rb.k1.f19607t.r("NameResolver returned no usable address. addrs=" + hVar.a() + ", attrs=" + hVar.b());
            c(k1VarR);
            return k1VarR;
        }
        if ((hVar.c() instanceof c) && (bool = (cVar = (c) hVar.c()).f21738a) != null && bool.booleanValue()) {
            ArrayList arrayList = new ArrayList(listA);
            Collections.shuffle(arrayList, cVar.f21739b != null ? new Random(cVar.f21739b.longValue()) : new Random());
            listA = arrayList;
        }
        r0.i iVar = this.f21733h;
        if (iVar == null) {
            r0.i iVarA = this.f21732g.a(r0.b.d().e(listA).c());
            iVarA.h(new a(iVarA));
            this.f21733h = iVarA;
            j(rb.p.CONNECTING, new d(r0.f.h(iVarA)));
            iVarA.f();
        } else {
            iVar.i(listA);
        }
        return rb.k1.f19592e;
    }

    @Override // rb.r0
    public void c(rb.k1 k1Var) {
        r0.i iVar = this.f21733h;
        if (iVar != null) {
            iVar.g();
            this.f21733h = null;
        }
        j(rb.p.TRANSIENT_FAILURE, new d(r0.f.f(k1Var)));
    }

    @Override // rb.r0
    public void e() {
        r0.i iVar = this.f21733h;
        if (iVar != null) {
            iVar.f();
        }
    }

    @Override // rb.r0
    public void f() {
        r0.i iVar = this.f21733h;
        if (iVar != null) {
            iVar.g();
        }
    }
}
