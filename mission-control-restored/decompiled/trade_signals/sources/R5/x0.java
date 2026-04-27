package R5;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f7289b;

    public x0(String name, boolean z7) {
        AbstractC2304t.f(name, "name");
        this.f7288a = name;
        this.f7289b = z7;
    }

    public Integer a(x0 visibility) {
        AbstractC2304t.f(visibility, "visibility");
        return w0.f7275a.a(this, visibility);
    }

    public String b() {
        return this.f7288a;
    }

    public final boolean c() {
        return this.f7289b;
    }

    public final String toString() {
        return b();
    }

    public x0 d() {
        return this;
    }
}
