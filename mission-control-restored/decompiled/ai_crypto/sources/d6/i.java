package d6;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class i {
    public static /* synthetic */ boolean a(AtomicReferenceArray atomicReferenceArray, int i7, Object obj, Object obj2) {
        while (!atomicReferenceArray.compareAndSet(i7, obj, obj2)) {
            if (atomicReferenceArray.get(i7) != obj) {
                return false;
            }
        }
        return true;
    }
}
