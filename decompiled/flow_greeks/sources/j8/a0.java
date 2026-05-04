package j8;

import java.lang.Thread;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public interface a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a0 f13948a = new a();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements a0 {
        @Override // j8.a0
        public void a(Thread thread, String str) {
            thread.setName(str);
        }

        @Override // j8.a0
        public void b(Thread thread, boolean z10) {
            thread.setDaemon(z10);
        }

        @Override // j8.a0
        public void c(Thread thread, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            thread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
        }
    }

    void a(Thread thread, String str);

    void b(Thread thread, boolean z10);

    void c(Thread thread, Thread.UncaughtExceptionHandler uncaughtExceptionHandler);
}
