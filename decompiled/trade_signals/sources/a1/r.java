package a1;

import a1.n;
import com.bumptech.glide.h;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import q1.AbstractC2628k;

/* JADX INFO: loaded from: classes.dex */
public class r {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f9881e = new c();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final n f9882f = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f9883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f9884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f9885c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final S.d f9886d;

    public static class a implements n {
        @Override // a1.n
        public n.a a(Object obj, int i8, int i9, U0.h hVar) {
            return null;
        }

        @Override // a1.n
        public boolean b(Object obj) {
            return false;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class f9887a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class f9888b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final o f9889c;

        public b(Class cls, Class cls2, o oVar) {
            this.f9887a = cls;
            this.f9888b = cls2;
            this.f9889c = oVar;
        }

        public boolean a(Class cls) {
            return this.f9887a.isAssignableFrom(cls);
        }

        public boolean b(Class cls, Class cls2) {
            return a(cls) && this.f9888b.isAssignableFrom(cls2);
        }
    }

    public static class c {
        public q a(List list, S.d dVar) {
            return new q(list, dVar);
        }
    }

    public r(S.d dVar) {
        this(dVar, f9881e);
    }

    public static n f() {
        return f9882f;
    }

    public final void a(Class cls, Class cls2, o oVar, boolean z7) {
        b bVar = new b(cls, cls2, oVar);
        List list = this.f9883a;
        list.add(z7 ? list.size() : 0, bVar);
    }

    public synchronized void b(Class cls, Class cls2, o oVar) {
        a(cls, cls2, oVar, true);
    }

    public final n c(b bVar) {
        return (n) AbstractC2628k.d(bVar.f9889c.d(this));
    }

    public synchronized n d(Class cls, Class cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z7 = false;
            for (b bVar : this.f9883a) {
                if (this.f9885c.contains(bVar)) {
                    z7 = true;
                } else if (bVar.b(cls, cls2)) {
                    this.f9885c.add(bVar);
                    arrayList.add(c(bVar));
                    this.f9885c.remove(bVar);
                }
            }
            if (arrayList.size() > 1) {
                return this.f9884b.a(arrayList, this.f9886d);
            }
            if (arrayList.size() == 1) {
                return (n) arrayList.get(0);
            }
            if (!z7) {
                throw new h.c(cls, cls2);
            }
            return f();
        } catch (Throwable th) {
            this.f9885c.clear();
            throw th;
        }
    }

    public synchronized List e(Class cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (b bVar : this.f9883a) {
                if (!this.f9885c.contains(bVar) && bVar.a(cls)) {
                    this.f9885c.add(bVar);
                    arrayList.add(c(bVar));
                    this.f9885c.remove(bVar);
                }
            }
        } finally {
        }
        return arrayList;
    }

    public synchronized List g(Class cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (b bVar : this.f9883a) {
            if (!arrayList.contains(bVar.f9888b) && bVar.a(cls)) {
                arrayList.add(bVar.f9888b);
            }
        }
        return arrayList;
    }

    public r(S.d dVar, c cVar) {
        this.f9883a = new ArrayList();
        this.f9885c = new HashSet();
        this.f9886d = dVar;
        this.f9884b = cVar;
    }
}
