package g0;

import B5.k;
import g0.AbstractC1776f;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.AbstractC2306v;
import o5.C2489q;
import p5.AbstractC2592n;
import p5.L;
import p5.r;
import p5.z;

/* JADX INFO: renamed from: g0.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1773c extends AbstractC1776f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f17966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C1772b f17967b;

    /* JADX INFO: renamed from: g0.c$a */
    public static final class a extends AbstractC2306v implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f17968a = new a();

        public a() {
            super(1);
        }

        @Override // B5.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(Map.Entry entry) {
            AbstractC2304t.f(entry, "entry");
            Object value = entry.getValue();
            return "  " + ((AbstractC1776f.a) entry.getKey()).a() + " = " + (value instanceof byte[] ? AbstractC2592n.T((byte[]) value, ", ", "[", "]", 0, null, null, 56, null) : String.valueOf(entry.getValue()));
        }
    }

    public C1773c(Map preferencesMap, boolean z7) {
        AbstractC2304t.f(preferencesMap, "preferencesMap");
        this.f17966a = preferencesMap;
        this.f17967b = new C1772b(z7);
    }

    @Override // g0.AbstractC1776f
    public Map a() {
        C2489q c2489q;
        Set<Map.Entry> setEntrySet = this.f17966a.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(H5.i.b(L.d(r.s(setEntrySet, 10)), 16));
        for (Map.Entry entry : setEntrySet) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                Object key = entry.getKey();
                byte[] bArr = (byte[]) value;
                byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                AbstractC2304t.e(bArrCopyOf, "copyOf(this, size)");
                c2489q = new C2489q(key, bArrCopyOf);
            } else {
                c2489q = new C2489q(entry.getKey(), entry.getValue());
            }
            linkedHashMap.put(c2489q.c(), c2489q.d());
        }
        return AbstractC1771a.b(linkedHashMap);
    }

    @Override // g0.AbstractC1776f
    public Object b(AbstractC1776f.a key) {
        AbstractC2304t.f(key, "key");
        Object obj = this.f17966a.get(key);
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        AbstractC2304t.e(bArrCopyOf, "copyOf(this, size)");
        return bArrCopyOf;
    }

    public final void e() {
        if (!(!this.f17967b.a())) {
            throw new IllegalStateException("Do mutate preferences once returned to DataStore.".toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof g0.C1773c
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            g0.c r6 = (g0.C1773c) r6
            java.util.Map r0 = r6.f17966a
            java.util.Map r2 = r5.f17966a
            r3 = 1
            if (r0 != r2) goto L10
            return r3
        L10:
            int r0 = r0.size()
            java.util.Map r2 = r5.f17966a
            int r2 = r2.size()
            if (r0 == r2) goto L1d
            return r1
        L1d:
            java.util.Map r6 = r6.f17966a
            boolean r0 = r6.isEmpty()
            if (r0 == 0) goto L27
        L25:
            r1 = r3
            goto L67
        L27:
            java.util.Set r6 = r6.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L2f:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L25
            java.lang.Object r0 = r6.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.util.Map r2 = r5.f17966a
            java.lang.Object r4 = r0.getKey()
            java.lang.Object r2 = r2.get(r4)
            if (r2 == 0) goto L64
            java.lang.Object r0 = r0.getValue()
            boolean r4 = r0 instanceof byte[]
            if (r4 == 0) goto L5f
            boolean r4 = r2 instanceof byte[]
            if (r4 == 0) goto L64
            byte[] r0 = (byte[]) r0
            byte[] r2 = (byte[]) r2
            boolean r0 = java.util.Arrays.equals(r0, r2)
            if (r0 == 0) goto L64
            r0 = r3
            goto L65
        L5f:
            boolean r0 = kotlin.jvm.internal.AbstractC2304t.b(r0, r2)
            goto L65
        L64:
            r0 = r1
        L65:
            if (r0 != 0) goto L2f
        L67:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: g0.C1773c.equals(java.lang.Object):boolean");
    }

    public final void f() {
        e();
        this.f17966a.clear();
    }

    public final void g() {
        this.f17967b.b(true);
    }

    public final void h(AbstractC1776f.b... pairs) {
        AbstractC2304t.f(pairs, "pairs");
        e();
        if (pairs.length <= 0) {
            return;
        }
        AbstractC1776f.b bVar = pairs[0];
        throw null;
    }

    public int hashCode() {
        Iterator it = this.f17966a.entrySet().iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object value = ((Map.Entry) it.next()).getValue();
            iHashCode += value instanceof byte[] ? Arrays.hashCode((byte[]) value) : value.hashCode();
        }
        return iHashCode;
    }

    public final Object i(AbstractC1776f.a key) {
        AbstractC2304t.f(key, "key");
        e();
        return this.f17966a.remove(key);
    }

    public final void j(AbstractC1776f.a key, Object obj) {
        AbstractC2304t.f(key, "key");
        k(key, obj);
    }

    public final void k(AbstractC1776f.a key, Object obj) {
        AbstractC2304t.f(key, "key");
        e();
        if (obj == null) {
            i(key);
            return;
        }
        if (obj instanceof Set) {
            this.f17966a.put(key, AbstractC1771a.a((Set) obj));
            return;
        }
        if (!(obj instanceof byte[])) {
            this.f17966a.put(key, obj);
            return;
        }
        Map map = this.f17966a;
        byte[] bArr = (byte[]) obj;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        AbstractC2304t.e(bArrCopyOf, "copyOf(this, size)");
        map.put(key, bArrCopyOf);
    }

    public String toString() {
        return z.h0(this.f17966a.entrySet(), ",\n", "{\n", "\n}", 0, null, a.f17968a, 24, null);
    }

    public /* synthetic */ C1773c(Map map, boolean z7, int i8, AbstractC2296k abstractC2296k) {
        this((i8 & 1) != 0 ? new LinkedHashMap() : map, (i8 & 2) != 0 ? true : z7);
    }
}
