package e3;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.FirebaseMessaging;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import q.C0910b;

/* JADX INFO: renamed from: e3.C, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0533C {
    public static final long i = TimeUnit.HOURS.toSeconds(8);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f6086j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0556p f6088b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final T2.I f6089c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FirebaseMessaging f6090d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ScheduledThreadPoolExecutor f6091f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final C0531A f6093h;
    public final C0910b e = new C0910b();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f6092g = false;

    public C0533C(FirebaseMessaging firebaseMessaging, C0556p c0556p, C0531A c0531a, T2.I i6, Context context, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        this.f6090d = firebaseMessaging;
        this.f6088b = c0556p;
        this.f6093h = c0531a;
        this.f6089c = i6;
        this.f6087a = context;
        this.f6091f = scheduledThreadPoolExecutor;
    }

    public static void a(Task task) throws IOException {
        try {
            Tasks.await(task, 30L, TimeUnit.SECONDS);
        } catch (InterruptedException | TimeoutException e) {
            throw new IOException("SERVICE_NOT_AVAILABLE", e);
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            }
            if (!(cause instanceof RuntimeException)) {
                throw new IOException(e2);
            }
            throw ((RuntimeException) cause);
        }
    }

    public final void b(String str) throws IOException {
        String strA = this.f6090d.a();
        T2.I i6 = this.f6089c;
        i6.getClass();
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", "/topics/" + str);
        a(i6.d(i6.m(strA, "/topics/" + str, bundle)));
    }

    public final void c(String str) throws IOException {
        String strA = this.f6090d.a();
        T2.I i6 = this.f6089c;
        i6.getClass();
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", "/topics/" + str);
        bundle.putString("delete", "1");
        a(i6.d(i6.m(strA, "/topics/" + str, bundle)));
    }

    public final Task d(z zVar) {
        ArrayDeque arrayDeque;
        C0531A c0531a = this.f6093h;
        synchronized (c0531a) {
            A.f fVar = c0531a.f6080a;
            String str = zVar.f6205c;
            fVar.getClass();
            if (!TextUtils.isEmpty(str) && !str.contains((String) fVar.f13c)) {
                synchronized (((ArrayDeque) fVar.e)) {
                    if (((ArrayDeque) fVar.e).add(str)) {
                        ((ScheduledThreadPoolExecutor) fVar.f15f).execute(new E3.d(fVar, 17));
                    }
                }
            }
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        synchronized (this.e) {
            try {
                String str2 = zVar.f6205c;
                if (this.e.containsKey(str2)) {
                    arrayDeque = (ArrayDeque) this.e.getOrDefault(str2, null);
                } else {
                    ArrayDeque arrayDeque2 = new ArrayDeque();
                    this.e.put(str2, arrayDeque2);
                    arrayDeque = arrayDeque2;
                }
                arrayDeque.add(taskCompletionSource);
            } catch (Throwable th) {
                throw th;
            }
        }
        return taskCompletionSource.getTask();
    }

    public final synchronized void e(boolean z6) {
        this.f6092g = z6;
    }

    public final void f() {
        boolean z6;
        if (this.f6093h.a() != null) {
            synchronized (this) {
                z6 = this.f6092g;
            }
            if (z6) {
                return;
            }
            h(0L);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e3.C0533C.g():boolean");
    }

    public final void h(long j4) {
        long jMin = Math.min(Math.max(30L, 2 * j4), i);
        this.f6091f.schedule(new RunnableC0535E(this, this.f6087a, this.f6088b, jMin), j4, TimeUnit.SECONDS);
        e(true);
    }
}
