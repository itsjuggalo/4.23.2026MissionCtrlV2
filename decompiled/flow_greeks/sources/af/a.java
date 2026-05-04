package af;

import dd.a0;
import dd.j0;
import dd.s;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import vd.g;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends bf.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C0011a f809g = new C0011a(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f810h = new a(1, 0, 7);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f811i = new a(new int[0]);

    /* JADX INFO: renamed from: af.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0011a {
        public /* synthetic */ C0011a(k kVar) {
            this();
        }

        public final a a(InputStream stream) {
            t.f(stream, "stream");
            DataInputStream dataInputStream = new DataInputStream(stream);
            g gVar = new g(1, dataInputStream.readInt());
            ArrayList arrayList = new ArrayList(s.u(gVar, 10));
            Iterator it = gVar.iterator();
            while (it.hasNext()) {
                ((j0) it).nextInt();
                arrayList.add(Integer.valueOf(dataInputStream.readInt()));
            }
            int[] iArrH0 = a0.H0(arrayList);
            return new a(Arrays.copyOf(iArrH0, iArrH0.length));
        }

        public C0011a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(int... numbers) {
        super(Arrays.copyOf(numbers, numbers.length));
        t.f(numbers, "numbers");
    }

    public boolean h() {
        return f(f810h);
    }
}
