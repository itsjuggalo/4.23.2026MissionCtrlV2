package Z1;

import com.google.android.gms.common.api.internal.InterfaceC0399b;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class f implements InterfaceC0399b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReference f3957a = new AtomicReference();

    @Override // com.google.android.gms.common.api.internal.InterfaceC0399b
    public final void a(boolean z6) {
        synchronized (h.f3960k) {
            try {
                for (h hVar : new ArrayList(h.f3961l.values())) {
                    if (hVar.e.get()) {
                        hVar.l(z6);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
