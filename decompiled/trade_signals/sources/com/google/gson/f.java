package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class f extends i implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f16013a = new ArrayList();

    public void I(i iVar) {
        if (iVar == null) {
            iVar = k.f16252a;
        }
        this.f16013a.add(iVar);
    }

    public final i J() {
        int size = this.f16013a.size();
        if (size == 1) {
            return (i) this.f16013a.get(0);
        }
        throw new IllegalStateException("Array must have size 1, but has size " + size);
    }

    @Override // com.google.gson.i
    public boolean a() {
        return J().a();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof f) && ((f) obj).f16013a.equals(this.f16013a));
    }

    @Override // com.google.gson.i
    public String h() {
        return J().h();
    }

    public int hashCode() {
        return this.f16013a.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return this.f16013a.iterator();
    }
}
