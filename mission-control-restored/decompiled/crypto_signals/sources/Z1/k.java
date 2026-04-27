package Z1;

import com.google.android.gms.common.internal.I;

/* JADX INFO: loaded from: classes.dex */
public class k extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(String str) {
        super(str);
        I.e(str, "Detail message must not be empty");
    }
}
