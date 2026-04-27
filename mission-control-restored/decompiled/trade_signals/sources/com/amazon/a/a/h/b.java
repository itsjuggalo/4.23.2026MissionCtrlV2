package com.amazon.a.a.h;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b implements Serializable, Iterable<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f13765a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<a> f13766b = new ArrayList();

    public void a(a aVar) {
        this.f13766b.add(aVar);
    }

    public Collection<a> b() {
        return this.f13766b;
    }

    public int c() {
        return this.f13766b.size();
    }

    @Override // java.lang.Iterable
    public Iterator<a> iterator() {
        return this.f13766b.iterator();
    }

    public String toString() {
        return "MetricBatch: [" + this.f13766b + "]";
    }

    public boolean a() {
        return this.f13766b.isEmpty();
    }
}
