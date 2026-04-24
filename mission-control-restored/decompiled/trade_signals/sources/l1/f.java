package l1;

import U0.k;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f20533a = new ArrayList();

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class f20534a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final k f20535b;

        public a(Class cls, k kVar) {
            this.f20534a = cls;
            this.f20535b = kVar;
        }

        public boolean a(Class cls) {
            return this.f20534a.isAssignableFrom(cls);
        }
    }

    public synchronized void a(Class cls, k kVar) {
        this.f20533a.add(new a(cls, kVar));
    }

    public synchronized k b(Class cls) {
        int size = this.f20533a.size();
        for (int i8 = 0; i8 < size; i8++) {
            a aVar = (a) this.f20533a.get(i8);
            if (aVar.a(cls)) {
                return aVar.f20535b;
            }
        }
        return null;
    }
}
