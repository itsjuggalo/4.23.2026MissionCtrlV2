package d9;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.firebase.firestore.i f7854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f7855b;

    public c(com.google.firebase.firestore.i iVar, List list) {
        this.f7854a = iVar;
        this.f7855b = list;
    }

    public static /* synthetic */ Object a(c cVar, TaskCompletionSource taskCompletionSource, Task task) {
        cVar.getClass();
        if (task.isSuccessful()) {
            taskCompletionSource.setResult(new com.google.firebase.firestore.b(cVar, (Map) task.getResult()));
            return null;
        }
        taskCompletionSource.setException(task.getException());
        return null;
    }

    public Task c(d dVar) {
        n9.x.c(dVar, "AggregateSource must not be null");
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        ((Task) this.f7854a.f6193b.s(new n9.t() { // from class: d9.a
            @Override // n9.t
            public final Object apply(Object obj) {
                c cVar = this.f7842a;
                return ((g9.q0) obj).M(cVar.f7854a.f6192a, cVar.f7855b);
            }
        })).continueWith(n9.p.f16963b, new Continuation() { // from class: d9.b
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return c.a(this.f7847a, taskCompletionSource, task);
            }
        });
        return taskCompletionSource.getTask();
    }

    public com.google.firebase.firestore.i d() {
        return this.f7854a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f7854a.equals(cVar.f7854a) && this.f7855b.equals(cVar.f7855b);
    }

    public int hashCode() {
        return Objects.hash(this.f7854a, this.f7855b);
    }
}
