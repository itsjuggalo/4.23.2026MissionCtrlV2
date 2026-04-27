package A;

import java.util.ArrayList;
import java.util.Arrays;
import s3.C1030k;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f28a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f29b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f30c;

    public /* synthetic */ k(Object obj, int i, int i6) {
        this.f28a = i6;
        this.f29b = i;
        this.f30c = obj;
    }

    public void a(int i, int i6) {
        int i7 = i6 + i;
        char[] cArr = (char[]) this.f30c;
        if (cArr.length <= i7) {
            int i8 = i * 2;
            if (i7 < i8) {
                i7 = i8;
            }
            char[] cArrCopyOf = Arrays.copyOf(cArr, i7);
            kotlin.jvm.internal.j.d(cArrCopyOf, "copyOf(...)");
            this.f30c = cArrCopyOf;
        }
    }

    public boolean b(int i) {
        return ((1 << i) & this.f29b) != 0;
    }

    public void c() {
        r5.b bVar = r5.b.f9481c;
        char[] array = (char[]) this.f30c;
        bVar.getClass();
        kotlin.jvm.internal.j.e(array, "array");
        synchronized (bVar) {
            int i = bVar.f4572a;
            if (array.length + i < r5.a.f9480a) {
                bVar.f4572a = i + array.length;
                ((H4.f) bVar.f4573b).addLast(array);
            }
        }
    }

    public void d(int i, int i6) {
        int[] iArr = (int[]) this.f30c;
        if (i >= iArr.length) {
            return;
        }
        this.f29b = (1 << i) | this.f29b;
        iArr[i] = i6;
    }

    public void e(String text) {
        kotlin.jvm.internal.j.e(text, "text");
        int length = text.length();
        if (length == 0) {
            return;
        }
        a(this.f29b, length);
        text.getChars(0, text.length(), (char[]) this.f30c, this.f29b);
        this.f29b += length;
    }

    public String toString() {
        switch (this.f28a) {
            case 3:
                return "ExistenceFilter{count=" + this.f29b + ", unchangedNames=" + ((C1030k) this.f30c) + '}';
            case 4:
                return new String((char[]) this.f30c, 0, this.f29b);
            default:
                return super.toString();
        }
    }

    public k(int i, byte b3) {
        this.f28a = i;
        switch (i) {
            case 6:
                this.f30c = new ArrayList();
                this.f29b = 128;
                break;
            case 7:
                this.f30c = new int[10];
                break;
        }
    }

    public k(byte[] bArr, int i) {
        this.f28a = 5;
        this.f30c = bArr;
        this.f29b = i;
    }

    public k(int i) {
        this.f28a = 1;
        if (i > 0) {
            this.f30c = new Object[i];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }
}
