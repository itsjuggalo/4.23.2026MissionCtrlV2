package M2;

import K2.C0369q;
import K2.EnumC0368p;
import K2.S;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: M2.u0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0448u0 extends K2.S {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final S.e f2637g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public S.i f2638h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public EnumC0368p f2639i = EnumC0368p.IDLE;

    /* JADX INFO: renamed from: M2.u0$a */
    public class a implements S.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ S.i f2640a;

        public a(S.i iVar) {
            this.f2640a = iVar;
        }

        @Override // K2.S.k
        public void a(C0369q c0369q) {
            C0448u0.this.i(this.f2640a, c0369q);
        }
    }

    /* JADX INFO: renamed from: M2.u0$b */
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2642a;

        static {
            int[] iArr = new int[EnumC0368p.values().length];
            f2642a = iArr;
            try {
                iArr[EnumC0368p.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2642a[EnumC0368p.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2642a[EnumC0368p.READY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2642a[EnumC0368p.TRANSIENT_FAILURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: renamed from: M2.u0$c */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Boolean f2643a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Long f2644b;

        public c(Boolean bool) {
            this(bool, null);
        }

        public c(Boolean bool, Long l4) {
            this.f2643a = bool;
            this.f2644b = l4;
        }
    }

    /* JADX INFO: renamed from: M2.u0$d */
    public static final class d extends S.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final S.f f2645a;

        public d(S.f fVar) {
            this.f2645a = (S.f) Z1.m.o(fVar, "result");
        }

        @Override // K2.S.j
        public S.f a(S.g gVar) {
            return this.f2645a;
        }

        public String toString() {
            return Z1.g.a(d.class).d("result", this.f2645a).toString();
        }
    }

    /* JADX INFO: renamed from: M2.u0$e */
    public final class e extends S.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final S.i f2646a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicBoolean f2647b = new AtomicBoolean(false);

        /* JADX INFO: renamed from: M2.u0$e$a */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.f2646a.f();
            }
        }

        public e(S.i iVar) {
            this.f2646a = (S.i) Z1.m.o(iVar, "subchannel");
        }

        @Override // K2.S.j
        public S.f a(S.g gVar) {
            if (this.f2647b.compareAndSet(false, true)) {
                C0448u0.this.f2637g.d().execute(new a());
            }
            return S.f.g();
        }
    }

    public C0448u0(S.e eVar) {
        this.f2637g = (S.e) Z1.m.o(eVar, "helper");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(S.i iVar, C0369q c0369q) {
        S.j eVar;
        S.j dVar;
        EnumC0368p enumC0368pC = c0369q.c();
        if (enumC0368pC == EnumC0368p.SHUTDOWN) {
            return;
        }
        EnumC0368p enumC0368p = EnumC0368p.TRANSIENT_FAILURE;
        if (enumC0368pC == enumC0368p || enumC0368pC == EnumC0368p.IDLE) {
            this.f2637g.e();
        }
        if (this.f2639i == enumC0368p) {
            if (enumC0368pC == EnumC0368p.CONNECTING) {
                return;
            }
            if (enumC0368pC == EnumC0368p.IDLE) {
                e();
                return;
            }
        }
        int i4 = b.f2642a[enumC0368pC.ordinal()];
        if (i4 != 1) {
            if (i4 == 2) {
                dVar = new d(S.f.g());
            } else if (i4 == 3) {
                eVar = new d(S.f.h(iVar));
            } else {
                if (i4 != 4) {
                    throw new IllegalArgumentException("Unsupported state:" + enumC0368pC);
                }
                dVar = new d(S.f.f(c0369q.d()));
            }
            j(enumC0368pC, dVar);
        }
        eVar = new e(iVar);
        dVar = eVar;
        j(enumC0368pC, dVar);
    }

    private void j(EnumC0368p enumC0368p, S.j jVar) {
        this.f2639i = enumC0368p;
        this.f2637g.f(enumC0368p, jVar);
    }

    @Override // K2.S
    public K2.l0 a(S.h hVar) {
        c cVar;
        Boolean bool;
        List listA = hVar.a();
        if (listA.isEmpty()) {
            K2.l0 l0VarQ = K2.l0.f1230t.q("NameResolver returned no usable address. addrs=" + hVar.a() + ", attrs=" + hVar.b());
            c(l0VarQ);
            return l0VarQ;
        }
        if ((hVar.c() instanceof c) && (bool = (cVar = (c) hVar.c()).f2643a) != null && bool.booleanValue()) {
            ArrayList arrayList = new ArrayList(listA);
            Collections.shuffle(arrayList, cVar.f2644b != null ? new Random(cVar.f2644b.longValue()) : new Random());
            listA = arrayList;
        }
        S.i iVar = this.f2638h;
        if (iVar == null) {
            S.i iVarA = this.f2637g.a(S.b.d().e(listA).c());
            iVarA.h(new a(iVarA));
            this.f2638h = iVarA;
            j(EnumC0368p.CONNECTING, new d(S.f.h(iVarA)));
            iVarA.f();
        } else {
            iVar.i(listA);
        }
        return K2.l0.f1215e;
    }

    @Override // K2.S
    public void c(K2.l0 l0Var) {
        S.i iVar = this.f2638h;
        if (iVar != null) {
            iVar.g();
            this.f2638h = null;
        }
        j(EnumC0368p.TRANSIENT_FAILURE, new d(S.f.f(l0Var)));
    }

    @Override // K2.S
    public void e() {
        S.i iVar = this.f2638h;
        if (iVar != null) {
            iVar.f();
        }
    }

    @Override // K2.S
    public void f() {
        S.i iVar = this.f2638h;
        if (iVar != null) {
            iVar.g();
        }
    }
}
