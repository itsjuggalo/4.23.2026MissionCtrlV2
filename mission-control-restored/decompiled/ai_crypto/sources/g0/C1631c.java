package g0;

import E5.o;
import F5.AbstractC0552j;
import F5.AbstractC0557o;
import F5.I;
import F5.v;
import Q5.k;
import W5.l;
import g0.f;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: renamed from: g0.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1631c extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f14242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C1630b f14243b;

    /* JADX INFO: renamed from: g0.c$a */
    public static final class a extends s implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f14244a = new a();

        public a() {
            super(1);
        }

        @Override // Q5.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(Map.Entry entry) {
            r.f(entry, "entry");
            Object value = entry.getValue();
            return "  " + ((f.a) entry.getKey()).a() + " = " + (value instanceof byte[] ? AbstractC0552j.S((byte[]) value, ", ", "[", "]", 0, null, null, 56, null) : String.valueOf(entry.getValue()));
        }
    }

    public /* synthetic */ C1631c(Map map, boolean z7, int i7, AbstractC2148j abstractC2148j) {
        this((i7 & 1) != 0 ? new LinkedHashMap() : map, (i7 & 2) != 0 ? true : z7);
    }

    @Override // g0.f
    public Map a() {
        o oVar;
        Set<Map.Entry> setEntrySet = this.f14242a.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(l.b(I.b(AbstractC0557o.q(setEntrySet, 10)), 16));
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
        return AbstractC1629a.b(linkedHashMap);
    }

    @Override // g0.f
    public Object b(f.a key) {
        r.f(key, "key");
        Object obj = this.f14242a.get(key);
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        r.e(bArrCopyOf, "copyOf(this, size)");
        return bArrCopyOf;
    }

    public final void e() {
        if (this.f14243b.a()) {
            throw new IllegalStateException("Do mutate preferences once returned to DataStore.");
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
            boolean r0 = r6 instanceof g0.C1631c
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            g0.c r6 = (g0.C1631c) r6
            java.util.Map r0 = r6.f14242a
            java.util.Map r2 = r5.f14242a
            r3 = 1
            if (r0 != r2) goto L10
            return r3
        L10:
            int r0 = r0.size()
            java.util.Map r2 = r5.f14242a
            int r2 = r2.size()
            if (r0 == r2) goto L1d
            return r1
        L1d:
            java.util.Map r6 = r6.f14242a
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
            java.util.Map r2 = r5.f14242a
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
            boolean r0 = kotlin.jvm.internal.r.b(r0, r2)
            goto L65
        L64:
            r0 = r1
        L65:
            if (r0 != 0) goto L2f
        L67:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: g0.C1631c.equals(java.lang.Object):boolean");
    }

    public final void f() {
        e();
        this.f14242a.clear();
    }

    public final void g() {
        this.f14243b.b(true);
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
        Iterator it = this.f14242a.entrySet().iterator();
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
        return this.f14242a.remove(key);
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
            this.f14242a.put(key, AbstractC1629a.a((Set) obj));
            return;
        }
        if (!(obj instanceof byte[])) {
            this.f14242a.put(key, obj);
            return;
        }
        Map map = this.f14242a;
        byte[] bArr = (byte[]) obj;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        r.e(bArrCopyOf, "copyOf(this, size)");
        map.put(key, bArrCopyOf);
    }

    public String toString() {
        return v.R(this.f14242a.entrySet(), ",\n", "{\n", "\n}", 0, null, a.f14244a, 24, null);
    }

    public C1631c(Map preferencesMap, boolean z7) {
        r.f(preferencesMap, "preferencesMap");
        this.f14242a = preferencesMap;
        this.f14243b = new C1630b(z7);
    }
}
