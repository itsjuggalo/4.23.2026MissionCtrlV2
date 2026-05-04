package x3;

import g3.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f24186a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f24187b = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class f24188a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class f24189b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final j f24190c;

        public a(Class cls, Class cls2, j jVar) {
            this.f24188a = cls;
            this.f24189b = cls2;
            this.f24190c = jVar;
        }

        public boolean a(Class cls, Class cls2) {
            return this.f24188a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f24189b);
        }
    }

    public synchronized void a(String str, j jVar, Class cls, Class cls2) {
        c(str).add(new a(cls, cls2, jVar));
    }

    public synchronized List b(Class cls, Class cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator it = this.f24186a.iterator();
        while (it.hasNext()) {
            List<a> list = (List) this.f24187b.get((String) it.next());
            if (list != null) {
                for (a aVar : list) {
                    if (aVar.a(cls, cls2)) {
                        arrayList.add(aVar.f24190c);
                    }
                }
            }
        }
        return arrayList;
    }

    public final synchronized List c(String str) {
        List arrayList;
        try {
            if (!this.f24186a.contains(str)) {
                this.f24186a.add(str);
            }
            arrayList = (List) this.f24187b.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.f24187b.put(str, arrayList);
            }
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    public synchronized List d(Class cls, Class cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator it = this.f24186a.iterator();
        while (it.hasNext()) {
            List<a> list = (List) this.f24187b.get((String) it.next());
            if (list != null) {
                for (a aVar : list) {
                    if (aVar.a(cls, cls2) && !arrayList.contains(aVar.f24189b)) {
                        arrayList.add(aVar.f24189b);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized void e(List list) {
        try {
            ArrayList<String> arrayList = new ArrayList(this.f24186a);
            this.f24186a.clear();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.f24186a.add((String) it.next());
            }
            for (String str : arrayList) {
                if (!list.contains(str)) {
                    this.f24186a.add(str);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
