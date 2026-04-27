package U;

import android.util.SparseArray;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3074a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q f3075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public q f3076c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public q f3077d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3078f;

    public n(q qVar) {
        this.f3075b = qVar;
        this.f3076c = qVar;
    }

    public final int a(int i) {
        SparseArray sparseArray = this.f3076c.f3090a;
        q qVar = sparseArray == null ? null : (q) sparseArray.get(i);
        int i6 = 1;
        int i7 = 2;
        if (this.f3074a == 2) {
            if (qVar != null) {
                this.f3076c = qVar;
                this.f3078f++;
            } else if (i == 65038) {
                b();
            } else if (i != 65039) {
                q qVar2 = this.f3076c;
                if (qVar2.f3091b != null) {
                    i7 = 3;
                    if (this.f3078f != 1) {
                        this.f3077d = qVar2;
                        b();
                    } else if (c()) {
                        this.f3077d = this.f3076c;
                        b();
                    } else {
                        b();
                    }
                } else {
                    b();
                }
            }
            i6 = i7;
        } else if (qVar == null) {
            b();
        } else {
            this.f3074a = 2;
            this.f3076c = qVar;
            this.f3078f = 1;
            i6 = i7;
        }
        this.e = i;
        return i6;
    }

    public final void b() {
        this.f3074a = 1;
        this.f3076c = this.f3075b;
        this.f3078f = 0;
    }

    public final boolean c() {
        V.a aVarB = this.f3076c.f3091b.b();
        int iA = aVarB.a(6);
        return !(iA == 0 || ((ByteBuffer) aVarB.f254d).get(iA + aVarB.f251a) == 0) || this.e == 65039;
    }
}
