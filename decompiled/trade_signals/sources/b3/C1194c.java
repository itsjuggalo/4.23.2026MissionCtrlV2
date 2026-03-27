package b3;

import java.util.HashMap;

/* JADX INFO: renamed from: b3.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1194c implements InterfaceC1195d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12889a;

    public C1194c(int i8) {
        this.f12889a = i8;
    }

    public static boolean b(StackTraceElement[] stackTraceElementArr, int i8, int i9) {
        int i10 = i9 - i8;
        if (i9 + i10 > stackTraceElementArr.length) {
            return false;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            if (!stackTraceElementArr[i8 + i11].equals(stackTraceElementArr[i9 + i11])) {
                return false;
            }
        }
        return true;
    }

    public static StackTraceElement[] c(StackTraceElement[] stackTraceElementArr, int i8) {
        int i9;
        HashMap map = new HashMap();
        StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[stackTraceElementArr.length];
        int i10 = 0;
        int i11 = 0;
        int i12 = 1;
        while (i10 < stackTraceElementArr.length) {
            StackTraceElement stackTraceElement = stackTraceElementArr[i10];
            Integer num = (Integer) map.get(stackTraceElement);
            if (num == null || !b(stackTraceElementArr, num.intValue(), i10)) {
                stackTraceElementArr2[i11] = stackTraceElementArr[i10];
                i11++;
                i12 = 1;
                i9 = i10;
            } else {
                int iIntValue = i10 - num.intValue();
                if (i12 < i8) {
                    System.arraycopy(stackTraceElementArr, i10, stackTraceElementArr2, i11, iIntValue);
                    i11 += iIntValue;
                    i12++;
                }
                i9 = (iIntValue - 1) + i10;
            }
            map.put(stackTraceElement, Integer.valueOf(i10));
            i10 = i9 + 1;
        }
        StackTraceElement[] stackTraceElementArr3 = new StackTraceElement[i11];
        System.arraycopy(stackTraceElementArr2, 0, stackTraceElementArr3, 0, i11);
        return stackTraceElementArr3;
    }

    @Override // b3.InterfaceC1195d
    public StackTraceElement[] a(StackTraceElement[] stackTraceElementArr) {
        StackTraceElement[] stackTraceElementArrC = c(stackTraceElementArr, this.f12889a);
        return stackTraceElementArrC.length < stackTraceElementArr.length ? stackTraceElementArrC : stackTraceElementArr;
    }
}
