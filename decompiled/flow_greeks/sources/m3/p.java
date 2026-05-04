package m3;

import com.bumptech.glide.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f15806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f15807b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map f15808a = new HashMap();

        /* JADX INFO: renamed from: m3.p$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class C0287a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final List f15809a;

            public C0287a(List list) {
                this.f15809a = list;
            }
        }

        public void a() {
            this.f15808a.clear();
        }

        public List b(Class cls) {
            C0287a c0287a = (C0287a) this.f15808a.get(cls);
            if (c0287a == null) {
                return null;
            }
            return c0287a.f15809a;
        }

        public void c(Class cls, List list) {
            if (((C0287a) this.f15808a.put(cls, new C0287a(list))) == null) {
                return;
            }
            throw new IllegalStateException("Already cached loaders for model: " + cls);
        }
    }

    public p(s0.c cVar) {
        this(new r(cVar));
    }

    public static Class b(Object obj) {
        return obj.getClass();
    }

    public synchronized void a(Class cls, Class cls2, o oVar) {
        this.f15806a.b(cls, cls2, oVar);
        this.f15807b.a();
    }

    public synchronized List c(Class cls) {
        return this.f15806a.g(cls);
    }

    public List d(Object obj) {
        List listE = e(b(obj));
        if (listE.isEmpty()) {
            throw new h.c(obj);
        }
        int size = listE.size();
        List arrayList = Collections.EMPTY_LIST;
        boolean z10 = true;
        for (int i10 = 0; i10 < size; i10++) {
            n nVar = (n) listE.get(i10);
            if (nVar.a(obj)) {
                if (z10) {
                    arrayList = new ArrayList(size - i10);
                    z10 = false;
                }
                arrayList.add(nVar);
            }
        }
        if (arrayList.isEmpty()) {
            throw new h.c(obj, listE);
        }
        return arrayList;
    }

    public final synchronized List e(Class cls) {
        List listB;
        listB = this.f15807b.b(cls);
        if (listB == null) {
            listB = Collections.unmodifiableList(this.f15806a.c(cls));
            this.f15807b.c(cls, listB);
        }
        return listB;
    }

    public p(r rVar) {
        this.f15807b = new a();
        this.f15806a = rVar;
    }
}
