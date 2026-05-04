package ua;

import android.util.Log;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class t0 implements s0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xa.j f22660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n0 f22661c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k0 f22662d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final w0 f22663e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final l1.i f22664f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final w f22665g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final gd.i f22666h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SessionData f22667i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f22668j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b f22669k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f22670l;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends id.m implements pd.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f22671a;

        /* JADX INFO: renamed from: ua.t0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0390a extends id.m implements pd.p {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f22673a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public /* synthetic */ Object f22674b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public /* synthetic */ Object f22675c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ t0 f22676d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0390a(t0 t0Var, gd.e eVar) {
                super(3, eVar);
                this.f22676d = t0Var;
            }

            @Override // pd.p
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(qg.e eVar, Throwable th, gd.e eVar2) {
                C0390a c0390a = new C0390a(this.f22676d, eVar2);
                c0390a.f22674b = eVar;
                c0390a.f22675c = th;
                return c0390a.invokeSuspend(cd.h0.f3852a);
            }

            @Override // id.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objF = hd.c.f();
                int i10 = this.f22673a;
                if (i10 == 0) {
                    cd.s.b(obj);
                    qg.e eVar = (qg.e) this.f22674b;
                    Throwable th = (Throwable) this.f22675c;
                    SessionData sessionData = new SessionData(this.f22676d.f22661c.a(null), (Time) null, (Map) null, 4, (kotlin.jvm.internal.k) null);
                    Log.d("FirebaseSessions", "Init session datastore failed with exception message: " + th.getMessage() + ". Emit fallback session " + sessionData.getSessionDetails().getSessionId());
                    this.f22674b = null;
                    this.f22673a = 1;
                    if (eVar.emit(sessionData, this) == objF) {
                        return objF;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    cd.s.b(obj);
                }
                return cd.h0.f3852a;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class b implements qg.e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ t0 f22677a;

            public b(t0 t0Var) {
                this.f22677a = t0Var;
            }

            @Override // qg.e
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object emit(SessionData sessionData, gd.e eVar) throws Throwable {
                this.f22677a.r(sessionData);
                Object objQ = this.f22677a.q(sessionData.getSessionDetails().getSessionId(), b.f22678a, eVar);
                return objQ == hd.c.f() ? objQ : cd.h0.f3852a;
            }
        }

        public a(gd.e eVar) {
            super(2, eVar);
        }

        @Override // id.a
        public final gd.e create(Object obj, gd.e eVar) {
            return t0.this.new a(eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = hd.c.f();
            int i10 = this.f22671a;
            if (i10 == 0) {
                cd.s.b(obj);
                qg.d dVarD = qg.f.d(t0.this.f22664f.getData(), new C0390a(t0.this, null));
                b bVar = new b(t0.this);
                this.f22671a = 1;
                if (dVarD.collect(bVar, this) == objF) {
                    return objF;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                cd.s.b(obj);
            }
            return cd.h0.f3852a;
        }

        @Override // pd.o
        public final Object invoke(ng.n0 n0Var, gd.e eVar) {
            return ((a) create(n0Var, eVar)).invokeSuspend(cd.h0.f3852a);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f22678a = new b("GENERAL", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f22679b = new b("FALLBACK", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ b[] f22680c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ jd.a f22681d;

        static {
            b[] bVarArrA = a();
            f22680c = bVarArrA;
            f22681d = jd.b.a(bVarArrA);
        }

        public b(String str, int i10) {
        }

        public static final /* synthetic */ b[] a() {
            return new b[]{f22678a, f22679b};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) f22680c.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f22682a;

        static {
            int[] iArr = new int[b.values().length];
            try {
                iArr[b.f22678a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[b.f22679b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f22682a = iArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d extends id.m implements pd.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f22683a;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a extends id.m implements pd.o {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f22685a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public /* synthetic */ Object f22686b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ t0 f22687c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(t0 t0Var, gd.e eVar) {
                super(2, eVar);
                this.f22687c = t0Var;
            }

            @Override // pd.o
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(SessionData sessionData, gd.e eVar) {
                return ((a) create(sessionData, eVar)).invokeSuspend(cd.h0.f3852a);
            }

            @Override // id.a
            public final gd.e create(Object obj, gd.e eVar) {
                a aVar = new a(this.f22687c, eVar);
                aVar.f22686b = obj;
                return aVar;
            }

            @Override // id.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                hd.c.f();
                if (this.f22685a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                cd.s.b(obj);
                return SessionData.c((SessionData) this.f22686b, null, this.f22687c.f22663e.a(), null, 5, null);
            }
        }

        public d(gd.e eVar) {
            super(2, eVar);
        }

        @Override // id.a
        public final gd.e create(Object obj, gd.e eVar) {
            return t0.this.new d(eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = hd.c.f();
            int i10 = this.f22683a;
            try {
                if (i10 == 0) {
                    cd.s.b(obj);
                    l1.i iVar = t0.this.f22664f;
                    a aVar = new a(t0.this, null);
                    this.f22683a = 1;
                    if (iVar.a(aVar, this) == objF) {
                        return objF;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    cd.s.b(obj);
                }
            } catch (Exception e10) {
                Log.d("FirebaseSessions", "App backgrounded, failed to update data. Message: " + e10.getMessage());
                t0 t0Var = t0.this;
                t0Var.r(SessionData.c(t0Var.m(), null, t0.this.f22663e.a(), null, 5, null));
            }
            return cd.h0.f3852a;
        }

        @Override // pd.o
        public final Object invoke(ng.n0 n0Var, gd.e eVar) {
            return ((d) create(n0Var, eVar)).invokeSuspend(cd.h0.f3852a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class e extends id.m implements pd.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f22688a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ SessionData f22690c;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a extends id.m implements pd.o {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f22691a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public /* synthetic */ Object f22692b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ t0 f22693c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(t0 t0Var, gd.e eVar) {
                super(2, eVar);
                this.f22693c = t0Var;
            }

            @Override // pd.o
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(SessionData sessionData, gd.e eVar) {
                return ((a) create(sessionData, eVar)).invokeSuspend(cd.h0.f3852a);
            }

            @Override // id.a
            public final gd.e create(Object obj, gd.e eVar) {
                a aVar = new a(this.f22693c, eVar);
                aVar.f22692b = obj;
                return aVar;
            }

            @Override // id.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                hd.c.f();
                if (this.f22691a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                cd.s.b(obj);
                SessionData sessionData = (SessionData) this.f22692b;
                boolean zP = this.f22693c.p(sessionData);
                boolean zN = this.f22693c.n(sessionData);
                boolean zO = this.f22693c.o(sessionData);
                Map mapE = zN ? this.f22693c.f22665g.e() : zO ? this.f22693c.f22665g.f(sessionData.getProcessDataMap()) : sessionData.getProcessDataMap();
                SessionDetails sessionDetails = zN ? null : sessionData.getSessionDetails();
                if (!zP && !zN) {
                    return zO ? SessionData.c(sessionData, null, null, this.f22693c.f22665g.f(mapE), 3, null) : sessionData;
                }
                SessionDetails sessionDetailsA = this.f22693c.f22661c.a(sessionDetails);
                this.f22693c.f22662d.a(sessionDetailsA);
                this.f22693c.f22665g.a();
                return sessionData.b(sessionDetailsA, null, mapE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(SessionData sessionData, gd.e eVar) {
            super(2, eVar);
            this.f22690c = sessionData;
        }

        @Override // id.a
        public final gd.e create(Object obj, gd.e eVar) {
            return t0.this.new e(this.f22690c, eVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
        
            if (r10.a(r0, r9) == r1) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0097, code lost:
        
            if (r10.q(r0, r3, r9) == r1) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0099, code lost:
        
            return r1;
         */
        @Override // id.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
            /*
                r9 = this;
                java.lang.Object r1 = hd.c.f()
                int r0 = r9.f22688a
                r2 = 2
                r3 = 1
                if (r0 == 0) goto L23
                if (r0 == r3) goto L1b
                if (r0 != r2) goto L13
                cd.s.b(r10)
                goto L9a
            L13:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L1b:
                cd.s.b(r10)     // Catch: java.lang.Exception -> L20
                goto L9a
            L20:
                r0 = move-exception
                r10 = r0
                goto L3d
            L23:
                cd.s.b(r10)
                ua.t0 r10 = ua.t0.this     // Catch: java.lang.Exception -> L20
                l1.i r10 = ua.t0.e(r10)     // Catch: java.lang.Exception -> L20
                ua.t0$e$a r0 = new ua.t0$e$a     // Catch: java.lang.Exception -> L20
                ua.t0 r4 = ua.t0.this     // Catch: java.lang.Exception -> L20
                r5 = 0
                r0.<init>(r4, r5)     // Catch: java.lang.Exception -> L20
                r9.f22688a = r3     // Catch: java.lang.Exception -> L20
                java.lang.Object r10 = r10.a(r0, r9)     // Catch: java.lang.Exception -> L20
                if (r10 != r1) goto L9a
                goto L99
            L3d:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r3 = "App foregrounded, failed to update data. Message: "
                r0.append(r3)
                java.lang.String r10 = r10.getMessage()
                r0.append(r10)
                java.lang.String r10 = r0.toString()
                java.lang.String r0 = "FirebaseSessions"
                android.util.Log.d(r0, r10)
                ua.t0 r10 = ua.t0.this
                ua.e0 r0 = r9.f22690c
                boolean r10 = ua.t0.k(r10, r0)
                if (r10 == 0) goto L9a
                ua.t0 r10 = ua.t0.this
                ua.n0 r10 = ua.t0.g(r10)
                ua.e0 r0 = r9.f22690c
                ua.h0 r0 = r0.getSessionDetails()
                ua.h0 r4 = r10.a(r0)
                ua.t0 r10 = ua.t0.this
                ua.e0 r3 = r9.f22690c
                r7 = 4
                r8 = 0
                r5 = 0
                r6 = 0
                ua.e0 r0 = ua.SessionData.c(r3, r4, r5, r6, r7, r8)
                r10.r(r0)
                ua.t0 r10 = ua.t0.this
                ua.k0 r10 = ua.t0.f(r10)
                r10.a(r4)
                ua.t0 r10 = ua.t0.this
                java.lang.String r0 = r4.getSessionId()
                ua.t0$b r3 = ua.t0.b.f22679b
                r9.f22688a = r2
                java.lang.Object r10 = ua.t0.l(r10, r0, r3, r9)
                if (r10 != r1) goto L9a
            L99:
                return r1
            L9a:
                cd.h0 r10 = cd.h0.f3852a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: ua.t0.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // pd.o
        public final Object invoke(ng.n0 n0Var, gd.e eVar) {
            return ((e) create(n0Var, eVar)).invokeSuspend(cd.h0.f3852a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class f extends id.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f22694a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f22695b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f22696c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f22698e;

        public f(gd.e eVar) {
            super(eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) {
            this.f22696c = obj;
            this.f22698e |= Integer.MIN_VALUE;
            return t0.this.q(null, null, this);
        }
    }

    public t0(xa.j sessionsSettings, n0 sessionGenerator, k0 sessionFirelogPublisher, w0 timeProvider, l1.i sessionDataStore, w processDataManager, gd.i backgroundDispatcher) {
        kotlin.jvm.internal.t.f(sessionsSettings, "sessionsSettings");
        kotlin.jvm.internal.t.f(sessionGenerator, "sessionGenerator");
        kotlin.jvm.internal.t.f(sessionFirelogPublisher, "sessionFirelogPublisher");
        kotlin.jvm.internal.t.f(timeProvider, "timeProvider");
        kotlin.jvm.internal.t.f(sessionDataStore, "sessionDataStore");
        kotlin.jvm.internal.t.f(processDataManager, "processDataManager");
        kotlin.jvm.internal.t.f(backgroundDispatcher, "backgroundDispatcher");
        this.f22660b = sessionsSettings;
        this.f22661c = sessionGenerator;
        this.f22662d = sessionFirelogPublisher;
        this.f22663e = timeProvider;
        this.f22664f = sessionDataStore;
        this.f22665g = processDataManager;
        this.f22666h = backgroundDispatcher;
        this.f22669k = b.f22678a;
        this.f22670l = "";
        ng.k.d(ng.o0.a(backgroundDispatcher), null, null, new a(null), 3, null);
    }

    @Override // ua.s0
    public boolean a() {
        return this.f22668j;
    }

    @Override // ua.s0
    public void b() {
        this.f22668j = false;
        if (this.f22667i == null) {
            Log.d("FirebaseSessions", "App backgrounded, but local SessionData not initialized");
            return;
        }
        Log.d("FirebaseSessions", "App backgrounded on " + this.f22665g.c());
        ng.k.d(ng.o0.a(this.f22666h), null, null, new d(null), 3, null);
    }

    @Override // ua.s0
    public void c() {
        this.f22668j = true;
        if (this.f22667i == null) {
            Log.d("FirebaseSessions", "App foregrounded, but local SessionData not initialized");
            return;
        }
        SessionData sessionDataM = m();
        Log.d("FirebaseSessions", "App foregrounded on " + this.f22665g.c());
        if (p(sessionDataM) || o(sessionDataM)) {
            ng.k.d(ng.o0.a(this.f22666h), null, null, new e(sessionDataM, null), 3, null);
        }
    }

    public final SessionData m() {
        SessionData sessionData = this.f22667i;
        if (sessionData != null) {
            return sessionData;
        }
        kotlin.jvm.internal.t.s("localSessionData");
        return null;
    }

    public final boolean n(SessionData sessionData) {
        Map processDataMap = sessionData.getProcessDataMap();
        if (processDataMap == null) {
            Log.d("FirebaseSessions", "No process data map");
            return true;
        }
        boolean zB = this.f22665g.b(processDataMap);
        if (zB) {
            Log.d("FirebaseSessions", "Cold app start detected");
        }
        return zB;
    }

    public final boolean o(SessionData sessionData) {
        Map processDataMap = sessionData.getProcessDataMap();
        if (processDataMap == null) {
            Log.d("FirebaseSessions", "No process data for " + this.f22665g.c());
            return true;
        }
        boolean zD = this.f22665g.d(processDataMap);
        if (zD) {
            Log.d("FirebaseSessions", "Process " + this.f22665g.c() + " is stale");
        }
        return zD;
    }

    public final boolean p(SessionData sessionData) {
        Time backgroundTime = sessionData.getBackgroundTime();
        if (backgroundTime == null) {
            Log.d("FirebaseSessions", "Session " + sessionData.getSessionDetails().getSessionId() + " has not backgrounded yet");
            return false;
        }
        boolean z10 = lg.a.l(this.f22663e.a().c(backgroundTime), this.f22660b.b()) > 0;
        if (z10) {
            Log.d("FirebaseSessions", "Session " + sessionData.getSessionDetails().getSessionId() + " is expired");
        }
        return z10;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q(java.lang.String r6, ua.t0.b r7, gd.e r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 206
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ua.t0.q(java.lang.String, ua.t0$b, gd.e):java.lang.Object");
    }

    public final void r(SessionData sessionData) {
        kotlin.jvm.internal.t.f(sessionData, "<set-?>");
        this.f22667i = sessionData;
    }
}
