package okhttp3.internal.publicsuffix;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class PublicSuffixDatabase {
    static {
        new PublicSuffixDatabase();
    }

    public PublicSuffixDatabase() {
        new AtomicBoolean(false);
        new CountDownLatch(1);
    }
}
