package i1;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f18757a = new ArrayList();

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class f18758a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class f18759b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final e f18760c;

        public a(Class cls, Class cls2, e eVar) {
            this.f18758a = cls;
            this.f18759b = cls2;
            this.f18760c = eVar;
        }

        public boolean a(Class cls, Class cls2) {
            return this.f18758a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f18759b);
        }
    }

    public synchronized e a(Class cls, Class cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return g.b();
        }
        for (a aVar : this.f18757a) {
            if (aVar.a(cls, cls2)) {
                return aVar.f18760c;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    public synchronized List b(Class cls, Class cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        for (a aVar : this.f18757a) {
            if (aVar.a(cls, cls2) && !arrayList.contains(aVar.f18759b)) {
                arrayList.add(aVar.f18759b);
            }
        }
        return arrayList;
    }

    public synchronized void c(Class cls, Class cls2, e eVar) {
        this.f18757a.add(new a(cls, cls2, eVar));
    }
}
