package d7;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes2.dex */
public final class y {
    private volatile AtomicReferenceArray<Object> array;

    public y(int i8) {
        this.array = new AtomicReferenceArray<>(i8);
    }

    public final int a() {
        return this.array.length();
    }

    public final Object b(int i8) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.array;
        if (i8 < atomicReferenceArray.length()) {
            return atomicReferenceArray.get(i8);
        }
        return null;
    }

    public final void c(int i8, Object obj) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.array;
        int length = atomicReferenceArray.length();
        if (i8 < length) {
            atomicReferenceArray.set(i8, obj);
            return;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(H5.i.b(i8 + 1, length * 2));
        for (int i9 = 0; i9 < length; i9++) {
            atomicReferenceArray2.set(i9, atomicReferenceArray.get(i9));
        }
        atomicReferenceArray2.set(i8, obj);
        this.array = atomicReferenceArray2;
    }
}
