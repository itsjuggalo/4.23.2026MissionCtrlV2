package U2;

import android.os.AsyncTask;
import com.google.android.gms.tasks.TaskExecutors;
import java.util.concurrent.Executor;
import m0.ExecutorC0856c;

/* JADX INFO: loaded from: classes.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Executor f3157a = TaskExecutors.MAIN_THREAD;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ExecutorC0856c f3158b = new ExecutorC0856c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final q f3159c;

    static {
        Executor executor = AsyncTask.THREAD_POOL_EXECUTOR;
        f3159c = new q();
    }
}
