package J3;

import K3.AbstractC0612b;
import K3.C0617g;
import java.util.Locale;
import r5.l0;

/* JADX INFO: loaded from: classes.dex */
public class L {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3095b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public C0617g.b f3096c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final C0617g f3098e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f3099f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public D3.a0 f3094a = D3.a0.UNKNOWN;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f3097d = true;

    public interface a {
        void a(D3.a0 a0Var);
    }

    public L(C0617g c0617g, a aVar) {
        this.f3098e = c0617g;
        this.f3099f = aVar;
    }

    public final void b() {
        C0617g.b bVar = this.f3096c;
        if (bVar != null) {
            bVar.c();
            this.f3096c = null;
        }
    }

    public D3.a0 c() {
        return this.f3094a;
    }

    public void d(l0 l0Var) {
        if (this.f3094a == D3.a0.ONLINE) {
            h(D3.a0.UNKNOWN);
            AbstractC0612b.d(this.f3095b == 0, "watchStreamFailures must be 0", new Object[0]);
            AbstractC0612b.d(this.f3096c == null, "onlineStateTimer must be null", new Object[0]);
            return;
        }
        int i7 = this.f3095b + 1;
        this.f3095b = i7;
        if (i7 >= 1) {
            b();
            g(String.format(Locale.ENGLISH, "Connection failed %d times. Most recent error: %s", 1, l0Var));
            h(D3.a0.OFFLINE);
        }
    }

    public void e() {
        if (this.f3095b == 0) {
            h(D3.a0.UNKNOWN);
            AbstractC0612b.d(this.f3096c == null, "onlineStateTimer shouldn't be started yet", new Object[0]);
            this.f3096c = this.f3098e.k(C0617g.d.ONLINE_STATE_TIMEOUT, 10000L, new Runnable() { // from class: J3.K
                @Override // java.lang.Runnable
                public final void run() {
                    this.f3093a.f();
                }
            });
        }
    }

    public final /* synthetic */ void f() {
        this.f3096c = null;
        AbstractC0612b.d(this.f3094a == D3.a0.UNKNOWN, "Timer should be canceled if we transitioned to a different state.", new Object[0]);
        g(String.format(Locale.ENGLISH, "Backend didn't respond within %d seconds\n", 10));
        h(D3.a0.OFFLINE);
    }

    public final void g(String str) {
        String str2 = String.format("Could not reach Cloud Firestore backend. %s\nThis typically indicates that your device does not have a healthy Internet connection at the moment. The client will operate in offline mode until it is able to successfully connect to the backend.", str);
        if (!this.f3097d) {
            K3.x.a("OnlineStateTracker", "%s", str2);
        } else {
            K3.x.e("OnlineStateTracker", "%s", str2);
            this.f3097d = false;
        }
    }

    public final void h(D3.a0 a0Var) {
        if (a0Var != this.f3094a) {
            this.f3094a = a0Var;
            this.f3099f.a(a0Var);
        }
    }

    public void i(D3.a0 a0Var) {
        b();
        this.f3095b = 0;
        if (a0Var == D3.a0.ONLINE) {
            this.f3097d = false;
        }
        h(a0Var);
    }
}
