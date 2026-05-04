package m7;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class k1 implements Continuation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f16035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f16036b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a0 f16037c;

    public k1(a0 a0Var, String str, e eVar) {
        this.f16035a = str;
        this.f16036b = eVar;
        Objects.requireNonNull(a0Var);
        this.f16037c = a0Var;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Object then(Task task) {
        return FirebaseAuth.getInstance(this.f16037c.m0()).P((String) com.google.android.gms.common.internal.s.k(((c0) task.getResult()).g()), this.f16035a, this.f16036b);
    }
}
