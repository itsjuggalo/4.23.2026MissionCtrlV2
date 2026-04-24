package G4;

import F4.AbstractC0497k;
import F4.C0489c;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: G4.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public interface InterfaceC0553t extends F4.I {

    /* JADX INFO: renamed from: G4.t$a */
    public interface a {
        void a(long j8);

        void onFailure(Throwable th);
    }

    void d(a aVar, Executor executor);

    r e(F4.Y y7, F4.X x8, C0489c c0489c, AbstractC0497k[] abstractC0497kArr);
}
