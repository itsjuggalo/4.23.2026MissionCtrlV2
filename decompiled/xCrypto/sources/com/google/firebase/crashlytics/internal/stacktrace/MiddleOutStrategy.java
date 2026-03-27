package com.google.firebase.crashlytics.internal.stacktrace;

/* JADX INFO: loaded from: classes.dex */
public class MiddleOutStrategy implements StackTraceTrimmingStrategy {
    private final int trimmedSize;

    public MiddleOutStrategy(int i4) {
        this.trimmedSize = i4;
    }

    @Override // com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy
    public StackTraceElement[] getTrimmedStackTrace(StackTraceElement[] stackTraceElementArr) {
        int length = stackTraceElementArr.length;
        int i4 = this.trimmedSize;
        if (length <= i4) {
            return stackTraceElementArr;
        }
        int i5 = i4 / 2;
        int i6 = i4 - i5;
        StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[i4];
        System.arraycopy(stackTraceElementArr, 0, stackTraceElementArr2, 0, i6);
        System.arraycopy(stackTraceElementArr, stackTraceElementArr.length - i5, stackTraceElementArr2, i6, i5);
        return stackTraceElementArr2;
    }
}
