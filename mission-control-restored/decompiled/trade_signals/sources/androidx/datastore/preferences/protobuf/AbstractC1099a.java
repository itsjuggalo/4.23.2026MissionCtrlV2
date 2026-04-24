package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.J;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1099a implements J {
    protected int memoizedHashCode = 0;

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0179a implements J.a {
        public static void g(Iterable iterable, List list) {
            AbstractC1118u.a(iterable);
            h(iterable, list);
        }

        public static void h(Iterable iterable, List list) {
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

        public static e0 i(J j8) {
            return new e0(j8);
        }
    }

    public static void a(Iterable iterable, List list) {
        AbstractC0179a.g(iterable, list);
    }

    public abstract int g(Y y7);

    public e0 h() {
        return new e0(this);
    }

    public void i(OutputStream outputStream) {
        AbstractC1107i abstractC1107iY = AbstractC1107i.Y(outputStream, AbstractC1107i.C(c()));
        e(abstractC1107iY);
        abstractC1107iY.V();
    }
}
