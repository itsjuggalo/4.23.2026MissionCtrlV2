package j8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class l implements Iterable, Comparable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final l f14013d = new l("");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r8.b[] f14014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14016c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f14017a;

        public a() {
            this.f14017a = l.this.f14015b;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public r8.b next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements.");
            }
            r8.b[] bVarArr = l.this.f14014a;
            int i10 = this.f14017a;
            r8.b bVar = bVarArr[i10];
            this.f14017a = i10 + 1;
            return bVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f14017a < l.this.f14016c;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Can't remove component from immutable Path!");
        }
    }

    public l(r8.b... bVarArr) {
        this.f14014a = (r8.b[]) Arrays.copyOf(bVarArr, bVarArr.length);
        this.f14015b = 0;
        this.f14016c = bVarArr.length;
        for (r8.b bVar : bVarArr) {
            m8.m.g(bVar != null, "Can't construct a path with a null value!");
        }
    }

    public static l G() {
        return f14013d;
    }

    public static l R(l lVar, l lVar2) {
        r8.b bVarK = lVar.K();
        r8.b bVarK2 = lVar2.K();
        if (bVarK == null) {
            return lVar2;
        }
        if (bVarK.equals(bVarK2)) {
            return R(lVar.S(), lVar2.S());
        }
        throw new e8.d("INTERNAL ERROR: " + lVar2 + " is not contained in " + lVar);
    }

    public r8.b A() {
        if (isEmpty()) {
            return null;
        }
        return this.f14014a[this.f14016c - 1];
    }

    public r8.b K() {
        if (isEmpty()) {
            return null;
        }
        return this.f14014a[this.f14015b];
    }

    public l L() {
        if (isEmpty()) {
            return null;
        }
        return new l(this.f14014a, this.f14015b, this.f14016c - 1);
    }

    public l S() {
        int i10 = this.f14015b;
        if (!isEmpty()) {
            i10++;
        }
        return new l(this.f14014a, i10, this.f14016c);
    }

    public String T() {
        if (isEmpty()) {
            return "/";
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = this.f14015b; i10 < this.f14016c; i10++) {
            if (i10 > this.f14015b) {
                sb2.append("/");
            }
            sb2.append(this.f14014a[i10].b());
        }
        return sb2.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        l lVar = (l) obj;
        if (size() != lVar.size()) {
            return false;
        }
        int i10 = this.f14015b;
        for (int i11 = lVar.f14015b; i10 < this.f14016c && i11 < lVar.f14016c; i11++) {
            if (!this.f14014a[i10].equals(lVar.f14014a[i11])) {
                return false;
            }
            i10++;
        }
        return true;
    }

    public int hashCode() {
        int iHashCode = 0;
        for (int i10 = this.f14015b; i10 < this.f14016c; i10++) {
            iHashCode = (iHashCode * 37) + this.f14014a[i10].hashCode();
        }
        return iHashCode;
    }

    public boolean isEmpty() {
        return this.f14015b >= this.f14016c;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new a();
    }

    public List s() {
        ArrayList arrayList = new ArrayList(size());
        Iterator it = iterator();
        while (it.hasNext()) {
            arrayList.add(((r8.b) it.next()).b());
        }
        return arrayList;
    }

    public int size() {
        return this.f14016c - this.f14015b;
    }

    public String toString() {
        if (isEmpty()) {
            return "/";
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = this.f14015b; i10 < this.f14016c; i10++) {
            sb2.append("/");
            sb2.append(this.f14014a[i10].b());
        }
        return sb2.toString();
    }

    public l u(l lVar) {
        int size = size() + lVar.size();
        r8.b[] bVarArr = new r8.b[size];
        System.arraycopy(this.f14014a, this.f14015b, bVarArr, 0, size());
        System.arraycopy(lVar.f14014a, lVar.f14015b, bVarArr, size(), lVar.size());
        return new l(bVarArr, 0, size);
    }

    public l v(r8.b bVar) {
        int size = size();
        int i10 = size + 1;
        r8.b[] bVarArr = new r8.b[i10];
        System.arraycopy(this.f14014a, this.f14015b, bVarArr, 0, size);
        bVarArr[size] = bVar;
        return new l(bVarArr, 0, i10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
    
        if (r0 != r2) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0024, code lost:
    
        if (r1 != r5.f14016c) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0026, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0028, code lost:
    
        if (r0 != r2) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002a, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002c, code lost:
    
        return 1;
     */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int compareTo(j8.l r5) {
        /*
            r4 = this;
            int r0 = r4.f14015b
            int r1 = r5.f14015b
        L4:
            int r2 = r4.f14016c
            if (r0 >= r2) goto L20
            int r3 = r5.f14016c
            if (r1 >= r3) goto L20
            r8.b[] r2 = r4.f14014a
            r2 = r2[r0]
            r8.b[] r3 = r5.f14014a
            r3 = r3[r1]
            int r2 = r2.compareTo(r3)
            if (r2 == 0) goto L1b
            return r2
        L1b:
            int r0 = r0 + 1
            int r1 = r1 + 1
            goto L4
        L20:
            if (r0 != r2) goto L28
            int r5 = r5.f14016c
            if (r1 != r5) goto L28
            r5 = 0
            return r5
        L28:
            if (r0 != r2) goto L2c
            r5 = -1
            return r5
        L2c:
            r5 = 1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: j8.l.compareTo(j8.l):int");
    }

    public boolean y(l lVar) {
        if (size() > lVar.size()) {
            return false;
        }
        int i10 = this.f14015b;
        int i11 = lVar.f14015b;
        while (i10 < this.f14016c) {
            if (!this.f14014a[i10].equals(lVar.f14014a[i11])) {
                return false;
            }
            i10++;
            i11++;
        }
        return true;
    }

    public l(List list) {
        this.f14014a = new r8.b[list.size()];
        Iterator it = list.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            this.f14014a[i10] = r8.b.h((String) it.next());
            i10++;
        }
        this.f14015b = 0;
        this.f14016c = list.size();
    }

    public l(String str) {
        String[] strArrSplit = str.split("/", -1);
        int i10 = 0;
        for (String str2 : strArrSplit) {
            if (str2.length() > 0) {
                i10++;
            }
        }
        this.f14014a = new r8.b[i10];
        int i11 = 0;
        for (String str3 : strArrSplit) {
            if (str3.length() > 0) {
                this.f14014a[i11] = r8.b.h(str3);
                i11++;
            }
        }
        this.f14015b = 0;
        this.f14016c = this.f14014a.length;
    }

    public l(r8.b[] bVarArr, int i10, int i11) {
        this.f14014a = bVarArr;
        this.f14015b = i10;
        this.f14016c = i11;
    }
}
