package com.google.firebase.crashlytics.internal.stacktrace;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class RemoveRepeatsStrategy implements StackTraceTrimmingStrategy {
    private final int maxRepetitions;

    public RemoveRepeatsStrategy() {
        this(1);
    }

    private static boolean isRepeatingSequence(StackTraceElement[] stackTraceElementArr, int i4, int i5) {
        int i6 = i5 - i4;
        if (i5 + i6 > stackTraceElementArr.length) {
            return false;
        }
        for (int i7 = 0; i7 < i6; i7++) {
            if (!stackTraceElementArr[i4 + i7].equals(stackTraceElementArr[i5 + i7])) {
                return false;
            }
        }
        return true;
    }

    private static StackTraceElement[] trimRepeats(StackTraceElement[] stackTraceElementArr, int i4) {
        int i5;
        HashMap map = new HashMap();
        StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[stackTraceElementArr.length];
        int i6 = 0;
        int i7 = 0;
        int i8 = 1;
        while (i6 < stackTraceElementArr.length) {
            StackTraceElement stackTraceElement = stackTraceElementArr[i6];
            Integer num = (Integer) map.get(stackTraceElement);
            if (num == null || !isRepeatingSequence(stackTraceElementArr, num.intValue(), i6)) {
                stackTraceElementArr2[i7] = stackTraceElementArr[i6];
                i7++;
                i8 = 1;
                i5 = i6;
            } else {
                int iIntValue = i6 - num.intValue();
                if (i8 < i4) {
                    System.arraycopy(stackTraceElementArr, i6, stackTraceElementArr2, i7, iIntValue);
                    i7 += iIntValue;
                    i8++;
                }
                i5 = (iIntValue - 1) + i6;
            }
            map.put(stackTraceElement, Integer.valueOf(i6));
            i6 = i5 + 1;
        }
        StackTraceElement[] stackTraceElementArr3 = new StackTraceElement[i7];
        System.arraycopy(stackTraceElementArr2, 0, stackTraceElementArr3, 0, i7);
        return stackTraceElementArr3;
    }

    @Override // com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy
    public StackTraceElement[] getTrimmedStackTrace(StackTraceElement[] stackTraceElementArr) {
        StackTraceElement[] stackTraceElementArrTrimRepeats = trimRepeats(stackTraceElementArr, this.maxRepetitions);
        return stackTraceElementArrTrimRepeats.length < stackTraceElementArr.length ? stackTraceElementArrTrimRepeats : stackTraceElementArr;
    }

    public RemoveRepeatsStrategy(int i4) {
        this.maxRepetitions = i4;
    }
}
