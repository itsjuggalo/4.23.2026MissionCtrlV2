package k0;

import W2.E;
import W2.q;
import a3.AbstractC0787c;
import android.content.Context;
import android.net.Uri;
import android.view.InputEvent;
import b3.l;
import e2.InterfaceFutureC1233e;
import i3.o;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import l0.AbstractC1588a;
import l0.m;
import l0.n;
import t3.AbstractC1822k;
import t3.C1803a0;
import t3.L;
import t3.M;

/* JADX INFO: renamed from: k0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1566a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f13385a = new b(null);

    /* JADX INFO: renamed from: k0.a$a, reason: collision with other inner class name */
    public static final class C0207a extends AbstractC1566a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final l0.b f13386b;

        /* JADX INFO: renamed from: k0.a$a$a, reason: collision with other inner class name */
        public static final class C0208a extends l implements o {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f13387a;

            public C0208a(AbstractC1588a abstractC1588a, Z2.e eVar) {
                super(2, eVar);
            }

            @Override // b3.AbstractC0863a
            public final Z2.e create(Object obj, Z2.e eVar) {
                return C0207a.this.new C0208a(null, eVar);
            }

            @Override // b3.AbstractC0863a
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objE = AbstractC0787c.e();
                int i4 = this.f13387a;
                if (i4 == 0) {
                    q.b(obj);
                    l0.b bVar = C0207a.this.f13386b;
                    this.f13387a = 1;
                    if (bVar.a(null, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i4 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    q.b(obj);
                }
                return E.f5463a;
            }

            @Override // i3.o
            public final Object invoke(L l4, Z2.e eVar) {
                return ((C0208a) create(l4, eVar)).invokeSuspend(E.f5463a);
            }
        }

        /* JADX INFO: renamed from: k0.a$a$b */
        public static final class b extends l implements o {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f13389a;

            public b(Z2.e eVar) {
                super(2, eVar);
            }

            @Override // b3.AbstractC0863a
            public final Z2.e create(Object obj, Z2.e eVar) {
                return C0207a.this.new b(eVar);
            }

            @Override // b3.AbstractC0863a
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objE = AbstractC0787c.e();
                int i4 = this.f13389a;
                if (i4 != 0) {
                    if (i4 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    q.b(obj);
                    return obj;
                }
                q.b(obj);
                l0.b bVar = C0207a.this.f13386b;
                this.f13389a = 1;
                Object objB = bVar.b(this);
                return objB == objE ? objE : objB;
            }

            @Override // i3.o
            public final Object invoke(L l4, Z2.e eVar) {
                return ((b) create(l4, eVar)).invokeSuspend(E.f5463a);
            }
        }

        /* JADX INFO: renamed from: k0.a$a$c */
        public static final class c extends l implements o {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f13391a;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Uri f13393c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ InputEvent f13394d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(Uri uri, InputEvent inputEvent, Z2.e eVar) {
                super(2, eVar);
                this.f13393c = uri;
                this.f13394d = inputEvent;
            }

            @Override // b3.AbstractC0863a
            public final Z2.e create(Object obj, Z2.e eVar) {
                return C0207a.this.new c(this.f13393c, this.f13394d, eVar);
            }

            @Override // b3.AbstractC0863a
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objE = AbstractC0787c.e();
                int i4 = this.f13391a;
                if (i4 == 0) {
                    q.b(obj);
                    l0.b bVar = C0207a.this.f13386b;
                    Uri uri = this.f13393c;
                    InputEvent inputEvent = this.f13394d;
                    this.f13391a = 1;
                    if (bVar.c(uri, inputEvent, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i4 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    q.b(obj);
                }
                return E.f5463a;
            }

            @Override // i3.o
            public final Object invoke(L l4, Z2.e eVar) {
                return ((c) create(l4, eVar)).invokeSuspend(E.f5463a);
            }
        }

        /* JADX INFO: renamed from: k0.a$a$d */
        public static final class d extends l implements o {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f13395a;

            public d(m mVar, Z2.e eVar) {
                super(2, eVar);
            }

            @Override // b3.AbstractC0863a
            public final Z2.e create(Object obj, Z2.e eVar) {
                return C0207a.this.new d(null, eVar);
            }

            @Override // b3.AbstractC0863a
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objE = AbstractC0787c.e();
                int i4 = this.f13395a;
                if (i4 == 0) {
                    q.b(obj);
                    l0.b bVar = C0207a.this.f13386b;
                    this.f13395a = 1;
                    if (bVar.d(null, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i4 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    q.b(obj);
                }
                return E.f5463a;
            }

            @Override // i3.o
            public final Object invoke(L l4, Z2.e eVar) {
                return ((d) create(l4, eVar)).invokeSuspend(E.f5463a);
            }
        }

        /* JADX INFO: renamed from: k0.a$a$e */
        public static final class e extends l implements o {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f13397a;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Uri f13399c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(Uri uri, Z2.e eVar) {
                super(2, eVar);
                this.f13399c = uri;
            }

            @Override // b3.AbstractC0863a
            public final Z2.e create(Object obj, Z2.e eVar) {
                return C0207a.this.new e(this.f13399c, eVar);
            }

            @Override // b3.AbstractC0863a
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objE = AbstractC0787c.e();
                int i4 = this.f13397a;
                if (i4 == 0) {
                    q.b(obj);
                    l0.b bVar = C0207a.this.f13386b;
                    Uri uri = this.f13399c;
                    this.f13397a = 1;
                    if (bVar.e(uri, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i4 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    q.b(obj);
                }
                return E.f5463a;
            }

            @Override // i3.o
            public final Object invoke(L l4, Z2.e eVar) {
                return ((e) create(l4, eVar)).invokeSuspend(E.f5463a);
            }
        }

        /* JADX INFO: renamed from: k0.a$a$f */
        public static final class f extends l implements o {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f13400a;

            public f(n nVar, Z2.e eVar) {
                super(2, eVar);
            }

            @Override // b3.AbstractC0863a
            public final Z2.e create(Object obj, Z2.e eVar) {
                return C0207a.this.new f(null, eVar);
            }

            @Override // b3.AbstractC0863a
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objE = AbstractC0787c.e();
                int i4 = this.f13400a;
                if (i4 == 0) {
                    q.b(obj);
                    l0.b bVar = C0207a.this.f13386b;
                    this.f13400a = 1;
                    if (bVar.f(null, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i4 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    q.b(obj);
                }
                return E.f5463a;
            }

            @Override // i3.o
            public final Object invoke(L l4, Z2.e eVar) {
                return ((f) create(l4, eVar)).invokeSuspend(E.f5463a);
            }
        }

        /* JADX INFO: renamed from: k0.a$a$g */
        public static final class g extends l implements o {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f13402a;

            public g(l0.o oVar, Z2.e eVar) {
                super(2, eVar);
            }

            @Override // b3.AbstractC0863a
            public final Z2.e create(Object obj, Z2.e eVar) {
                return C0207a.this.new g(null, eVar);
            }

            @Override // b3.AbstractC0863a
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objE = AbstractC0787c.e();
                int i4 = this.f13402a;
                if (i4 == 0) {
                    q.b(obj);
                    l0.b bVar = C0207a.this.f13386b;
                    this.f13402a = 1;
                    if (bVar.g(null, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i4 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    q.b(obj);
                }
                return E.f5463a;
            }

            @Override // i3.o
            public final Object invoke(L l4, Z2.e eVar) {
                return ((g) create(l4, eVar)).invokeSuspend(E.f5463a);
            }
        }

        public C0207a(l0.b mMeasurementManager) {
            r.f(mMeasurementManager, "mMeasurementManager");
            this.f13386b = mMeasurementManager;
        }

        @Override // k0.AbstractC1566a
        public InterfaceFutureC1233e b() {
            return j0.b.c(AbstractC1822k.b(M.a(C1803a0.a()), null, null, new b(null), 3, null), null, 1, null);
        }

        @Override // k0.AbstractC1566a
        public InterfaceFutureC1233e c(Uri trigger) {
            r.f(trigger, "trigger");
            return j0.b.c(AbstractC1822k.b(M.a(C1803a0.a()), null, null, new e(trigger, null), 3, null), null, 1, null);
        }

        public InterfaceFutureC1233e e(AbstractC1588a deletionRequest) {
            r.f(deletionRequest, "deletionRequest");
            return j0.b.c(AbstractC1822k.b(M.a(C1803a0.a()), null, null, new C0208a(deletionRequest, null), 3, null), null, 1, null);
        }

        public InterfaceFutureC1233e f(Uri attributionSource, InputEvent inputEvent) {
            r.f(attributionSource, "attributionSource");
            return j0.b.c(AbstractC1822k.b(M.a(C1803a0.a()), null, null, new c(attributionSource, inputEvent, null), 3, null), null, 1, null);
        }

        public InterfaceFutureC1233e g(m request) {
            r.f(request, "request");
            return j0.b.c(AbstractC1822k.b(M.a(C1803a0.a()), null, null, new d(request, null), 3, null), null, 1, null);
        }

        public InterfaceFutureC1233e h(n request) {
            r.f(request, "request");
            return j0.b.c(AbstractC1822k.b(M.a(C1803a0.a()), null, null, new f(request, null), 3, null), null, 1, null);
        }

        public InterfaceFutureC1233e i(l0.o request) {
            r.f(request, "request");
            return j0.b.c(AbstractC1822k.b(M.a(C1803a0.a()), null, null, new g(request, null), 3, null), null, 1, null);
        }
    }

    /* JADX INFO: renamed from: k0.a$b */
    public static final class b {
        public /* synthetic */ b(AbstractC1585j abstractC1585j) {
            this();
        }

        public final AbstractC1566a a(Context context) {
            r.f(context, "context");
            l0.b bVarA = l0.b.f13436a.a(context);
            if (bVarA != null) {
                return new C0207a(bVarA);
            }
            return null;
        }

        public b() {
        }
    }

    public static final AbstractC1566a a(Context context) {
        return f13385a.a(context);
    }

    public abstract InterfaceFutureC1233e b();

    public abstract InterfaceFutureC1233e c(Uri uri);
}
