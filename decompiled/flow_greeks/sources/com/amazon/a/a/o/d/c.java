package com.amazon.a.a.o.d;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c implements Iterable<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<b, a> f4632a = new HashMap();

    public <T> c a(T t10, T t11, b bVar) {
        if (!a(t10, t11)) {
            this.f4632a.put(bVar, new a(bVar, "'" + t10 + "' != '" + t11 + "'"));
        }
        return this;
    }

    @Override // java.lang.Iterable
    public Iterator<a> iterator() {
        return this.f4632a.values().iterator();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("Verifier:");
        Iterator<a> it = this.f4632a.values().iterator();
        while (it.hasNext()) {
            sb2.append("\n\t" + it.next());
        }
        return sb2.toString();
    }

    private boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public <T extends Comparable<T>> c a(T t10, T t11, b bVar) {
        if (t10.compareTo(t11) <= 0) {
            this.f4632a.put(bVar, new a(bVar, "'" + t10 + "' <= '" + t11 + "'"));
        }
        return this;
    }

    public c a(Exception exc, b bVar) {
        this.f4632a.put(bVar, new a(bVar, "Exception: " + exc));
        return this;
    }

    public boolean a() {
        return !this.f4632a.isEmpty();
    }

    public boolean a(b bVar) {
        return this.f4632a.containsKey(bVar);
    }
}
