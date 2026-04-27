package com.amazon.a.a.o.d;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c implements Iterable<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<b, a> f14134a = new HashMap();

    public <T extends Comparable<T>> c a(T t8, T t9, b bVar) {
        if (t8.compareTo(t9) <= 0) {
            this.f14134a.put(bVar, new a(bVar, "'" + t8 + "' <= '" + t9 + "'"));
        }
        return this;
    }

    @Override // java.lang.Iterable
    public Iterator<a> iterator() {
        return this.f14134a.values().iterator();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Verifier:");
        Iterator<a> it = this.f14134a.values().iterator();
        while (it.hasNext()) {
            sb.append("\n\t" + it.next());
        }
        return sb.toString();
    }

    public c a(Exception exc, b bVar) {
        this.f14134a.put(bVar, new a(bVar, "Exception: " + exc));
        return this;
    }

    public <T> c a(T t8, T t9, b bVar) {
        if (!a(t8, t9)) {
            this.f14134a.put(bVar, new a(bVar, "'" + t8 + "' != '" + t9 + "'"));
        }
        return this;
    }

    public boolean a() {
        return !this.f14134a.isEmpty();
    }

    public boolean a(b bVar) {
        return this.f14134a.containsKey(bVar);
    }

    private boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }
}
