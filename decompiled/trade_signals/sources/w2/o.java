package w2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import v2.AbstractC2844j;
import v2.AbstractC2848n;
import z2.AbstractC3003a;

/* JADX INFO: loaded from: classes.dex */
public abstract class o {
    public static int a(int i8) {
        AbstractC2915d.b(i8, "arraySize");
        return AbstractC3003a.a(((long) i8) + 5 + ((long) (i8 / 10)));
    }

    public static boolean b(List list, Object obj) {
        if (obj == AbstractC2848n.n(list)) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list2 = (List) obj;
        int size = list.size();
        if (size != list2.size()) {
            return false;
        }
        if (!(list instanceof RandomAccess) || !(list2 instanceof RandomAccess)) {
            return n.a(list.iterator(), list2.iterator());
        }
        for (int i8 = 0; i8 < size; i8++) {
            if (!AbstractC2844j.a(list.get(i8), list2.get(i8))) {
                return false;
            }
        }
        return true;
    }

    public static int c(List list, Object obj) {
        if (list instanceof RandomAccess) {
            return d(list, obj);
        }
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (AbstractC2844j.a(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    public static int d(List list, Object obj) {
        int size = list.size();
        int i8 = 0;
        if (obj == null) {
            while (i8 < size) {
                if (list.get(i8) == null) {
                    return i8;
                }
                i8++;
            }
            return -1;
        }
        while (i8 < size) {
            if (obj.equals(list.get(i8))) {
                return i8;
            }
            i8++;
        }
        return -1;
    }

    public static int e(List list, Object obj) {
        if (list instanceof RandomAccess) {
            return f(list, obj);
        }
        ListIterator listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (AbstractC2844j.a(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    public static int f(List list, Object obj) {
        if (obj == null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (list.get(size) == null) {
                    return size;
                }
            }
            return -1;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            if (obj.equals(list.get(size2))) {
                return size2;
            }
        }
        return -1;
    }

    public static ArrayList g(Object... objArr) {
        AbstractC2848n.n(objArr);
        ArrayList arrayList = new ArrayList(a(objArr.length));
        Collections.addAll(arrayList, objArr);
        return arrayList;
    }
}
