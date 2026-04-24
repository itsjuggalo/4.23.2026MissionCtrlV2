package L3;

import L3.j;
import M.o;
import android.content.Context;
import android.util.Base64OutputStream;
import b3.C0982E;
import b3.C0986c;
import b3.InterfaceC0987d;
import b3.InterfaceC0990g;
import b3.q;
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
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f implements i, j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final N3.b f3659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f3660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final N3.b f3661c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set f3662d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Executor f3663e;

    public f(final Context context, final String str, Set set, N3.b bVar, Executor executor) {
        this(new N3.b() { // from class: L3.c
            @Override // N3.b
            public final Object get() {
                return f.j(context, str);
            }
        }, set, executor, bVar, context);
    }

    public static C0986c g() {
        final C0982E c0982eA = C0982E.a(U2.a.class, Executor.class);
        return C0986c.f(f.class, i.class, j.class).b(q.l(Context.class)).b(q.l(Q2.g.class)).b(q.o(g.class)).b(q.n(X3.i.class)).b(q.k(c0982eA)).f(new InterfaceC0990g() { // from class: L3.b
            @Override // b3.InterfaceC0990g
            public final Object a(InterfaceC0987d interfaceC0987d) {
                return f.h(c0982eA, interfaceC0987d);
            }
        }).d();
    }

    public static /* synthetic */ f h(C0982E c0982e, InterfaceC0987d interfaceC0987d) {
        return new f((Context) interfaceC0987d.a(Context.class), ((Q2.g) interfaceC0987d.a(Q2.g.class)).s(), interfaceC0987d.f(g.class), interfaceC0987d.d(X3.i.class), (Executor) interfaceC0987d.e(c0982e));
    }

    public static /* synthetic */ k j(Context context, String str) {
        return new k(context, str);
    }

    @Override // L3.i
    public Task a() {
        return !o.a(this.f3660b) ? Tasks.forResult("") : Tasks.call(this.f3663e, new Callable() { // from class: L3.d
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f3657a.i();
            }
        });
    }

    @Override // L3.j
    public synchronized j.a b(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        k kVar = (k) this.f3659a.get();
        if (!kVar.i(jCurrentTimeMillis)) {
            return j.a.NONE;
        }
        kVar.g();
        return j.a.GLOBAL;
    }

    public final /* synthetic */ String i() {
        String string;
        synchronized (this) {
            try {
                k kVar = (k) this.f3659a.get();
                List listC = kVar.c();
                kVar.b();
                JSONArray jSONArray = new JSONArray();
                for (int i7 = 0; i7 < listC.size(); i7++) {
                    l lVar = (l) listC.get(i7);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("agent", lVar.c());
                    jSONObject.put("dates", new JSONArray((Collection) lVar.b()));
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

    public final /* synthetic */ Void k() {
        synchronized (this) {
            ((k) this.f3659a.get()).k(System.currentTimeMillis(), ((X3.i) this.f3661c.get()).a());
        }
        return null;
    }

    public Task l() {
        return this.f3662d.size() <= 0 ? Tasks.forResult(null) : !o.a(this.f3660b) ? Tasks.forResult(null) : Tasks.call(this.f3663e, new Callable() { // from class: L3.e
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f3658a.k();
            }
        });
    }

    public f(N3.b bVar, Set set, Executor executor, N3.b bVar2, Context context) {
        this.f3659a = bVar;
        this.f3662d = set;
        this.f3663e = executor;
        this.f3661c = bVar2;
        this.f3660b = context;
    }
}
