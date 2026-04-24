package F4;

import F4.InterfaceC0498l;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import v2.AbstractC2848n;
import v2.C2841g;

/* JADX INFO: renamed from: F4.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0507v {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C2841g f1904c = C2841g.e(',');

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0507v f1905d = a().f(new InterfaceC0498l.a(), true).f(InterfaceC0498l.b.f1851a, false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f1906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f1907b;

    /* JADX INFO: renamed from: F4.v$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InterfaceC0506u f1908a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f1909b;

        public a(InterfaceC0506u interfaceC0506u, boolean z7) {
            this.f1908a = (InterfaceC0506u) AbstractC2848n.o(interfaceC0506u, "decompressor");
            this.f1909b = z7;
        }
    }

    public C0507v() {
        this.f1906a = new LinkedHashMap(0);
        this.f1907b = new byte[0];
    }

    public static C0507v a() {
        return new C0507v();
    }

    public static C0507v c() {
        return f1905d;
    }

    public Set b() {
        HashSet hashSet = new HashSet(this.f1906a.size());
        for (Map.Entry entry : this.f1906a.entrySet()) {
            if (((a) entry.getValue()).f1909b) {
                hashSet.add((String) entry.getKey());
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public byte[] d() {
        return this.f1907b;
    }

    public InterfaceC0506u e(String str) {
        a aVar = (a) this.f1906a.get(str);
        if (aVar != null) {
            return aVar.f1908a;
        }
        return null;
    }

    public C0507v f(InterfaceC0506u interfaceC0506u, boolean z7) {
        return new C0507v(interfaceC0506u, z7, this);
    }

    public C0507v(InterfaceC0506u interfaceC0506u, boolean z7, C0507v c0507v) {
        String strA = interfaceC0506u.a();
        AbstractC2848n.e(!strA.contains(com.amazon.a.a.o.b.f.f14100a), "Comma is currently not allowed in message encoding");
        int size = c0507v.f1906a.size();
        LinkedHashMap linkedHashMap = new LinkedHashMap(c0507v.f1906a.containsKey(interfaceC0506u.a()) ? size : size + 1);
        for (a aVar : c0507v.f1906a.values()) {
            String strA2 = aVar.f1908a.a();
            if (!strA2.equals(strA)) {
                linkedHashMap.put(strA2, new a(aVar.f1908a, aVar.f1909b));
            }
        }
        linkedHashMap.put(strA, new a(interfaceC0506u, z7));
        this.f1906a = Collections.unmodifiableMap(linkedHashMap);
        this.f1907b = f1904c.c(b()).getBytes(Charset.forName("US-ASCII"));
    }
}
