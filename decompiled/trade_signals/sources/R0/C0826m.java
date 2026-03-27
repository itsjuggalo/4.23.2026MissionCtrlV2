package R0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: renamed from: R0.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0826m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f7005a;

    /* JADX INFO: renamed from: R0.m$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set f7006a = new HashSet();

        public a a(int i8) {
            this.f7006a.add(Integer.valueOf(i8));
            return this;
        }

        public C0826m b() {
            return new C0826m(this.f7006a, null);
        }
    }

    public /* synthetic */ C0826m(Set set, z0 z0Var) {
        this.f7005a = new ArrayList(Collections.unmodifiableList(new ArrayList(set)));
    }

    public static a a() {
        return new a();
    }

    public final ArrayList b() {
        return this.f7005a;
    }
}
