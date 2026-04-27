package B3;

import B3.j;
import M2.C0700c;
import M2.E;
import M2.InterfaceC0701d;
import M2.w;
import android.content.Context;
import android.util.Base64OutputStream;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.zip.GZIPOutputStream;
import l2.AbstractC2328l;
import l2.AbstractC2331o;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f implements i, j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S3.b f137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f138b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final S3.b f139c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set f140d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Executor f141e;

    public f(S3.b bVar, Set set, Executor executor, S3.b bVar2, Context context) {
        this.f137a = bVar;
        this.f140d = set;
        this.f141e = executor;
        this.f139c = bVar2;
        this.f138b = context;
    }

    public static C0700c g() {
        final E eA = E.a(J2.a.class, Executor.class);
        return C0700c.f(f.class, i.class, j.class).b(M2.q.l(Context.class)).b(M2.q.l(G2.f.class)).b(M2.q.o(g.class)).b(M2.q.n(a4.i.class)).b(M2.q.k(eA)).f(new M2.g() { // from class: B3.b
            @Override // M2.g
            public final Object create(InterfaceC0701d interfaceC0701d) {
                return f.h(eA, interfaceC0701d);
            }
        }).d();
    }

    public static /* synthetic */ f h(E e8, InterfaceC0701d interfaceC0701d) {
        return new f((Context) interfaceC0701d.get(Context.class), ((G2.f) interfaceC0701d.get(G2.f.class)).s(), interfaceC0701d.g(g.class), interfaceC0701d.c(a4.i.class), (Executor) interfaceC0701d.d(e8));
    }

    public static /* synthetic */ p j(Context context, String str) {
        return new p(context, str);
    }

    @Override // B3.i
    public AbstractC2328l a() {
        return P.m.a(this.f138b) ^ true ? AbstractC2331o.e("") : AbstractC2331o.c(this.f141e, new Callable() { // from class: B3.d
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f135a.i();
            }
        });
    }

    @Override // B3.j
    public synchronized j.a b(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        p pVar = (p) this.f137a.get();
        if (!pVar.q(jCurrentTimeMillis)) {
            return j.a.NONE;
        }
        pVar.o();
        return j.a.GLOBAL;
    }

    public final /* synthetic */ String i() {
        String string;
        synchronized (this) {
            try {
                p pVar = (p) this.f137a.get();
                List listG = pVar.g();
                pVar.f();
                JSONArray jSONArray = new JSONArray();
                for (int i8 = 0; i8 < listG.size(); i8++) {
                    q qVar = (q) listG.get(i8);
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

    public final /* synthetic */ Void k() {
        synchronized (this) {
            ((p) this.f137a.get()).s(System.currentTimeMillis(), ((a4.i) this.f139c.get()).a());
        }
        return null;
    }

    public AbstractC2328l l() {
        return this.f140d.size() <= 0 ? AbstractC2331o.e(null) : P.m.a(this.f138b) ^ true ? AbstractC2331o.e(null) : AbstractC2331o.c(this.f141e, new Callable() { // from class: B3.e
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f136a.k();
            }
        });
    }

    public f(final Context context, final String str, Set set, S3.b bVar, Executor executor) {
        this(new w(new S3.b() { // from class: B3.c
            @Override // S3.b
            public final Object get() {
                return f.j(context, str);
            }
        }), set, executor, bVar, context);
    }
}
