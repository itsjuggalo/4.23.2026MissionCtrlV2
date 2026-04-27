package U3;

import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class U extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4819a;

    public U(String str) {
        super(str);
        this.f4819a = a(str);
    }

    public final int a(String str) {
        if (str == null) {
            return 0;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        lowerCase.hashCode();
        switch (lowerCase) {
        }
        return 0;
    }
}
