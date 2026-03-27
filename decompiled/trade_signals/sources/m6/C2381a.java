package m6;

import H5.d;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import n6.AbstractC2427a;
import p5.I;
import p5.r;
import p5.z;

/* JADX INFO: renamed from: m6.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2381a extends AbstractC2427a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C0357a f21477g = new C0357a(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final C2381a f21478h = new C2381a(1, 0, 7);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final C2381a f21479i = new C2381a(new int[0]);

    /* JADX INFO: renamed from: m6.a$a, reason: collision with other inner class name */
    public static final class C0357a {
        public C0357a() {
        }

        public final C2381a a(InputStream stream) {
            AbstractC2304t.f(stream, "stream");
            DataInputStream dataInputStream = new DataInputStream(stream);
            d dVar = new d(1, dataInputStream.readInt());
            ArrayList arrayList = new ArrayList(r.s(dVar, 10));
            Iterator it = dVar.iterator();
            while (it.hasNext()) {
                ((I) it).c();
                arrayList.add(Integer.valueOf(dataInputStream.readInt()));
            }
            int[] iArrF0 = z.F0(arrayList);
            return new C2381a(Arrays.copyOf(iArrF0, iArrF0.length));
        }

        public /* synthetic */ C0357a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2381a(int... numbers) {
        super(Arrays.copyOf(numbers, numbers.length));
        AbstractC2304t.f(numbers, "numbers");
    }

    public boolean h() {
        return f(f21478h);
    }
}
