package com.google.firebase.remoteconfig.internal;

import T3.h;
import T3.m;
import android.text.format.DateUtils;
import b4.p;
import b4.q;
import b4.r;
import b4.t;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.remoteconfig.internal.e;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import l2.AbstractC2328l;
import l2.AbstractC2331o;
import l2.InterfaceC2319c;
import l2.InterfaceC2327k;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f15842j = TimeUnit.HOURS.toSeconds(12);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int[] f15843k = {2, 4, 8, 16, 32, 64, 128, 256};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f15844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final S3.b f15845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f15846c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final W1.e f15847d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Random f15848e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c4.e f15849f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ConfigFetchHttpClient f15850g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final e f15851h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map f15852i;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Date f15853a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f15854b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.google.firebase.remoteconfig.internal.b f15855c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f15856d;

        public a(Date date, int i8, com.google.firebase.remoteconfig.internal.b bVar, String str) {
            this.f15853a = date;
            this.f15854b = i8;
            this.f15855c = bVar;
            this.f15856d = str;
        }

        public static a a(Date date, com.google.firebase.remoteconfig.internal.b bVar) {
            return new a(date, 1, bVar, null);
        }

        public static a b(com.google.firebase.remoteconfig.internal.b bVar, String str) {
            return new a(bVar.h(), 0, bVar, str);
        }

        public static a c(Date date) {
            return new a(date, 2, null, null);
        }

        public com.google.firebase.remoteconfig.internal.b d() {
            return this.f15855c;
        }

        public String e() {
            return this.f15856d;
        }

        public int f() {
            return this.f15854b;
        }
    }

    public enum b {
        BASE("BASE"),
        REALTIME("REALTIME");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f15860a;

        b(String str) {
            this.f15860a = str;
        }

        public String b() {
            return this.f15860a;
        }
    }

    public c(h hVar, S3.b bVar, Executor executor, W1.e eVar, Random random, c4.e eVar2, ConfigFetchHttpClient configFetchHttpClient, e eVar3, Map map) {
        this.f15844a = hVar;
        this.f15845b = bVar;
        this.f15846c = executor;
        this.f15847d = eVar;
        this.f15848e = random;
        this.f15849f = eVar2;
        this.f15850g = configFetchHttpClient;
        this.f15851h = eVar3;
        this.f15852i = map;
    }

    public static /* synthetic */ AbstractC2328l v(a aVar, com.google.firebase.remoteconfig.internal.b bVar) {
        return AbstractC2331o.e(aVar);
    }

    public final e.a A(int i8, Date date) {
        if (t(i8)) {
            B(date);
        }
        return this.f15851h.a();
    }

    public final void B(Date date) {
        int iB = this.f15851h.a().b() + 1;
        this.f15851h.l(iB, new Date(date.getTime() + q(iB)));
    }

    public final void C(AbstractC2328l abstractC2328l, Date date) {
        if (abstractC2328l.o()) {
            this.f15851h.t(date);
            return;
        }
        Exception excJ = abstractC2328l.j();
        if (excJ == null) {
            return;
        }
        if (excJ instanceof r) {
            this.f15851h.u();
        } else {
            this.f15851h.s();
        }
    }

    public final boolean f(long j8, Date date) {
        Date dateF = this.f15851h.f();
        if (dateF.equals(e.f15884f)) {
            return false;
        }
        return date.before(new Date(dateF.getTime() + TimeUnit.SECONDS.toMillis(j8)));
    }

    public final t g(t tVar) throws p {
        String str;
        int iA = tVar.a();
        if (iA == 401) {
            str = "The request did not have the required credentials. Please make sure your google-services.json is valid.";
        } else if (iA == 403) {
            str = "The user is not authorized to access the project. Please make sure you are using the API key that corresponds to your Firebase project.";
        } else {
            if (iA == 429) {
                throw new p("The throttled response from the server was not handled correctly by the FRC SDK.");
            }
            if (iA != 500) {
                switch (iA) {
                    case 502:
                    case 503:
                    case 504:
                        str = "The server is unavailable. Please try again later.";
                        break;
                    default:
                        str = "The server returned an unexpected error.";
                        break;
                }
            } else {
                str = "There was an internal server error.";
            }
        }
        return new t(tVar.a(), "Fetch failed: " + str, tVar);
    }

    public final String h(long j8) {
        return String.format("Fetch is throttled. Please wait before calling fetch again: %s", DateUtils.formatElapsedTime(TimeUnit.MILLISECONDS.toSeconds(j8)));
    }

    public AbstractC2328l i() {
        return j(this.f15851h.h());
    }

    public AbstractC2328l j(final long j8) {
        final HashMap map = new HashMap(this.f15852i);
        map.put("X-Firebase-RC-Fetch-Type", b.BASE.b() + "/1");
        return this.f15849f.e().i(this.f15846c, new InterfaceC2319c() { // from class: c4.f
            @Override // l2.InterfaceC2319c
            public final Object a(AbstractC2328l abstractC2328l) {
                return this.f13427a.u(j8, map, abstractC2328l);
            }
        });
    }

    public final a k(String str, String str2, Date date, Map map) throws t, r {
        try {
            a aVarFetch = this.f15850g.fetch(this.f15850g.d(), str, str2, s(), this.f15851h.e(), map, p(), date, this.f15851h.b());
            if (aVarFetch.d() != null) {
                this.f15851h.p(aVarFetch.d().k());
            }
            if (aVarFetch.e() != null) {
                this.f15851h.o(aVarFetch.e());
            }
            this.f15851h.j();
            return aVarFetch;
        } catch (t e8) {
            e.a aVarA = A(e8.a(), date);
            if (z(aVarA, e8.a())) {
                throw new r(aVarA.a().getTime());
            }
            throw g(e8);
        }
    }

    public final AbstractC2328l l(String str, String str2, Date date, Map map) {
        try {
            final a aVarK = k(str, str2, date, map);
            return aVarK.f() != 0 ? AbstractC2331o.e(aVarK) : this.f15849f.k(aVarK.d()).p(this.f15846c, new InterfaceC2327k() { // from class: c4.j
                @Override // l2.InterfaceC2327k
                public final AbstractC2328l a(Object obj) {
                    return com.google.firebase.remoteconfig.internal.c.v(aVarK, (com.google.firebase.remoteconfig.internal.b) obj);
                }
            });
        } catch (q e8) {
            return AbstractC2331o.d(e8);
        }
    }

    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public final AbstractC2328l u(AbstractC2328l abstractC2328l, long j8, final Map map) {
        AbstractC2328l abstractC2328lI;
        final Date date = new Date(this.f15847d.a());
        if (abstractC2328l.o() && f(j8, date)) {
            return AbstractC2331o.e(a.c(date));
        }
        Date dateO = o(date);
        if (dateO != null) {
            abstractC2328lI = AbstractC2331o.d(new r(h(dateO.getTime() - date.getTime()), dateO.getTime()));
        } else {
            final AbstractC2328l id = this.f15844a.getId();
            final AbstractC2328l abstractC2328lA = this.f15844a.a(false);
            abstractC2328lI = AbstractC2331o.j(id, abstractC2328lA).i(this.f15846c, new InterfaceC2319c() { // from class: c4.g
                @Override // l2.InterfaceC2319c
                public final Object a(AbstractC2328l abstractC2328l2) {
                    return this.f13430a.w(id, abstractC2328lA, date, map, abstractC2328l2);
                }
            });
        }
        return abstractC2328lI.i(this.f15846c, new InterfaceC2319c() { // from class: c4.h
            @Override // l2.InterfaceC2319c
            public final Object a(AbstractC2328l abstractC2328l2) {
                return this.f13435a.x(date, abstractC2328l2);
            }
        });
    }

    public AbstractC2328l n(b bVar, int i8) {
        final HashMap map = new HashMap(this.f15852i);
        map.put("X-Firebase-RC-Fetch-Type", bVar.b() + "/" + i8);
        return this.f15849f.e().i(this.f15846c, new InterfaceC2319c() { // from class: c4.i
            @Override // l2.InterfaceC2319c
            public final Object a(AbstractC2328l abstractC2328l) {
                return this.f13437a.y(map, abstractC2328l);
            }
        });
    }

    public final Date o(Date date) {
        Date dateA = this.f15851h.a().a();
        if (date.before(dateA)) {
            return dateA;
        }
        return null;
    }

    public final Long p() {
        AnalyticsConnector analyticsConnector = (AnalyticsConnector) this.f15845b.get();
        if (analyticsConnector == null) {
            return null;
        }
        return (Long) analyticsConnector.getUserProperties(true).get("_fot");
    }

    public final long q(int i8) {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        int[] iArr = f15843k;
        long millis = timeUnit.toMillis(iArr[Math.min(i8, iArr.length) - 1]);
        return (millis / 2) + ((long) this.f15848e.nextInt((int) millis));
    }

    public long r() {
        return this.f15851h.g();
    }

    public final Map s() {
        HashMap map = new HashMap();
        AnalyticsConnector analyticsConnector = (AnalyticsConnector) this.f15845b.get();
        if (analyticsConnector == null) {
            return map;
        }
        for (Map.Entry<String, Object> entry : analyticsConnector.getUserProperties(false).entrySet()) {
            map.put(entry.getKey(), entry.getValue().toString());
        }
        return map;
    }

    public final boolean t(int i8) {
        return i8 == 429 || i8 == 502 || i8 == 503 || i8 == 504;
    }

    public final /* synthetic */ AbstractC2328l w(AbstractC2328l abstractC2328l, AbstractC2328l abstractC2328l2, Date date, Map map, AbstractC2328l abstractC2328l3) {
        return !abstractC2328l.o() ? AbstractC2331o.d(new p("Firebase Installations failed to get installation ID for fetch.", abstractC2328l.j())) : !abstractC2328l2.o() ? AbstractC2331o.d(new p("Firebase Installations failed to get installation auth token for fetch.", abstractC2328l2.j())) : l((String) abstractC2328l.k(), ((m) abstractC2328l2.k()).b(), date, map);
    }

    public final /* synthetic */ AbstractC2328l x(Date date, AbstractC2328l abstractC2328l) {
        C(abstractC2328l, date);
        return abstractC2328l;
    }

    public final /* synthetic */ AbstractC2328l y(Map map, AbstractC2328l abstractC2328l) {
        return u(abstractC2328l, 0L, map);
    }

    public final boolean z(e.a aVar, int i8) {
        return aVar.b() > 1 || i8 == 429;
    }
}
