package G4;

import F4.C0503q;
import F4.EnumC0502p;
import F4.P;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import v2.AbstractC2842h;
import v2.AbstractC2848n;

/* JADX INFO: renamed from: G4.u0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0556u0 extends F4.P {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final P.e f3215g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public P.i f3216h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public EnumC0502p f3217i = EnumC0502p.IDLE;

    /* JADX INFO: renamed from: G4.u0$a */
    public class a implements P.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ P.i f3218a;

        public a(P.i iVar) {
            this.f3218a = iVar;
        }

        @Override // F4.P.k
        public void a(C0503q c0503q) {
            C0556u0.this.i(this.f3218a, c0503q);
        }
    }

    /* JADX INFO: renamed from: G4.u0$b */
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3220a;

        static {
            int[] iArr = new int[EnumC0502p.values().length];
            f3220a = iArr;
            try {
                iArr[EnumC0502p.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3220a[EnumC0502p.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3220a[EnumC0502p.READY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3220a[EnumC0502p.TRANSIENT_FAILURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: renamed from: G4.u0$c */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Boolean f3221a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Long f3222b;

        public c(Boolean bool) {
            this(bool, null);
        }

        public c(Boolean bool, Long l8) {
            this.f3221a = bool;
            this.f3222b = l8;
        }
    }

    /* JADX INFO: renamed from: G4.u0$d */
    public static final class d extends P.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final P.f f3223a;

        public d(P.f fVar) {
            this.f3223a = (P.f) AbstractC2848n.o(fVar, "result");
        }

        @Override // F4.P.j
        public P.f a(P.g gVar) {
            return this.f3223a;
        }

        public String toString() {
            return AbstractC2842h.a(d.class).d("result", this.f3223a).toString();
        }
    }

    /* JADX INFO: renamed from: G4.u0$e */
    public final class e extends P.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final P.i f3224a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicBoolean f3225b = new AtomicBoolean(false);

        /* JADX INFO: renamed from: G4.u0$e$a */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.f3224a.f();
            }
        }

        public e(P.i iVar) {
            this.f3224a = (P.i) AbstractC2848n.o(iVar, "subchannel");
        }

        @Override // F4.P.j
        public P.f a(P.g gVar) {
            if (this.f3225b.compareAndSet(false, true)) {
                C0556u0.this.f3215g.d().execute(new a());
            }
            return P.f.g();
        }
    }

    public C0556u0(P.e eVar) {
        this.f3215g = (P.e) AbstractC2848n.o(eVar, "helper");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(P.i iVar, C0503q c0503q) {
        P.j eVar;
        P.j dVar;
        EnumC0502p enumC0502pC = c0503q.c();
        if (enumC0502pC == EnumC0502p.SHUTDOWN) {
            return;
        }
        EnumC0502p enumC0502p = EnumC0502p.TRANSIENT_FAILURE;
        if (enumC0502pC == enumC0502p || enumC0502pC == EnumC0502p.IDLE) {
            this.f3215g.e();
        }
        if (this.f3217i == enumC0502p) {
            if (enumC0502pC == EnumC0502p.CONNECTING) {
                return;
            }
            if (enumC0502pC == EnumC0502p.IDLE) {
                e();
                return;
            }
        }
        int i8 = b.f3220a[enumC0502pC.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                dVar = new d(P.f.g());
            } else if (i8 == 3) {
                eVar = new d(P.f.h(iVar));
            } else {
                if (i8 != 4) {
                    throw new IllegalArgumentException("Unsupported state:" + enumC0502pC);
                }
                dVar = new d(P.f.f(c0503q.d()));
            }
            j(enumC0502pC, dVar);
        }
        eVar = new e(iVar);
        dVar = eVar;
        j(enumC0502pC, dVar);
    }

    private void j(EnumC0502p enumC0502p, P.j jVar) {
        this.f3217i = enumC0502p;
        this.f3215g.f(enumC0502p, jVar);
    }

    @Override // F4.P
    public F4.j0 a(P.h hVar) {
        c cVar;
        Boolean bool;
        List listA = hVar.a();
        if (listA.isEmpty()) {
            F4.j0 j0VarR = F4.j0.f1812t.r("NameResolver returned no usable address. addrs=" + hVar.a() + ", attrs=" + hVar.b());
            c(j0VarR);
            return j0VarR;
        }
        if ((hVar.c() instanceof c) && (bool = (cVar = (c) hVar.c()).f3221a) != null && bool.booleanValue()) {
            ArrayList arrayList = new ArrayList(listA);
            Collections.shuffle(arrayList, cVar.f3222b != null ? new Random(cVar.f3222b.longValue()) : new Random());
            listA = arrayList;
        }
        P.i iVar = this.f3216h;
        if (iVar == null) {
            P.i iVarA = this.f3215g.a(P.b.d().e(listA).c());
            iVarA.h(new a(iVarA));
            this.f3216h = iVarA;
            j(EnumC0502p.CONNECTING, new d(P.f.h(iVarA)));
            iVarA.f();
        } else {
            iVar.i(listA);
        }
        return F4.j0.f1797e;
    }

    @Override // F4.P
    public void c(F4.j0 j0Var) {
        P.i iVar = this.f3216h;
        if (iVar != null) {
            iVar.g();
            this.f3216h = null;
        }
        j(EnumC0502p.TRANSIENT_FAILURE, new d(P.f.f(j0Var)));
    }

    @Override // F4.P
    public void e() {
        P.i iVar = this.f3216h;
        if (iVar != null) {
            iVar.f();
        }
    }

    @Override // F4.P
    public void f() {
        P.i iVar = this.f3216h;
        if (iVar != null) {
            iVar.g();
        }
    }
}
