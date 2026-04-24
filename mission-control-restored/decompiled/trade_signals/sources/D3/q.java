package D3;

import N3.C0732n;
import N3.C0734o;
import N3.C0736p;
import N3.F0;
import N3.I0;
import N3.O0;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay;
import java.util.concurrent.Executor;
import l2.InterfaceC2324h;

/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final F0 f824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0732n f825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0736p f826c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C0734o f827d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final O0 f828e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final T3.h f829f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f830g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FirebaseInAppMessagingDisplay f831h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Executor f832i;

    public q(F0 f02, O0 o02, C0732n c0732n, T3.h hVar, C0736p c0736p, C0734o c0734o, Executor executor) {
        this.f824a = f02;
        this.f828e = o02;
        this.f825b = c0732n;
        this.f829f = hVar;
        this.f826c = c0736p;
        this.f827d = c0734o;
        this.f832i = executor;
        hVar.getId().f(executor, new InterfaceC2324h() { // from class: D3.o
            @Override // l2.InterfaceC2324h
            public final void onSuccess(Object obj) {
                q.e((String) obj);
            }
        });
        f02.K().F(new V4.d() { // from class: D3.p
            @Override // V4.d
            public final void accept(Object obj) {
                this.f823a.h((R3.o) obj);
            }
        });
    }

    public static /* synthetic */ void e(String str) {
        I0.c("Starting InAppMessaging runtime with Installation ID " + str);
    }

    public boolean c() {
        return this.f830g;
    }

    public void d() {
        I0.c("Removing display event component");
        this.f831h = null;
    }

    public void f() {
        this.f827d.e();
    }

    public void g(FirebaseInAppMessagingDisplay firebaseInAppMessagingDisplay) {
        I0.c("Setting display event component");
        this.f831h = firebaseInAppMessagingDisplay;
    }

    public final void h(R3.o oVar) {
        FirebaseInAppMessagingDisplay firebaseInAppMessagingDisplay = this.f831h;
        if (firebaseInAppMessagingDisplay != null) {
            firebaseInAppMessagingDisplay.displayMessage(oVar.a(), this.f826c.a(oVar.a(), oVar.b()));
        }
    }
}
