package U0;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class e extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8076a;

    public e(int i8) {
        this("Http request failed", i8);
    }

    public e(String str, int i8) {
        this(str, i8, null);
    }

    public e(String str, int i8, Throwable th) {
        super(str + ", status code: " + i8, th);
        this.f8076a = i8;
    }
}
