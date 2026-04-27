package com.amazon.a.a.h;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b implements Serializable, Iterable<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f9654a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<a> f9655b = new ArrayList();

    public boolean a() {
        return this.f9655b.isEmpty();
    }

    public Collection<a> b() {
        return this.f9655b;
    }

    public int c() {
        return this.f9655b.size();
    }

    @Override // java.lang.Iterable
    public Iterator<a> iterator() {
        return this.f9655b.iterator();
    }

    public String toString() {
        return "MetricBatch: [" + this.f9655b + "]";
    }

    public void a(a aVar) {
        this.f9655b.add(aVar);
    }
}
