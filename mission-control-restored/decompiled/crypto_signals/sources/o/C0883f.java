package o;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: o.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0883f implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C0880c f8622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C0880c f8623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakHashMap f8624c = new WeakHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8625d = 0;

    public C0880c a(Object obj) {
        C0880c c0880c = this.f8622a;
        while (c0880c != null && !c0880c.f8615a.equals(obj)) {
            c0880c = c0880c.f8617c;
        }
        return c0880c;
    }

    public Object b(Object obj) {
        C0880c c0880cA = a(obj);
        if (c0880cA == null) {
            return null;
        }
        this.f8625d--;
        WeakHashMap weakHashMap = this.f8624c;
        if (!weakHashMap.isEmpty()) {
            Iterator it = weakHashMap.keySet().iterator();
            while (it.hasNext()) {
                ((AbstractC0882e) it.next()).a(c0880cA);
            }
        }
        C0880c c0880c = c0880cA.f8618d;
        if (c0880c != null) {
            c0880c.f8617c = c0880cA.f8617c;
        } else {
            this.f8622a = c0880cA.f8617c;
        }
        C0880c c0880c2 = c0880cA.f8617c;
        if (c0880c2 != null) {
            c0880c2.f8618d = c0880c;
        } else {
            this.f8623b = c0880c;
        }
        c0880cA.f8617c = null;
        c0880cA.f8618d = null;
        return c0880cA.f8616b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0048, code lost:
    
        if (r3.hasNext() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0050, code lost:
    
        if (((o.C0879b) r7).hasNext() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0052, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0053, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r7 != r6) goto L4
            return r0
        L4:
            boolean r1 = r7 instanceof o.C0883f
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            o.f r7 = (o.C0883f) r7
            int r1 = r6.f8625d
            int r3 = r7.f8625d
            if (r1 == r3) goto L13
            return r2
        L13:
            java.util.Iterator r1 = r6.iterator()
            java.util.Iterator r7 = r7.iterator()
        L1b:
            r3 = r1
            o.b r3 = (o.C0879b) r3
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L44
            r4 = r7
            o.b r4 = (o.C0879b) r4
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L44
            java.lang.Object r3 = r3.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r4.next()
            if (r3 != 0) goto L3b
            if (r4 != 0) goto L43
        L3b:
            if (r3 == 0) goto L1b
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L1b
        L43:
            return r2
        L44:
            boolean r1 = r3.hasNext()
            if (r1 != 0) goto L53
            o.b r7 = (o.C0879b) r7
            boolean r7 = r7.hasNext()
            if (r7 != 0) goto L53
            return r0
        L53:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: o.C0883f.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        Iterator it = iterator();
        int iHashCode = 0;
        while (true) {
            C0879b c0879b = (C0879b) it;
            if (!c0879b.hasNext()) {
                return iHashCode;
            }
            iHashCode += ((Map.Entry) c0879b.next()).hashCode();
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        C0879b c0879b = new C0879b(this.f8622a, this.f8623b, 0);
        this.f8624c.put(c0879b, Boolean.FALSE);
        return c0879b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator it = iterator();
        while (true) {
            C0879b c0879b = (C0879b) it;
            if (!c0879b.hasNext()) {
                sb.append("]");
                return sb.toString();
            }
            sb.append(((Map.Entry) c0879b.next()).toString());
            if (c0879b.hasNext()) {
                sb.append(", ");
            }
        }
    }
}
