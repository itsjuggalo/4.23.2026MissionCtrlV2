package j6;

import E6.C0485y;
import G6.InterfaceC0581s;
import R5.i0;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: j6.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2262z implements InterfaceC0581s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2260x f20236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0485y f20237c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f20238d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final G6.r f20239e;

    public C2262z(InterfaceC2260x binaryClass, C0485y c0485y, boolean z7, G6.r abiStability) {
        AbstractC2304t.f(binaryClass, "binaryClass");
        AbstractC2304t.f(abiStability, "abiStability");
        this.f20236b = binaryClass;
        this.f20237c = c0485y;
        this.f20238d = z7;
        this.f20239e = abiStability;
    }

    @Override // R5.h0
    public i0 a() {
        i0 NO_SOURCE_FILE = i0.f7250a;
        AbstractC2304t.e(NO_SOURCE_FILE, "NO_SOURCE_FILE");
        return NO_SOURCE_FILE;
    }

    @Override // G6.InterfaceC0581s
    public String c() {
        return "Class '" + this.f20236b.d().a().a() + '\'';
    }

    public final InterfaceC2260x d() {
        return this.f20236b;
    }

    public String toString() {
        return C2262z.class.getSimpleName() + ": " + this.f20236b;
    }
}
