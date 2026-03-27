package f0;

import N1.CallableC0112m0;
import android.util.Log;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes.dex */
public final class b extends FutureTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RunnableC0584a f6397a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(RunnableC0584a runnableC0584a, CallableC0112m0 callableC0112m0) {
        super(callableC0112m0);
        this.f6397a = runnableC0584a;
    }

    @Override // java.util.concurrent.FutureTask
    public final void done() {
        RunnableC0584a runnableC0584a = this.f6397a;
        try {
            Object obj = get();
            if (runnableC0584a.f6396d.get()) {
                return;
            }
            runnableC0584a.a(obj);
        } catch (InterruptedException e) {
            Log.w("AsyncTask", e);
        } catch (CancellationException unused) {
            if (runnableC0584a.f6396d.get()) {
                return;
            }
            runnableC0584a.a(null);
        } catch (ExecutionException e2) {
            throw new RuntimeException("An error occurred while executing doInBackground()", e2.getCause());
        } catch (Throwable th) {
            throw new RuntimeException("An error occurred while executing doInBackground()", th);
        }
    }
}
