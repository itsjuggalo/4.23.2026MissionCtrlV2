package t5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import r5.C2601q;
import r5.EnumC2600p;
import r5.S;

/* JADX INFO: renamed from: t5.u0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2703u0 extends r5.S {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final S.e f24188g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public S.i f24189h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public EnumC2600p f24190i = EnumC2600p.IDLE;

    /* JADX INFO: renamed from: t5.u0$a */
    public class a implements S.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ S.i f24191a;

        public a(S.i iVar) {
            this.f24191a = iVar;
        }

        @Override // r5.S.k
        public void a(C2601q c2601q) {
            C2703u0.this.i(this.f24191a, c2601q);
        }
    }

    /* JADX INFO: renamed from: t5.u0$b */
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f24193a;

        static {
            int[] iArr = new int[EnumC2600p.values().length];
            f24193a = iArr;
            try {
                iArr[EnumC2600p.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f24193a[EnumC2600p.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f24193a[EnumC2600p.READY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f24193a[EnumC2600p.TRANSIENT_FAILURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: renamed from: t5.u0$c */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Boolean f24194a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Long f24195b;

        public c(Boolean bool) {
            this(bool, null);
        }

        public c(Boolean bool, Long l7) {
            this.f24194a = bool;
            this.f24195b = l7;
        }
    }

    /* JADX INFO: renamed from: t5.u0$d */
    public static final class d extends S.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final S.f f24196a;

        public d(S.f fVar) {
            this.f24196a = (S.f) H2.m.o(fVar, "result");
        }

        @Override // r5.S.j
        public S.f a(S.g gVar) {
            return this.f24196a;
        }

        public String toString() {
            return H2.g.a(d.class).d("result", this.f24196a).toString();
        }
    }

    /* JADX INFO: renamed from: t5.u0$e */
    public final class e extends S.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final S.i f24197a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicBoolean f24198b = new AtomicBoolean(false);

        /* JADX INFO: renamed from: t5.u0$e$a */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.f24197a.f();
            }
        }

        public e(S.i iVar) {
            this.f24197a = (S.i) H2.m.o(iVar, "subchannel");
        }

        @Override // r5.S.j
        public S.f a(S.g gVar) {
            if (this.f24198b.compareAndSet(false, true)) {
                C2703u0.this.f24188g.d().execute(new a());
            }
            return S.f.g();
        }
    }

    public C2703u0(S.e eVar) {
        this.f24188g = (S.e) H2.m.o(eVar, "helper");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(S.i iVar, C2601q c2601q) {
        S.j eVar;
        S.j dVar;
        EnumC2600p enumC2600pC = c2601q.c();
        if (enumC2600pC == EnumC2600p.SHUTDOWN) {
            return;
        }
        EnumC2600p enumC2600p = EnumC2600p.TRANSIENT_FAILURE;
        if (enumC2600pC == enumC2600p || enumC2600pC == EnumC2600p.IDLE) {
            this.f24188g.e();
        }
        if (this.f24190i == enumC2600p) {
            if (enumC2600pC == EnumC2600p.CONNECTING) {
                return;
            }
            if (enumC2600pC == EnumC2600p.IDLE) {
                e();
                return;
            }
        }
        int i7 = b.f24193a[enumC2600pC.ordinal()];
        if (i7 != 1) {
            if (i7 == 2) {
                dVar = new d(S.f.g());
            } else if (i7 == 3) {
                eVar = new d(S.f.h(iVar));
            } else {
                if (i7 != 4) {
                    throw new IllegalArgumentException("Unsupported state:" + enumC2600pC);
                }
                dVar = new d(S.f.f(c2601q.d()));
            }
            j(enumC2600pC, dVar);
        }
        eVar = new e(iVar);
        dVar = eVar;
        j(enumC2600pC, dVar);
    }

    private void j(EnumC2600p enumC2600p, S.j jVar) {
        this.f24190i = enumC2600p;
        this.f24188g.f(enumC2600p, jVar);
    }

    @Override // r5.S
    public r5.l0 a(S.h hVar) {
        c cVar;
        Boolean bool;
        List listA = hVar.a();
        if (listA.isEmpty()) {
            r5.l0 l0VarQ = r5.l0.f22720t.q("NameResolver returned no usable address. addrs=" + hVar.a() + ", attrs=" + hVar.b());
            c(l0VarQ);
            return l0VarQ;
        }
        if ((hVar.c() instanceof c) && (bool = (cVar = (c) hVar.c()).f24194a) != null && bool.booleanValue()) {
            ArrayList arrayList = new ArrayList(listA);
            Collections.shuffle(arrayList, cVar.f24195b != null ? new Random(cVar.f24195b.longValue()) : new Random());
            listA = arrayList;
        }
        S.i iVar = this.f24189h;
        if (iVar == null) {
            S.i iVarA = this.f24188g.a(S.b.d().e(listA).c());
            iVarA.h(new a(iVarA));
            this.f24189h = iVarA;
            j(EnumC2600p.CONNECTING, new d(S.f.h(iVarA)));
            iVarA.f();
        } else {
            iVar.i(listA);
        }
        return r5.l0.f22705e;
    }

    @Override // r5.S
    public void c(r5.l0 l0Var) {
        S.i iVar = this.f24189h;
        if (iVar != null) {
            iVar.g();
            this.f24189h = null;
        }
        j(EnumC2600p.TRANSIENT_FAILURE, new d(S.f.f(l0Var)));
    }

    @Override // r5.S
    public void e() {
        S.i iVar = this.f24189h;
        if (iVar != null) {
            iVar.f();
        }
    }

    @Override // r5.S
    public void f() {
        S.i iVar = this.f24189h;
        if (iVar != null) {
            iVar.g();
        }
    }
}
