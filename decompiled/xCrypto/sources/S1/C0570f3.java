package S1;

import com.google.android.gms.common.internal.AbstractC0940s;
import java.lang.Thread;
import java.util.Objects;

/* JADX INFO: renamed from: S1.f3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0570f3 implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0594i3 f4618b;

    public C0570f3(C0594i3 c0594i3, String str) {
        Objects.requireNonNull(c0594i3);
        this.f4618b = c0594i3;
        AbstractC0940s.k(str);
        this.f4617a = str;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.f4618b.f4245a.a().o().b(this.f4617a, th);
    }
}
