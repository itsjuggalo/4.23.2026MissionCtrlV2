package d9;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FirebaseFirestore f7844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f7845b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f7846c = false;

    public a2(FirebaseFirestore firebaseFirestore) {
        this.f7844a = (FirebaseFirestore) n9.x.b(firebaseFirestore);
    }

    public Task b() {
        h();
        this.f7846c = true;
        return !this.f7845b.isEmpty() ? (Task) this.f7844a.s(new n9.t() { // from class: d9.z1
            @Override // n9.t
            public final Object apply(Object obj) {
                return ((g9.q0) obj).T(this.f7984a.f7845b);
            }
        }) : Tasks.forResult(null);
    }

    public a2 c(com.google.firebase.firestore.c cVar) {
        this.f7844a.R(cVar);
        h();
        this.f7845b.add(new k9.c(cVar.q(), k9.m.f14793c));
        return this;
    }

    public a2 d(com.google.firebase.firestore.c cVar, Object obj) {
        return e(cVar, obj, q1.f7920c);
    }

    public a2 e(com.google.firebase.firestore.c cVar, Object obj, q1 q1Var) {
        this.f7844a.R(cVar);
        n9.x.c(obj, "Provided data must not be null.");
        n9.x.c(q1Var, "Provided options must not be null.");
        h();
        this.f7845b.add((q1Var.b() ? this.f7844a.F().g(obj, q1Var.a()) : this.f7844a.F().l(obj)).a(cVar.q(), k9.m.f14793c));
        return this;
    }

    public final a2 f(com.google.firebase.firestore.c cVar, g9.t1 t1Var) {
        this.f7844a.R(cVar);
        h();
        this.f7845b.add(t1Var.a(cVar.q(), k9.m.a(true)));
        return this;
    }

    public a2 g(com.google.firebase.firestore.c cVar, Map map) {
        return f(cVar, this.f7844a.F().o(map));
    }

    public final void h() {
        if (this.f7846c) {
            throw new IllegalStateException("A write batch can no longer be used after commit() has been called.");
        }
    }
}
