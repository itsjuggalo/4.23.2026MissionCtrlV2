package g2;

import android.content.Context;
import android.net.Uri;
import android.view.InputEvent;
import cd.h0;
import cd.s;
import h2.i;
import h2.j;
import h2.k;
import id.m;
import kotlin.jvm.internal.t;
import ng.c1;
import ng.n0;
import ng.o0;
import pd.o;
import u6.f;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f9992a = new b(null);

    /* JADX INFO: renamed from: g2.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0178a extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final h2.b f9993b;

        /* JADX INFO: renamed from: g2.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0179a extends m implements o {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f9994a;

            public C0179a(h2.a aVar, gd.e eVar) {
                super(2, eVar);
            }

            @Override // id.a
            public final gd.e create(Object obj, gd.e eVar) {
                return C0178a.this.new C0179a(null, eVar);
            }

            @Override // id.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objF = hd.c.f();
                int i10 = this.f9994a;
                if (i10 == 0) {
                    s.b(obj);
                    h2.b bVar = C0178a.this.f9993b;
                    this.f9994a = 1;
                    if (bVar.a(null, this) == objF) {
                        return objF;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    s.b(obj);
                }
                return h0.f3852a;
            }

            @Override // pd.o
            public final Object invoke(n0 n0Var, gd.e eVar) {
                return ((C0179a) create(n0Var, eVar)).invokeSuspend(h0.f3852a);
            }
        }

        /* JADX INFO: renamed from: g2.a$a$b */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class b extends m implements o {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f9996a;

            public b(gd.e eVar) {
                super(2, eVar);
            }

            @Override // id.a
            public final gd.e create(Object obj, gd.e eVar) {
                return C0178a.this.new b(eVar);
            }

            @Override // id.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objF = hd.c.f();
                int i10 = this.f9996a;
                if (i10 != 0) {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    s.b(obj);
                    return obj;
                }
                s.b(obj);
                h2.b bVar = C0178a.this.f9993b;
                this.f9996a = 1;
                Object objB = bVar.b(this);
                return objB == objF ? objF : objB;
            }

            @Override // pd.o
            public final Object invoke(n0 n0Var, gd.e eVar) {
                return ((b) create(n0Var, eVar)).invokeSuspend(h0.f3852a);
            }
        }

        /* JADX INFO: renamed from: g2.a$a$c */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class c extends m implements o {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f9998a;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Uri f10000c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ InputEvent f10001d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(Uri uri, InputEvent inputEvent, gd.e eVar) {
                super(2, eVar);
                this.f10000c = uri;
                this.f10001d = inputEvent;
            }

            @Override // id.a
            public final gd.e create(Object obj, gd.e eVar) {
                return C0178a.this.new c(this.f10000c, this.f10001d, eVar);
            }

            @Override // id.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objF = hd.c.f();
                int i10 = this.f9998a;
                if (i10 == 0) {
                    s.b(obj);
                    h2.b bVar = C0178a.this.f9993b;
                    Uri uri = this.f10000c;
                    InputEvent inputEvent = this.f10001d;
                    this.f9998a = 1;
                    if (bVar.c(uri, inputEvent, this) == objF) {
                        return objF;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    s.b(obj);
                }
                return h0.f3852a;
            }

            @Override // pd.o
            public final Object invoke(n0 n0Var, gd.e eVar) {
                return ((c) create(n0Var, eVar)).invokeSuspend(h0.f3852a);
            }
        }

        /* JADX INFO: renamed from: g2.a$a$d */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class d extends m implements o {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f10002a;

            public d(i iVar, gd.e eVar) {
                super(2, eVar);
            }

            @Override // id.a
            public final gd.e create(Object obj, gd.e eVar) {
                return C0178a.this.new d(null, eVar);
            }

            @Override // id.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objF = hd.c.f();
                int i10 = this.f10002a;
                if (i10 == 0) {
                    s.b(obj);
                    h2.b bVar = C0178a.this.f9993b;
                    this.f10002a = 1;
                    if (bVar.d(null, this) == objF) {
                        return objF;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    s.b(obj);
                }
                return h0.f3852a;
            }

            @Override // pd.o
            public final Object invoke(n0 n0Var, gd.e eVar) {
                return ((d) create(n0Var, eVar)).invokeSuspend(h0.f3852a);
            }
        }

        /* JADX INFO: renamed from: g2.a$a$e */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class e extends m implements o {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f10004a;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Uri f10006c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(Uri uri, gd.e eVar) {
                super(2, eVar);
                this.f10006c = uri;
            }

            @Override // id.a
            public final gd.e create(Object obj, gd.e eVar) {
                return C0178a.this.new e(this.f10006c, eVar);
            }

            @Override // id.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objF = hd.c.f();
                int i10 = this.f10004a;
                if (i10 == 0) {
                    s.b(obj);
                    h2.b bVar = C0178a.this.f9993b;
                    Uri uri = this.f10006c;
                    this.f10004a = 1;
                    if (bVar.e(uri, this) == objF) {
                        return objF;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    s.b(obj);
                }
                return h0.f3852a;
            }

            @Override // pd.o
            public final Object invoke(n0 n0Var, gd.e eVar) {
                return ((e) create(n0Var, eVar)).invokeSuspend(h0.f3852a);
            }
        }

        /* JADX INFO: renamed from: g2.a$a$f */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class f extends m implements o {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f10007a;

            public f(j jVar, gd.e eVar) {
                super(2, eVar);
            }

            @Override // id.a
            public final gd.e create(Object obj, gd.e eVar) {
                return C0178a.this.new f(null, eVar);
            }

            @Override // id.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objF = hd.c.f();
                int i10 = this.f10007a;
                if (i10 == 0) {
                    s.b(obj);
                    h2.b bVar = C0178a.this.f9993b;
                    this.f10007a = 1;
                    if (bVar.f(null, this) == objF) {
                        return objF;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    s.b(obj);
                }
                return h0.f3852a;
            }

            @Override // pd.o
            public final Object invoke(n0 n0Var, gd.e eVar) {
                return ((f) create(n0Var, eVar)).invokeSuspend(h0.f3852a);
            }
        }

        /* JADX INFO: renamed from: g2.a$a$g */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class g extends m implements o {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f10009a;

            public g(k kVar, gd.e eVar) {
                super(2, eVar);
            }

            @Override // id.a
            public final gd.e create(Object obj, gd.e eVar) {
                return C0178a.this.new g(null, eVar);
            }

            @Override // id.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objF = hd.c.f();
                int i10 = this.f10009a;
                if (i10 == 0) {
                    s.b(obj);
                    h2.b bVar = C0178a.this.f9993b;
                    this.f10009a = 1;
                    if (bVar.g(null, this) == objF) {
                        return objF;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    s.b(obj);
                }
                return h0.f3852a;
            }

            @Override // pd.o
            public final Object invoke(n0 n0Var, gd.e eVar) {
                return ((g) create(n0Var, eVar)).invokeSuspend(h0.f3852a);
            }
        }

        public C0178a(h2.b mMeasurementManager) {
            t.f(mMeasurementManager, "mMeasurementManager");
            this.f9993b = mMeasurementManager;
        }

        @Override // g2.a
        public u6.f b() {
            return f2.b.c(ng.k.b(o0.a(c1.a()), null, null, new b(null), 3, null), null, 1, null);
        }

        @Override // g2.a
        public u6.f c(Uri trigger) {
            t.f(trigger, "trigger");
            return f2.b.c(ng.k.b(o0.a(c1.a()), null, null, new e(trigger, null), 3, null), null, 1, null);
        }

        public u6.f e(h2.a deletionRequest) {
            t.f(deletionRequest, "deletionRequest");
            return f2.b.c(ng.k.b(o0.a(c1.a()), null, null, new C0179a(deletionRequest, null), 3, null), null, 1, null);
        }

        public u6.f f(Uri attributionSource, InputEvent inputEvent) {
            t.f(attributionSource, "attributionSource");
            return f2.b.c(ng.k.b(o0.a(c1.a()), null, null, new c(attributionSource, inputEvent, null), 3, null), null, 1, null);
        }

        public u6.f g(i request) {
            t.f(request, "request");
            return f2.b.c(ng.k.b(o0.a(c1.a()), null, null, new d(request, null), 3, null), null, 1, null);
        }

        public u6.f h(j request) {
            t.f(request, "request");
            return f2.b.c(ng.k.b(o0.a(c1.a()), null, null, new f(request, null), 3, null), null, 1, null);
        }

        public u6.f i(k request) {
            t.f(request, "request");
            return f2.b.c(ng.k.b(o0.a(c1.a()), null, null, new g(request, null), 3, null), null, 1, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final a a(Context context) {
            t.f(context, "context");
            h2.b bVarA = h2.b.f10967a.a(context);
            if (bVarA != null) {
                return new C0178a(bVarA);
            }
            return null;
        }

        public b() {
        }
    }

    public static final a a(Context context) {
        return f9992a.a(context);
    }

    public abstract f b();

    public abstract f c(Uri uri);
}
