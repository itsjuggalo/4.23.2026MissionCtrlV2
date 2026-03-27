package K2;

import K2.InterfaceC0364l;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: K2.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0373v {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Z1.f f1316c = Z1.f.e(',');

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0373v f1317d = a().f(new InterfaceC0364l.a(), true).f(InterfaceC0364l.b.f1213a, false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f1318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f1319b;

    /* JADX INFO: renamed from: K2.v$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InterfaceC0372u f1320a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f1321b;

        public a(InterfaceC0372u interfaceC0372u, boolean z4) {
            this.f1320a = (InterfaceC0372u) Z1.m.o(interfaceC0372u, "decompressor");
            this.f1321b = z4;
        }
    }

    public C0373v(InterfaceC0372u interfaceC0372u, boolean z4, C0373v c0373v) {
        String strA = interfaceC0372u.a();
        Z1.m.e(!strA.contains(com.amazon.a.a.o.b.f.f8804a), "Comma is currently not allowed in message encoding");
        int size = c0373v.f1318a.size();
        LinkedHashMap linkedHashMap = new LinkedHashMap(c0373v.f1318a.containsKey(interfaceC0372u.a()) ? size : size + 1);
        for (a aVar : c0373v.f1318a.values()) {
            String strA2 = aVar.f1320a.a();
            if (!strA2.equals(strA)) {
                linkedHashMap.put(strA2, new a(aVar.f1320a, aVar.f1321b));
            }
        }
        linkedHashMap.put(strA, new a(interfaceC0372u, z4));
        this.f1318a = Collections.unmodifiableMap(linkedHashMap);
        this.f1319b = f1316c.c(b()).getBytes(Charset.forName("US-ASCII"));
    }

    public static C0373v a() {
        return new C0373v();
    }

    public static C0373v c() {
        return f1317d;
    }

    public Set b() {
        HashSet hashSet = new HashSet(this.f1318a.size());
        for (Map.Entry entry : this.f1318a.entrySet()) {
            if (((a) entry.getValue()).f1321b) {
                hashSet.add((String) entry.getKey());
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public byte[] d() {
        return this.f1319b;
    }

    public InterfaceC0372u e(String str) {
        a aVar = (a) this.f1318a.get(str);
        if (aVar != null) {
            return aVar.f1320a;
        }
        return null;
    }

    public C0373v f(InterfaceC0372u interfaceC0372u, boolean z4) {
        return new C0373v(interfaceC0372u, z4, this);
    }

    public C0373v() {
        this.f1318a = new LinkedHashMap(0);
        this.f1319b = new byte[0];
    }
}
