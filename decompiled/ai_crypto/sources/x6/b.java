package x6;

import kotlin.jvm.internal.r;
import w6.C2792e;
import w6.C2795h;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f25326a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX WARN: Code restructure failed: missing block: B:39:0x005b, code lost:
    
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int c(byte[] r18, int r19) {
        /*
            Method dump skipped, instruction units count: 423
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x6.b.c(byte[], int):int");
    }

    public static final void d(C2795h c2795h, C2792e buffer, int i7, int i8) {
        r.f(c2795h, "<this>");
        r.f(buffer, "buffer");
        buffer.g(c2795h.m(), i7, i8);
    }

    public static final int e(char c7) {
        if ('0' <= c7 && c7 < ':') {
            return c7 - '0';
        }
        if ('a' <= c7 && c7 < 'g') {
            return c7 - 'W';
        }
        if ('A' <= c7 && c7 < 'G') {
            return c7 - '7';
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c7);
    }

    public static final char[] f() {
        return f25326a;
    }
}
