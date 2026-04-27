package V;

import V.f;
import W2.o;
import X2.AbstractC0765l;
import X2.AbstractC0770q;
import X2.K;
import X2.x;
import i3.k;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import o3.AbstractC1681l;

/* JADX INFO: loaded from: classes.dex */
public final class c extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f5275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f5276b;

    public static final class a extends s implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f5277a = new a();

        public a() {
            super(1);
        }

        @Override // i3.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(Map.Entry entry) {
            r.f(entry, "entry");
            Object value = entry.getValue();
            return "  " + ((f.a) entry.getKey()).a() + " = " + (value instanceof byte[] ? AbstractC0765l.T((byte[]) value, ", ", "[", "]", 0, null, null, 56, null) : String.valueOf(entry.getValue()));
        }
    }

    public /* synthetic */ c(Map map, boolean z4, int i4, AbstractC1585j abstractC1585j) {
        this((i4 & 1) != 0 ? new LinkedHashMap() : map, (i4 & 2) != 0 ? true : z4);
    }

    @Override // V.f
    public Map a() {
        o oVar;
        Set<Map.Entry> setEntrySet = this.f5275a.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC1681l.b(K.b(AbstractC0770q.q(setEntrySet, 10)), 16));
        for (Map.Entry entry : setEntrySet) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                Object key = entry.getKey();
                byte[] bArr = (byte[]) value;
                byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                r.e(bArrCopyOf, "copyOf(this, size)");
                oVar = new o(key, bArrCopyOf);
            } else {
                oVar = new o(entry.getKey(), entry.getValue());
            }
            linkedHashMap.put(oVar.c(), oVar.d());
        }
        return V.a.b(linkedHashMap);
    }

    @Override // V.f
    public Object b(f.a key) {
        r.f(key, "key");
        Object obj = this.f5275a.get(key);
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        r.e(bArrCopyOf, "copyOf(this, size)");
        return bArrCopyOf;
    }

    public final void e() {
        if (this.f5276b.a()) {
            throw new IllegalStateException("Do mutate preferences once returned to DataStore.");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof V.c
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            V.c r6 = (V.c) r6
            java.util.Map r0 = r6.f5275a
            java.util.Map r2 = r5.f5275a
            r3 = 1
            if (r0 != r2) goto L10
            return r3
        L10:
            int r0 = r0.size()
            java.util.Map r2 = r5.f5275a
            int r2 = r2.size()
            if (r0 == r2) goto L1d
            return r1
        L1d:
            java.util.Map r6 = r6.f5275a
            boolean r0 = r6.isEmpty()
            if (r0 == 0) goto L26
            return r3
        L26:
            java.util.Set r6 = r6.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L2e:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L67
            java.lang.Object r0 = r6.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.util.Map r2 = r5.f5275a
            java.lang.Object r4 = r0.getKey()
            java.lang.Object r2 = r2.get(r4)
            if (r2 == 0) goto L63
            java.lang.Object r0 = r0.getValue()
            boolean r4 = r0 instanceof byte[]
            if (r4 == 0) goto L5e
            boolean r4 = r2 instanceof byte[]
            if (r4 == 0) goto L63
            byte[] r0 = (byte[]) r0
            byte[] r2 = (byte[]) r2
            boolean r0 = java.util.Arrays.equals(r0, r2)
            if (r0 == 0) goto L63
            r0 = r3
            goto L64
        L5e:
            boolean r0 = kotlin.jvm.internal.r.b(r0, r2)
            goto L64
        L63:
            r0 = r1
        L64:
            if (r0 != 0) goto L2e
            return r1
        L67:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: V.c.equals(java.lang.Object):boolean");
    }

    public final void f() {
        e();
        this.f5275a.clear();
    }

    public final void g() {
        this.f5276b.b(true);
    }

    public final void h(f.b... pairs) {
        r.f(pairs, "pairs");
        e();
        if (pairs.length <= 0) {
            return;
        }
        f.b bVar = pairs[0];
        throw null;
    }

    public int hashCode() {
        Iterator it = this.f5275a.entrySet().iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object value = ((Map.Entry) it.next()).getValue();
            iHashCode += value instanceof byte[] ? Arrays.hashCode((byte[]) value) : value.hashCode();
        }
        return iHashCode;
    }

    public final Object i(f.a key) {
        r.f(key, "key");
        e();
        return this.f5275a.remove(key);
    }

    public final void j(f.a key, Object obj) {
        r.f(key, "key");
        k(key, obj);
    }

    public final void k(f.a key, Object obj) {
        r.f(key, "key");
        e();
        if (obj == null) {
            i(key);
            return;
        }
        if (obj instanceof Set) {
            this.f5275a.put(key, V.a.a((Set) obj));
            return;
        }
        if (!(obj instanceof byte[])) {
            this.f5275a.put(key, obj);
            return;
        }
        Map map = this.f5275a;
        byte[] bArr = (byte[]) obj;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        r.e(bArrCopyOf, "copyOf(this, size)");
        map.put(key, bArrCopyOf);
    }

    public String toString() {
        return x.Q(this.f5275a.entrySet(), ",\n", "{\n", "\n}", 0, null, a.f5277a, 24, null);
    }

    public c(Map preferencesMap, boolean z4) {
        r.f(preferencesMap, "preferencesMap");
        this.f5275a = preferencesMap;
        this.f5276b = new b(z4);
    }
}
