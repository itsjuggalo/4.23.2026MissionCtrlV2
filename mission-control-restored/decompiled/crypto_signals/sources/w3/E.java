package w3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* JADX INFO: loaded from: classes.dex */
public class E extends t3.s {
    @Override // t3.s
    public final Object b(B3.a aVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        aVar.d();
        while (aVar.o()) {
            try {
                arrayList.add(Integer.valueOf(aVar.t()));
            } catch (NumberFormatException e) {
                throw new t3.i(e);
            }
        }
        aVar.i();
        int size = arrayList.size();
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
        for (int i = 0; i < size; i++) {
            atomicIntegerArray.set(i, ((Integer) arrayList.get(i)).intValue());
        }
        return atomicIntegerArray;
    }

    @Override // t3.s
    public final void c(B3.b bVar, Object obj) throws IOException {
        bVar.f();
        int length = ((AtomicIntegerArray) obj).length();
        for (int i = 0; i < length; i++) {
            bVar.s(r6.get(i));
        }
        bVar.i();
    }
}
