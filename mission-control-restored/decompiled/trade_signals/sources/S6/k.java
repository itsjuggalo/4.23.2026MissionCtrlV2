package S6;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
public class k extends AbstractList implements RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f7764b;

    public static class b implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f7765a = new b();

        public static b b() {
            return f7765a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new IllegalStateException();
        }
    }

    public class c extends d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f7766b;

        public c() {
            super();
            this.f7766b = ((AbstractList) k.this).modCount;
        }

        @Override // S6.k.d
        public void b() {
            if (((AbstractList) k.this).modCount == this.f7766b) {
                return;
            }
            throw new ConcurrentModificationException("ModCount: " + ((AbstractList) k.this).modCount + "; expected: " + this.f7766b);
        }

        @Override // S6.k.d
        public Object c() {
            return k.this.f7764b;
        }

        @Override // java.util.Iterator
        public void remove() {
            b();
            k.this.clear();
        }
    }

    public static abstract class d implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f7768a;

        public d() {
        }

        public abstract void b();

        public abstract Object c();

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return !this.f7768a;
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (this.f7768a) {
                throw new NoSuchElementException();
            }
            this.f7768a = true;
            b();
            return c();
        }
    }

    public static /* synthetic */ void a(int i8) {
        String str = (i8 == 2 || i8 == 3 || i8 == 5 || i8 == 6 || i8 == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i8 == 2 || i8 == 3 || i8 == 5 || i8 == 6 || i8 == 7) ? 2 : 3];
        switch (i8) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
                break;
            case 4:
                objArr[0] = "a";
                break;
            default:
                objArr[0] = "elements";
                break;
        }
        if (i8 == 2 || i8 == 3) {
            objArr[1] = "iterator";
        } else if (i8 == 5 || i8 == 6 || i8 == 7) {
            objArr[1] = "toArray";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
        }
        switch (i8) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                break;
            case 4:
                objArr[2] = "toArray";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i8 != 2 && i8 != 3 && i8 != 5 && i8 != 6 && i8 != 7) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i8, Object obj) {
        int i9;
        if (i8 < 0 || i8 > (i9 = this.f7763a)) {
            throw new IndexOutOfBoundsException("Index: " + i8 + ", Size: " + this.f7763a);
        }
        if (i9 == 0) {
            this.f7764b = obj;
        } else if (i9 == 1 && i8 == 0) {
            this.f7764b = new Object[]{obj, this.f7764b};
        } else {
            Object[] objArr = new Object[i9 + 1];
            if (i9 == 1) {
                objArr[0] = this.f7764b;
            } else {
                Object[] objArr2 = (Object[]) this.f7764b;
                System.arraycopy(objArr2, 0, objArr, 0, i8);
                System.arraycopy(objArr2, i8, objArr, i8 + 1, this.f7763a - i8);
            }
            objArr[i8] = obj;
            this.f7764b = objArr;
        }
        this.f7763a++;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f7764b = null;
        this.f7763a = 0;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i8) {
        int i9;
        if (i8 >= 0 && i8 < (i9 = this.f7763a)) {
            return i9 == 1 ? this.f7764b : ((Object[]) this.f7764b)[i8];
        }
        throw new IndexOutOfBoundsException("Index: " + i8 + ", Size: " + this.f7763a);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        int i8 = this.f7763a;
        if (i8 == 0) {
            b bVarB = b.b();
            if (bVarB == null) {
                a(2);
            }
            return bVarB;
        }
        if (i8 == 1) {
            return new c();
        }
        Iterator it = super.iterator();
        if (it == null) {
            a(3);
        }
        return it;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object remove(int i8) {
        int i9;
        Object obj;
        if (i8 < 0 || i8 >= (i9 = this.f7763a)) {
            throw new IndexOutOfBoundsException("Index: " + i8 + ", Size: " + this.f7763a);
        }
        if (i9 == 1) {
            obj = this.f7764b;
            this.f7764b = null;
        } else {
            Object[] objArr = (Object[]) this.f7764b;
            Object obj2 = objArr[i8];
            if (i9 == 2) {
                this.f7764b = objArr[1 - i8];
            } else {
                int i10 = (i9 - i8) - 1;
                if (i10 > 0) {
                    System.arraycopy(objArr, i8 + 1, objArr, i8, i10);
                }
                objArr[this.f7763a - 1] = null;
            }
            obj = obj2;
        }
        this.f7763a--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i8, Object obj) {
        int i9;
        if (i8 < 0 || i8 >= (i9 = this.f7763a)) {
            throw new IndexOutOfBoundsException("Index: " + i8 + ", Size: " + this.f7763a);
        }
        if (i9 == 1) {
            Object obj2 = this.f7764b;
            this.f7764b = obj;
            return obj2;
        }
        Object[] objArr = (Object[]) this.f7764b;
        Object obj3 = objArr[i8];
        objArr[i8] = obj;
        return obj3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f7763a;
    }

    @Override // java.util.List
    public void sort(Comparator comparator) {
        int i8 = this.f7763a;
        if (i8 >= 2) {
            Arrays.sort((Object[]) this.f7764b, 0, i8, comparator);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray(Object[] objArr) {
        if (objArr == null) {
            a(4);
        }
        int length = objArr.length;
        int i8 = this.f7763a;
        if (i8 == 1) {
            if (length == 0) {
                Object[] objArr2 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), 1);
                objArr2[0] = this.f7764b;
                return objArr2;
            }
            objArr[0] = this.f7764b;
        } else {
            if (length < i8) {
                Object[] objArrCopyOf = Arrays.copyOf((Object[]) this.f7764b, i8, objArr.getClass());
                if (objArrCopyOf == null) {
                    a(6);
                }
                return objArrCopyOf;
            }
            if (i8 != 0) {
                System.arraycopy(this.f7764b, 0, objArr, 0, i8);
            }
        }
        int i9 = this.f7763a;
        if (length > i9) {
            objArr[i9] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        int i8 = this.f7763a;
        if (i8 == 0) {
            this.f7764b = obj;
        } else if (i8 == 1) {
            this.f7764b = new Object[]{this.f7764b, obj};
        } else {
            Object[] objArr = (Object[]) this.f7764b;
            int length = objArr.length;
            if (i8 >= length) {
                int i9 = ((length * 3) / 2) + 1;
                int i10 = i8 + 1;
                if (i9 < i10) {
                    i9 = i10;
                }
                Object[] objArr2 = new Object[i9];
                this.f7764b = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, length);
                objArr = objArr2;
            }
            objArr[this.f7763a] = obj;
        }
        this.f7763a++;
        ((AbstractList) this).modCount++;
        return true;
    }
}
