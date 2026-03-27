package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.J;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0788a implements J {
    protected int memoizedHashCode = 0;

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0100a implements J.a {
        public static void b(Iterable iterable, List list) {
            AbstractC0807u.a(iterable);
            c(iterable, list);
        }

        public static void c(Iterable iterable, List list) {
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

        public static e0 d(J j4) {
            return new e0(j4);
        }
    }

    public static void b(Iterable iterable, List list) {
        AbstractC0100a.b(iterable, list);
    }

    public abstract int c(Y y4);

    public e0 d() {
        return new e0(this);
    }

    public void e(OutputStream outputStream) {
        AbstractC0796i abstractC0796iY = AbstractC0796i.Y(outputStream, AbstractC0796i.C(getSerializedSize()));
        a(abstractC0796iY);
        abstractC0796iY.V();
    }
}
