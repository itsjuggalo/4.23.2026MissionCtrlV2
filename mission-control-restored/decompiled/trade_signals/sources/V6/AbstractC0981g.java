package V6;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: V6.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0981g {
    public static final boolean b(String str) {
        for (int i8 = 0; i8 < str.length(); i8++) {
            char cCharAt = str.charAt(i8);
            if (AbstractC2304t.g(cCharAt, 128) >= 0 || Character.isLetter(cCharAt)) {
                return true;
            }
        }
        return false;
    }
}
