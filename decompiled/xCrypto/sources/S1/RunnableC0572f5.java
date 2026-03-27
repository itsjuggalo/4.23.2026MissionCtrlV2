package S1;

import com.google.android.gms.common.internal.AbstractC0940s;
import java.net.URL;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: renamed from: S1.f5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0572f5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final URL f4619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f4620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC0556d5 f4621c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f4622d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map f4623e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ C0580g5 f4624f;

    public RunnableC0572f5(C0580g5 c0580g5, String str, URL url, byte[] bArr, Map map, InterfaceC0556d5 interfaceC0556d5) {
        Objects.requireNonNull(c0580g5);
        this.f4624f = c0580g5;
        AbstractC0940s.e(str);
        AbstractC0940s.k(url);
        AbstractC0940s.k(interfaceC0556d5);
        this.f4619a = url;
        this.f4620b = bArr;
        this.f4621c = interfaceC0556d5;
        this.f4622d = str;
        this.f4623e = map;
    }

    public final /* synthetic */ void a(int i4, Exception exc, byte[] bArr, Map map) {
        this.f4621c.a(this.f4622d, i4, exc, bArr, map);
    }

    public final void b(final int i4, final Exception exc, final byte[] bArr, final Map map) {
        this.f4624f.f4245a.b().t(new Runnable() { // from class: S1.e5
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f4478a.a(i4, exc, bArr, map);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0135 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x015d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v0, types: [S1.f5] */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r6v3 */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 384
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: S1.RunnableC0572f5.run():void");
    }
}
