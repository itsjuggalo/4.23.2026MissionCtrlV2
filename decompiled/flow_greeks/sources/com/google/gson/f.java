package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends i implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f6661a = new ArrayList();

    @Override // com.google.gson.i
    public boolean a() {
        return u().a();
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof f) && ((f) obj).f6661a.equals(this.f6661a);
        }
        return true;
    }

    @Override // com.google.gson.i
    public String f() {
        return u().f();
    }

    public int hashCode() {
        return this.f6661a.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return this.f6661a.iterator();
    }

    public void s(i iVar) {
        if (iVar == null) {
            iVar = k.f6876a;
        }
        this.f6661a.add(iVar);
    }

    public final i u() {
        int size = this.f6661a.size();
        if (size == 1) {
            return (i) this.f6661a.get(0);
        }
        throw new IllegalStateException("Array must have size 1, but has size " + size);
    }
}
