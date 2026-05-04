package rb;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import rb.l;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class v {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final p6.g f19730c = p6.g.e(',');

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final v f19731d = a().f(new l.a(), true).f(l.b.f19636a, false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f19732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f19733b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final u f19734a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f19735b;

        public a(u uVar, boolean z10) {
            this.f19734a = (u) p6.n.o(uVar, "decompressor");
            this.f19735b = z10;
        }
    }

    public v(u uVar, boolean z10, v vVar) {
        String strA = uVar.a();
        p6.n.e(!strA.contains(com.amazon.a.a.o.b.f.f4598a), "Comma is currently not allowed in message encoding");
        int size = vVar.f19732a.size();
        LinkedHashMap linkedHashMap = new LinkedHashMap(vVar.f19732a.containsKey(uVar.a()) ? size : size + 1);
        for (a aVar : vVar.f19732a.values()) {
            String strA2 = aVar.f19734a.a();
            if (!strA2.equals(strA)) {
                linkedHashMap.put(strA2, new a(aVar.f19734a, aVar.f19735b));
            }
        }
        linkedHashMap.put(strA, new a(uVar, z10));
        this.f19732a = Collections.unmodifiableMap(linkedHashMap);
        this.f19733b = f19730c.c(b()).getBytes(Charset.forName("US-ASCII"));
    }

    public static v a() {
        return new v();
    }

    public static v c() {
        return f19731d;
    }

    public Set b() {
        HashSet hashSet = new HashSet(this.f19732a.size());
        for (Map.Entry entry : this.f19732a.entrySet()) {
            if (((a) entry.getValue()).f19735b) {
                hashSet.add((String) entry.getKey());
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public byte[] d() {
        return this.f19733b;
    }

    public u e(String str) {
        a aVar = (a) this.f19732a.get(str);
        if (aVar != null) {
            return aVar.f19734a;
        }
        return null;
    }

    public v f(u uVar, boolean z10) {
        return new v(uVar, z10, this);
    }

    public v() {
        this.f19732a = new LinkedHashMap(0);
        this.f19733b = new byte[0];
    }
}
