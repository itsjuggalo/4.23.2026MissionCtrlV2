package kotlin.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class T {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f20473a;

    public T(int i8) {
        this.f20473a = new ArrayList(i8);
    }

    public void a(Object obj) {
        this.f20473a.add(obj);
    }

    public void b(Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length > 0) {
                ArrayList arrayList = this.f20473a;
                arrayList.ensureCapacity(arrayList.size() + objArr.length);
                Collections.addAll(this.f20473a, objArr);
                return;
            }
            return;
        }
        if (obj instanceof Collection) {
            this.f20473a.addAll((Collection) obj);
            return;
        }
        if (obj instanceof Iterable) {
            Iterator it = ((Iterable) obj).iterator();
            while (it.hasNext()) {
                this.f20473a.add(it.next());
            }
            return;
        }
        if (obj instanceof Iterator) {
            Iterator it2 = (Iterator) obj;
            while (it2.hasNext()) {
                this.f20473a.add(it2.next());
            }
        } else {
            throw new UnsupportedOperationException("Don't know how to spread " + obj.getClass());
        }
    }

    public int c() {
        return this.f20473a.size();
    }

    public Object[] d(Object[] objArr) {
        return this.f20473a.toArray(objArr);
    }
}
