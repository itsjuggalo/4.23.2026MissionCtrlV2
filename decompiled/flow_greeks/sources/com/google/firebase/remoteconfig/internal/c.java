package com.google.firebase.remoteconfig.internal;

import android.text.format.DateUtils;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.remoteconfig.internal.e;
import ga.h;
import ga.m;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import pa.p;
import pa.q;
import pa.r;
import pa.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f6495j = TimeUnit.HOURS.toSeconds(12);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int[] f6496k = {2, 4, 8, 16, 32, 64, 128, 256};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f6497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final fa.b f6498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f6499c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t5.e f6500d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Random f6501e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final qa.e f6502f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ConfigFetchHttpClient f6503g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final e f6504h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map f6505i;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Date f6506a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f6507b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.google.firebase.remoteconfig.internal.b f6508c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f6509d;

        public a(Date date, int i10, com.google.firebase.remoteconfig.internal.b bVar, String str) {
            this.f6506a = date;
            this.f6507b = i10;
            this.f6508c = bVar;
            this.f6509d = str;
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
            return this.f6508c;
        }

        public String e() {
            return this.f6509d;
        }

        public int f() {
            return this.f6507b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum b {
        BASE("BASE"),
        REALTIME("REALTIME");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f6513a;

        b(String str) {
            this.f6513a = str;
        }

        public String b() {
            return this.f6513a;
        }
    }

    public c(h hVar, fa.b bVar, Executor executor, t5.e eVar, Random random, qa.e eVar2, ConfigFetchHttpClient configFetchHttpClient, e eVar3, Map map) {
        this.f6497a = hVar;
        this.f6498b = bVar;
        this.f6499c = executor;
        this.f6500d = eVar;
        this.f6501e = random;
        this.f6502f = eVar2;
        this.f6503g = configFetchHttpClient;
        this.f6504h = eVar3;
        this.f6505i = map;
    }

    public static /* synthetic */ Task a(c cVar, Task task, Task task2, Date date, Map map, Task task3) {
        cVar.getClass();
        return !task.isSuccessful() ? Tasks.forException(new p("Firebase Installations failed to get installation ID for fetch.", task.getException())) : !task2.isSuccessful() ? Tasks.forException(new p("Firebase Installations failed to get installation auth token for fetch.", task2.getException())) : cVar.l((String) task.getResult(), ((m) task2.getResult()).b(), date, map);
    }

    public static /* synthetic */ Task c(c cVar, Date date, Task task) {
        cVar.x(task, date);
        return task;
    }

    public final boolean f(long j10, Date date) {
        Date dateF = this.f6504h.f();
        if (dateF.equals(e.f6537f)) {
            return false;
        }
        return date.before(new Date(dateF.getTime() + TimeUnit.SECONDS.toMillis(j10)));
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

    public final String h(long j10) {
        return String.format("Fetch is throttled. Please wait before calling fetch again: %s", DateUtils.formatElapsedTime(TimeUnit.MILLISECONDS.toSeconds(j10)));
    }

    public Task i() {
        return j(this.f6504h.h());
    }

    public Task j(final long j10) {
        final HashMap map = new HashMap(this.f6505i);
        map.put("X-Firebase-RC-Fetch-Type", b.BASE.b() + "/1");
        return this.f6502f.e().continueWithTask(this.f6499c, new Continuation() { // from class: qa.f
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return this.f18981a.m(task, j10, map);
            }
        });
    }

    public final a k(String str, String str2, Date date, Map map) throws r, t {
        Date date2;
        try {
            date2 = date;
            try {
                a aVarFetch = this.f6503g.fetch(this.f6503g.d(), str, str2, s(), this.f6504h.e(), map, p(), date2, this.f6504h.b());
                if (aVarFetch.d() != null) {
                    this.f6504h.p(aVarFetch.d().k());
                }
                if (aVarFetch.e() != null) {
                    this.f6504h.o(aVarFetch.e());
                }
                this.f6504h.j();
                return aVarFetch;
            } catch (t e10) {
                e = e10;
                t tVar = e;
                e.a aVarV = v(tVar.a(), date2);
                if (u(aVarV, tVar.a())) {
                    throw new r(aVarV.a().getTime());
                }
                throw g(tVar);
            }
        } catch (t e11) {
            e = e11;
            date2 = date;
        }
    }

    public final Task l(String str, String str2, Date date, Map map) {
        try {
            final a aVarK = k(str, str2, date, map);
            return aVarK.f() != 0 ? Tasks.forResult(aVarK) : this.f6502f.i(aVarK.d()).onSuccessTask(this.f6499c, new SuccessContinuation() { // from class: qa.j
                @Override // com.google.android.gms.tasks.SuccessContinuation
                public final Task then(Object obj) {
                    return Tasks.forResult(aVarK);
                }
            });
        } catch (q e10) {
            return Tasks.forException(e10);
        }
    }

    public final Task m(Task task, long j10, final Map map) {
        final c cVar;
        Task taskContinueWithTask;
        final Date date = new Date(this.f6500d.a());
        if (task.isSuccessful() && f(j10, date)) {
            return Tasks.forResult(a.c(date));
        }
        Date dateO = o(date);
        if (dateO != null) {
            taskContinueWithTask = Tasks.forException(new r(h(dateO.getTime() - date.getTime()), dateO.getTime()));
            cVar = this;
        } else {
            final Task id2 = this.f6497a.getId();
            final Task taskA = this.f6497a.a(false);
            cVar = this;
            taskContinueWithTask = Tasks.whenAllComplete((Task<?>[]) new Task[]{id2, taskA}).continueWithTask(this.f6499c, new Continuation() { // from class: qa.g
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task2) {
                    return com.google.firebase.remoteconfig.internal.c.a(this.f18984a, id2, taskA, date, map, task2);
                }
            });
        }
        return taskContinueWithTask.continueWithTask(cVar.f6499c, new Continuation() { // from class: qa.h
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) {
                return com.google.firebase.remoteconfig.internal.c.c(this.f18989a, date, task2);
            }
        });
    }

    public Task n(b bVar, int i10) {
        final HashMap map = new HashMap(this.f6505i);
        map.put("X-Firebase-RC-Fetch-Type", bVar.b() + "/" + i10);
        return this.f6502f.e().continueWithTask(this.f6499c, new Continuation() { // from class: qa.i
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return this.f18991a.m(task, 0L, map);
            }
        });
    }

    public final Date o(Date date) {
        Date dateA = this.f6504h.a().a();
        if (date.before(dateA)) {
            return dateA;
        }
        return null;
    }

    public final Long p() {
        AnalyticsConnector analyticsConnector = (AnalyticsConnector) this.f6498b.get();
        if (analyticsConnector == null) {
            return null;
        }
        return (Long) analyticsConnector.getUserProperties(true).get("_fot");
    }

    public final long q(int i10) {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        int[] iArr = f6496k;
        long millis = timeUnit.toMillis(iArr[Math.min(i10, iArr.length) - 1]);
        return (millis / 2) + ((long) this.f6501e.nextInt((int) millis));
    }

    public long r() {
        return this.f6504h.g();
    }

    public final Map s() {
        HashMap map = new HashMap();
        AnalyticsConnector analyticsConnector = (AnalyticsConnector) this.f6498b.get();
        if (analyticsConnector != null) {
            for (Map.Entry<String, Object> entry : analyticsConnector.getUserProperties(false).entrySet()) {
                map.put(entry.getKey(), entry.getValue().toString());
            }
        }
        return map;
    }

    public final boolean t(int i10) {
        return i10 == 429 || i10 == 502 || i10 == 503 || i10 == 504;
    }

    public final boolean u(e.a aVar, int i10) {
        return aVar.b() > 1 || i10 == 429;
    }

    public final e.a v(int i10, Date date) {
        if (t(i10)) {
            w(date);
        }
        return this.f6504h.a();
    }

    public final void w(Date date) {
        int iB = this.f6504h.a().b() + 1;
        this.f6504h.l(iB, new Date(date.getTime() + q(iB)));
    }

    public final void x(Task task, Date date) {
        if (task.isSuccessful()) {
            this.f6504h.t(date);
            return;
        }
        Exception exception = task.getException();
        if (exception == null) {
            return;
        }
        if (exception instanceof r) {
            this.f6504h.u();
        } else {
            this.f6504h.s();
        }
    }
}
