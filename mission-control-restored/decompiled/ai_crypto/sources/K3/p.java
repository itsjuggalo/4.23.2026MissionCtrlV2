package K3;

import android.os.AsyncTask;
import com.google.android.gms.tasks.TaskExecutors;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Executor f3450a = TaskExecutors.MAIN_THREAD;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Executor f3451b = new B0.k();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Executor f3452c = new C(4, AsyncTask.THREAD_POOL_EXECUTOR);
}
