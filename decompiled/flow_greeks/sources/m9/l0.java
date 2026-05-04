package m9;

import java.util.Locale;
import n9.g;
import rb.k1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class l0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f16204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g.b f16205c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n9.g f16207e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f16208f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g9.z0 f16203a = g9.z0.UNKNOWN;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f16206d = true;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface a {
        void a(g9.z0 z0Var);
    }

    public l0(n9.g gVar, a aVar) {
        this.f16207e = gVar;
        this.f16208f = aVar;
    }

    public static /* synthetic */ void a(l0 l0Var) {
        l0Var.f16205c = null;
        n9.b.d(l0Var.f16203a == g9.z0.UNKNOWN, "Timer should be canceled if we transitioned to a different state.", new Object[0]);
        l0Var.f(String.format(Locale.ENGLISH, "Backend didn't respond within %d seconds\n", 10));
        l0Var.g(g9.z0.OFFLINE);
    }

    public final void b() {
        g.b bVar = this.f16205c;
        if (bVar != null) {
            bVar.c();
            this.f16205c = null;
        }
    }

    public g9.z0 c() {
        return this.f16203a;
    }

    public void d(k1 k1Var) {
        if (this.f16203a == g9.z0.ONLINE) {
            g(g9.z0.UNKNOWN);
            n9.b.d(this.f16204b == 0, "watchStreamFailures must be 0", new Object[0]);
            n9.b.d(this.f16205c == null, "onlineStateTimer must be null", new Object[0]);
            return;
        }
        int i10 = this.f16204b + 1;
        this.f16204b = i10;
        if (i10 >= 1) {
            b();
            f(String.format(Locale.ENGLISH, "Connection failed %d times. Most recent error: %s", 1, k1Var));
            g(g9.z0.OFFLINE);
        }
    }

    public void e() {
        if (this.f16204b == 0) {
            g(g9.z0.UNKNOWN);
            n9.b.d(this.f16205c == null, "onlineStateTimer shouldn't be started yet", new Object[0]);
            this.f16205c = this.f16207e.k(g.d.ONLINE_STATE_TIMEOUT, 10000L, new Runnable() { // from class: m9.k0
                @Override // java.lang.Runnable
                public final void run() {
                    l0.a(this.f16197a);
                }
            });
        }
    }

    public final void f(String str) {
        String str2 = String.format("Could not reach Cloud Firestore backend. %s\nThis typically indicates that your device does not have a healthy Internet connection at the moment. The client will operate in offline mode until it is able to successfully connect to the backend.", str);
        if (!this.f16206d) {
            n9.v.a("OnlineStateTracker", "%s", str2);
        } else {
            n9.v.e("OnlineStateTracker", "%s", str2);
            this.f16206d = false;
        }
    }

    public final void g(g9.z0 z0Var) {
        if (z0Var != this.f16203a) {
            this.f16203a = z0Var;
            this.f16208f.a(z0Var);
        }
    }

    public void h(g9.z0 z0Var) {
        b();
        this.f16204b = 0;
        if (z0Var == g9.z0.ONLINE) {
            this.f16206d = false;
        }
        g(z0Var);
    }
}
