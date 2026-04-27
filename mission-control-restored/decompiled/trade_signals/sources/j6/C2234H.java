package j6;

import I6.S;
import R5.InterfaceC0848e;
import java.util.Collection;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: j6.H, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2234H implements InterfaceC2233G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2234H f20125a = new C2234H();

    @Override // j6.InterfaceC2233G
    public S a(S kotlinType) {
        AbstractC2304t.f(kotlinType, "kotlinType");
        return null;
    }

    @Override // j6.InterfaceC2233G
    public void b(S kotlinType, InterfaceC0848e descriptor) {
        AbstractC2304t.f(kotlinType, "kotlinType");
        AbstractC2304t.f(descriptor, "descriptor");
    }

    @Override // j6.InterfaceC2233G
    public S c(Collection types) {
        AbstractC2304t.f(types, "types");
        throw new AssertionError("There should be no intersection type in existing descriptors, but found: " + p5.z.h0(types, null, null, null, 0, null, null, 63, null));
    }

    @Override // j6.InterfaceC2233G
    public String d(InterfaceC0848e classDescriptor) {
        AbstractC2304t.f(classDescriptor, "classDescriptor");
        return null;
    }

    @Override // j6.InterfaceC2233G
    public String f(InterfaceC0848e classDescriptor) {
        AbstractC2304t.f(classDescriptor, "classDescriptor");
        return null;
    }

    @Override // j6.InterfaceC2233G
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public AbstractC2255s e(InterfaceC0848e classDescriptor) {
        AbstractC2304t.f(classDescriptor, "classDescriptor");
        return null;
    }
}
