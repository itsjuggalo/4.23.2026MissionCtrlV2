package l1;

import U0.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f20528a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f20529b = new HashMap();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class f20530a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class f20531b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final j f20532c;

        public a(Class cls, Class cls2, j jVar) {
            this.f20530a = cls;
            this.f20531b = cls2;
            this.f20532c = jVar;
        }

        public boolean a(Class cls, Class cls2) {
            return this.f20530a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f20531b);
        }
    }

    public synchronized void a(String str, j jVar, Class cls, Class cls2) {
        c(str).add(new a(cls, cls2, jVar));
    }

    public synchronized List b(Class cls, Class cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator it = this.f20528a.iterator();
        while (it.hasNext()) {
            List<a> list = (List) this.f20529b.get((String) it.next());
            if (list != null) {
                for (a aVar : list) {
                    if (aVar.a(cls, cls2)) {
                        arrayList.add(aVar.f20532c);
                    }
                }
            }
        }
        return arrayList;
    }

    public final synchronized List c(String str) {
        List arrayList;
        try {
            if (!this.f20528a.contains(str)) {
                this.f20528a.add(str);
            }
            arrayList = (List) this.f20529b.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.f20529b.put(str, arrayList);
            }
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    public synchronized List d(Class cls, Class cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator it = this.f20528a.iterator();
        while (it.hasNext()) {
            List<a> list = (List) this.f20529b.get((String) it.next());
            if (list != null) {
                for (a aVar : list) {
                    if (aVar.a(cls, cls2) && !arrayList.contains(aVar.f20531b)) {
                        arrayList.add(aVar.f20531b);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized void e(List list) {
        try {
            ArrayList<String> arrayList = new ArrayList(this.f20528a);
            this.f20528a.clear();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.f20528a.add((String) it.next());
            }
            for (String str : arrayList) {
                if (!list.contains(str)) {
                    this.f20528a.add(str);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
