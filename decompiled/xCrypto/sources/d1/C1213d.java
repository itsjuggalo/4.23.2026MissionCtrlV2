package d1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: d1.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1213d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C1213d f11413c = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f11415b;

    /* JADX INFO: renamed from: d1.d$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f11416a = "";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List f11417b = new ArrayList();

        public C1213d a() {
            return new C1213d(this.f11416a, Collections.unmodifiableList(this.f11417b));
        }

        public a b(List list) {
            this.f11417b = list;
            return this;
        }

        public a c(String str) {
            this.f11416a = str;
            return this;
        }
    }

    public C1213d(String str, List list) {
        this.f11414a = str;
        this.f11415b = list;
    }

    public static a c() {
        return new a();
    }

    public List a() {
        return this.f11415b;
    }

    public String b() {
        return this.f11414a;
    }
}
