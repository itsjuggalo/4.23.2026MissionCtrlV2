package o9;

import android.content.Context;
import android.util.Base64OutputStream;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.zip.GZIPOutputStream;
import o7.e0;
import o7.w;
import o9.j;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class f implements i, j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fa.b f17668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f17669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final fa.b f17670c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set f17671d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Executor f17672e;

    public f(final Context context, final String str, Set set, fa.b bVar, Executor executor) {
        this(new w(new fa.b() { // from class: o9.c
            @Override // fa.b
            public final Object get() {
                return f.d(context, str);
            }
        }), set, executor, bVar, context);
    }

    public static /* synthetic */ String c(f fVar) {
        String string;
        synchronized (fVar) {
            try {
                p pVar = (p) fVar.f17668a.get();
                List listG = pVar.g();
                pVar.f();
                JSONArray jSONArray = new JSONArray();
                for (int i10 = 0; i10 < listG.size(); i10++) {
                    q qVar = (q) listG.get(i10);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("agent", qVar.c());
                    jSONObject.put("dates", new JSONArray((Collection) qVar.b()));
                    jSONArray.put(jSONObject);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("heartbeats", jSONArray);
                jSONObject2.put(DiagnosticsEntry.VERSION_KEY, "2");
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Base64OutputStream base64OutputStream = new Base64OutputStream(byteArrayOutputStream, 11);
                try {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(base64OutputStream);
                    try {
                        gZIPOutputStream.write(jSONObject2.toString().getBytes("UTF-8"));
                        gZIPOutputStream.close();
                        base64OutputStream.close();
                        string = byteArrayOutputStream.toString("UTF-8");
                    } finally {
                    }
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return string;
    }

    public static /* synthetic */ p d(Context context, String str) {
        return new p(context, str);
    }

    public static /* synthetic */ f e(e0 e0Var, o7.d dVar) {
        return new f((Context) dVar.get(Context.class), ((a7.g) dVar.get(a7.g.class)).s(), dVar.c(g.class), dVar.b(oa.i.class), (Executor) dVar.f(e0Var));
    }

    public static /* synthetic */ Void f(f fVar) {
        synchronized (fVar) {
            ((p) fVar.f17668a.get()).o(System.currentTimeMillis(), ((oa.i) fVar.f17670c.get()).a());
        }
        return null;
    }

    public static o7.c g() {
        final e0 e0VarA = e0.a(d7.a.class, Executor.class);
        return o7.c.d(f.class, i.class, j.class).b(o7.q.k(Context.class)).b(o7.q.k(a7.g.class)).b(o7.q.o(g.class)).b(o7.q.m(oa.i.class)).b(o7.q.l(e0VarA)).f(new o7.g() { // from class: o9.b
            @Override // o7.g
            public final Object create(o7.d dVar) {
                return f.e(e0VarA, dVar);
            }
        }).d();
    }

    @Override // o9.i
    public Task a() {
        return !p0.l.a(this.f17669b) ? Tasks.forResult("") : Tasks.call(this.f17672e, new Callable() { // from class: o9.d
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return f.c(this.f17666a);
            }
        });
    }

    @Override // o9.j
    public synchronized j.a b(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        p pVar = (p) this.f17668a.get();
        if (!pVar.m(jCurrentTimeMillis)) {
            return j.a.NONE;
        }
        pVar.k();
        return j.a.GLOBAL;
    }

    public Task h() {
        return this.f17671d.size() <= 0 ? Tasks.forResult(null) : !p0.l.a(this.f17669b) ? Tasks.forResult(null) : Tasks.call(this.f17672e, new Callable() { // from class: o9.e
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return f.f(this.f17667a);
            }
        });
    }

    public f(fa.b bVar, Set set, Executor executor, fa.b bVar2, Context context) {
        this.f17668a = bVar;
        this.f17671d = set;
        this.f17672e = executor;
        this.f17670c = bVar2;
        this.f17669b = context;
    }
}
