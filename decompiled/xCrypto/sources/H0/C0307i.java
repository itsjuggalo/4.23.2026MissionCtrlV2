package H0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: renamed from: H0.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0307i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f666a;

    /* JADX INFO: renamed from: H0.i$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set f667a = new HashSet();

        public a a(int i4) {
            this.f667a.add(Integer.valueOf(i4));
            return this;
        }

        public C0307i b() {
            return new C0307i(this.f667a, null);
        }
    }

    public /* synthetic */ C0307i(Set set, n0 n0Var) {
        this.f666a = new ArrayList(Collections.unmodifiableList(new ArrayList(set)));
    }

    public static a a() {
        return new a();
    }

    public final ArrayList b() {
        return this.f666a;
    }
}
