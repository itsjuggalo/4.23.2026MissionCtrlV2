package n7;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuth;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class l1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final l1 f16811c = new l1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p0 f16812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a0 f16813b;

    public l1() {
        this(p0.j(), a0.b());
    }

    public static l1 f() {
        return f16811c;
    }

    public final void a(Context context) {
        this.f16812a.a(context);
    }

    public final void b(FirebaseAuth firebaseAuth) {
        this.f16812a.h(firebaseAuth);
    }

    public final boolean c(Activity activity, TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth) {
        return this.f16813b.i(activity, taskCompletionSource, firebaseAuth);
    }

    public final boolean d(Activity activity, TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth, m7.a0 a0Var) {
        return this.f16813b.j(activity, taskCompletionSource, firebaseAuth, a0Var);
    }

    public final Task e() {
        return this.f16812a.i();
    }

    public l1(p0 p0Var, a0 a0Var) {
        this.f16812a = p0Var;
        this.f16813b = a0Var;
    }
}
