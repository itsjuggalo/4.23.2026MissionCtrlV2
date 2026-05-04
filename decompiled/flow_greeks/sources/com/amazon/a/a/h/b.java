package com.amazon.a.a.h;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b implements Serializable, Iterable<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f4281a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<a> f4282b = new ArrayList();

    public boolean a() {
        return this.f4282b.isEmpty();
    }

    public Collection<a> b() {
        return this.f4282b;
    }

    public int c() {
        return this.f4282b.size();
    }

    @Override // java.lang.Iterable
    public Iterator<a> iterator() {
        return this.f4282b.iterator();
    }

    public String toString() {
        return "MetricBatch: [" + this.f4282b + "]";
    }

    public void a(a aVar) {
        this.f4282b.add(aVar);
    }
}
