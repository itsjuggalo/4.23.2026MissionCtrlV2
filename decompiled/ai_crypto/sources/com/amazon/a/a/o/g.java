package com.amazon.a.a.o;

import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class g<T> implements Iterable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakHashMap<T, Object> f10024a = new WeakHashMap<>();

    public void a(T t7) {
        this.f10024a.put(t7, null);
    }

    public void b(T t7) {
        this.f10024a.remove(t7);
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return this.f10024a.keySet().iterator();
    }

    public String toString() {
        return this.f10024a.keySet().toString();
    }

    public boolean a() {
        return this.f10024a.isEmpty();
    }

    public int b() {
        return this.f10024a.size();
    }
}
