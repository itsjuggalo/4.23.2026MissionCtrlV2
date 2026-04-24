package com.amazon.a.a.o;

import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class g<T> implements Iterable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakHashMap<T, Object> f14135a = new WeakHashMap<>();

    public void a(T t8) {
        this.f14135a.put(t8, null);
    }

    public int b() {
        return this.f14135a.size();
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return this.f14135a.keySet().iterator();
    }

    public String toString() {
        return this.f14135a.keySet().toString();
    }

    public boolean a() {
        return this.f14135a.isEmpty();
    }

    public void b(T t8) {
        this.f14135a.remove(t8);
    }
}
