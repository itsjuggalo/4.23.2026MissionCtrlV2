package L3;

import W2.AbstractC0734b;
import W2.AbstractC0735c;
import W2.C0733a;
import W2.C0739g;
import a3.AbstractC0787c;
import b3.AbstractC0866d;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class S {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0378a f1469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f1470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1471c;

    public static final class a extends b3.k implements i3.p {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1472b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f1473c;

        public a(Z2.e eVar) {
            super(3, eVar);
        }

        @Override // i3.p
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object invoke(AbstractC0735c abstractC0735c, W2.E e4, Z2.e eVar) {
            a aVar = S.this.new a(eVar);
            aVar.f1473c = abstractC0735c;
            return aVar.invokeSuspend(W2.E.f5463a);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = AbstractC0787c.e();
            int i4 = this.f1472b;
            if (i4 == 0) {
                W2.q.b(obj);
                AbstractC0735c abstractC0735c = (AbstractC0735c) this.f1473c;
                byte bE = S.this.f1469a.E();
                if (bE == 1) {
                    return S.this.j(true);
                }
                if (bE == 0) {
                    return S.this.j(false);
                }
                if (bE != 6) {
                    if (bE == 8) {
                        return S.this.f();
                    }
                    AbstractC0378a.y(S.this.f1469a, "Can't begin reading element, unexpected token", 0, null, 6, null);
                    throw new C0739g();
                }
                S s4 = S.this;
                this.f1472b = 1;
                obj = s4.i(abstractC0735c, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                W2.q.b(obj);
            }
            return (K3.h) obj;
        }
    }

    public static final class b extends AbstractC0866d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f1475a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f1476b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f1477c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f1478d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public /* synthetic */ Object f1479e;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f1481g;

        public b(Z2.e eVar) {
            super(eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) {
            this.f1479e = obj;
            this.f1481g |= Integer.MIN_VALUE;
            return S.this.i(null, this);
        }
    }

    public S(K3.f configuration, AbstractC0378a lexer) {
        kotlin.jvm.internal.r.f(configuration, "configuration");
        kotlin.jvm.internal.r.f(lexer, "lexer");
        this.f1469a = lexer;
        this.f1470b = configuration.m();
    }

    public final K3.h e() {
        byte bE = this.f1469a.E();
        if (bE == 1) {
            return j(true);
        }
        if (bE == 0) {
            return j(false);
        }
        if (bE == 6) {
            int i4 = this.f1471c + 1;
            this.f1471c = i4;
            this.f1471c--;
            return i4 == 200 ? g() : h();
        }
        if (bE == 8) {
            return f();
        }
        AbstractC0378a.y(this.f1469a, "Cannot begin reading element, unexpected token: " + ((int) bE), 0, null, 6, null);
        throw new C0739g();
    }

    public final K3.h f() {
        byte bM = this.f1469a.m();
        if (this.f1469a.E() == 4) {
            AbstractC0378a.y(this.f1469a, "Unexpected leading comma", 0, null, 6, null);
            throw new C0739g();
        }
        ArrayList arrayList = new ArrayList();
        while (this.f1469a.f()) {
            arrayList.add(e());
            bM = this.f1469a.m();
            if (bM != 4) {
                AbstractC0378a abstractC0378a = this.f1469a;
                boolean z4 = bM == 9;
                int i4 = abstractC0378a.f1505a;
                if (!z4) {
                    AbstractC0378a.y(abstractC0378a, "Expected end of the array or comma", i4, null, 4, null);
                    throw new C0739g();
                }
            }
        }
        if (bM == 8) {
            this.f1469a.n((byte) 9);
        } else if (bM == 4) {
            AbstractC0378a.y(this.f1469a, "Unexpected trailing comma", 0, null, 6, null);
            throw new C0739g();
        }
        return new K3.b(arrayList);
    }

    public final K3.h g() {
        return (K3.h) AbstractC0734b.b(new C0733a(new a(null)), W2.E.f5463a);
    }

    public final K3.h h() {
        byte bN = this.f1469a.n((byte) 6);
        if (this.f1469a.E() == 4) {
            AbstractC0378a.y(this.f1469a, "Unexpected leading comma", 0, null, 6, null);
            throw new C0739g();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (true) {
            if (!this.f1469a.f()) {
                break;
            }
            String strS = this.f1470b ? this.f1469a.s() : this.f1469a.q();
            this.f1469a.n((byte) 5);
            linkedHashMap.put(strS, e());
            bN = this.f1469a.m();
            if (bN != 4) {
                if (bN != 7) {
                    AbstractC0378a.y(this.f1469a, "Expected end of the object or comma", 0, null, 6, null);
                    throw new C0739g();
                }
            }
        }
        if (bN == 6) {
            this.f1469a.n((byte) 7);
        } else if (bN == 4) {
            AbstractC0378a.y(this.f1469a, "Unexpected trailing comma", 0, null, 6, null);
            throw new C0739g();
        }
        return new K3.u(linkedHashMap);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0096 -> B:27:0x00a0). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(W2.AbstractC0735c r20, Z2.e r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: L3.S.i(W2.c, Z2.e):java.lang.Object");
    }

    public final K3.w j(boolean z4) {
        String strS = (this.f1470b || !z4) ? this.f1469a.s() : this.f1469a.q();
        return (z4 || !kotlin.jvm.internal.r.b(strS, "null")) ? new K3.o(strS, z4, null, 4, null) : K3.s.INSTANCE;
    }
}
