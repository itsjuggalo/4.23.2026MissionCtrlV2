package m1;

import java.util.Arrays;

/* JADX INFO: renamed from: m1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2228b extends RuntimeException {
    public C2228b(String str, String[] strArr, String[] strArr2) {
        super("Could not find '" + str + "'. Looked for: " + Arrays.toString(strArr) + ", but only found: " + Arrays.toString(strArr2) + ".");
    }
}
