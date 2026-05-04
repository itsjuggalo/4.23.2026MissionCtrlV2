package xa;

import android.util.Log;
import cd.h0;
import cd.s;
import kotlin.jvm.internal.t;
import lg.a;
import org.json.JSONObject;
import ua.w0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements o {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f24712g = new a(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f24713h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final kg.n f24714i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w0 f24715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ga.h f24716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ua.b f24717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final xa.a f24718d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final l f24719e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final wg.a f24720f;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final int a() {
            return d.f24713h;
        }

        public a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends id.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f24721a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f24722b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f24723c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f24725e;

        public b(gd.e eVar) {
            super(eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) {
            this.f24723c = obj;
            this.f24725e |= Integer.MIN_VALUE;
            return d.this.c(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends id.m implements pd.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f24726a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f24727b;

        public c(gd.e eVar) {
            super(2, eVar);
        }

        @Override // pd.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(JSONObject jSONObject, gd.e eVar) {
            return ((c) create(jSONObject, eVar)).invokeSuspend(h0.f3852a);
        }

        @Override // id.a
        public final gd.e create(Object obj, gd.e eVar) {
            c cVar = d.this.new c(eVar);
            cVar.f24727b = obj;
            return cVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:44:0x00c0  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00c5  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x00f0 A[RETURN] */
        @Override // id.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r20) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 244
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: xa.d.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: xa.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0448d extends id.m implements pd.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f24729a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f24730b;

        public C0448d(gd.e eVar) {
            super(2, eVar);
        }

        @Override // pd.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(String str, gd.e eVar) {
            return ((C0448d) create(str, eVar)).invokeSuspend(h0.f3852a);
        }

        @Override // id.a
        public final gd.e create(Object obj, gd.e eVar) {
            C0448d c0448d = new C0448d(eVar);
            c0448d.f24730b = obj;
            return c0448d;
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            hd.c.f();
            if (this.f24729a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            s.b(obj);
            Log.e("FirebaseSessions", "Error failed to fetch the remote configs: " + ((String) this.f24730b));
            return h0.f3852a;
        }
    }

    static {
        a.C0282a c0282a = lg.a.f15679b;
        f24713h = (int) lg.a.A(lg.c.s(24, lg.d.f15691g));
        f24714i = new kg.n("/");
    }

    public d(w0 timeProvider, ga.h firebaseInstallationsApi, ua.b appInfo, xa.a configsFetcher, l settingsCache) {
        t.f(timeProvider, "timeProvider");
        t.f(firebaseInstallationsApi, "firebaseInstallationsApi");
        t.f(appInfo, "appInfo");
        t.f(configsFetcher, "configsFetcher");
        t.f(settingsCache, "settingsCache");
        this.f24715a = timeProvider;
        this.f24716b = firebaseInstallationsApi;
        this.f24717c = appInfo;
        this.f24718d = configsFetcher;
        this.f24719e = settingsCache;
        this.f24720f = wg.g.b(false, 1, null);
    }

    @Override // xa.o
    public Boolean a() {
        return this.f24719e.e();
    }

    @Override // xa.o
    public lg.a b() {
        Integer numC = this.f24719e.c();
        if (numC == null) {
            return null;
        }
        a.C0282a c0282a = lg.a.f15679b;
        return lg.a.i(lg.c.s(numC.intValue(), lg.d.f15689e));
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00c4 A[Catch: all -> 0x004f, TRY_LEAVE, TryCatch #2 {all -> 0x004f, blocks: (B:21:0x004a, B:47:0x00b6, B:49:0x00c4, B:52:0x00cf), top: B:64:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00cf A[Catch: all -> 0x004f, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x004f, blocks: (B:21:0x004a, B:47:0x00b6, B:49:0x00c4, B:52:0x00cf), top: B:64:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // xa.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c(gd.e r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 339
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: xa.d.c(gd.e):java.lang.Object");
    }

    @Override // xa.o
    public Double d() {
        return this.f24719e.a();
    }

    public final String i(String str) {
        return f24714i.c(str, "");
    }
}
