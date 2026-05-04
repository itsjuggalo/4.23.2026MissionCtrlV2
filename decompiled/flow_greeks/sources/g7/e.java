package g7;

import android.util.Log;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import h7.o;
import h7.p;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class e implements e7.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f10096f = "g7.e";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f10097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f10098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f10099c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p f10100d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Task f10101e;

    public e(a7.g gVar, fa.b bVar, Executor executor, Executor executor2, Executor executor3) {
        s.k(gVar);
        this.f10097a = new o(gVar);
        this.f10098b = executor;
        this.f10099c = executor3;
        this.f10100d = new p();
        String debugSecret = bVar.get() != null ? ((f7.c) bVar.get()).getDebugSecret() : null;
        this.f10101e = debugSecret == null ? f(gVar, executor2) : Tasks.forResult(debugSecret);
    }

    public static /* synthetic */ Task b(final e eVar, String str) {
        eVar.getClass();
        final f fVar = new f(str);
        return Tasks.call(eVar.f10099c, new Callable() { // from class: g7.d
            @Override // java.util.concurrent.Callable
            public final Object call() {
                e eVar2 = this.f10094a;
                return eVar2.f10097a.b(fVar.a().getBytes("UTF-8"), 2, eVar2.f10100d);
            }
        });
    }

    public static /* synthetic */ void e(a7.g gVar, TaskCompletionSource taskCompletionSource) {
        g gVar2 = new g(gVar.m(), gVar.s());
        String strA = gVar2.a();
        if (strA == null) {
            strA = UUID.randomUUID().toString();
            gVar2.b(strA);
        }
        Log.d(f10096f, "Enter this debug secret into the allow list in the Firebase Console for your project: " + strA);
        taskCompletionSource.setResult(strA);
    }

    public static Task f(final a7.g gVar, Executor executor) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        executor.execute(new Runnable() { // from class: g7.c
            @Override // java.lang.Runnable
            public final void run() {
                e.e(gVar, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    @Override // e7.a
    public Task a() {
        return this.f10101e.onSuccessTask(this.f10098b, new SuccessContinuation() { // from class: g7.a
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return e.b(this.f10091a, (String) obj);
            }
        }).onSuccessTask(this.f10098b, new SuccessContinuation() { // from class: g7.b
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return Tasks.forResult(h7.b.c((h7.a) obj));
            }
        });
    }
}
