package com.amazon.a.a.o;

import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class g<T> implements Iterable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakHashMap<T, Object> f4633a = new WeakHashMap<>();

    public void a(T t10) {
        this.f4633a.put(t10, null);
    }

    public void b(T t10) {
        this.f4633a.remove(t10);
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return this.f4633a.keySet().iterator();
    }

    public String toString() {
        return this.f4633a.keySet().toString();
    }

    public boolean a() {
        return this.f4633a.isEmpty();
    }

    public int b() {
        return this.f4633a.size();
    }
}
