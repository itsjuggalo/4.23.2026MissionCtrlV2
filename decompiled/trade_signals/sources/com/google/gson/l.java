package com.google.gson;

import com.google.gson.internal.y;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class l extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f16253a = new y(false);

    public void I(String str, i iVar) {
        y yVar = this.f16253a;
        if (iVar == null) {
            iVar = k.f16252a;
        }
        yVar.put(str, iVar);
    }

    public Set J() {
        return this.f16253a.entrySet();
    }

    public boolean K(String str) {
        return this.f16253a.containsKey(str);
    }

    public i L(String str) {
        return (i) this.f16253a.remove(str);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof l) && ((l) obj).f16253a.equals(this.f16253a));
    }

    public int hashCode() {
        return this.f16253a.hashCode();
    }
}
