package l1;

import android.os.FileObserver;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.functions.Function0;
import l1.a0;
import ng.e1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a0 extends FileObserver {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f14987c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f14988d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map f14989e = new LinkedHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f14991b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: l1.a0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0260a extends id.m implements pd.o {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f14992a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f14993b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public /* synthetic */ Object f14994c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ File f14995d;

            /* JADX INFO: renamed from: l1.a0$a$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
            public static final class C0261a extends kotlin.jvm.internal.v implements Function0 {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ e1 f14996a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0261a(e1 e1Var) {
                    super(0);
                    this.f14996a = e1Var;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m272invoke();
                    return cd.h0.f3852a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m272invoke() {
                    this.f14996a.dispose();
                }
            }

            /* JADX INFO: renamed from: l1.a0$a$a$b */
            /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
            public static final class b extends kotlin.jvm.internal.v implements pd.k {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ File f14997a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ pg.v f14998b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public b(File file, pg.v vVar) {
                    super(1);
                    this.f14997a = file;
                    this.f14998b = vVar;
                }

                @Override // pd.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((String) obj);
                    return cd.h0.f3852a;
                }

                public final void invoke(String str) {
                    if (kotlin.jvm.internal.t.b(str, this.f14997a.getName())) {
                        pg.n.b(this.f14998b, cd.h0.f3852a);
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0260a(File file, gd.e eVar) {
                super(2, eVar);
                this.f14995d = file;
            }

            @Override // pd.o
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(pg.v vVar, gd.e eVar) {
                return ((C0260a) create(vVar, eVar)).invokeSuspend(cd.h0.f3852a);
            }

            @Override // id.a
            public final gd.e create(Object obj, gd.e eVar) {
                C0260a c0260a = new C0260a(this.f14995d, eVar);
                c0260a.f14994c = obj;
                return c0260a;
            }

            /* JADX WARN: Code restructure failed: missing block: B:15:0x0063, code lost:
            
                if (pg.t.a(r3, r7, r6) == r0) goto L16;
             */
            @Override // id.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
                /*
                    r6 = this;
                    java.lang.Object r0 = hd.c.f()
                    int r1 = r6.f14993b
                    r2 = 2
                    r3 = 1
                    if (r1 == 0) goto L26
                    if (r1 == r3) goto L1a
                    if (r1 != r2) goto L12
                    cd.s.b(r7)
                    goto L66
                L12:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r0)
                    throw r7
                L1a:
                    java.lang.Object r1 = r6.f14992a
                    ng.e1 r1 = (ng.e1) r1
                    java.lang.Object r3 = r6.f14994c
                    pg.v r3 = (pg.v) r3
                    cd.s.b(r7)
                    goto L53
                L26:
                    cd.s.b(r7)
                    java.lang.Object r7 = r6.f14994c
                    pg.v r7 = (pg.v) r7
                    l1.a0$a$a$b r1 = new l1.a0$a$a$b
                    java.io.File r4 = r6.f14995d
                    r1.<init>(r4, r7)
                    l1.a0$a r4 = l1.a0.f14987c
                    java.io.File r5 = r6.f14995d
                    java.io.File r5 = r5.getParentFile()
                    kotlin.jvm.internal.t.c(r5)
                    ng.e1 r1 = l1.a0.a.b(r4, r5, r1)
                    cd.h0 r4 = cd.h0.f3852a
                    r6.f14994c = r7
                    r6.f14992a = r1
                    r6.f14993b = r3
                    java.lang.Object r3 = r7.i(r4, r6)
                    if (r3 != r0) goto L52
                    goto L65
                L52:
                    r3 = r7
                L53:
                    l1.a0$a$a$a r7 = new l1.a0$a$a$a
                    r7.<init>(r1)
                    r1 = 0
                    r6.f14994c = r1
                    r6.f14992a = r1
                    r6.f14993b = r2
                    java.lang.Object r7 = pg.t.a(r3, r7, r6)
                    if (r7 != r0) goto L66
                L65:
                    return r0
                L66:
                    cd.h0 r7 = cd.h0.f3852a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: l1.a0.a.C0260a.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public static final void f(String str, pd.k observer) {
            kotlin.jvm.internal.t.f(observer, "$observer");
            synchronized (a0.f14988d) {
                try {
                    a aVar = a0.f14987c;
                    a0 a0Var = (a0) aVar.c().get(str);
                    if (a0Var != null) {
                        a0Var.f14991b.remove(observer);
                        if (a0Var.f14991b.isEmpty()) {
                            aVar.c().remove(str);
                            a0Var.stopWatching();
                        }
                    }
                    cd.h0 h0Var = cd.h0.f3852a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final Map c() {
            return a0.f14989e;
        }

        public final e1 d(File file, final pd.k kVar) {
            final String key = file.getCanonicalFile().getPath();
            synchronized (a0.f14988d) {
                try {
                    Map mapC = a0.f14987c.c();
                    kotlin.jvm.internal.t.e(key, "key");
                    Object a0Var = mapC.get(key);
                    if (a0Var == null) {
                        a0Var = new a0(key, null);
                        mapC.put(key, a0Var);
                    }
                    a0 a0Var2 = (a0) a0Var;
                    a0Var2.f14991b.add(kVar);
                    if (a0Var2.f14991b.size() == 1) {
                        a0Var2.startWatching();
                    }
                    cd.h0 h0Var = cd.h0.f3852a;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return new e1() { // from class: l1.z
                @Override // ng.e1
                public final void dispose() {
                    a0.a.f(key, kVar);
                }
            };
        }

        public final qg.d e(File file) {
            kotlin.jvm.internal.t.f(file, "file");
            return qg.f.f(new C0260a(file, null));
        }

        public a() {
        }
    }

    public /* synthetic */ a0(String str, kotlin.jvm.internal.k kVar) {
        this(str);
    }

    @Override // android.os.FileObserver
    public void onEvent(int i10, String str) {
        Iterator it = this.f14991b.iterator();
        while (it.hasNext()) {
            ((pd.k) it.next()).invoke(str);
        }
    }

    public a0(String str) {
        super(str, 128);
        this.f14990a = str;
        this.f14991b = new CopyOnWriteArrayList();
    }
}
