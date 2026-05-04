package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.j0;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements j0 {
    protected int memoizedHashCode = 0;

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class AbstractC0020a implements j0.a {
        public static void f(Iterable iterable, List list) {
            u.a(iterable);
            g(iterable, list);
        }

        public static void g(Iterable iterable, List list) {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
            }
            int size = list.size();
            for (Object obj : iterable) {
                if (obj == null) {
                    String str = "Element at index " + (list.size() - size) + " is null.";
                    for (int size2 = list.size() - 1; size2 >= size; size2--) {
                        list.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                list.add(obj);
            }
        }

        public static d1 h(j0 j0Var) {
            return new d1(j0Var);
        }
    }

    public static void f(Iterable iterable, List list) {
        AbstractC0020a.f(iterable, list);
    }

    public abstract int g(x0 x0Var);

    public d1 h() {
        return new d1(this);
    }

    public void i(OutputStream outputStream) {
        i iVarY = i.Y(outputStream, i.C(b()));
        d(iVarY);
        iVarY.V();
    }
}
