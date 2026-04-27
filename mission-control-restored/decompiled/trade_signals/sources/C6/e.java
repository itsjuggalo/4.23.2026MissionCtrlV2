package C6;

import I6.AbstractC0613d0;
import R5.InterfaceC0848e;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public class e implements g, h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0848e f640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC0848e f642c;

    public e(InterfaceC0848e classDescriptor, e eVar) {
        AbstractC2304t.f(classDescriptor, "classDescriptor");
        this.f640a = classDescriptor;
        this.f641b = eVar == null ? this : eVar;
        this.f642c = classDescriptor;
    }

    @Override // C6.g
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public AbstractC0613d0 getType() {
        AbstractC0613d0 abstractC0613d0T = this.f640a.t();
        AbstractC2304t.e(abstractC0613d0T, "getDefaultType(...)");
        return abstractC0613d0T;
    }

    public boolean equals(Object obj) {
        InterfaceC0848e interfaceC0848e = this.f640a;
        e eVar = obj instanceof e ? (e) obj : null;
        return AbstractC2304t.b(interfaceC0848e, eVar != null ? eVar.f640a : null);
    }

    public int hashCode() {
        return this.f640a.hashCode();
    }

    @Override // C6.h
    public final InterfaceC0848e s() {
        return this.f640a;
    }

    public String toString() {
        return "Class{" + getType() + '}';
    }
}
