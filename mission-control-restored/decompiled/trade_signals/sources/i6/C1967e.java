package i6;

import S5.c;
import java.util.Map;
import o5.C2480h;

/* JADX INFO: renamed from: i6.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1967e implements S5.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1967e f18864a = new C1967e();

    @Override // S5.c
    public Map a() {
        b();
        throw new C2480h();
    }

    public final Void b() {
        throw new IllegalStateException("No methods should be called on this descriptor. Only its presence matters".toString());
    }

    @Override // S5.c
    public q6.c e() {
        return c.a.a(this);
    }

    @Override // S5.c
    public I6.S getType() {
        b();
        throw new C2480h();
    }

    @Override // S5.c
    public R5.h0 j() {
        b();
        throw new C2480h();
    }

    public String toString() {
        return "[EnhancedType]";
    }
}
