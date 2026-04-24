package G2;

import com.google.android.gms.common.internal.AbstractC1294n;

/* JADX INFO: loaded from: classes.dex */
public abstract class l extends Exception {
    public l() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(String str) {
        super(str);
        AbstractC1294n.e(str, "Detail message must not be empty");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(String str, Throwable th) {
        super(str, th);
        AbstractC1294n.e(str, "Detail message must not be empty");
    }
}
