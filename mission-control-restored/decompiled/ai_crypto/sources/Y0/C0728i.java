package Y0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: renamed from: Y0.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0728i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f5593a;

    /* JADX INFO: renamed from: Y0.i$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set f5594a = new HashSet();

        public a a(int i7) {
            this.f5594a.add(Integer.valueOf(i7));
            return this;
        }

        public C0728i b() {
            return new C0728i(this.f5594a, null);
        }
    }

    public /* synthetic */ C0728i(Set set, n0 n0Var) {
        this.f5593a = new ArrayList(Collections.unmodifiableList(new ArrayList(set)));
    }

    public static a a() {
        return new a();
    }

    public final ArrayList b() {
        return this.f5593a;
    }
}
