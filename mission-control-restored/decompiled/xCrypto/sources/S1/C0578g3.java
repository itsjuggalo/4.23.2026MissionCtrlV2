package S1;

import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: renamed from: S1.g3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0578g3 extends FutureTask implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f4633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f4634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f4635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ C0594i3 f4636d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0578g3(C0594i3 c0594i3, Runnable runnable, boolean z4, String str) {
        super(runnable, null);
        Objects.requireNonNull(c0594i3);
        this.f4636d = c0594i3;
        AbstractC0940s.k(str);
        long andIncrement = C0594i3.f4681k.getAndIncrement();
        this.f4633a = andIncrement;
        this.f4635c = str;
        this.f4634b = z4;
        if (andIncrement == Long.MAX_VALUE) {
            c0594i3.f4245a.a().o().a("Tasks index overflow");
        }
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        C0578g3 c0578g3 = (C0578g3) obj;
        boolean z4 = c0578g3.f4634b;
        boolean z5 = this.f4634b;
        if (z5 != z4) {
            return !z5 ? 1 : -1;
        }
        long j4 = this.f4633a;
        long j5 = c0578g3.f4633a;
        if (j4 < j5) {
            return -1;
        }
        if (j4 > j5) {
            return 1;
        }
        this.f4636d.f4245a.a().p().b("Two tasks share the same index. index", Long.valueOf(j4));
        return 0;
    }

    @Override // java.util.concurrent.FutureTask
    public final void setException(Throwable th) {
        this.f4636d.f4245a.a().o().b(this.f4635c, th);
        super.setException(th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0578g3(C0594i3 c0594i3, Callable callable, boolean z4, String str) {
        super(callable);
        Objects.requireNonNull(c0594i3);
        this.f4636d = c0594i3;
        AbstractC0940s.k("Task exception on worker thread");
        long andIncrement = C0594i3.f4681k.getAndIncrement();
        this.f4633a = andIncrement;
        this.f4635c = "Task exception on worker thread";
        this.f4634b = z4;
        if (andIncrement == Long.MAX_VALUE) {
            c0594i3.f4245a.a().o().a("Tasks index overflow");
        }
    }
}
