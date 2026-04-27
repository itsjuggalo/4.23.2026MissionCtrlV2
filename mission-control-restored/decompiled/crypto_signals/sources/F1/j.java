package F1;

import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public final class j extends ThreadLocal {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f506a;

    @Override // java.lang.ThreadLocal
    public final Object initialValue() {
        switch (this.f506a) {
            case 0:
                return 0L;
            case 1:
                return new Random();
            default:
                return Boolean.FALSE;
        }
    }
}
