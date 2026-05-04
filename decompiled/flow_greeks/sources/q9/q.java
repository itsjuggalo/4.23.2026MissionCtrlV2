package q9;

import aa.e2;
import aa.h2;
import aa.n2;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e2 f18929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final aa.n f18930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final aa.p f18931c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final aa.o f18932d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n2 f18933e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ga.h f18934f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f18935g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FirebaseInAppMessagingDisplay f18936h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Executor f18937i;

    public q(e2 e2Var, n2 n2Var, aa.n nVar, ga.h hVar, aa.p pVar, aa.o oVar, Executor executor) {
        this.f18929a = e2Var;
        this.f18933e = n2Var;
        this.f18930b = nVar;
        this.f18934f = hVar;
        this.f18931c = pVar;
        this.f18932d = oVar;
        this.f18937i = executor;
        hVar.getId().addOnSuccessListener(executor, new OnSuccessListener() { // from class: q9.o
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                h2.c("Starting InAppMessaging runtime with Installation ID " + ((String) obj));
            }
        });
        e2Var.K().F(new ic.d() { // from class: q9.p
            @Override // ic.d
            public final void accept(Object obj) {
                this.f18928a.g((ea.o) obj);
            }
        });
    }

    public boolean c() {
        return this.f18935g;
    }

    public void d() {
        h2.c("Removing display event component");
        this.f18936h = null;
    }

    public void e() {
        this.f18932d.e();
    }

    public void f(FirebaseInAppMessagingDisplay firebaseInAppMessagingDisplay) {
        h2.c("Setting display event component");
        this.f18936h = firebaseInAppMessagingDisplay;
    }

    public final void g(ea.o oVar) {
        FirebaseInAppMessagingDisplay firebaseInAppMessagingDisplay = this.f18936h;
        if (firebaseInAppMessagingDisplay != null) {
            firebaseInAppMessagingDisplay.displayMessage(oVar.a(), this.f18931c.a(oVar.a(), oVar.b()));
        }
    }
}
