package v0;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set f15205c = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15207b;

    public static class a extends h {
        public a(String str, String str2) {
            super(str, str2);
        }
    }

    public static class b extends h {
        public b(String str, String str2) {
            super(str, str2);
        }
    }

    public h(String str, String str2) {
        this.f15206a = str;
        this.f15207b = str2;
        f15205c.add(this);
    }
}
