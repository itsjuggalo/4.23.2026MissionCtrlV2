package j5;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k {
    public static int a(int i8) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i8 - 1));
    }
}
