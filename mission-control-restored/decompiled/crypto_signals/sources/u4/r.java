package u4;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Q3.h f10479c = new Q3.h(String.valueOf(','));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final r f10480d = new r(C1226h.f10411b, false, new r(new C1226h(2), true, new r()));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f10481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f10482b;

    public r(InterfaceC1227i interfaceC1227i, boolean z6, r rVar) {
        String strG = interfaceC1227i.g();
        s3.D.f("Comma is currently not allowed in message encoding", !strG.contains(","));
        int size = rVar.f10481a.size();
        LinkedHashMap linkedHashMap = new LinkedHashMap(rVar.f10481a.containsKey(interfaceC1227i.g()) ? size : size + 1);
        for (C1235q c1235q : rVar.f10481a.values()) {
            String strG2 = c1235q.f10477a.g();
            if (!strG2.equals(strG)) {
                linkedHashMap.put(strG2, new C1235q(c1235q.f10477a, c1235q.f10478b));
            }
        }
        linkedHashMap.put(strG, new C1235q(interfaceC1227i, z6));
        Map mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        this.f10481a = mapUnmodifiableMap;
        HashSet hashSet = new HashSet(mapUnmodifiableMap.size());
        for (Map.Entry entry : mapUnmodifiableMap.entrySet()) {
            if (((C1235q) entry.getValue()).f10478b) {
                hashSet.add((String) entry.getKey());
            }
        }
        Set setUnmodifiableSet = Collections.unmodifiableSet(hashSet);
        Q3.h hVar = f10479c;
        hVar.getClass();
        Iterator it = setUnmodifiableSet.iterator();
        StringBuilder sb = new StringBuilder();
        try {
            if (it.hasNext()) {
                Object next = it.next();
                Objects.requireNonNull(next);
                sb.append(next instanceof CharSequence ? (CharSequence) next : next.toString());
                while (it.hasNext()) {
                    sb.append((CharSequence) hVar.f2742b);
                    Object next2 = it.next();
                    Objects.requireNonNull(next2);
                    sb.append(next2 instanceof CharSequence ? (CharSequence) next2 : next2.toString());
                }
            }
            this.f10482b = sb.toString().getBytes(Charset.forName("US-ASCII"));
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public r() {
        this.f10481a = new LinkedHashMap(0);
        this.f10482b = new byte[0];
    }
}
