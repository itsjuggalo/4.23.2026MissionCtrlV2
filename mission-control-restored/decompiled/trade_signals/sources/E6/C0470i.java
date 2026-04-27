package E6;

import R5.h0;
import kotlin.jvm.internal.AbstractC2304t;
import n6.AbstractC2427a;
import n6.InterfaceC2429c;

/* JADX INFO: renamed from: E6.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0470i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2429c f987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l6.c f988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AbstractC2427a f989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h0 f990d;

    public C0470i(InterfaceC2429c nameResolver, l6.c classProto, AbstractC2427a metadataVersion, h0 sourceElement) {
        AbstractC2304t.f(nameResolver, "nameResolver");
        AbstractC2304t.f(classProto, "classProto");
        AbstractC2304t.f(metadataVersion, "metadataVersion");
        AbstractC2304t.f(sourceElement, "sourceElement");
        this.f987a = nameResolver;
        this.f988b = classProto;
        this.f989c = metadataVersion;
        this.f990d = sourceElement;
    }

    public final InterfaceC2429c a() {
        return this.f987a;
    }

    public final l6.c b() {
        return this.f988b;
    }

    public final AbstractC2427a c() {
        return this.f989c;
    }

    public final h0 d() {
        return this.f990d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0470i)) {
            return false;
        }
        C0470i c0470i = (C0470i) obj;
        return AbstractC2304t.b(this.f987a, c0470i.f987a) && AbstractC2304t.b(this.f988b, c0470i.f988b) && AbstractC2304t.b(this.f989c, c0470i.f989c) && AbstractC2304t.b(this.f990d, c0470i.f990d);
    }

    public int hashCode() {
        return (((((this.f987a.hashCode() * 31) + this.f988b.hashCode()) * 31) + this.f989c.hashCode()) * 31) + this.f990d.hashCode();
    }

    public String toString() {
        return "ClassData(nameResolver=" + this.f987a + ", classProto=" + this.f988b + ", metadataVersion=" + this.f989c + ", sourceElement=" + this.f990d + ')';
    }
}
