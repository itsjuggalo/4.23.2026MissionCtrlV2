package d7;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: d7.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1642c {
    public static final Object a(AtomicReference atomicReference) {
        return atomicReference.get();
    }

    public static final void b(AtomicReference atomicReference, Object obj) {
        atomicReference.set(obj);
    }
}
