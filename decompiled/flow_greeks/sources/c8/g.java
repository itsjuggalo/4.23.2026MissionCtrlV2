package c8;

import android.content.Context;
import android.content.SharedPreferences;
import c8.g;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;
import u7.b0;
import u7.c0;
import u7.d0;
import u7.h0;
import u7.s0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class g implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f3730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f3731c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b0 f3732d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c8.a f3733e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final l f3734f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c0 f3735g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicReference f3736h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicReference f3737i;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements SuccessContinuation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v7.i f3738a;

        public a(v7.i iVar) {
            this.f3738a = iVar;
        }

        @Override // com.google.android.gms.tasks.SuccessContinuation
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Task then(Void r52) throws Throwable {
            JSONObject jSONObject = (JSONObject) this.f3738a.f23155d.d().submit(new Callable() { // from class: c8.f
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    g.a aVar = this.f3728a;
                    return g.this.f3734f.a(g.this.f3730b, true);
                }
            }).get();
            if (jSONObject != null) {
                d dVarB = g.this.f3731c.b(jSONObject);
                g.this.f3733e.c(dVarB.f3713c, jSONObject);
                g.this.q(jSONObject, "Loaded settings: ");
                g gVar = g.this;
                gVar.r(gVar.f3730b.f3746f);
                g.this.f3736h.set(dVarB);
                ((TaskCompletionSource) g.this.f3737i.get()).trySetResult(dVarB);
            }
            return Tasks.forResult(null);
        }
    }

    public g(Context context, k kVar, b0 b0Var, h hVar, c8.a aVar, l lVar, c0 c0Var) {
        AtomicReference atomicReference = new AtomicReference();
        this.f3736h = atomicReference;
        this.f3737i = new AtomicReference(new TaskCompletionSource());
        this.f3729a = context;
        this.f3730b = kVar;
        this.f3732d = b0Var;
        this.f3731c = hVar;
        this.f3733e = aVar;
        this.f3734f = lVar;
        this.f3735g = c0Var;
        atomicReference.set(b.b(b0Var));
    }

    public static g l(Context context, String str, h0 h0Var, z7.b bVar, String str2, String str3, a8.g gVar, c0 c0Var) {
        String strG = h0Var.g();
        s0 s0Var = new s0();
        return new g(context, new k(str, h0Var.h(), h0Var.i(), h0Var.j(), h0Var, u7.i.h(u7.i.m(context), str, str3, str2), str3, str2, d0.b(strG).c()), s0Var, new h(s0Var), new c8.a(gVar), new c(String.format(Locale.US, "https://firebase-settings.crashlytics.com/spi/v2/platforms/android/gmp/%s/settings", str), bVar), c0Var);
    }

    @Override // c8.j
    public Task a() {
        return ((TaskCompletionSource) this.f3737i.get()).getTask();
    }

    @Override // c8.j
    public d b() {
        return (d) this.f3736h.get();
    }

    public boolean k() {
        return !n().equals(this.f3730b.f3746f);
    }

    public final d m(e eVar) throws Throwable {
        d dVar = null;
        try {
            if (!e.SKIP_CACHE_LOOKUP.equals(eVar)) {
                JSONObject jSONObjectB = this.f3733e.b();
                if (jSONObjectB != null) {
                    d dVarB = this.f3731c.b(jSONObjectB);
                    if (dVarB == null) {
                        r7.g.f().e("Failed to parse cached settings data.", null);
                        return null;
                    }
                    q(jSONObjectB, "Loaded cached settings: ");
                    long currentTimeMillis = this.f3732d.getCurrentTimeMillis();
                    if (!e.IGNORE_CACHE_EXPIRATION.equals(eVar) && dVarB.a(currentTimeMillis)) {
                        r7.g.f().i("Cached settings have expired.");
                        return null;
                    }
                    try {
                        r7.g.f().i("Returning cached settings.");
                        return dVarB;
                    } catch (Exception e10) {
                        e = e10;
                        dVar = dVarB;
                        r7.g.f().e("Failed to get cached settings", e);
                        return dVar;
                    }
                }
                r7.g.f().b("No cached settings data found.");
            }
            return null;
        } catch (Exception e11) {
            e = e11;
        }
    }

    public final String n() {
        return u7.i.q(this.f3729a).getString("existing_instance_identifier", "");
    }

    public Task o(e eVar, v7.i iVar) throws Throwable {
        d dVarM;
        if (!k() && (dVarM = m(eVar)) != null) {
            this.f3736h.set(dVarM);
            ((TaskCompletionSource) this.f3737i.get()).trySetResult(dVarM);
            return Tasks.forResult(null);
        }
        d dVarM2 = m(e.IGNORE_CACHE_EXPIRATION);
        if (dVarM2 != null) {
            this.f3736h.set(dVarM2);
            ((TaskCompletionSource) this.f3737i.get()).trySetResult(dVarM2);
        }
        return this.f3735g.i().onSuccessTask(iVar.f23152a, new a(iVar));
    }

    public Task p(v7.i iVar) {
        return o(e.USE_CACHE, iVar);
    }

    public final void q(JSONObject jSONObject, String str) {
        r7.g.f().b(str + jSONObject.toString());
    }

    public final boolean r(String str) {
        SharedPreferences.Editor editorEdit = u7.i.q(this.f3729a).edit();
        editorEdit.putString("existing_instance_identifier", str);
        editorEdit.apply();
        return true;
    }
}
