package r5;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import r5.InterfaceC2596l;

/* JADX INFO: renamed from: r5.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2605v {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final H2.f f22806c = H2.f.e(',');

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C2605v f22807d = a().f(new InterfaceC2596l.a(), true).f(InterfaceC2596l.b.f22703a, false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f22808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f22809b;

    /* JADX INFO: renamed from: r5.v$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InterfaceC2604u f22810a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f22811b;

        public a(InterfaceC2604u interfaceC2604u, boolean z7) {
            this.f22810a = (InterfaceC2604u) H2.m.o(interfaceC2604u, "decompressor");
            this.f22811b = z7;
        }
    }

    public C2605v(InterfaceC2604u interfaceC2604u, boolean z7, C2605v c2605v) {
        String strA = interfaceC2604u.a();
        H2.m.e(!strA.contains(com.amazon.a.a.o.b.f.f9989a), "Comma is currently not allowed in message encoding");
        int size = c2605v.f22808a.size();
        LinkedHashMap linkedHashMap = new LinkedHashMap(c2605v.f22808a.containsKey(interfaceC2604u.a()) ? size : size + 1);
        for (a aVar : c2605v.f22808a.values()) {
            String strA2 = aVar.f22810a.a();
            if (!strA2.equals(strA)) {
                linkedHashMap.put(strA2, new a(aVar.f22810a, aVar.f22811b));
            }
        }
        linkedHashMap.put(strA, new a(interfaceC2604u, z7));
        this.f22808a = Collections.unmodifiableMap(linkedHashMap);
        this.f22809b = f22806c.c(b()).getBytes(Charset.forName("US-ASCII"));
    }

    public static C2605v a() {
        return new C2605v();
    }

    public static C2605v c() {
        return f22807d;
    }

    public Set b() {
        HashSet hashSet = new HashSet(this.f22808a.size());
        for (Map.Entry entry : this.f22808a.entrySet()) {
            if (((a) entry.getValue()).f22811b) {
                hashSet.add((String) entry.getKey());
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public byte[] d() {
        return this.f22809b;
    }

    public InterfaceC2604u e(String str) {
        a aVar = (a) this.f22808a.get(str);
        if (aVar != null) {
            return aVar.f22810a;
        }
        return null;
    }

    public C2605v f(InterfaceC2604u interfaceC2604u, boolean z7) {
        return new C2605v(interfaceC2604u, z7, this);
    }

    public C2605v() {
        this.f22808a = new LinkedHashMap(0);
        this.f22809b = new byte[0];
    }
}
