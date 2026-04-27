package T;

import kotlin.jvm.internal.j;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2891a;

    public e(String name) {
        j.e(name, "name");
        this.f2891a = name;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        return j.a(this.f2891a, ((e) obj).f2891a);
    }

    public final int hashCode() {
        return this.f2891a.hashCode();
    }

    public final String toString() {
        return this.f2891a;
    }
}
