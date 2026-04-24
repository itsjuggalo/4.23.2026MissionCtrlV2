package F4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

/* JADX INFO: loaded from: classes.dex */
public abstract class i0 {

    public class a implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f1792a;

        public a(b bVar) {
            this.f1792a = bVar;
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            int iB = this.f1792a.b(obj) - this.f1792a.b(obj2);
            return iB != 0 ? iB : obj.getClass().getName().compareTo(obj2.getClass().getName());
        }
    }

    public interface b {
        boolean a(Object obj);

        int b(Object obj);
    }

    public static Object a(Class cls, Class cls2) {
        try {
            return cls2.asSubclass(cls).getConstructor(null).newInstance(null);
        } catch (ClassCastException unused) {
            return null;
        } catch (Throwable th) {
            throw new ServiceConfigurationError(String.format("Provider %s could not be instantiated %s", cls2.getName(), th), th);
        }
    }

    public static Iterable b(Class cls, Iterable iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Object objA = a(cls, (Class) it.next());
            if (objA != null) {
                arrayList.add(objA);
            }
        }
        return arrayList;
    }

    public static Iterable c(Class cls, ClassLoader classLoader) {
        ServiceLoader serviceLoaderLoad = ServiceLoader.load(cls, classLoader);
        return !serviceLoaderLoad.iterator().hasNext() ? ServiceLoader.load(cls) : serviceLoaderLoad;
    }

    public static boolean d(ClassLoader classLoader) {
        try {
            Class.forName("android.app.Application", false, classLoader);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static List e(Class cls, Iterable iterable, ClassLoader classLoader, b bVar) {
        Iterable iterableB = d(classLoader) ? b(cls, iterable) : c(cls, classLoader);
        ArrayList arrayList = new ArrayList();
        for (Object obj : iterableB) {
            if (bVar.a(obj)) {
                arrayList.add(obj);
            }
        }
        Collections.sort(arrayList, Collections.reverseOrder(new a(bVar)));
        return Collections.unmodifiableList(arrayList);
    }
}
