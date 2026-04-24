package h3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import k3.AbstractC2279m;
import p3.C2548b;

/* JADX INFO: renamed from: h3.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1875k implements Iterable, Comparable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C1875k f18456d = new C1875k("");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2548b[] f18457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f18458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f18459c;

    /* JADX INFO: renamed from: h3.k$a */
    public class a implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f18460a;

        public a() {
            this.f18460a = C1875k.this.f18458b;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public C2548b next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements.");
            }
            C2548b[] c2548bArr = C1875k.this.f18457a;
            int i8 = this.f18460a;
            C2548b c2548b = c2548bArr[i8];
            this.f18460a = i8 + 1;
            return c2548b;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f18460a < C1875k.this.f18459c;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Can't remove component from immutable Path!");
        }
    }

    public C1875k(String str) {
        String[] strArrSplit = str.split("/", -1);
        int i8 = 0;
        for (String str2 : strArrSplit) {
            if (str2.length() > 0) {
                i8++;
            }
        }
        this.f18457a = new C2548b[i8];
        int i9 = 0;
        for (String str3 : strArrSplit) {
            if (str3.length() > 0) {
                this.f18457a[i9] = C2548b.i(str3);
                i9++;
            }
        }
        this.f18458b = 0;
        this.f18459c = this.f18457a.length;
    }

    public static C1875k O() {
        return f18456d;
    }

    public static C1875k R(C1875k c1875k, C1875k c1875k2) {
        C2548b c2548bP = c1875k.P();
        C2548b c2548bP2 = c1875k2.P();
        if (c2548bP == null) {
            return c1875k2;
        }
        if (c2548bP.equals(c2548bP2)) {
            return R(c1875k.S(), c1875k2.S());
        }
        throw new c3.d("INTERNAL ERROR: " + c1875k2 + " is not contained in " + c1875k);
    }

    public List I() {
        ArrayList arrayList = new ArrayList(size());
        Iterator it = iterator();
        while (it.hasNext()) {
            arrayList.add(((C2548b) it.next()).b());
        }
        return arrayList;
    }

    public C1875k J(C1875k c1875k) {
        int size = size() + c1875k.size();
        C2548b[] c2548bArr = new C2548b[size];
        System.arraycopy(this.f18457a, this.f18458b, c2548bArr, 0, size());
        System.arraycopy(c1875k.f18457a, c1875k.f18458b, c2548bArr, size(), c1875k.size());
        return new C1875k(c2548bArr, 0, size);
    }

    public C1875k K(C2548b c2548b) {
        int size = size();
        int i8 = size + 1;
        C2548b[] c2548bArr = new C2548b[i8];
        System.arraycopy(this.f18457a, this.f18458b, c2548bArr, 0, size);
        c2548bArr[size] = c2548b;
        return new C1875k(c2548bArr, 0, i8);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
    
        if (r0 != r2) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0024, code lost:
    
        if (r1 != r5.f18459c) goto L16;
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
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int compareTo(h3.C1875k r5) {
        /*
            r4 = this;
            int r0 = r4.f18458b
            int r1 = r5.f18458b
        L4:
            int r2 = r4.f18459c
            if (r0 >= r2) goto L20
            int r3 = r5.f18459c
            if (r1 >= r3) goto L20
            p3.b[] r2 = r4.f18457a
            r2 = r2[r0]
            p3.b[] r3 = r5.f18457a
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
            int r5 = r5.f18459c
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
        throw new UnsupportedOperationException("Method not decompiled: h3.C1875k.compareTo(h3.k):int");
    }

    public boolean M(C1875k c1875k) {
        if (size() > c1875k.size()) {
            return false;
        }
        int i8 = this.f18458b;
        int i9 = c1875k.f18458b;
        while (i8 < this.f18459c) {
            if (!this.f18457a[i8].equals(c1875k.f18457a[i9])) {
                return false;
            }
            i8++;
            i9++;
        }
        return true;
    }

    public C2548b N() {
        if (isEmpty()) {
            return null;
        }
        return this.f18457a[this.f18459c - 1];
    }

    public C2548b P() {
        if (isEmpty()) {
            return null;
        }
        return this.f18457a[this.f18458b];
    }

    public C1875k Q() {
        if (isEmpty()) {
            return null;
        }
        return new C1875k(this.f18457a, this.f18458b, this.f18459c - 1);
    }

    public C1875k S() {
        int i8 = this.f18458b;
        if (!isEmpty()) {
            i8++;
        }
        return new C1875k(this.f18457a, i8, this.f18459c);
    }

    public String T() {
        if (isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (int i8 = this.f18458b; i8 < this.f18459c; i8++) {
            if (i8 > this.f18458b) {
                sb.append("/");
            }
            sb.append(this.f18457a[i8].b());
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1875k)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        C1875k c1875k = (C1875k) obj;
        if (size() != c1875k.size()) {
            return false;
        }
        int i8 = this.f18458b;
        for (int i9 = c1875k.f18458b; i8 < this.f18459c && i9 < c1875k.f18459c; i9++) {
            if (!this.f18457a[i8].equals(c1875k.f18457a[i9])) {
                return false;
            }
            i8++;
        }
        return true;
    }

    public int hashCode() {
        int iHashCode = 0;
        for (int i8 = this.f18458b; i8 < this.f18459c; i8++) {
            iHashCode = (iHashCode * 37) + this.f18457a[i8].hashCode();
        }
        return iHashCode;
    }

    public boolean isEmpty() {
        return this.f18458b >= this.f18459c;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new a();
    }

    public int size() {
        return this.f18459c - this.f18458b;
    }

    public String toString() {
        if (isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (int i8 = this.f18458b; i8 < this.f18459c; i8++) {
            sb.append("/");
            sb.append(this.f18457a[i8].b());
        }
        return sb.toString();
    }

    public C1875k(List list) {
        this.f18457a = new C2548b[list.size()];
        Iterator it = list.iterator();
        int i8 = 0;
        while (it.hasNext()) {
            this.f18457a[i8] = C2548b.i((String) it.next());
            i8++;
        }
        this.f18458b = 0;
        this.f18459c = list.size();
    }

    public C1875k(C2548b... c2548bArr) {
        this.f18457a = (C2548b[]) Arrays.copyOf(c2548bArr, c2548bArr.length);
        this.f18458b = 0;
        this.f18459c = c2548bArr.length;
        for (C2548b c2548b : c2548bArr) {
            AbstractC2279m.g(c2548b != null, "Can't construct a path with a null value!");
        }
    }

    public C1875k(C2548b[] c2548bArr, int i8, int i9) {
        this.f18457a = c2548bArr;
        this.f18458b = i8;
        this.f18459c = i9;
    }
}
