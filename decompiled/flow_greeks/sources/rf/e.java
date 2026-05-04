package rf;

import kotlin.jvm.internal.t;
import xf.c1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class e implements g, h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fe.e f19878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f19879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final fe.e f19880c;

    public e(fe.e classDescriptor, e eVar) {
        t.f(classDescriptor, "classDescriptor");
        this.f19878a = classDescriptor;
        this.f19879b = eVar == null ? this : eVar;
        this.f19880c = classDescriptor;
    }

    @Override // rf.g
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public c1 getType() {
        c1 c1VarS = this.f19878a.s();
        t.e(c1VarS, "getDefaultType(...)");
        return c1VarS;
    }

    public boolean equals(Object obj) {
        fe.e eVar = this.f19878a;
        e eVar2 = obj instanceof e ? (e) obj : null;
        return t.b(eVar, eVar2 != null ? eVar2.f19878a : null);
    }

    public int hashCode() {
        return this.f19878a.hashCode();
    }

    @Override // rf.h
    public final fe.e r() {
        return this.f19878a;
    }

    public String toString() {
        return "Class{" + getType() + '}';
    }
}
