package o4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f17504c = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f17506b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f17507a = "";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List f17508b = new ArrayList();

        public d a() {
            return new d(this.f17507a, Collections.unmodifiableList(this.f17508b));
        }

        public a b(List list) {
            this.f17508b = list;
            return this;
        }

        public a c(String str) {
            this.f17507a = str;
            return this;
        }
    }

    public d(String str, List list) {
        this.f17505a = str;
        this.f17506b = list;
    }

    public static a c() {
        return new a();
    }

    public List a() {
        return this.f17506b;
    }

    public String b() {
        return this.f17505a;
    }
}
