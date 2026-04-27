package h3;

import java.lang.Thread;

/* JADX INFO: loaded from: classes.dex */
public interface z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f18668a = new a();

    public class a implements z {
        @Override // h3.z
        public void a(Thread thread, String str) {
            thread.setName(str);
        }

        @Override // h3.z
        public void b(Thread thread, boolean z7) {
            thread.setDaemon(z7);
        }

        @Override // h3.z
        public void c(Thread thread, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            thread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
        }
    }

    void a(Thread thread, String str);

    void b(Thread thread, boolean z7);

    void c(Thread thread, Thread.UncaughtExceptionHandler uncaughtExceptionHandler);
}
