package j4;

import W6.a;
import android.util.Log;
import g4.C1813b;
import g4.InterfaceC1808X;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import o5.AbstractC2491s;
import o5.C2470H;
import org.json.JSONException;
import org.json.JSONObject;
import s5.InterfaceC2707e;
import t5.AbstractC2751c;
import u5.AbstractC2775b;
import u5.AbstractC2777d;
import u5.AbstractC2785l;

/* JADX INFO: renamed from: j4.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2217d implements o {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f20032g = new a(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f20033h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final V6.n f20034i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC1808X f20035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T3.h f20036b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C1813b f20037c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC2214a f20038d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final l f20039e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h7.a f20040f;

    /* JADX INFO: renamed from: j4.d$a */
    public static final class a {
        public a() {
        }

        public final int a() {
            return C2217d.f20033h;
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    /* JADX INFO: renamed from: j4.d$b */
    public static final class b extends AbstractC2777d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f20041a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f20042b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f20043c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f20045e;

        public b(InterfaceC2707e interfaceC2707e) {
            super(interfaceC2707e);
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) {
            this.f20043c = obj;
            this.f20045e |= Integer.MIN_VALUE;
            return C2217d.this.d(this);
        }
    }

    /* JADX INFO: renamed from: j4.d$c */
    public static final class c extends AbstractC2785l implements B5.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f20046a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f20047b;

        public c(InterfaceC2707e interfaceC2707e) {
            super(2, interfaceC2707e);
        }

        @Override // B5.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(JSONObject jSONObject, InterfaceC2707e interfaceC2707e) {
            return ((c) create(jSONObject, interfaceC2707e)).invokeSuspend(C2470H.f21956a);
        }

        @Override // u5.AbstractC2774a
        public final InterfaceC2707e create(Object obj, InterfaceC2707e interfaceC2707e) {
            c cVar = C2217d.this.new c(interfaceC2707e);
            cVar.f20047b = obj;
            return cVar;
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Boolean bool;
            Double d8;
            Integer num;
            JSONException jSONException;
            Integer num2;
            Integer num3;
            Double d9;
            Object objF = AbstractC2751c.f();
            int i8 = this.f20046a;
            if (i8 == 0) {
                AbstractC2491s.b(obj);
                JSONObject jSONObject = (JSONObject) this.f20047b;
                Log.d("FirebaseSessions", "Fetched settings: " + jSONObject);
                Integer num4 = null;
                num4 = null;
                Boolean bool2 = null;
                if (jSONObject.has("app_quality")) {
                    Object obj2 = jSONObject.get("app_quality");
                    AbstractC2304t.d(obj2, "null cannot be cast to non-null type org.json.JSONObject");
                    JSONObject jSONObject2 = (JSONObject) obj2;
                    try {
                        Boolean bool3 = jSONObject2.has("sessions_enabled") ? (Boolean) jSONObject2.get("sessions_enabled") : null;
                        try {
                            d9 = jSONObject2.has("sampling_rate") ? (Double) jSONObject2.get("sampling_rate") : null;
                            try {
                                num3 = jSONObject2.has("session_timeout_seconds") ? (Integer) jSONObject2.get("session_timeout_seconds") : null;
                            } catch (JSONException e8) {
                                num3 = null;
                                bool2 = bool3;
                                jSONException = e8;
                                num2 = null;
                            }
                        } catch (JSONException e9) {
                            num3 = null;
                            d9 = null;
                            bool2 = bool3;
                            jSONException = e9;
                            num2 = null;
                        }
                        try {
                            num4 = jSONObject2.has("cache_duration") ? (Integer) jSONObject2.get("cache_duration") : null;
                            C2470H c2470h = C2470H.f21956a;
                            num = num3;
                            d8 = d9;
                            bool = bool3;
                        } catch (JSONException e10) {
                            Boolean bool4 = bool3;
                            jSONException = e10;
                            num2 = num4;
                            bool2 = bool4;
                            AbstractC2775b.c(Log.e("FirebaseSessions", "Error parsing the configs remotely fetched: ", jSONException));
                            num = num3;
                            d8 = d9;
                            bool = bool2;
                            num4 = num2;
                        }
                    } catch (JSONException e11) {
                        jSONException = e11;
                        num2 = null;
                        num3 = null;
                        d9 = null;
                    }
                } else {
                    bool = null;
                    d8 = null;
                    num = null;
                }
                l lVar = C2217d.this.f20039e;
                SessionConfigs sessionConfigs = new SessionConfigs(bool, d8, num, AbstractC2775b.c(num4 != null ? num4.intValue() : C2217d.f20032g.a()), AbstractC2775b.d(C2217d.this.f20035a.a().getSeconds()));
                this.f20046a = 1;
                if (lVar.c(sessionConfigs, this) == objF) {
                    return objF;
                }
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC2491s.b(obj);
            }
            return C2470H.f21956a;
        }
    }

    /* JADX INFO: renamed from: j4.d$d, reason: collision with other inner class name */
    public static final class C0327d extends AbstractC2785l implements B5.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f20049a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f20050b;

        public C0327d(InterfaceC2707e interfaceC2707e) {
            super(2, interfaceC2707e);
        }

        @Override // B5.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(String str, InterfaceC2707e interfaceC2707e) {
            return ((C0327d) create(str, interfaceC2707e)).invokeSuspend(C2470H.f21956a);
        }

        @Override // u5.AbstractC2774a
        public final InterfaceC2707e create(Object obj, InterfaceC2707e interfaceC2707e) {
            C0327d c0327d = new C0327d(interfaceC2707e);
            c0327d.f20050b = obj;
            return c0327d;
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) throws Throwable {
            AbstractC2751c.f();
            if (this.f20049a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC2491s.b(obj);
            Log.e("FirebaseSessions", "Error failed to fetch the remote configs: " + ((String) this.f20050b));
            return C2470H.f21956a;
        }
    }

    static {
        a.C0149a c0149a = W6.a.f9306b;
        f20033h = (int) W6.a.J(W6.c.s(24, W6.d.f9318g));
        f20034i = new V6.n("/");
    }

    public C2217d(InterfaceC1808X timeProvider, T3.h firebaseInstallationsApi, C1813b appInfo, InterfaceC2214a configsFetcher, l settingsCache) {
        AbstractC2304t.f(timeProvider, "timeProvider");
        AbstractC2304t.f(firebaseInstallationsApi, "firebaseInstallationsApi");
        AbstractC2304t.f(appInfo, "appInfo");
        AbstractC2304t.f(configsFetcher, "configsFetcher");
        AbstractC2304t.f(settingsCache, "settingsCache");
        this.f20035a = timeProvider;
        this.f20036b = firebaseInstallationsApi;
        this.f20037c = appInfo;
        this.f20038d = configsFetcher;
        this.f20039e = settingsCache;
        this.f20040f = h7.g.b(false, 1, null);
    }

    @Override // j4.o
    public Boolean a() {
        return this.f20039e.e();
    }

    @Override // j4.o
    public W6.a b() {
        Integer numB = this.f20039e.b();
        if (numB == null) {
            return null;
        }
        a.C0149a c0149a = W6.a.f9306b;
        return W6.a.k(W6.c.s(numB.intValue(), W6.d.f9316e));
    }

    @Override // j4.o
    public Double c() {
        return this.f20039e.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00c2 A[Catch: all -> 0x004f, TRY_LEAVE, TryCatch #2 {all -> 0x004f, blocks: (B:21:0x004a, B:47:0x00b4, B:49:0x00c2, B:52:0x00cd), top: B:64:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00cd A[Catch: all -> 0x004f, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x004f, blocks: (B:21:0x004a, B:47:0x00b4, B:49:0x00c2, B:52:0x00cd), top: B:64:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // j4.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object d(s5.InterfaceC2707e r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 337
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j4.C2217d.d(s5.e):java.lang.Object");
    }

    public final String i(String str) {
        return f20034i.c(str, "");
    }
}
