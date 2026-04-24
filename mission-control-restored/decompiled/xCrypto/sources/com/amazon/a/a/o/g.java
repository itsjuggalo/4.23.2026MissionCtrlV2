package com.amazon.a.a.o;

import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class g<T> implements Iterable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakHashMap<T, Object> f8839a = new WeakHashMap<>();

    public void a(T t4) {
        this.f8839a.put(t4, null);
    }

    public void b(T t4) {
        this.f8839a.remove(t4);
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return this.f8839a.keySet().iterator();
    }

    public String toString() {
        return this.f8839a.keySet().toString();
    }

    public boolean a() {
        return this.f8839a.isEmpty();
    }

    public int b() {
        return this.f8839a.size();
    }
}
