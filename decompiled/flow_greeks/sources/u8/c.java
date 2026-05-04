package u8;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import cd.h0;
import cd.s;
import dd.o0;
import dd.q;
import gd.e;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.i0;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t;
import l1.i;
import p1.f;
import p1.g;
import p1.j;
import pd.k;
import pd.o;
import wd.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ m[] f22400f = {n0.h(new i0(c.class, "dataStore", "getDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 0))};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f22401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ThreadLocal f22403c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final sd.c f22404d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i f22405e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends id.m implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f22406a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ k f22408c;

        /* JADX INFO: renamed from: u8.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0385a extends id.m implements o {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f22409a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public /* synthetic */ Object f22410b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ k f22411c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0385a(k kVar, e eVar) {
                super(2, eVar);
                this.f22411c = kVar;
            }

            @Override // id.a
            public final e create(Object obj, e eVar) {
                C0385a c0385a = new C0385a(this.f22411c, eVar);
                c0385a.f22410b = obj;
                return c0385a;
            }

            @Override // id.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                hd.c.f();
                if (this.f22409a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                s.b(obj);
                this.f22411c.invoke((p1.c) this.f22410b);
                return h0.f3852a;
            }

            @Override // pd.o
            public final Object invoke(p1.c cVar, e eVar) {
                return ((C0385a) create(cVar, eVar)).invokeSuspend(h0.f3852a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(k kVar, e eVar) {
            super(2, eVar);
            this.f22408c = kVar;
        }

        @Override // id.a
        public final e create(Object obj, e eVar) {
            return c.this.new a(this.f22408c, eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = hd.c.f();
            int i10 = this.f22406a;
            try {
                if (i10 == 0) {
                    s.b(obj);
                    if (t.b(c.this.f22403c.get(), id.b.a(true))) {
                        throw new IllegalStateException("Don't call JavaDataStorage.edit() from within an existing edit() callback.\nThis causes deadlocks, and is generally indicative of a code smell.\nInstead, either pass around the initial `MutablePreferences` instance, or don't do everything in a single callback. ");
                    }
                    c.this.f22403c.set(id.b.a(true));
                    i iVar = c.this.f22405e;
                    C0385a c0385a = new C0385a(this.f22408c, null);
                    this.f22406a = 1;
                    obj = j.a(iVar, c0385a, this);
                    if (obj == objF) {
                        return objF;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    s.b(obj);
                }
                return (f) obj;
            } finally {
                c.this.f22403c.set(id.b.a(false));
            }
        }

        @Override // pd.o
        public final Object invoke(ng.n0 n0Var, e eVar) {
            return ((a) create(n0Var, eVar)).invokeSuspend(h0.f3852a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends id.m implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f22412a;

        public b(e eVar) {
            super(2, eVar);
        }

        @Override // id.a
        public final e create(Object obj, e eVar) {
            return c.this.new b(eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Map mapA;
            Object objF = hd.c.f();
            int i10 = this.f22412a;
            if (i10 == 0) {
                s.b(obj);
                qg.d data = c.this.f22405e.getData();
                this.f22412a = 1;
                obj = qg.f.m(data, this);
                if (obj == objF) {
                    return objF;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                s.b(obj);
            }
            f fVar = (f) obj;
            return (fVar == null || (mapA = fVar.a()) == null) ? o0.h() : mapA;
        }

        @Override // pd.o
        public final Object invoke(ng.n0 n0Var, e eVar) {
            return ((b) create(n0Var, eVar)).invokeSuspend(h0.f3852a);
        }
    }

    /* JADX INFO: renamed from: u8.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0386c extends id.m implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f22414a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ f.a f22416c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Object f22417d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0386c(f.a aVar, Object obj, e eVar) {
            super(2, eVar);
            this.f22416c = aVar;
            this.f22417d = obj;
        }

        @Override // id.a
        public final e create(Object obj, e eVar) {
            return c.this.new C0386c(this.f22416c, this.f22417d, eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objB;
            Object objF = hd.c.f();
            int i10 = this.f22414a;
            if (i10 == 0) {
                s.b(obj);
                qg.d data = c.this.f22405e.getData();
                this.f22414a = 1;
                obj = qg.f.m(data, this);
                if (obj == objF) {
                    return objF;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                s.b(obj);
            }
            f fVar = (f) obj;
            return (fVar == null || (objB = fVar.b(this.f22416c)) == null) ? this.f22417d : objB;
        }

        @Override // pd.o
        public final Object invoke(ng.n0 n0Var, e eVar) {
            return ((C0386c) create(n0Var, eVar)).invokeSuspend(h0.f3852a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d extends id.m implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f22418a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ f.a f22420c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Object f22421d;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a extends id.m implements o {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f22422a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public /* synthetic */ Object f22423b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ f.a f22424c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Object f22425d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(f.a aVar, Object obj, e eVar) {
                super(2, eVar);
                this.f22424c = aVar;
                this.f22425d = obj;
            }

            @Override // id.a
            public final e create(Object obj, e eVar) {
                a aVar = new a(this.f22424c, this.f22425d, eVar);
                aVar.f22423b = obj;
                return aVar;
            }

            @Override // id.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                hd.c.f();
                if (this.f22422a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                s.b(obj);
                ((p1.c) this.f22423b).j(this.f22424c, this.f22425d);
                return h0.f3852a;
            }

            @Override // pd.o
            public final Object invoke(p1.c cVar, e eVar) {
                return ((a) create(cVar, eVar)).invokeSuspend(h0.f3852a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(f.a aVar, Object obj, e eVar) {
            super(2, eVar);
            this.f22420c = aVar;
            this.f22421d = obj;
        }

        @Override // id.a
        public final e create(Object obj, e eVar) {
            return c.this.new d(this.f22420c, this.f22421d, eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = hd.c.f();
            int i10 = this.f22418a;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                s.b(obj);
                return obj;
            }
            s.b(obj);
            i iVar = c.this.f22405e;
            a aVar = new a(this.f22420c, this.f22421d, null);
            this.f22418a = 1;
            Object objA = j.a(iVar, aVar, this);
            return objA == objF ? objF : objA;
        }

        @Override // pd.o
        public final Object invoke(ng.n0 n0Var, e eVar) {
            return ((d) create(n0Var, eVar)).invokeSuspend(h0.f3852a);
        }
    }

    public c(Context context, String name) {
        t.f(context, "context");
        t.f(name, "name");
        this.f22401a = context;
        this.f22402b = name;
        this.f22403c = new ThreadLocal();
        this.f22404d = o1.a.b(name, new m1.b(new k() { // from class: u8.a
            @Override // pd.k
            public final Object invoke(Object obj) {
                return c.e(this.f22398a, (l1.d) obj);
            }
        }), new k() { // from class: u8.b
            @Override // pd.k
            public final Object invoke(Object obj) {
                return c.f(this.f22399a, (Context) obj);
            }
        }, null, 8, null);
        this.f22405e = i(context);
    }

    public static final f e(c cVar, l1.d ex) {
        t.f(ex, "ex");
        Log.w(n0.b(c.class).c(), "CorruptionException in " + cVar.f22402b + " DataStore running in process " + Process.myPid(), ex);
        return g.a();
    }

    public static final List f(c cVar, Context it) {
        t.f(it, "it");
        return q.e(o1.i.b(it, cVar.f22402b, null, 4, null));
    }

    public final f g(k transform) {
        t.f(transform, "transform");
        return (f) ng.j.b(null, new a(transform, null), 1, null);
    }

    public final Map h() {
        return (Map) ng.j.b(null, new b(null), 1, null);
    }

    public final i i(Context context) {
        return (i) this.f22404d.a(context, f22400f[0]);
    }

    public final Object j(f.a key, Object obj) {
        t.f(key, "key");
        return ng.j.b(null, new C0386c(key, obj, null), 1, null);
    }

    public final f k(f.a key, Object obj) {
        t.f(key, "key");
        return (f) ng.j.b(null, new d(key, obj, null), 1, null);
    }
}
