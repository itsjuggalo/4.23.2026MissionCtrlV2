package M0;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set f3732c = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3734b;

    public static class a extends l {
        public a(String str, String str2) {
            super(str, str2);
        }
    }

    public static class b extends l {
        public b(String str, String str2) {
            super(str, str2);
        }
    }

    public l(String str, String str2) {
        this.f3733a = str;
        this.f3734b = str2;
        f3732c.add(this);
    }
}
