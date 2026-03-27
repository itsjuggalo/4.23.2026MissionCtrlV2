package d4;

import E5.E;
import E5.q;
import Q5.o;
import Z3.C0782b;
import a6.C0929a;
import android.util.Log;
import b4.InterfaceC0994a;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class d implements m {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f13346g = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final H5.g f13347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final O3.h f13348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0782b f13349c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC1463a f13350d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final InterfaceC0994a f13351e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final k6.a f13352f;

    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public a() {
        }
    }

    public static final class b extends J5.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f13353a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f13354b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f13355c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f13357e;

        public b(H5.d dVar) {
            super(dVar);
        }

        @Override // J5.a
        public final Object invokeSuspend(Object obj) {
            this.f13355c = obj;
            this.f13357e |= Integer.MIN_VALUE;
            return d.this.b(this);
        }
    }

    public static final class c extends J5.l implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f13358a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f13359b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f13360c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public /* synthetic */ Object f13361d;

        public c(H5.d dVar) {
            super(2, dVar);
        }

        @Override // J5.a
        public final H5.d create(Object obj, H5.d dVar) {
            c cVar = d.this.new c(dVar);
            cVar.f13361d = obj;
            return cVar;
        }

        @Override // Q5.o
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final Object invoke(JSONObject jSONObject, H5.d dVar) {
            return ((c) create(jSONObject, dVar)).invokeSuspend(E.f1657a);
        }

        /* JADX WARN: Removed duplicated region for block: B:45:0x00fb  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x011b  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x013b  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x0158  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x015b  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x0195 A[RETURN] */
        @Override // J5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 428
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: d4.d.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: d4.d$d, reason: collision with other inner class name */
    public static final class C0229d extends J5.l implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f13363a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f13364b;

        public C0229d(H5.d dVar) {
            super(2, dVar);
        }

        @Override // J5.a
        public final H5.d create(Object obj, H5.d dVar) {
            C0229d c0229d = new C0229d(dVar);
            c0229d.f13364b = obj;
            return c0229d;
        }

        @Override // Q5.o
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final Object invoke(String str, H5.d dVar) {
            return ((C0229d) create(str, dVar)).invokeSuspend(E.f1657a);
        }

        @Override // J5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            I5.c.e();
            if (this.f13363a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.b(obj);
            Log.e("SessionConfigFetcher", "Error failing to fetch the remote configs: " + ((String) this.f13364b));
            return E.f1657a;
        }
    }

    public d(H5.g backgroundDispatcher, O3.h firebaseInstallationsApi, C0782b appInfo, InterfaceC1463a configsFetcher, InterfaceC0994a lazySettingsCache) {
        r.f(backgroundDispatcher, "backgroundDispatcher");
        r.f(firebaseInstallationsApi, "firebaseInstallationsApi");
        r.f(appInfo, "appInfo");
        r.f(configsFetcher, "configsFetcher");
        r.f(lazySettingsCache, "lazySettingsCache");
        this.f13347a = backgroundDispatcher;
        this.f13348b = firebaseInstallationsApi;
        this.f13349c = appInfo;
        this.f13350d = configsFetcher;
        this.f13351e = lazySettingsCache;
        this.f13352f = k6.c.b(false, 1, null);
    }

    @Override // d4.m
    public Boolean a() {
        return f().g();
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00c5 A[Catch: all -> 0x004f, TRY_LEAVE, TryCatch #2 {all -> 0x004f, blocks: (B:21:0x004a, B:47:0x00b7, B:49:0x00c5, B:52:0x00d0), top: B:64:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d0 A[Catch: all -> 0x004f, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x004f, blocks: (B:21:0x004a, B:47:0x00b7, B:49:0x00c5, B:52:0x00d0), top: B:64:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // d4.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(H5.d r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d4.d.b(H5.d):java.lang.Object");
    }

    @Override // d4.m
    public C0929a c() {
        Integer numE = f().e();
        if (numE == null) {
            return null;
        }
        C0929a.C0116a c0116a = C0929a.f6400b;
        return C0929a.i(a6.c.s(numE.intValue(), a6.d.f6410e));
    }

    @Override // d4.m
    public Double d() {
        return f().f();
    }

    public final k f() {
        Object obj = this.f13351e.get();
        r.e(obj, "lazySettingsCache.get()");
        return (k) obj;
    }

    public final String g(String str) {
        return new Z5.i("/").c(str, "");
    }
}
