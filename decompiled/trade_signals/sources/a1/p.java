package a1;

import com.bumptech.glide.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f9868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f9869b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map f9870a = new HashMap();

        /* JADX INFO: renamed from: a1.p$a$a, reason: collision with other inner class name */
        public static class C0167a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final List f9871a;

            public C0167a(List list) {
                this.f9871a = list;
            }
        }

        public void a() {
            this.f9870a.clear();
        }

        public List b(Class cls) {
            C0167a c0167a = (C0167a) this.f9870a.get(cls);
            if (c0167a == null) {
                return null;
            }
            return c0167a.f9871a;
        }

        public void c(Class cls, List list) {
            if (((C0167a) this.f9870a.put(cls, new C0167a(list))) == null) {
                return;
            }
            throw new IllegalStateException("Already cached loaders for model: " + cls);
        }
    }

    public p(S.d dVar) {
        this(new r(dVar));
    }

    public static Class b(Object obj) {
        return obj.getClass();
    }

    public synchronized void a(Class cls, Class cls2, o oVar) {
        this.f9868a.b(cls, cls2, oVar);
        this.f9869b.a();
    }

    public synchronized List c(Class cls) {
        return this.f9868a.g(cls);
    }

    public List d(Object obj) {
        List listE = e(b(obj));
        if (listE.isEmpty()) {
            throw new h.c(obj);
        }
        int size = listE.size();
        List listEmptyList = Collections.emptyList();
        boolean z7 = true;
        for (int i8 = 0; i8 < size; i8++) {
            n nVar = (n) listE.get(i8);
            if (nVar.b(obj)) {
                if (z7) {
                    listEmptyList = new ArrayList(size - i8);
                    z7 = false;
                }
                listEmptyList.add(nVar);
            }
        }
        if (listEmptyList.isEmpty()) {
            throw new h.c(obj, listE);
        }
        return listEmptyList;
    }

    public final synchronized List e(Class cls) {
        List listB;
        listB = this.f9869b.b(cls);
        if (listB == null) {
            listB = Collections.unmodifiableList(this.f9868a.e(cls));
            this.f9869b.c(cls, listB);
        }
        return listB;
    }

    public p(r rVar) {
        this.f9869b = new a();
        this.f9868a = rVar;
    }
}
