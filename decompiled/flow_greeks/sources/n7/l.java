package n7;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class l implements Continuation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f16809a;

    public l(m mVar) {
        Objects.requireNonNull(mVar);
        this.f16809a = mVar;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Object then(Task task) {
        return !task.isSuccessful() ? Tasks.forException((Exception) com.google.android.gms.common.internal.s.k(task.getException())) : Tasks.forResult(p.S(((m7.c0) task.getResult()).g(), this.f16809a.f16814a));
    }
}
