package kotlin.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f14951a;

    public r0(int i10) {
        this.f14951a = new ArrayList(i10);
    }

    public void a(Object obj) {
        this.f14951a.add(obj);
    }

    public void b(Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length > 0) {
                ArrayList arrayList = this.f14951a;
                arrayList.ensureCapacity(arrayList.size() + objArr.length);
                Collections.addAll(this.f14951a, objArr);
                return;
            }
            return;
        }
        if (obj instanceof Collection) {
            this.f14951a.addAll((Collection) obj);
            return;
        }
        if (obj instanceof Iterable) {
            Iterator it = ((Iterable) obj).iterator();
            while (it.hasNext()) {
                this.f14951a.add(it.next());
            }
            return;
        }
        if (obj instanceof Iterator) {
            Iterator it2 = (Iterator) obj;
            while (it2.hasNext()) {
                this.f14951a.add(it2.next());
            }
        } else {
            throw new UnsupportedOperationException("Don't know how to spread " + obj.getClass());
        }
    }

    public int c() {
        return this.f14951a.size();
    }

    public Object[] d(Object[] objArr) {
        return this.f14951a.toArray(objArr);
    }
}
