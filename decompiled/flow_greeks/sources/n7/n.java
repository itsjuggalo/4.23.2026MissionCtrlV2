package n7;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class n implements Continuation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f16821a;

    public n(o oVar) {
        Objects.requireNonNull(oVar);
        this.f16821a = oVar;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Object then(Task task) {
        if (this.f16821a.f16830d == null) {
            return task;
        }
        if (task.isSuccessful()) {
            m7.i iVar = (m7.i) task.getResult();
            return Tasks.forResult(new i2((i) iVar.G(), (g2) iVar.y(), this.f16821a.f16830d));
        }
        Exception exception = task.getException();
        if (exception instanceof m7.x) {
            ((m7.x) exception).e(this.f16821a.f16830d);
        }
        return Tasks.forException(exception);
    }
}
