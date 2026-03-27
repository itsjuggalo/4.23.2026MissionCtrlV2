package q4;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: renamed from: q4.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0946b extends Z3.v {
    public static final C0946b e = new C0946b(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f9324d;

    public /* synthetic */ C0946b(int i) {
        this.f9324d = i;
    }

    @Override // Z3.v
    public Object f(byte b3, ByteBuffer byteBuffer) {
        switch (this.f9324d) {
            case 1:
                if (b3 == -127) {
                    Long l6 = (Long) e(byteBuffer);
                    if (l6 != null) {
                        int iLongValue = (int) l6.longValue();
                        K.f9315b.getClass();
                        K[] kArrValues = K.values();
                        int length = kArrValues.length;
                        for (int i = 0; i < length; i++) {
                            K k6 = kArrValues[i];
                            if (k6.f9319a == iLongValue) {
                            }
                        }
                    }
                } else if (b3 == -126) {
                    Object objE = e(byteBuffer);
                    List list = objE instanceof List ? (List) objE : null;
                    if (list != null) {
                        String str = (String) list.get(0);
                        Object obj = list.get(1);
                        kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.Boolean");
                    }
                } else if (b3 == -125) {
                    Object objE2 = e(byteBuffer);
                    List list2 = objE2 instanceof List ? (List) objE2 : null;
                    if (list2 != null) {
                        String str2 = (String) list2.get(0);
                        Object obj2 = list2.get(1);
                        kotlin.jvm.internal.j.c(obj2, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.StringListLookupResultType");
                    }
                }
                break;
        }
        return super.f(b3, byteBuffer);
    }

    @Override // Z3.v
    public void k(ByteArrayOutputStream stream, Object obj) {
        switch (this.f9324d) {
            case 1:
                kotlin.jvm.internal.j.e(stream, "stream");
                if (obj instanceof K) {
                    stream.write(129);
                    k(stream, Integer.valueOf(((K) obj).f9319a));
                } else if (obj instanceof C0951g) {
                    stream.write(130);
                    C0951g c0951g = (C0951g) obj;
                    k(stream, H4.g.c0(new Object[]{c0951g.f9332a, Boolean.valueOf(c0951g.f9333b)}));
                } else if (!(obj instanceof M)) {
                    super.k(stream, obj);
                } else {
                    stream.write(131);
                    M m5 = (M) obj;
                    k(stream, H4.g.c0(new Object[]{m5.f9320a, m5.f9321b}));
                }
                break;
            default:
                super.k(stream, obj);
                break;
        }
    }
}
