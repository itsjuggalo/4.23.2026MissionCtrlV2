package t3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: renamed from: t3.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1181c extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s f10236b;

    public /* synthetic */ C1181c(s sVar, int i) {
        this.f10235a = i;
        this.f10236b = sVar;
    }

    @Override // t3.s
    public final Object b(B3.a aVar) throws IOException {
        switch (this.f10235a) {
            case 0:
                return new AtomicLong(((Number) this.f10236b.b(aVar)).longValue());
            default:
                ArrayList arrayList = new ArrayList();
                aVar.d();
                while (aVar.o()) {
                    arrayList.add(Long.valueOf(((Number) this.f10236b.b(aVar)).longValue()));
                }
                aVar.i();
                int size = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i = 0; i < size; i++) {
                    atomicLongArray.set(i, ((Long) arrayList.get(i)).longValue());
                }
                return atomicLongArray;
        }
    }

    @Override // t3.s
    public final void c(B3.b bVar, Object obj) throws IOException {
        switch (this.f10235a) {
            case 0:
                this.f10236b.c(bVar, Long.valueOf(((AtomicLong) obj).get()));
                break;
            default:
                AtomicLongArray atomicLongArray = (AtomicLongArray) obj;
                bVar.f();
                int length = atomicLongArray.length();
                for (int i = 0; i < length; i++) {
                    this.f10236b.c(bVar, Long.valueOf(atomicLongArray.get(i)));
                }
                bVar.i();
                break;
        }
    }
}
