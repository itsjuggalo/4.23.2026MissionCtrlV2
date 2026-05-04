package com.google.gson;

import com.google.gson.internal.y;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class l extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f6877a = new y(false);

    public boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof l) && ((l) obj).f6877a.equals(this.f6877a);
        }
        return true;
    }

    public int hashCode() {
        return this.f6877a.hashCode();
    }

    public void s(String str, i iVar) {
        y yVar = this.f6877a;
        if (iVar == null) {
            iVar = k.f6876a;
        }
        yVar.put(str, iVar);
    }

    public Set u() {
        return this.f6877a.entrySet();
    }

    public boolean v(String str) {
        return this.f6877a.containsKey(str);
    }

    public i w(String str) {
        return (i) this.f6877a.remove(str);
    }
}
