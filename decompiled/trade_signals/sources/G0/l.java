package G0;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set f2017c = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2019b;

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
        this.f2018a = str;
        this.f2019b = str2;
        f2017c.add(this);
    }
}
