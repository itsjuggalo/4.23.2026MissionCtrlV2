package T;

import H4.j;
import H4.t;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f2885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Q.a f2886b;

    public b(LinkedHashMap linkedHashMap, boolean z6) {
        this.f2885a = linkedHashMap;
        this.f2886b = new Q.a(z6);
    }

    public final Map a() {
        G4.f fVar;
        Set<Map.Entry> setEntrySet = this.f2885a.entrySet();
        int iP = t.P(j.d0(setEntrySet, 10));
        if (iP < 16) {
            iP = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iP);
        for (Map.Entry entry : setEntrySet) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                Object key = entry.getKey();
                byte[] bArr = (byte[]) value;
                byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                kotlin.jvm.internal.j.d(bArrCopyOf, "copyOf(this, size)");
                fVar = new G4.f(key, bArrCopyOf);
            } else {
                fVar = new G4.f(entry.getKey(), entry.getValue());
            }
            linkedHashMap.put(fVar.f529a, fVar.f530b);
        }
        Map mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        kotlin.jvm.internal.j.d(mapUnmodifiableMap, "unmodifiableMap(map)");
        return mapUnmodifiableMap;
    }

    public final void b() {
        if (this.f2886b.f2609a.get()) {
            throw new IllegalStateException("Do mutate preferences once returned to DataStore.");
        }
    }

    public final Object c(e key) {
        kotlin.jvm.internal.j.e(key, "key");
        Object obj = this.f2885a.get(key);
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        kotlin.jvm.internal.j.d(bArrCopyOf, "copyOf(this, size)");
        return bArrCopyOf;
    }

    public final void d(e key) {
        kotlin.jvm.internal.j.e(key, "key");
        b();
        this.f2885a.remove(key);
    }

    public final void e(e key, Object obj) {
        kotlin.jvm.internal.j.e(key, "key");
        f(key, obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof T.b
            r1 = 0
            if (r0 != 0) goto L6
            goto L62
        L6:
            T.b r7 = (T.b) r7
            java.util.LinkedHashMap r0 = r7.f2885a
            java.util.LinkedHashMap r2 = r6.f2885a
            r3 = 1
            if (r0 != r2) goto L10
            goto L63
        L10:
            int r0 = r0.size()
            int r4 = r2.size()
            if (r0 == r4) goto L1b
            goto L62
        L1b:
            java.util.LinkedHashMap r7 = r7.f2885a
            boolean r0 = r7.isEmpty()
            if (r0 == 0) goto L24
            goto L63
        L24:
            java.util.Set r7 = r7.entrySet()
            java.util.Iterator r7 = r7.iterator()
        L2c:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L63
            java.lang.Object r0 = r7.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r4 = r0.getKey()
            java.lang.Object r4 = r2.get(r4)
            if (r4 == 0) goto L5f
            java.lang.Object r0 = r0.getValue()
            boolean r5 = r0 instanceof byte[]
            if (r5 == 0) goto L5a
            boolean r5 = r4 instanceof byte[]
            if (r5 == 0) goto L5f
            byte[] r0 = (byte[]) r0
            byte[] r4 = (byte[]) r4
            boolean r0 = java.util.Arrays.equals(r0, r4)
            if (r0 == 0) goto L5f
            r0 = r3
            goto L60
        L5a:
            boolean r0 = kotlin.jvm.internal.j.a(r0, r4)
            goto L60
        L5f:
            r0 = r1
        L60:
            if (r0 != 0) goto L2c
        L62:
            return r1
        L63:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: T.b.equals(java.lang.Object):boolean");
    }

    public final void f(e key, Object obj) {
        kotlin.jvm.internal.j.e(key, "key");
        b();
        if (obj == null) {
            d(key);
            return;
        }
        boolean z6 = obj instanceof Set;
        LinkedHashMap linkedHashMap = this.f2885a;
        if (z6) {
            Set setUnmodifiableSet = Collections.unmodifiableSet(H4.h.r0((Set) obj));
            kotlin.jvm.internal.j.d(setUnmodifiableSet, "unmodifiableSet(set.toSet())");
            linkedHashMap.put(key, setUnmodifiableSet);
        } else {
            if (!(obj instanceof byte[])) {
                linkedHashMap.put(key, obj);
                return;
            }
            byte[] bArr = (byte[]) obj;
            byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
            kotlin.jvm.internal.j.d(bArrCopyOf, "copyOf(this, size)");
            linkedHashMap.put(key, bArrCopyOf);
        }
    }

    public final int hashCode() {
        Iterator it = this.f2885a.entrySet().iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object value = ((Map.Entry) it.next()).getValue();
            iHashCode += value instanceof byte[] ? Arrays.hashCode((byte[]) value) : value.hashCode();
        }
        return iHashCode;
    }

    public final String toString() {
        return H4.h.h0(this.f2885a.entrySet(), ",\n", "{\n", "\n}", a.f2884a, 24);
    }

    public /* synthetic */ b(boolean z6) {
        this(new LinkedHashMap(), z6);
    }
}
