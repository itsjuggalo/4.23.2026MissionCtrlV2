package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.profileinstaller.ProfileInstallerInitializer;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class ProfileInstallerInitializer implements p0.b {

    public static class a {
        public static void b(final Runnable runnable) {
            Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: m0.i
                @Override // android.view.Choreographer.FrameCallback
                public final void doFrame(long j4) {
                    runnable.run();
                }
            });
        }
    }

    public static class b {
        public static Handler a(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    public static class c {
    }

    public static void h(final Context context) {
        new ThreadPoolExecutor(0, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new Runnable() { // from class: m0.h
            @Override // java.lang.Runnable
            public final void run() {
                androidx.profileinstaller.c.h(context);
            }
        });
    }

    @Override // p0.b
    public List dependencies() {
        return Collections.EMPTY_LIST;
    }

    @Override // p0.b
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public c a(Context context) {
        f(context.getApplicationContext());
        return new c();
    }

    public void f(final Context context) {
        a.b(new Runnable() { // from class: m0.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f13507a.g(context);
            }
        });
    }

    public void g(final Context context) {
        (Build.VERSION.SDK_INT >= 28 ? b.a(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new Runnable() { // from class: m0.g
            @Override // java.lang.Runnable
            public final void run() {
                ProfileInstallerInitializer.h(context);
            }
        }, new Random().nextInt(Math.max(1000, 1)) + 5000);
    }
}
