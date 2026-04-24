package C1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f612c = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f614b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f615a = "";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List f616b = new ArrayList();

        public d a() {
            return new d(this.f615a, Collections.unmodifiableList(this.f616b));
        }

        public a b(List list) {
            this.f616b = list;
            return this;
        }

        public a c(String str) {
            this.f615a = str;
            return this;
        }
    }

    public d(String str, List list) {
        this.f613a = str;
        this.f614b = list;
    }

    public static a c() {
        return new a();
    }

    public List a() {
        return this.f614b;
    }

    public String b() {
        return this.f613a;
    }
}
