package u1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: u1.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2748d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C2748d f24446c = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f24447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f24448b;

    /* JADX INFO: renamed from: u1.d$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f24449a = "";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List f24450b = new ArrayList();

        public C2748d a() {
            return new C2748d(this.f24449a, Collections.unmodifiableList(this.f24450b));
        }

        public a b(List list) {
            this.f24450b = list;
            return this;
        }

        public a c(String str) {
            this.f24449a = str;
            return this;
        }
    }

    public C2748d(String str, List list) {
        this.f24447a = str;
        this.f24448b = list;
    }

    public static a c() {
        return new a();
    }

    public List a() {
        return this.f24448b;
    }

    public String b() {
        return this.f24447a;
    }
}
