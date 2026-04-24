package M2;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public interface R0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final R0 f1954a = new a();

    public class a implements R0 {
        @Override // M2.R0
        public long a() {
            return TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
        }
    }

    long a();
}
